import com.bamboogled.exceptions.GameAlreadyInProgressException;
import com.bamboogled.exceptions.GameNotInProgressException;
import com.bamboogled.exceptions.NoMorePlayersException;
import com.bamboogled.exceptions.PlayerAlreadyPlayedException;
import com.bamboogled.model.model.BoggleModel;
import com.bamboogled.model.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;

public class ModelTest {
    @Test
    public void testNewGameResetsPlayerStats() {
        BoggleModel model = new BoggleModel();
        ArrayList<Player> players = new ArrayList<>();
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        p1.addWord("word");
        p2.addWord("word");
        players.add(p1);
        players.add(p2);
        model.newGame(4, players);
        assert p1.getFoundWords().size() == 0;
        assert p2.getFoundWords().size() == 0;
        assert p1.getScore() == 0;
        assert p2.getScore() == 0;
    }

    @Test
    public void testStartGameForNextPlayer() {
        BoggleModel model = new BoggleModel();
        ArrayList<Player> players = new ArrayList<>();
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        players.add(p1);
        players.add(p2);
        model.newGame(4, players);
        try {
            model.startGameForNextPlayer();
        } catch (NoMorePlayersException e) {
            throw new RuntimeException(e);
        } catch (GameAlreadyInProgressException e) {
            throw new RuntimeException(e);
        } catch (PlayerAlreadyPlayedException e) {
            throw new RuntimeException(e);
        }
        assert model.getCurrentPlayer().equals(p1);
        try {
            model.endGame();
        } catch (GameNotInProgressException e) {
            throw new RuntimeException(e);
        }
        try {
            model.startGameForNextPlayer();
        } catch (NoMorePlayersException e) {
            throw new RuntimeException(e);
        } catch (GameAlreadyInProgressException e) {
            throw new RuntimeException(e);
        } catch (PlayerAlreadyPlayedException e) {
            throw new RuntimeException(e);
        }
        assert model.getCurrentPlayer().equals(p2);
        try {
            model.endGame();
        } catch (GameNotInProgressException e) {
            throw new RuntimeException(e);
        }
        try {
            model.startGameForNextPlayer();
        } catch (NoMorePlayersException | PlayerAlreadyPlayedException | GameAlreadyInProgressException e) {
            assert (e instanceof NoMorePlayersException);
            return;
        }
        fail();
    }
}
