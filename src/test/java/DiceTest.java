import com.backend.dice.BoardLetterGeneratorSmall;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiceTest {

    @Test
    public void testBoardLetterGeneratorSmallRandomGenerateString() {
        BoardLetterGeneratorSmall smallGenerator = new BoardLetterGeneratorSmall();
        for (int i = 0; i < 100; i++) {
            assertEquals(smallGenerator.generateString().length(), 16);
        }
    }

}

