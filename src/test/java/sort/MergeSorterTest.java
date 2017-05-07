package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class MergeSorterTest extends AbstractSorterTest {

    @Test
    public void sortNull() {
        sorter = new MergeSorter<Integer>();
        sorted = sorter.sort(new ArrayList<>());
        expected = new ArrayList<>();
        assertEquals(expected, sorted);
    }

    @Test
    public void emptyList() {
        sorter = new MergeSorter<Integer>();
        sorted = sorter.sort(new ArrayList<>());
        expected = new ArrayList<>();
        assertEquals(expected, sorted);
    }

    @Test
    public void oneElementInList() {
        sorter = new MergeSorter<Integer>();
        unsorted = Collections.singletonList(44);
        expected = Collections.singletonList(44);
        sorted = sorter.sort(unsorted);
        assertEquals(expected, sorted);
    }

    @Test
    public void normalList() {
        sorter = new MergeSorter<Integer>();
        sorted = sorter.sort(unsorted);
        assertEquals(expected, sorted);
    }

    @Test
    public void normalStringList() {
        sorter = new MergeSorter<String>();
        sortedString = sorter.sort(unsortedStrings);
        assertEquals(expectedStrings, sortedString);
    }

}