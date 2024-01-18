package org.sachco.learn.mc;

import org.sachco.learn.mc.controller.JackpotGame;
import org.sachco.learn.mc.controller.NumberedJackpot;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JackpotGame jackpotGame = new NumberedJackpot(
                Arrays.asList("132", "432"),
                10,
                3,
                Arrays.asList(2, 3));
        jackpotGame.startGame();
    }
}