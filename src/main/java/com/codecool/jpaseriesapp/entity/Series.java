package com.codecool.jpaseriesapp.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

@Data // getters, setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;
    private LocalDate releaseYear;
    private int numberOfSeasons;
    private int numberOfEpisodes;
    private String distributor;
    private String countryOfOrigin;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Singular("genre")
    @ElementCollection
    private List<String> genres;

    @Singular("actor")
    @ElementCollection
    private List<String> actors;

    @Singular("season")
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Season> seasonSet;

    @Transient
    private long age;

    public void calculateAge() {
        if (releaseYear != null) {
            age = ChronoUnit.YEARS.between(releaseYear, LocalDate.now());
        }
    }

}
