package org.sachco.learn.mc.service;

import org.sachco.learn.mc.model.Pair;

import java.util.List;
import java.util.Random;

/**
 * Created by: sachco at date: 18/01/24.
 */
public class NumberedSvc {
    private final Random rand = new Random();
    private final StringBuilder sb = new StringBuilder();

    public Pair<String, String> pullTrigger(char[] charPool,
                                             List<String> outComes,
                                             int numberOfSlots,
                                             List<String> customWinningSequences,
                                             List<Integer> winConsecutiveNumOfChars) {
        sb.setLength(0);
        int charPoolSize = charPool.length;
        while (numberOfSlots-- > 0) sb.append(charPool[rand.nextInt(charPoolSize)]);
        String outCome = sb.toString();
        outComes.add(outCome);
        boolean won = customWinningSequences.contains(outCome) ||
                defaultWinningSequences(outCome, winConsecutiveNumOfChars);
        return new Pair<>(outCome, won ? "Hit the Jackpot" : "Oops try again!");
    }

    private boolean defaultWinningSequences(String outCome, List<Integer> winConsecutiveNumOfChars) {
        int len = outCome.length();
        int count = 1;
        char prev = outCome.charAt(0);
        for (int i = 1; i < len; i++) {
            if(outCome.charAt(i) == prev) count++;
            else {
                prev = outCome.charAt(i);
                count = 1;
            }
            if(winConsecutiveNumOfChars.contains(count)) {
                return true;
            }
        }
        return false;
    }
}
