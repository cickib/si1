package sort;

import org.junit.Before;

import java.util.Arrays;
import java.util.List;


abstract class AbstractSorterTest {
    Sorter sorter;
    List<Integer> unsorted;

    List<Integer> expected;
    List<Integer> sorted;
    List<String> unsortedStrings;

    List<String> expectedStrings;
    List<String> sortedString;

    @Before
    public void setup() {
        unsorted = Arrays.asList(44, 1, 9, 4, 3, 8);
        expected = Arrays.asList(1, 3, 4, 8, 9, 44);

        unsortedStrings = Arrays.asList("ww", "a", "98");
        expectedStrings = Arrays.asList("98", "a", "ww");
    }

}
