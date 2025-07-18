import org.junit.Test;
import static org.junit.Assert.*;
import DiceyLab.Dice;

// Import Dice class if it's in another package
// import DiceyLab.Dice;

public class DiceTest {
    // Test the roll method returns a value between 1 and 6
    // Test the tossAndSum method returns a value between numberOfDice and numberOfDice * 6
    @Test
    public void testTossAndSumWithTwoDice() {
        Dice diceTwo = new Dice(2);
        int result = diceTwo.tossAndSum();
        assertTrue(result >= 2 && result <= 12);
    }

    @Test
    public void testTossAndSumWithFiveDice() {
        Dice diceFive = new Dice(5);
        int result = diceFive.tossAndSum();
        assertTrue(result >= 5 && result <= 30);
    }

    @Test
    public void testGetNumberOfDies() {
        Dice diceTwo = new Dice(2);
        Dice diceFive = new Dice(5);
        assertEquals(2, diceTwo.getNumberOfDies().intValue());
        assertEquals(5, diceFive.getNumberOfDies().intValue());
    }



}

