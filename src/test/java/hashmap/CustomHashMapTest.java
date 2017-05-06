package hashmap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.Assert.*;


public class CustomHashMapTest {

    private CustomHashMap<String, String> stringHashMap;
    private CustomHashMap<Integer, Integer> integerHashMap;


    @Test
    public void emptyHashMapSizeIsZero() {
        stringHashMap = new CustomHashMap<>();
        assertEquals(0, stringHashMap.getSize());
    }

    @Test
    public void emptyHashMapRemove_returnsFalse() {
        stringHashMap = new CustomHashMap<>();
        assertFalse(stringHashMap.remove(""));
    }

    @Test
    public void emptyHashMap_keysetHasNoElements() {
        stringHashMap = new CustomHashMap<>();
        assertTrue(stringHashMap.keyset().isEmpty());
    }

    @Test
    public void putTwoStringElementsIn_keysetHasThem() {
        stringHashMap = new CustomHashMap<>();
        stringHashMap.put("2", "2");
        stringHashMap.put("wmikosidf", "1");
        Set<String> expectedSet = new HashSet<>(Arrays.asList("wmikosidf", "2"));
        assertEquals(expectedSet, stringHashMap.keyset());
    }

    @Test
    public void putTwoIntegerElementsIn_keysetHasThem() {
        integerHashMap = new CustomHashMap<>();
        integerHashMap.put(3, 3);
        integerHashMap.put(4, 4);
        Set<Integer> expectedSet = new HashSet<>(Arrays.asList(3, 4));
        assertEquals(expectedSet, integerHashMap.keyset());
    }

    @Test
    public void putExistingKeyIn_valueUpdated() {
        stringHashMap = new CustomHashMap<>();
        stringHashMap.put("2", "2");
        String valueBefore = stringHashMap.get("2");
        stringHashMap.put("2", "two");
        String valueAfter = stringHashMap.get("2");
        assertNotEquals(valueBefore, valueAfter);
    }

    @Test
    public void getoIntegerElements() {
        integerHashMap = new CustomHashMap<>();
        integerHashMap.put(3, 3);
        integerHashMap.put(4, 4);
        int three = integerHashMap.get(3);
        int four = integerHashMap.get(4);
        assertEquals(3, three);
        assertEquals(4, four);
    }

    @Test(expected = NoSuchElementException.class)
    public void getNotExistingElement() {
        integerHashMap = new CustomHashMap<>();
        integerHashMap.put(3, 3);
        integerHashMap.get(4);
    }

    @Test
    public void removeExistingKeyElement_keysetAndSizeUpdated() {
        integerHashMap = new CustomHashMap<>();
        integerHashMap.put(3, 3);
        integerHashMap.put(4, 4);
        int sizeBefore = integerHashMap.getSize();
        Set<Integer> keysetBefore = integerHashMap.keyset();
        integerHashMap.remove(4);
        int sizeAfter = integerHashMap.getSize();
        Set<Integer> keysetAfter = integerHashMap.keyset();
        assertTrue(sizeBefore > sizeAfter);
        assertNotEquals(keysetBefore, keysetAfter);
    }

    @Test
    public void removeNotExistingKeyElement_returnsFalse() {
        integerHashMap = new CustomHashMap<>();
        integerHashMap.put(3, 3);
        assertFalse(integerHashMap.remove(4));
    }

    @Test(expected = NullPointerException.class)
    public void clearNotEmptyHashMap_keysetIsNull_sizeIsZero() {
        stringHashMap = new CustomHashMap<>();
        stringHashMap.put("2", "2");
        assertFalse(stringHashMap.keyset().isEmpty());
        stringHashMap.clear();
        stringHashMap.keyset();
        assertEquals(0, stringHashMap.getSize());
    }

}