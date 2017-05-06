package hashmap;


import lombok.Data;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Set;

@Data
public class CustomHashMap<K, V> {

    public Set<K> keyset() {
        Set<K> keyset = new HashSet<>();
        for (LinkedList<CustomEntry> bucket : table) {
            for (CustomEntry entry : bucket) {
                keyset.add((K) entry.key);
            }
        }
        return keyset;
    }

    private int capacity;
    private int size;
    private LinkedList<CustomEntry>[] table;

    public CustomHashMap() {
        this.capacity = 4;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        if (!containsKey(key)) {
            CustomEntry<K, V> newEntry = new CustomEntry<>(key, value);
            table[newEntry.hash].add(newEntry);
        } else {
            for (CustomEntry entry : table[hash(key.hashCode())]) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                }
            }
        }
        size++;
    }

    private int hash(int hashCode) {
        return Math.abs(hashCode % capacity);
    }

    public boolean remove(K key) {
        for (LinkedList<CustomEntry> bucket : table) {
            for (CustomEntry entry : bucket) {
                if (entry.key.equals(key)) {
                    bucket.remove(entry);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        if (containsKey(key)) {
            for (CustomEntry<K, V> entry : table[bucketIndex]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        } else {
            throw new NoSuchElementException();
        }
        return null;
    }

    public boolean containsKey(K key) {
        int bucketIndex = hash(key.hashCode());
        for (CustomEntry<K, V> entry : table[bucketIndex]) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    private class CustomEntry<K, V> {
        final K key;
        V value;
        int hash;
//        TODO
        CustomEntry<K, V> nextEntry;

        CustomEntry(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = hash(key.hashCode());
        }

        @Override
        public String toString() {
            return String.format("%s(key=%s, value=%s)", this.getClass().getSimpleName(), key, value);
        }

    }

    public void clear() {
        size = 0;
        table = new LinkedList[capacity];
    }

}