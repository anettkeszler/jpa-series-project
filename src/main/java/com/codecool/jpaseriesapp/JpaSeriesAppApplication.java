package com.codecool.jpaseriesapp;

import com.codecool.jpaseriesapp.entity.Episode;
import com.codecool.jpaseriesapp.entity.Season;
import com.codecool.jpaseriesapp.entity.Series;
import com.codecool.jpaseriesapp.repository.EpisodeRepository;
import com.codecool.jpaseriesapp.repository.SeasonRepository;
import com.codecool.jpaseriesapp.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class JpaSeriesAppApplication {
    private SeriesRepository seriesRepository;

    @Autowired
    public JpaSeriesAppApplication(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaSeriesAppApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        CommandLineRunner clr = args -> {
            Episode episode1 = Episode.builder()
                    .title("Sugarwood")
                    .build();

            Episode episode2 = Episode.builder()
                    .title("Blue Cat")
                    .build();

            Episode episode3 = Episode.builder()
                    .title("My Dripping Sleep")
                    .build();

            Episode episode4 = Episode.builder()
                    .title("Tonight We Improvise")
                    .build();

            Episode episode5 = Episode.builder()
                    .title("Ruling Days")
                    .build();

            Episode episode6 = Episode.builder()
                    .title("Book of Ruth")
                    .build();

            Episode episode7 = Episode.builder()
                    .title("Nest Box"	)
                    .build();

            Episode episode8 = Episode.builder()
                    .title("Kaleidoscope")
                    .build();

            Episode episode9 = Episode.builder()
                    .title("Coffee, Black")
                    .build();

            Episode episode10 = Episode.builder()
                    .title("The Toll")
                    .build();

            Episode episode11 = Episode.builder()
                    .title("Reparations")
                    .build();

            Episode episode12 = Episode.builder()
                    .title("The Precious Blood of Jesus")
                    .build();

            Episode episode13 = Episode.builder()
                    .title("Once a Langmore...")
                    .build();

            Episode episode14 = Episode.builder()
                    .title("Stag")
                    .build();

            Episode episode15 = Episode.builder()
                    .title("Game Day")
                    .build();

            Episode episode16 = Episode.builder()
                    .title("Outer Darkness")
                    .build();

            Episode episode17 = Episode.builder()
                    .title("One Way Out")
                    .build();

            Episode episode18 = Episode.builder()
                    .title("The Big Sleep")
                    .build();

            Episode episode19 = Episode.builder()
                    .title("The Badger")
                    .build();

            Episode episode20 = Episode.builder()
                    .title("The Gold Coast")
                    .build();

            Episode episode21 = Episode.builder()
                    .title("Wartime")
                    .build();

            Episode episode22 = Episode.builder()
                    .title("Civil Union")
                    .build();

            Episode episode23 = Episode.builder()
                    .title("Kevin Cronin Was Here")
                    .build();

            Episode episode24 = Episode.builder()
                    .title("Boss Fight")
                    .build();

            Episode episode25 = Episode.builder()
                    .title("It Came From Michoacán")
                    .build();

            Episode episode26 = Episode.builder()
                    .title("Su Casa Es Mi Casa")
                    .build();

            Episode episode27 = Episode.builder()
                    .title("In Case of Emergency")
                    .build();

            Episode episode28 = Episode.builder()
                    .title("BFF")
                    .build();

            Episode episode29 = Episode.builder()
                    .title("Fire Pink")
                    .build();

            Episode episode30 = Episode.builder()
                    .title("All in")
                    .build();


            Season season1 = Season.builder()
                    .numberOfEpisodes(10)
                    .seasonNumber(1)
                    .episode(episode1)
                    .episode(episode2)
                    .episode(episode3)
                    .episode(episode4)
                    .episode(episode5)
                    .episode(episode6)
                    .episode(episode7)
                    .episode(episode8)
                    .episode(episode9)
                    .episode(episode10)
                    .build();

            Season season2 = Season.builder()
                    .numberOfEpisodes(10)
                    .seasonNumber(2)
                    .episode(episode11)
                    .episode(episode12)
                    .episode(episode13)
                    .episode(episode14)
                    .episode(episode15)
                    .episode(episode16)
                    .episode(episode17)
                    .episode(episode18)
                    .episode(episode19)
                    .episode(episode20)
                    .build();

            Season season3 = Season.builder()
                    .numberOfEpisodes(10)
                    .seasonNumber(3)
                    .episode(episode21)
                    .episode(episode22)
                    .episode(episode23)
                    .episode(episode24)
                    .episode(episode25)
                    .episode(episode26)
                    .episode(episode27)
                    .episode(episode28)
                    .episode(episode29)
                    .episode(episode30)
                    .build();

            Series ozark = Series.builder()
                    .title("Ozark")
                    .distributor("Netflix")
                    .countryOfOrigin("USA")
                    .season(season1)
                    .season(season2)
                    .season(season3)
                    .numberOfSeasons(3)
                    .numberOfEpisodes(30)
                    .releaseYear(LocalDate.of(2017, 07, 21))
                    .build();

            season1.setSeries(ozark);
            season2.setSeries(ozark);
            season3.setSeries(ozark);

            episode1.setSeason(season1);
            episode2.setSeason(season1);
            episode3.setSeason(season1);
            episode4.setSeason(season1);
            episode5.setSeason(season1);
            episode6.setSeason(season1);
            episode7.setSeason(season1);
            episode8.setSeason(season1);
            episode9.setSeason(season1);
            episode10.setSeason(season1);

            episode11.setSeason(season2);
            episode12.setSeason(season2);
            episode13.setSeason(season2);
            episode14.setSeason(season2);
            episode15.setSeason(season2);
            episode16.setSeason(season2);
            episode17.setSeason(season2);
            episode18.setSeason(season2);
            episode19.setSeason(season2);
            episode20.setSeason(season2);

            episode21.setSeason(season3);
            episode22.setSeason(season3);
            episode23.setSeason(season3);
            episode24.setSeason(season3);
            episode25.setSeason(season3);
            episode26.setSeason(season3);
            episode27.setSeason(season3);
            episode28.setSeason(season3);
            episode29.setSeason(season3);
            episode30.setSeason(season3);

            seriesRepository.save(ozark);
        };
        return clr;
    }
}
