package com.example.hngovi.demobowling;

import lombok.Getter;
import lombok.Setter;

public class LastFrame extends Frame {
    @Setter
    @Getter
    private Throw extraThrow = new Throw();

    @Override
    public void countScoreResult() {
        for(Throw throwItem : getMyThrows()) {
            if(throwItem.getPins() == Game.ALL_PINS) {
                setResultType(ResultType.STRIKE);
            }
            setScoreResult(getScoreResult() +throwItem.getPins());
        }

        if(getScoreResult() == Game.ALL_PINS) {
            setResultType(ResultType.SPARE);
        }

        if(getResultType() == ResultType.STRIKE || getResultType() == ResultType.SPARE) {
            setScoreResult(getScoreResult() + extraThrow.getPins());
        }

    }
}
