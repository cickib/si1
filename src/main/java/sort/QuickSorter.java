package sort;

import lombok.Data;

import java.util.List;

@Data
public class QuickSorter<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public List<T> sort(List<T> unsorted) {
//        if the list has only one element or empty, it's sorted and can be returned
        if (unsorted.size() > 1) {
            quickSort(unsorted, 0, unsorted.size() - 1);
        }
        return unsorted;
    }

    private int partition(List<T> arr, int left, int right) {
        T pivot = arr.get((left + right) / 2);
        while (left <= right) {
            while (arr.get(left).compareTo(pivot) < 0) {
                left++;
            }
            while (arr.get(right).compareTo(pivot) > 0) {
                right--;
            }
            if (left <= right) {
                T temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);
                left++;
                right--;
            }
        }
        return left;
    }

    private void quickSort(List<T> arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

}
