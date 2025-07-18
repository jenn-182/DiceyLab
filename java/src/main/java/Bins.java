import java.util.HashMap;
import java.util.Map;

// Bins class to represent a collection of bins for dice rolls and stores their results
// Use hash maps to store the results of each bin


public class Bins {

    // Variables for min, max, bins, and total rolls
    private int min;
    private int max;
    private Map<Integer, Integer> bins;
    private long totalRolls;



    //------Initialize Bins ------

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

    public Integer getBin(int binNumber) {
        if (binNumber < this.min || binNumber > this.max) {
            System.out.println("ERR, bin number is out of range");
            return null;
        }
        //return 0 if the bin does not exist
        return bins.putIfAbsent(binNumber, 0);
    }

    //----- Increment the bin for a given number-----

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
