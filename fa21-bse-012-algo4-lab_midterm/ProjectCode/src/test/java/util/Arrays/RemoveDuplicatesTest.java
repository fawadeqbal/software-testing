package util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesTest {

    @Test
    public void testEmptyArray() {
        int[] array = {};
        assertEquals(0, RemoveDuplicates.removeDuplicates(array));
    }

    @Test
    public void testArrayWithNoDuplicates() {
        int[] array = {1, 2, 3};
        assertEquals(3,  RemoveDuplicates.removeDuplicates(array));
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] array = {1, 1, 2, 3};
        assertEquals(3, RemoveDuplicates.removeDuplicates(array));
    }
}
