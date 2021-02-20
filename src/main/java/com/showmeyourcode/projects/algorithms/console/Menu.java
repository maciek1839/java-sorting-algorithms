package com.showmeyourcode.projects.algorithms.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Menu {

    private static final Logger logger = LoggerFactory.getLogger(Menu.class);

    public void displayMenu() {
        final StringBuilder strBuilderMenu = new StringBuilder();
        strBuilderMenu.append("\n");
        strBuilderMenu.append("1.Bubble Sort\n");
        strBuilderMenu.append("2.Counting Sort\n");
        strBuilderMenu.append("3.Heap Sort\n");
        strBuilderMenu.append("4.Insertion Sort\n");
        strBuilderMenu.append("5.Merge Sort\n");
        strBuilderMenu.append("6.Quick Sort\n");
        strBuilderMenu.append("7.Selection Sort\n");
        strBuilderMenu.append("8.Shaker Sort\n");
        strBuilderMenu.append("9.Shell Sort\n");
        strBuilderMenu.append("11. Exit program\n");
        strBuilderMenu.append("What would you like to try?\tPlease choose one option:\n");
        logger.info(strBuilderMenu.toString());
    }
}
