package com.genspark.gameLibrary.DAO;

import com.genspark.gameLibrary.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDAO extends JpaRepository<Game, Integer> {
}
