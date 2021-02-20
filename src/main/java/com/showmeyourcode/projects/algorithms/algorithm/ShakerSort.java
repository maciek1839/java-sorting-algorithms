package com.showmeyourcode.projects.algorithms.algorithm;

public class ShakerSort extends AlgorithmBase {


    @Override
    public String getAlgorithmPerformance() {
        return "O(N)/O(N^2)";
    }

    /*
    PSEUDOCODE
        Shaker sort (bidirectional bubble sort)

    PERFORMANCE
        Worst-case performance O(n^{2})
        Best-case performance  O(n)
        Worst-case space complexity O(1)
        Stability? Yes
     */
    @Override
    public String toString() {
        return "Shaker Sort ";
    }

    @Override
    public int[] sortData(int[] data) {
        if (data == null || data.length == 0) {
            return new int[]{};
        }

        int valToSwap, iLoop = 0;//i_loop means the same as int i in for loop
        boolean isSwapped;

        do {
            isSwapped = false;
            for (int j = iLoop; j < data.length - iLoop - 1; j++) {
                if (data[j] > data[j + 1]) {
                    valToSwap = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = valToSwap;
                    isSwapped = true;
                }
            }
            //means that array is sorted and we dont have to do more comparisions
            if (!isSwapped) break;
            for (int j = data.length - iLoop - 1; j > iLoop; j--) {
                if (data[j] < data[j - 1]) {
                    valToSwap = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = valToSwap;
                    isSwapped = true;
                }
            }
            iLoop++;
        } while (isSwapped);

        return data;
    }
}
