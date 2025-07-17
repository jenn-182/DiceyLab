import org.junit.Test;
import static org.junit.Assert.*;
import DiceyLab.Dice;

// Import Dice class if it's in another package
// import DiceyLab.Dice;

public class DiceTest {
    // Test the roll method returns a value between 1 and 6
    @Test
    public void testRolls() {
        Dice dice = new Dice(2);
        int result = dice.roll();
        assertTrue(result >= 1 && result <= 6);
    }
}

