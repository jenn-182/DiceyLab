package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class SimulationTest {

    @Test
    public void testSimulationRunsAndCounts() {
        int numberOfDies = 2;
        int numberOfRolls = 1000;
        Simulation simulation = new Simulation(numberOfDies, numberOfRolls);
        simulation.runSimulation();

        // Check that the total number of rolls counted matches the number requested
        int min = simulation.getResults().getMin();
        int max = simulation.getResults().getMax();
        int totalCounted = 0;
        for (int i = min; i <= max; i++) {
            Integer count = simulation.getResults().getBin(i);
            if (count != null) {
                totalCounted += count;
            }
        }
        assertEquals("Total rolls counted should match numberOfRolls", numberOfRolls, totalCounted);
    }

    @Test
    public void testSimulationPrintResultsDoesNotThrow() {
        Simulation simulation = new Simulation(2, 100);
        simulation.runSimulation();
        // This should not throw any exceptions
        simulation.printResults();
    }
}