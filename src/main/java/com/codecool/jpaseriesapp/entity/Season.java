package com.codecool.jpaseriesapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data // getters, setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {
    @Id
    @GeneratedValue
    private Long id;

    private int seasonNumber;
    private int numberOfEpisodes;

    @ManyToOne
    private Series series;

    @Singular("episode")
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Episode> episodeSet;

}
