package com.example.hngovi.demobowling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Frame {
    @Getter
    private Throw[] myThrows = new Throw[2];

    @Getter
    @Setter
    private int scoreResult = 0;

    @Setter
    @Getter
    private ResultType resultType = ResultType.NORMAL;

    public void countScoreResult() {
        for(Throw throwItem : myThrows) {
            if(throwItem.getPins() == Game.ALL_PINS) {
                this.resultType = ResultType.STRIKE;
                break;
            }
            this.scoreResult += throwItem.getPins();
        }
        if(this.scoreResult == Game.ALL_PINS) {
            this.resultType = ResultType.SPARE;
            this.scoreResult = 0;
        }
    }

    public static enum ResultType {
        NORMAL, SPARE, STRIKE

    }
}
