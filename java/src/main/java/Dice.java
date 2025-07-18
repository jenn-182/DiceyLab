import java.util.Random;

//---SUMMARY-----

//The Dice class is a factory that makes dice sets
// When you make a new set (new Dice(2)), it remembers how many dice are in it
// When you tell it to tossAndSum(), it rolls each of its dice randomly (from 1 to 6) and gives you the total
// You can also ask it getNumberOfDies() to find out how many dice are in that set


//---Blue Print for Dice Factory---

// Purpose: Represents a set of dice and provides methods to roll them and get the number of dice
// Think of it like this: Drawing plans for a specific type of toy.
// Every time you want a new set of dice in your program, you'll use this blueprint.
// numberOfDies => stores the number of dice in the set; "How many dice do you want in this set?" 
// The CONSTRUCTOR -> like the "assembly instructions" for when you first build a new Dice toy 
// So when you say new Dice(2), this code runs.

public class Dice {

    Random random = new Random();

    private int numberOfDies; // How many dice are in this set?

    public Dice(int numberOfDies) {

        if (numberOfDies <= 0) {
            System.out.println("Number of dies must be greater than 0");
            return;
        } else {
            this.numberOfDies = numberOfDies; //sets the number of dice in this set
        }
        
        //Initialize the random number generator
        this.random = new Random();
    }


    //------Toss and Sum------
    
    // ACTION method / verb
    // Purpose: Simulates rolling the dice and returns the sum of the rolled values
    // Think of it like : a button on your Dice toy that says "Roll!" When you press it, the dice will roll, and it will tell you the total.
    // For loop => "Do the following steps over and over again, once for each die in our set."
    // random.nextInt(6) => "Roll a die and get a random number between 1 and 5"
    // + 1 => "Add 1 to that number because we want it to be between 1 and 6, not 0 and 5"
    // sum => "Add up all the numbers we rolled to get the total"
   
    // Simulates a set of N random dice rolls
    public Integer tossAndSum() { 
        int sum = 0;
       
        for (int i = 0; i < numberOfDies; i++) {
            sum = sum + (random.nextInt(6) + 1); //random number between 1 and 6
        }
        return sum;
    }


    //------Get Number of Dies------

    // Purpose: Get information; doesnt change anything
    // Think of it like: Asking your Dice toy "How many dice do you have?"

    // Returns the number of dies
    public int getNumberOfDies() {
        return numberOfDies;
    }
}

