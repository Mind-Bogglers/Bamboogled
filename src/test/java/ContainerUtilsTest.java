import com.backend.engine.BoggleGrid;
import com.backend.engine.NoPathException;
import com.backend.engine.PathContainerUtils;
import com.backend.engine.PossiblePathContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ContainerUtilsTest {
    @Test
    public void TestFetchContainer() throws NoPathException {
        BoggleGrid boggleGrid = new BoggleGrid(4);
        boggleGrid.initalizeBoard("ABCDEDFGABDMABCD");
        PossiblePathContainer container = null;
        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'A');
        assertEquals(3, container.getPaths().size());

        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'B');
        assertEquals(5, container.getPaths().size());

        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'D');
        assertEquals(7, container.getPaths().size());

        container = null;
        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'M');
        assertEquals(1, container.getPaths().size());

        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'D');
        assertEquals(2, container.getPaths().size());

        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'F');
        assertEquals(1, container.getPaths().size());
        try {
            container = PathContainerUtils.fetchContainer(container, boggleGrid, 'Z');
            System.out.println(container.getPaths().size());
        } catch (NoPathException e) {
            return;
        }
        fail();
    }
}
