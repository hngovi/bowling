package com.example.hngovi.demobowling;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class Game {
    public static final int ALL_PINS = 10;

    private Map<Long, Player> league;

    public Game() {
        league = new HashMap<>();
        league.put(1L, new Player("Player 1"));
        league.put(2L, new Player("Player 1"));
        league.put(3L, new Player("Player 1"));
        league.put(4L, new Player("Player 1"));
        league.put(5L, new Player("Player 1"));
        league.put(6L, new Player("Player 1"));
    }
}
