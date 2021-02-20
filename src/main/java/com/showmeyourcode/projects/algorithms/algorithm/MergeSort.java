package com.showmeyourcode.projects.algorithms.algorithm;

public class MergeSort extends AlgorithmBase {
    @Override
    public String getAlgorithmPerformance() {
        return "O(N*LOG N)";
    }

    /*
    PSEUDOCODE
        more on the Internet

    PERFORMANCE
       Worst-case performance O(n log n)
       Best-case performance  O(n log n)
       Worst-case space complexity O(n)

     */

    @Override
    public int[] sortData(int[] data) {
        if (data == null || data.length == 0) {
            return new int[]{};
        }

        for (int i_partSize = 1; i_partSize < data.length; i_partSize = i_partSize * 2)
            data = mergeParts(data, i_partSize);
        return data;
    }

    private int[] mergeParts(int[] data, int partSize) {

        int leftPart = 0, leftStart = 0, rightStart = partSize, rightPart = partSize;
        int[] sortedElements = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            if (leftStart - leftPart == partSize && rightStart - rightPart != partSize) {
                sortedElements[i] = data[rightStart];
                rightStart++;
            } else if ((rightStart - rightPart == partSize || rightStart >= data.length) && leftStart - leftPart < partSize) {
                sortedElements[i] = data[leftStart];
                leftStart++;
            } else if (data[leftStart] < data[rightStart]) {
                sortedElements[i] = data[leftStart];
                leftStart++;
            } else {
                sortedElements[i] = data[rightStart];
                rightStart++;
            }
            //check if each segmenet's element was compared
            if (leftStart - leftPart == partSize && rightStart - rightPart == partSize) {
                leftPart += 2 * partSize;
                leftStart = leftPart;
                rightPart += 2 * partSize;
                rightStart = rightPart;
            }
        }
        return sortedElements;
    }

    @Override
    public String toString() {
        return "Merge sort ";
    }
}
