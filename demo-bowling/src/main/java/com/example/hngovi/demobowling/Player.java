package com.example.hngovi.demobowling;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Player {
    private String name;
    private Score score = new Score();
    private int currentTurn = 0;

    public Player(String name) {
        this.name = name;
    }

    public void play() {
        if (currentTurn == 9) {
            playLastFrame();
        } else {
            playFrame();
        }
    }

    private void playFrame() {
        Frame frame = new Frame();
        Throw first = new Throw();
        first.knockdown();
        if (first.getPins() < Game.ALL_PINS) {
            Throw second = new Throw();
            second.knockdown();
            frame.getMyThrows()[1] = second;

        }
        frame.getMyThrows()[0] = first;
        frame.countScoreResult();
        score.getFrames()[currentTurn] = frame;
        score.countScoreResult();
        currentTurn++;
    }

    private void playLastFrame() {
        LastFrame lastFrame = new LastFrame();
        Throw first = new Throw();
        first.knockdown();
        lastFrame.getMyThrows()[0] = first;
        Throw second = new Throw();
        second.knockdown();
        lastFrame.getMyThrows()[1] = second;
        if (first.getPins() == Game.ALL_PINS
                || (first.getPins() + second.getPins()) == Game.ALL_PINS) {
            Throw extraThrow = new Throw();
            extraThrow.knockdown();
            lastFrame.setExtraThrow(extraThrow);
        }
        lastFrame.countScoreResult();
        score.setLastFrame(lastFrame);
        score.countScoreResult();
        currentTurn = 0;
    }
}
