package com.codecool.jpaseriesapp.repository;

import com.codecool.jpaseriesapp.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
