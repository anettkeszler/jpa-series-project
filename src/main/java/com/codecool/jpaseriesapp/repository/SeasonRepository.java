package com.codecool.jpaseriesapp.repository;

import com.codecool.jpaseriesapp.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
