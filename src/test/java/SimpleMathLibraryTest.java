import org.example.homework27.SimpleMathLibrary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleMathLibraryTest {
    @Test
    public void testAdd() {
        double result = SimpleMathLibrary.add(2.5, 3.5);
        assertEquals(6.0, result, 0.0001);
    }

    @Test
    public void testMinus() {
        double result = SimpleMathLibrary.minus(5.0, 2.0);
        assertEquals(3.0, result, 0.0001);
    }

    @Test
    public void testZeroDivision(){
        double result = SimpleMathLibrary.division(2.0,0.0);
        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    public void testDivision(){
        double result = SimpleMathLibrary.division(2.0,2.0);
        assertEquals(1.0, result, 0.0001);
    }
}
