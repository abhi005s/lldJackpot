package org.sachco.learn.mc.controller;

import org.sachco.learn.mc.model.Pair;
import org.sachco.learn.mc.service.NumberedSvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: sachco at date: 18/01/24.
 */
public class NumberedJackpot implements JackpotGame{

    private final List<String> winningSequences;
    private static final char[] charPool = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private int numberOfAttempts;
    private final int numberOfSlots;
    private final List<String> outComes;
    private final NumberedSvc numberedSvc;
    private final List<Integer> winConsecutiveNumOfChars;
    public NumberedJackpot(List<String> winningSequences, int numberOfAttempts, int numberOfSlots,
                           List<Integer> winConsecutiveNumOfChars) {
        this.winningSequences = winningSequences;
        this.numberOfAttempts = numberOfAttempts;
        this.numberOfSlots = numberOfSlots;
        this.winConsecutiveNumOfChars = winConsecutiveNumOfChars;
        outComes = new ArrayList<>();
        numberedSvc = new NumberedSvc();
    }

    @Override
    public void startGame() {
        while(numberOfAttempts-- > 0) {
            Pair<String, String> attempt = numberedSvc.pullTrigger(
                    charPool, outComes, numberOfSlots,
                    winningSequences, winConsecutiveNumOfChars);
            System.out.println("| "+attempt.getKey() + "---" +attempt.getValue()+" |");
        }
    }
}
