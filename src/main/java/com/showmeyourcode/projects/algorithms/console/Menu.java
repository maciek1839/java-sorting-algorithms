package com.showmeyourcode.projects.algorithms.console;

public class Menu {
    public String createMenu() {
        return new StringBuilder()
                .append("\n------------------------\n")
                .append("1. Bubble Sort\n")
                .append("2. Counting Sort\n")
                .append("3. Heap Sort\n")
                .append("4. Insertion Sort\n")
                .append("5. Merge Sort\n")
                .append("6. Quick Sort\n")
                .append("7. Selection Sort\n")
                .append("8. Shaker Sort\n")
                .append("9. Shell Sort\n")
                .append("10. Benchmark\n")
                .append("11. Exit program\n")
                .append("What would you like to try?\tPlease choose one option:\n")
                .toString();
    }
}
