import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAdd() {
        assertEquals(Calculator.add(1, 2), 3);
        assertEquals(Calculator.add(0, 0), 0);
    }

    @Test
    public void testMultiply() {
        assertEquals(Calculator.multiply(1, 2), 3);
        assertEquals(Calculator.multiply(0, 0), 0);
    }
}
