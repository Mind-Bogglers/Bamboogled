import com.bamboogled.model.grid.BoggleGrid;
import com.bamboogled.model.word.BoggleDictionary;
import com.bamboogled.model.word.WordUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordUtilsTest {
    @Test
    public void TestFindAllWordsSmall() {
        BoggleGrid boggleGrid = new BoggleGrid(4);
        boggleGrid.initalizeBoard("SETSPIRDLANESETS");
        BoggleDictionary dict = new BoggleDictionary("src/main/java/com/backend/wordlist2.txt");
        assertEquals(WordUtils.findAllWords(dict, boggleGrid).size(), 567);
    }

    @Test
    public void TestFindAllWordsBig() {
        BoggleGrid boggleGrid = new BoggleGrid(5);
        boggleGrid.initalizeBoard("RSLCSDEIAEGNTRPATESESMIDR ");
        BoggleDictionary dict = new BoggleDictionary("src/main/java/com/backend/wordlist2.txt");
        assertEquals(WordUtils.findAllWords(dict, boggleGrid).size(), 1112);
    }
}
