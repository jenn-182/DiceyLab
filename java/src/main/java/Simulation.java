import java.text.DecimalFormat;


public class Simulation {

    // Variables to hold the number of dice, rolls, and results
    private int numberOfDies;
    private int numberOfRolls;
    private Dice dice;
    private Bins results;

    //------Initialize Simulation------

    public Simulation(int numberOfDies, int numberOfRolls) {

        //edge cases 
        if (numberOfDies <= 0) {
            System.out.println("ERR, number of dies must be greater than 0: Defaulting to 2 dice");
            this.numberOfDies = 2; // default to 2 dice
        } else {
            this.numberOfDies = numberOfDies;
        }

        if (numberOfRolls <= 0) {
            System.out.println("ERR, number of rolls must be greater than 0: Defaulting to 1 roll");
            this.numberOfRolls = 1; // default to 1 roll
        } else {
            this.numberOfRolls = numberOfRolls;
        }

        // Initialize the Dice object with the number of dice
        this.dice = new Dice(this.numberOfDies);

        // Calculate the minimum and maximum sums based on the number of dice
        int minSum = this.numberOfDies*1; // minimum sum --> all dice show 1
        int maxSum = this.numberOfDies*6; // maximum sum --> all dice show 6

        // Initialize the Bins object with the min and max sums
        this.results = new Bins(minSum, maxSum); 
    }


    //------Run Simulation------
    public void runSimulation() {
        // Loop through the number of rolls
        for (int i = 0; i < this.numberOfRolls; i++) {
            // Roll the dice and get the sum
            int rollResult = this.dice.tossAndSum();
            // Increment the bin for the roll result
            this.results.incrementBin(rollResult);
        }

        // Print the results of the simulation
        System.out.println("Simulation Completed!");
    }


    //------Print Results ------

    public void printResults() {
        StringBuilder output = new StringBuilder();
        output.append("Results of the Simulation:\n");
        output.append("Number of Dice: " + this.numberOfDies + "\n");
        output.append("Number of Rolls: " + this.numberOfRolls + "\n");
        output.append("Results:\n");

        // Format output to percentage
        DecimalFormat df = new DecimalFormat("0.00");

        int min = this.results.getMin();
        int max = this.results.getMax();

        // Loop through the bins, increment line for each bin
        for (int i = min; i <= max; i++) {

            // Get the bin value
            int binValue = this.results.getBin(i);

            // Calculate the percentage of the bin value
            double percentage = (double) binValue / this.numberOfRolls;

            //calculate number of asterisks
            int maxAsterisks = 16; // maximum number of asterisks per line
            int numberOfAsterisks = (int)Math.round(percentage * 100 * (maxAsterisks/16.0));

            // Create a string of asterisks based on the percentage
            StringBuilder asterisks = new StringBuilder();
            for (int j = 0; j < numberOfAsterisks; j++) {
                asterisks.append("*");
            }

            //format output to include bin number, bin value, percentage, and asterisks
            output.append(String.format("%2d: %8d: %s %s\n", i, binValue, df.format(percentage * 100), asterisks.toString()));
            
        }

        // Print the final output
        System.out.println(output.toString());

    }


    //------Main Method for Testing ------

    public static void main(String[] args) {
        
        // Create a Simulation object with 2 dice and 1,000,000 rolls
        Simulation simulation = new Simulation(2, 1000000);
        
        //runSimulation and print results
        simulation.runSimulation();
        simulation.printResults();
    }
}
