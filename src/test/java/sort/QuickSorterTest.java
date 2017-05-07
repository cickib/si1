package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class QuickSorterTest extends AbstractSorterTest {

    @Test
    public void sortNull() {
        sorter = new QuickSorter<Integer>();
        sorted = sorter.sort(new ArrayList<>());
        expected = new ArrayList<>();
        assertEquals(expected, sorted);
    }

    @Test
    public void emptyList() {
        sorter = new QuickSorter<Integer>();
        sorted = sorter.sort(new ArrayList<>());
        expected = new ArrayList<>();
        assertEquals(expected, sorted);
    }

    @Test
    public void oneElementInList() {
        sorter = new QuickSorter<Integer>();
        unsorted = Collections.singletonList(44);
        expected = Collections.singletonList(44);
        sorted = sorter.sort(unsorted);
        assertEquals(expected, sorted);
    }

    @Test
    public void normalList() {
        sorter = new QuickSorter<Integer>();
        sorted = sorter.sort(unsorted);
        assertEquals(expected, sorted);
    }

    @Test
    public void normalStringList() {
        sorter = new QuickSorter<String>();
        sortedString = sorter.sort(unsortedStrings);
        assertEquals(expectedStrings, sortedString);
    }

}