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

            Season season1 = Season.builder()
                    .numberOfEpisodes(10)
                    .seasonNumber(1)
                    .episode(episode1)
                    .episode(episode2)
                    .build();

            Season season2 = Season.builder()
                    .numberOfEpisodes(10)
                    .seasonNumber(2)
                    .episode(episode3)
                    .build();

            Series ozark = Series.builder()
                    .title("Ozark")
                    .distributor("Netflix")
                    .countryOfOrigin("USA")
                    .season(season1)
                    .season(season2)
                    .numberOfSeasons(3)
                    .numberOfEpisodes(30)
                    .releaseYear(LocalDate.of(2017, 07, 21))
                    .build();

//            ozark.calculateAge();

            season1.setSeries(ozark);
            season2.setSeries(ozark);

            episode1.setSeason(season1);
            episode2.setSeason(season1);

            episode3.setSeason(season2);

            seriesRepository.save(ozark);
        };
        return clr;
    }
}
