import org.junit.jupiter.api.Test;
import static org.example.homework27.ArrayUtils.checkArray;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ArrayUtilsTest {
    @Test
    public void testCheckArray() {
        // тесты, где массивы соответствуют требованиям
        assertTrue(checkArray(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
        assertTrue(checkArray(new int[]{1, 4, 1, 4, 1, 4}));
        assertTrue(checkArray(new int[]{1, 4, 4, 1, 4, 1}));

        // тесты, где массивы не соответствуют требованиям
        assertFalse(checkArray(new int[]{1, 1, 1, 1, 1, 1}));
        assertFalse(checkArray(new int[]{4, 4, 4, 4}));
        assertFalse(checkArray(new int[]{1, 4, 4, 1, 1, 4, 3}));
        assertFalse(checkArray(new int[]{2, 2, 2, 2}));
    }
}
