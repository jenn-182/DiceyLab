import java.text.DecimalFormat;

//---SUMMARY-----

//The Simulation class is the boss that runs the whole show.
// It sets up the dice (Dice object) and the counter (Bins object).
// It then repeatedly rolls the dice and tells the counter to mark down each result.
// Finally, it prints a summary report of all the counts, showing percentages and little asterisk graphs.


//---Blue Print for Simulation---

// Purpose: Represents a simulation of rolling dice and counting the results
// Think of it like this: A Simulation class is like a game master that runs the dice rolling game.

public class Simulation {

    // Variables to hold the number of dice, rolls, and results
    // numberOfDies => a box that remembers how many dice we want to roll
    // numberOfRolls => a box that remembers how many times we want to roll (1,000,000 in this case)
    // Dice dice; => where we keep our "Dice Roller" toy (the Dice object) so the director can tell it to roll.
    // Bins results; => where we'll keep our "Counting Machine" (the Bins object) so the director can tell it to count the results.


    private int numberOfDies;
    private int numberOfRolls;
    private Dice dice;
    private Bins results;


    //------Initialize Simulation------

    // This is our CONSTRUCTOR
    // Purpose: Initializes the simulation with a specified number of dice and rolls
    // Think of it like: When you first set up the game, you decide how many dice you want to roll and how many times you want to roll them.
    // So when we say new Simulation(2, 1000000), this code runs.

    // int numberOfDies, int numberOfRolls => "How many dice per roll, and how many total rolls?"
    // this.dice = new Dice =>  Now that we know how many dice per roll, let's actually build our Dice toy and put it in its spot
    // this.results = new Bins(minSum, maxSum) => Now that we know the range of sums we can roll, let's build our counting machine and tell it what range of numbers to count

    public Simulation(int numberOfDies, int numberOfRolls) {

        //edge cases for error messages
        
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

        
        this.dice = new Dice(this.numberOfDies);

        
        int minSum = this.numberOfDies*1; // minimum sum --> all dice show 1
        int maxSum = this.numberOfDies*6; // maximum sum --> all dice show 6


        this.results = new Bins(minSum, maxSum); 
    }


    //------Run Simulation------

    // Purpose: Runs the simulation by rolling the dice and counting the results
    // Think of it like: The director tells the Dice toy to roll the dice a certain number of times, and each time it rolls, it tells the Counting Machine to mark down the result
    // void => it just does the action, it doesn't return anything
    // for loop => Repeat the following steps over and over again, for the total numberOfRolls we decided on
    // this.dice.tossAndSum() => Roll the dice and get the total and store it in rollResult
    // this.results.incrementBin(rollResult) => Tell the Counting Machine to mark down the result of this roll and store it in the right bin (adds a checkmark to the right box)
    // System.out.println => After all rolls are done, print a message saying the simulation is complete

    public void runSimulation() {
        
        for (int i = 0; i < this.numberOfRolls; i++) {
       
            int rollResult = this.dice.tossAndSum();
    
            this.results.incrementBin(rollResult);
        }

        System.out.println("Simulation Completed!");
    }


    //------Print Results ------

    // Purpose: Prints the results of the simulation in a formatted way
    // Think of it like: After the game is over, the director shows you a summary of how many times each sum was rolled, along with a percentage and a little graph
    // void => it just does the action, it doesn't return anything
    // StringBuilder output = new StringBuilder() => like a blank piece of paper where we'll slowly build up our report text
    // output.append => Add lines to our report, starting with the title and the number of dice and rolls
    // DecimalFormat df = new DecimalFormat("0.00") => This is how we format the percentages to look nice with two decimal places
    
    public void printResults() {

        StringBuilder output = new StringBuilder();
        output.append("Results of the Simulation:\n");
        output.append("Number of Dice: " + this.numberOfDies + "\n");
        output.append("Number of Rolls: " + this.numberOfRolls + "\n");
        output.append("Results:\n");


        DecimalFormat df = new DecimalFormat("0.00");

        // int min & max => Ask the Bins counting machine what its smallest and largest bin numbers are
        // For loop => now go through each bin number from the smallest to the largest
        // int binValue = this.results.getBin(i) => ask the Bins counting machine: 'How many times did this sum occur?'
        // double percentage = (double) binValue / this.numberOfRolls => Calculate what percentage of the total rolls this bin's count represents
        // int numberOfAsterisks = (int)Math.round(percentage * 100 * (maxAsterisks/16.0)) => Calculate how many asterisks to draw based on the percentage (the higher the percentage, the more asterisks
        


        int min = this.results.getMin();
        int max = this.results.getMax();

        for (int i = min; i <= max; i++) {

            int binValue = this.results.getBin(i);

            double percentage = (double) binValue / this.numberOfRolls;

        
            int maxAsterisks = 16; // maximum number of asterisks per line
            int numberOfAsterisks = (int)Math.round(percentage * 100 * (maxAsterisks/16.0));


            // StringBuilder asterisks = new StringBuilder() => get another blank piece of paper to hold the asterisks and use for loop to draw the correct number of asterisks
            // output.append(String.format(...)) => Add a line to our report with the bin number, bin value, percentage, and asterisks
            // Finally, print the whole report
            // System.out.println(output.toString()) => Print the final report to the console


            StringBuilder asterisks = new StringBuilder();
            for (int j = 0; j < numberOfAsterisks; j++) {
                asterisks.append("*");
            }


            output.append(String.format("%2d: %8d: %s %s\n", i, binValue, df.format(percentage * 100), asterisks.toString()));
            
        }

       
        System.out.println(output.toString());

    }


    //------Main Method for Testing ------

    // Purpose: The start program button (the staring point of the simulation)
    // Think of it like: When you run the program, this is where it all begins
    // Simulation simulation = new Simulation(2, 1000000) => Builds our machine and decides to use 2 dice and roll 1,000,000 times
    // simulation.runSimulation() => This is where we tell the Simulation to start rolling the dice and counting the results
    // simulation.printResults() => After the simulation is done, we print the results to the console

    public static void main(String[] args) {
        
        Simulation simulation = new Simulation(2, 1000000);
        
       
        simulation.runSimulation();
        simulation.printResults();
    }
}
