package calculator;

import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class to test class InteractCalc.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class InteractCalcTest {
    /**
     * 2 + 3 = 5
     */
    @Test
    public void sum() {
        InteractCalc ic = new InteractCalc(new StubInput(List.of("2", "3", "+", "e")));
        ic.calculate();
        assertEquals(5d, ic.getResult(), 0.001);
    }

    /**
     * 2 * (-3) = -6
     */
    @Test
    public void multiply() {
        InteractCalc ic = new InteractCalc(new StubInput(List.of("2", "-3", "*", "e")));
        ic.calculate();
        assertEquals(-6d, ic.getResult(), 0.001);
    }

    /**
     * 24 - 3 = 21
     */
    @Test
    public void subtract() {
        InteractCalc ic = new InteractCalc(new StubInput(List.of("24", "3", "-", "e")));
        ic.calculate();
        assertEquals(21d, ic.getResult(), 0.001);
    }

    /**
     * 24 / 3 = 8
     */
    @Test
    public void div() {
        InteractCalc ic = new InteractCalc(new StubInput(List.of("24", "3", "/", "e")));
        ic.calculate();
        assertEquals(8d, ic.getResult(), 0.001);
    }

    /**
     * 2 + 4 = 5
     * 5 + 5 = 10
     */
    @Test
    public void usePeviousResult() {
        InteractCalc ic = new InteractCalc(new StubInput(List.of("2", "3", "+", "m", "m", "+", "e")));
        ic.calculate();
        assertEquals(10d, ic.getResult(), 0.001);
    }
}