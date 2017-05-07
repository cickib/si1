package sort;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MergeSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public List<T> sort(List<T> unsorted) {
        return mergeSort(unsorted);
    }

    private List<T> mergeSort(List<T> unsorted) {
        if (unsorted.size() > 1) {
            int center = unsorted.size() / 2;
            List<T> left = unsorted.stream().filter(item -> unsorted.indexOf(item) < center).collect(Collectors.toList());
            List<T> right = unsorted.stream().filter(item -> unsorted.indexOf(item) >= center).collect(Collectors.toList());

            left = mergeSort(left);
            right = mergeSort(right);

            merge(left, right, unsorted);
        }
        return unsorted;
    }

    private void merge(List<T> left, List<T> right, List<T> unsorted) {
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                unsorted.set(index, left.get(leftIndex));
                leftIndex++;
            } else {
                unsorted.set(index, right.get(rightIndex));
                rightIndex++;
            }
            index++;
        }

        List<T> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            unsorted.set(index, rest.get(i));
            index++;
        }
    }

}
