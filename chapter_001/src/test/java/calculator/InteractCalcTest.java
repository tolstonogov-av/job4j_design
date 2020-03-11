package calculator;

import java.util.List;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
    public void whenAddThenReturnSum() {
        InteractCalc ic = new InteractCalc(new StubInput(List.of("2", "3", "+", "e")));
        ic.calculate();
        assertThat(ic.getResult(), is(5d));
    }

    /**
     * 2 * (-3) = -6
     */
    @Test
    public void whenMultiplyThenReturnMultiply() {
        InteractCalc ic = new InteractCalc(new StubInput(List.of("2", "-3", "*", "e")));
        ic.calculate();
        assertThat(ic.getResult(), is(-6d));
    }

    /**
     * 24 - 3 = 21
     */
    @Test
    public void whenSubtractThenReturnSubtract() {
        InteractCalc ic = new InteractCalc(new StubInput(List.of("24", "3", "-", "e")));
        ic.calculate();
        assertThat(ic.getResult(), is(21d));
    }

    /**
     * 24 / 3 = 8
     */
    @Test
    public void whenDivThenReturnDiv() {
        InteractCalc ic = new InteractCalc(new StubInput(List.of("24", "3", "/", "e")));
        ic.calculate();
        assertThat(ic.getResult(), is(8d));
    }

    /**
     * 2 + 4 = 5
     * 5 + 5 = 10
     */
    @Test
    public void whenUsedMThenRGetPreviousResult() {
        InteractCalc ic = new InteractCalc(new StubInput(List.of("2", "3", "+", "m", "m", "+", "e")));
        ic.calculate();
        assertThat(ic.getResult(), is(10d));
    }
}