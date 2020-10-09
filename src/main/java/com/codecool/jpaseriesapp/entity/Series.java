package com.codecool.jpaseriesapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Lombok annotations
@Data // getters, setters, constructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
// JPA annotation
@Entity
public class Series {
    @Id
    @GeneratedValue
    private Long id;


}
