package com.showmeyourcode.projects.algorithms.algorithm;

public class QuickSort extends AlgorithmBase {

    @Override
    public String getAlgorithmPerformance() {
        return "O(N*LOG N)/O(N^2)";
    }

    /*
    PSEUDOCODE
        more on the Internet

    PERFORMANCE
       Worst-case performance O(n^2)
       Best-case performance  O(n log n)
       Worst-case space complexity O(1)
     */
    @Override
    public String toString() {
        return "Quick sort ";
    }

    @Override
    public int[] sortData(int[] data) {
        if (data == null || data.length == 0) {
            return new int[]{};
        }

        sortWithPivot(data, 0, data.length - 1);

        return data;
    }

    //we use index of table's elements!
    private int[] sortWithPivot(int[] tData, int from, int to) {

        int left = from, right = to;
        int tmp;
        int pivot = tData[(from + to) / 2];

        while (left <= right) {
            while (tData[left] < pivot)
                left++;
            while (tData[right] > pivot)
                right--;
            if (left <= right) {
                tmp = tData[left];
                tData[left] = tData[right];
                tData[right] = tmp;
                left++;
                right--;
            }
        }

        if (from < right)
            sortWithPivot(tData, from, right);
        if (left < to)
            sortWithPivot(tData, left, to);
        return tData;
    }
}
