import com.backend.BoggleGrid;
import com.backend.engine.PathContainerUtils;
import com.backend.engine.PossiblePathContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerUtilsTest {
    @Test
    public void TestFetchContainer() {
        BoggleGrid boggleGrid = new BoggleGrid(4);
        boggleGrid.initalizeBoard("ABCDEDFGABDMABCD");
        PossiblePathContainer container = null;
        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'A');
        System.out.println(container);
        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'B');
        System.out.println(container);
        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'D');
        System.out.println(container);
        container = null;
        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'M');
        System.out.println(container);
        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'D');
        System.out.println(container);
        container = PathContainerUtils.fetchContainer(container, boggleGrid, 'F');
        System.out.println(container);
    }
}
