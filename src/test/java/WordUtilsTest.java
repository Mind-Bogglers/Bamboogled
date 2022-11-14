import com.backend.BoggleGrid;
import com.backend.Dictionary;
import com.backend.engine.WordUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordUtilsTest {
    @Test
    public void TestFindAllWordsSmall() {
        BoggleGrid boggleGrid = new BoggleGrid(4);
        boggleGrid.initalizeBoard("SETSPIRDLANESETS");
        Dictionary dict = new Dictionary("src/main/java/com/backend/wordlist.txt");
        assertEquals(WordUtils.findAllWords(dict, boggleGrid).size(), 567);
    }

    @Test
    public void TestFindAllWordsBig() {
        BoggleGrid boggleGrid = new BoggleGrid(5);
        boggleGrid.initalizeBoard("RSLCSDEIAEGNTRPATESESMIDR ");
        Dictionary dict = new Dictionary("src/main/java/com/backend/wordlist.txt");
        assertEquals(WordUtils.findAllWords(dict, boggleGrid).size(), 1112);
    }
}
