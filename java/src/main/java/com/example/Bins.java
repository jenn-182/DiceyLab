package com.example;

import java.util.HashMap;
import java.util.Map;

//-----SUMMARY-----

//The Bins class is your counting machine for dice sums
//You tell it what range of sums it should count (min to max)
//You tell it to incrementBin() when a specific sum happens, and it adds a checkmark to the right box
//You can getBin() to find out how many checkmarks are in any specific box, or getTotalTosses() for the grand total



//---Blue Print for Counting Machine---

// Purpose: Bins class represents a collection of bins for dice rolls and stores their results
// Think of it like => Bins class is a counting machine for dice sums
// private min & max -> Tell it what range of sums to count; "whats the smallest sum ill count and whats the largest sum ill count?" 

public class Bins {

    // Variables 
    private int min;
    private int max;

    // Use a HashMap to store the bins and their counts
    // <Integer, Integer> => Just means the labels and counts will be whole numbers 
    private Map<Integer, Integer> bins;

    // Hold grand total of all rolls
    // long -> because were rolling A LOT of dice
    private long totalRolls;


    //------Initialize Bins ------

    // Hash Maps => store the results of each bin
    // Purpose: For every possible sum from min to max (2,3,4,etc), create a container with that number as its label and put 0 in it because we havent counted yet
    // This is our CONSTRUCTOR
    // Think of it like: Hash maps create a collection of labeled containers & each container is like a box that will hold the count of how many times we've rolled that sum
    // int min -> the smallest sum we can roll with the dice (with 2 dice, the smallest sum is 2)
    // int max -> the largest sum we can roll with the dice (with 2 dice, the largest sum is 12)
    // this.binCounts = new HashMap<>(); => This is where we create the HashMap to hold our bins
    // binCounts.put(i, 0); => This initializes each bin with a count of 0 because we haven't rolled any dice yet


    public Bins(int min, int max) {
        if (min > max) {
            System.out.println("ERR, min bin number cannot be greater than max bin number");
            this.min = 1;
            this.max = 6;
        } else {
            this.min = min;
            this.max = max;
        }

        this.bins = new HashMap<>();

        //initialize bins to 0
        for (int i = this.min; i <= this.max; i++) {
            bins.put(i, 0);
        }
        this.totalRolls = 0;
    }


    //------Getters for Bins ------
    
    // Purpose: Get the current count for a specific bin number
    // You getBin to find out how many checkmarks are in a specific box
    // Think of it like: "Hey how many checkmarks do I have in this box labeled 4?""
    // You get totalRolls for the grand total of all checkmarks


    public Integer getBin(int binNumber) {
        if (binNumber < this.min || binNumber > this.max) {
            System.out.println("ERR, bin number is out of range");
            return null;
        }
        //return 0 if the bin does not exist
        return bins.putIfAbsent(binNumber, 0);
    }


    //----- Increment the bin for a given number-----

    // Purpose: Tell the computer which bin number to add a checkmark to
    // You increment a bin when a specific sum happens and it adds a checkmark to the right box
    // Think of it like: "Hey, I just rolled a 4, so add a checkmark to the box labeled 4"
    // If < min or > max  -> If the bin number is out of range, the code says hey this is smaller than our min or max so print an error
    // bins.put (binNumber, bins.get(binNumber) + 1) -> Get the current total count from that bin and then add one more
    // totalRolls++ -> Increment the total rolls by 1
    // Think of it like: "Hey, I just rolled a die, so add one more checkmark to the total"

    public void incrementBin(int binNumber) {
        if (binNumber < this.min || binNumber > this.max) {
            System.out.println("ERR, bin number is out of range");
            return;
        }       
        // Increment the bin value by 1
        bins.put(binNumber, bins.get(binNumber) + 1);
        totalRolls++;
    }


    //----- Return Min, Max, and Total Rolls -----

    // Purpose: Get the minimum and maximum bin numbers and the total number of rolls
    // Act as labels on our counting machine and tells us settings and overall progress
    // They just GIVE you information, they dont change anything

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public long getTotalRolls() {
        return totalRolls;
    }

}
