package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinsTest {

    private Bins bins;

    @Before
    public void setUp() {
        bins = new Bins(2, 12); // typical for two dice
    }

    @Test
    public void testInitialization() {
        for (int i = 2; i <= 12; i++) {
            assertEquals("Bin should initialize to 0", (Integer) 0, bins.getBin(i));
        }
    }

    @Test
    public void testIncrementBin() {
        bins.incrementBin(7);
        assertEquals("Bin 7 should be incremented to 1", (Integer) 1, bins.getBin(7));
        bins.incrementBin(7);
        assertEquals("Bin 7 should be incremented to 2", (Integer) 2, bins.getBin(7));
    }

    @Test
    public void testTotalRolls() {
        bins.incrementBin(3);
        bins.incrementBin(4);
        bins.incrementBin(5);
        assertEquals("Total rolls should be 3", 3, bins.getTotalRolls());
    }

    @Test
    public void testOutOfRangeBin() {
        assertNull("Bin below min should return null", bins.getBin(1));
        assertNull("Bin above max should return null", bins.getBin(13));
    }

    @Test
    public void testIncrementOutOfRangeDoesNotAffectTotal() {
        long before = bins.getTotalRolls();
        bins.incrementBin(1); // out of range
        bins.incrementBin(13); // out of range
        assertEquals("Total rolls should not change for out-of-range bins", before, bins.getTotalRolls());
    }
}