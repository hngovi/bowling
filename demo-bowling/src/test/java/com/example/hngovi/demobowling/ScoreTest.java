package com.example.hngovi.demobowling;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {

    Score score;

    @Test
    void testCountScoreResult_whenNormal() {
        Frame frame1 = new Frame();
        frame1.getMyThrows()[0] = new Throw(1);
        frame1.getMyThrows()[1] = new Throw(4);
        frame1.countScoreResult();

        Frame frame2 = new Frame();
        frame2.getMyThrows()[0] = new Throw(4);
        frame2.getMyThrows()[1] = new Throw(5);
        frame2.countScoreResult();

        score = new Score();
        score.getFrames()[0] = frame1;
        score.getFrames()[1] = frame2;

        score.countScoreResult();
        assertEquals(14, score.getScoreResult());
    }

    @Test
    void testCountScoreResult_whenSpare() {
        Frame frame1 = new Frame();
        frame1.getMyThrows()[0] = new Throw(1);
        frame1.getMyThrows()[1] = new Throw(9);
        frame1.countScoreResult();

        Frame frame2 = new Frame();
        frame2.getMyThrows()[0] = new Throw(4);
        frame2.getMyThrows()[1] = new Throw(5);
        frame2.countScoreResult();

        score = new Score();
        score.getFrames()[0] = frame1;
        score.getFrames()[1] = frame2;

        score.countScoreResult();
        assertEquals(23, score.getScoreResult());
    }

    @Test
    void testCountScoreResult_whenStrike() {
        Frame frame1 = new Frame();
        frame1.getMyThrows()[0] = new Throw(10);
        frame1.countScoreResult();

        Frame frame2 = new Frame();
        frame2.getMyThrows()[0] = new Throw(4);
        frame2.getMyThrows()[1] = new Throw(5);
        frame2.countScoreResult();

        score = new Score();
        score.getFrames()[0] = frame1;
        score.getFrames()[1] = frame2;

        score.countScoreResult();
        assertEquals(28, score.getScoreResult());
    }

    @Test
    void testCountScoreResult_whenLastFrame() {
        Frame frame1 = new Frame();
        frame1.getMyThrows()[0] = new Throw(10);
        frame1.countScoreResult();

        Frame frame2 = new Frame();
        frame2.getMyThrows()[0] = new Throw(4);
        frame2.getMyThrows()[1] = new Throw(5);
        frame2.countScoreResult();

        Frame frame3 = new Frame();
        frame3.getMyThrows()[0] = new Throw(4);
        frame3.getMyThrows()[1] = new Throw(5);
        frame3.countScoreResult();

        Frame frame4 = new Frame();
        frame4.getMyThrows()[0] = new Throw(4);
        frame4.getMyThrows()[1] = new Throw(5);
        frame4.countScoreResult();

        Frame frame5 = new Frame();
        frame5.getMyThrows()[0] = new Throw(4);
        frame5.getMyThrows()[1] = new Throw(5);
        frame5.countScoreResult();

        Frame frame6 = new Frame();
        frame6.getMyThrows()[0] = new Throw(4);
        frame6.getMyThrows()[1] = new Throw(5);
        frame6.countScoreResult();

        Frame frame7 = new Frame();
        frame7.getMyThrows()[0] = new Throw(4);
        frame7.getMyThrows()[1] = new Throw(5);
        frame7.countScoreResult();

        Frame frame8 = new Frame();
        frame8.getMyThrows()[0] = new Throw(4);
        frame8.getMyThrows()[1] = new Throw(5);
        frame8.countScoreResult();

        Frame frame9 = new Frame();
        frame9.getMyThrows()[0] = new Throw(4);
        frame9.getMyThrows()[1] = new Throw(5);
        frame9.countScoreResult();

        LastFrame frame10 = new LastFrame();
        frame10.getMyThrows()[0] = new Throw(10);
        frame10.getMyThrows()[1] = new Throw(10);
        frame10.getExtraThrow().setPins(10);
        frame10.countScoreResult();

        score = new Score();
        score.getFrames()[0] = frame1;
        score.getFrames()[1] = frame2;
        score.getFrames()[2] = frame3;
        score.getFrames()[3] = frame4;
        score.getFrames()[4] = frame5;
        score.getFrames()[5] = frame6;
        score.getFrames()[6] = frame7;
        score.getFrames()[7] = frame8;
        score.getFrames()[8] = frame9;
        score.setLastFrame(frame10);
        score.countScoreResult();

        assertEquals(121, score.getScoreResult());
    }
}
