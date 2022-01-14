package com.wtiinfo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wtiinfo.dsmovie.entities.Score;
import com.wtiinfo.dsmovie.entities.ScorePK;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
