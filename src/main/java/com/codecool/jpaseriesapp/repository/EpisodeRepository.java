package com.codecool.jpaseriesapp.repository;

import com.codecool.jpaseriesapp.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
