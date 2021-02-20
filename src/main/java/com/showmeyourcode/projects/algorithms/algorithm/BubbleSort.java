package com.showmeyourcode.projects.algorithms.algorithm;

public class BubbleSort extends AlgorithmBase {

    @Override
    public String getAlgorithmPerformance() {
        return "O(N)/O(N^2)";
    }

    @Override
    public int[] sortData(int[] tData) {
        if (tData == null || tData.length == 0) {
            return new int[]{};
        }

        int valToSwap;
        boolean swapped = true;

        for (int i = 0; i < tData.length - 1 && swapped; i++) {
            swapped = false;
            for (int j = 0; j < tData.length - i - 1; j++) {
                if (tData[j] > tData[j + 1]) {
                    valToSwap = tData[j];
                    tData[j] = tData[j + 1];
                    tData[j + 1] = valToSwap;
                    swapped = true;
                }
            }
        }
        return tData;
    }

    /*
    PSEUDOCODE
        find it on the Internet

    PERFORMANCE
        Worst-case performance O(n^{2})
        Best-case performance  O(n)
        Worst-case space complexity O(1)
        Stability? Yes

        Case 1) O(n^2) (Worst case) The worst case is if the array is already sorted but in descending order.
        This means that in the first iteration it would have to look at n elements,
        then after that it would look n - 1 elements (since the biggest integer is at the end)
        and so on and so forth till 1 comparison occurs. Big Oh = n + n - 1 + n - 2 ... + 1 = (n*(n + 1))/2 = O(n^2)(approximation)

        Case 2) O(n) (Best case) This time complexity can occur if the array is already sorted,
        and that means that no swap occurred and only 1 iteration of n elements
    */
    @Override
    public String toString() {
        return "Bubble Sort ";
    }
}
