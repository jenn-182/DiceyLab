package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void testGetNumberOfDice() {
        Dice dice = new Dice(3);
        assertEquals(3, dice.getNumberOfDice());
    }

    @Test
    public void testTossAndSumRange() {
        Dice dice = new Dice(2);
        for (int i = 0; i < 100; i++) {
            int sum = dice.tossAndSum();
            assertTrue("Sum should be at least 2", sum >= 2);
            assertTrue("Sum should be at most 12", sum <= 12);
        }
    }

    @Test
    public void testTossAndSumRandomness() {
        Dice dice = new Dice(2);
        boolean foundDifferent = false;
        int first = dice.tossAndSum();
        for (int i = 0; i < 20; i++) {
            if (dice.tossAndSum() != first) {
                foundDifferent = true;
                break;
            }
        }
        assertTrue("tossAndSum should produce different results", foundDifferent);
    }

    @Test
    public void testZeroDice() {
        Dice dice = new Dice(0);
        assertEquals(0, dice.getNumberOfDice());
        assertEquals(0, (int)dice.tossAndSum());
    }
}