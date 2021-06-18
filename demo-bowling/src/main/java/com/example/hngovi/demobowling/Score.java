package com.example.hngovi.demobowling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Score {
    @Getter
    private Frame[] frames = new Frame[9];

    @Setter
    @Getter
    private LastFrame lastFrame;

    @Getter
    private int scoreResult = 0;

    public void countScoreResult() {
        for (int i = 0; i < frames.length; i++) {
            Frame frame = frames[i];
            if (frame == null) {
                break;
            }

            switch (i) {
                case 0:
                    handlingFirstFrame(frame);
                    break;
                default:
                    handlingFrame(frame, i);
            }
        }

        // Last Frame
        if(frames[8] != null && lastFrame != null) {
            handingLastFrame();
        }
    }

    private void handlingFrame(Frame frame, int i) {
        Frame previous = frames[i-1];
        switch (frame.getResultType()) {
            case NORMAL:
                int currentResult = frame.getScoreResult();
                scoreResult += currentResult;
                if(previous.getResultType() == Frame.ResultType.SPARE) {
                    scoreResult += addScoreDueToSpareOrStrike(frame.getMyThrows()[0].getPins());
                }
                if(previous.getResultType() == Frame.ResultType.STRIKE) {
                    scoreResult += addScoreDueToSpareOrStrike(currentResult);
                }
                break;
            case SPARE:
            case STRIKE:
                break;
        }
    }

    private void handingLastFrame() {
        int currentResult = lastFrame.getScoreResult();
        scoreResult += currentResult;
        Frame previous = frames[9-1];
        if(previous.getResultType() == Frame.ResultType.SPARE) {
            scoreResult += addScoreDueToSpareOrStrike(lastFrame.getMyThrows()[0].getPins());
        }
        if(previous.getResultType() == Frame.ResultType.STRIKE) {
            scoreResult += addScoreDueToSpareOrStrike(lastFrame.getMyThrows()[0].getPins()
            + lastFrame.getMyThrows()[1].getPins());
        }

    }

    private void handlingFirstFrame(Frame frame) {
        switch (frame.getResultType()) {
            case NORMAL:
                int currentResult = frame.getScoreResult();
                scoreResult += currentResult;
                break;
            case SPARE:
            case STRIKE:
                break;
        }
    }

    private int addScoreDueToSpareOrStrike(int scoreToAdd) {
        return Game.ALL_PINS + scoreToAdd;
    }

}
