import java.util.Random;

public class Dice {

    //initiate random number generator
    Random random = new Random();

    //initiate variable for number of dice
    private int numberOfDies;

    //Set error if number of dies is less than or equal to 0
    public Dice(int numberOfDies) {

        //Initialize the number of dies
        if (numberOfDies <= 0) {
            System.out.println("Number of dies must be greater than 0");
            return;
        } else {
            this.numberOfDies = numberOfDies;
        }
        
        //Initialize the random number generator
        this.random = new Random();
    }
   
    // Simulates a set of N random dice rolls
    public Integer tossAndSum() { 
        int sum = 0;
        //loop through the number of dice
        //and generate a random number between 1 and 6 for each die
        for (int i = 0; i < numberOfDies; i++) {
            sum = sum + (random.nextInt(6) + 1); 
        }
        return sum;
    }

    // Returns the number of dies
    public int getNumberOfDies() {
        return numberOfDies;
    }

public static void main(String[] args) {

    Dice myDice = new Dice(2);
    Dice myDice2 = new Dice(5);

    Integer roll1 = myDice.tossAndSum();
    Integer roll2 = myDice2.tossAndSum();

    System.out.println("Roll 1: " + roll1);
    System.out.println("Roll 2: " + roll2);

    System.out.println("Number of dies in roll 1: " + myDice.getNumberOfDies());
    System.out.println("Number of dies in roll 2: " + myDice2.getNumberOfDies());
    }
}

