package com.example.hngovi.demobowling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    Game game;

    @GetMapping("/game")
    public Game showGame() {
        return game;
    }

    @GetMapping("/players")
    public Game doPlay(@RequestParam Long playerId) {
        Player player = game.getLeague().get(playerId);
        player.play();
        return game;
    }

}
