package com.codecool.jpaseriesapp.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data // getters, setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {
    @Id
    @GeneratedValue
    private int id;

    private String title;

    @ManyToOne
    private Season season;

}
