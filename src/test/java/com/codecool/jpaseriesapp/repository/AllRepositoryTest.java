package com.codecool.jpaseriesapp.repository;

import com.codecool.jpaseriesapp.entity.Episode;
import com.codecool.jpaseriesapp.entity.Season;
import com.codecool.jpaseriesapp.entity.Series;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)

public class AllRepositoryTest {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveOneSimple() {
        Series himym = Series.builder()
                .title("HIMYM")
                .numberOfSeasons(9)
                .numberOfEpisodes(123)
                .releaseYear(LocalDate.of(2009, 8, 27))
                .build();

        seriesRepository.save(himym);

        List<Series> seriesList = seriesRepository.findAll();

        assertThat(seriesList).hasSize(1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void saveUniqueFieldTwice() {
        Series gossipGirl = Series.builder()
                .title("Gossip Girl")
                .build();

        seriesRepository.save(gossipGirl);

        Series gossipGirl2 = Series.builder()
                .title("Gossip Girl")
                .build();

        seriesRepository.saveAndFlush(gossipGirl2);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void seriesTitleShouldBeNotNull() {
        Series gossipGirl = Series.builder()
                .releaseYear(LocalDate.of(2010, 8, 17))
                .build();

        seriesRepository.save(gossipGirl);
    }

    @Test
    public void transientIsNotSaved() {
        Series gossipGirl = Series.builder()
                .title("Gossip Girl")
                .releaseYear(LocalDate.of(2010, 3, 2))
                .build();

        gossipGirl.calculateAge();
        assertThat(gossipGirl.getAge()).isGreaterThanOrEqualTo(10);

        seriesRepository.save(gossipGirl);
        testEntityManager.clear();

        List<Series> series = seriesRepository.findAll();
        assertThat(series).allMatch(series1 -> series1.getAge() == 0L);
    }

//    @Test
//    public void seasonIsPersistedWithSeries() {
//        Season season = Season.builder()
//                .numberOfEpisodes(10)
//                .releaseYear(LocalDate.of(2017, 07, 21))
//                .seasonNumber(3)
//                .build();
//
//        Series.builder()
//                .seasonSet(season)
//                .build()
//    }

    @Test
    public void SeasonsArePersistedAndDeletedWithSeries() {
        Set<Season> seasons = IntStream.range(1, 10)
                .boxed()
                .map(integer -> Season.builder().numberOfEpisodes(10).build())
                .collect(Collectors.toSet());

        Series series = Series.builder()
                .title("Ozark")
                .seasonSet(seasons)
                .build();

        seriesRepository.save(series);

        assertThat(seasonRepository.findAll())
                .hasSize(1)
                .anyMatch(series1 -> series1.getNumberOfEpisodes() == 10);

        seasonRepository.deleteAll();

        assertThat(seriesRepository.findAll())
                .hasSize(0);
    }


}