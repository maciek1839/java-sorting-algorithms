package com.showmeyourcode.projects.exercise;

import java.util.Arrays;
import java.util.Objects;

/**
 * Binary search is an efficient algorithm for finding an item from a sorted list of items.
 * It works by repeatedly dividing in half the portion of the list that could contain the item,
 * until you've narrowed down the possible locations to just one.
 *
 * The time complexity of binary search is O(logn).
 *
 * function binary_search(list, target):
 *     left = 0
 *     right = length(list) - 1
 *     while left <= right:
 *         mid = (left + right) // 2
 *         if list[mid] == target:
 *             return mid
 *         elif list[mid] < target:
 *             left = mid + 1
 *         else:
 *             right = mid - 1
 *     return -1
 */
class BinarySearchExercise<T extends Comparable<T>> {

    static final String INVALID_ARGUMENT_MSG = "The array cannot be null";
    private final T[]arr;

    public BinarySearchExercise(T[] arr) {
        // assert vs IllegalArgumentException
        //
        // Assertions should be used to check something that should never happen, while an exception should be used to check something that might happen.
        // Or, assertions should only be used to verify conditions that should be logically impossible to be false (read: sanity checks).
        //
        // Exceptions are used in situations where it might be possible to recover from the error, so we want to give the program a chance to do that.
        // Assertions are for situations where things are so screwed up that the program must stop.
        //
        // Assertions are removed at runtime unless you explicitly specify to "enable assertions" when compiling your code.
        // Also assert will throw AssertionError which extends Error not Exception, and which normally indicates you have a very abnormal error (like "OutOfMemoryError" which is hard to recover from, isn't it?) you are not expected to be able to treat.
        //
        // references:
        // https://softwareengineering.stackexchange.com/questions/137158/is-it-better-to-use-assert-or-illegalargumentexception-for-required-method-param
        // https://softwareengineering.stackexchange.com/questions/432156/assertion-statements-remove-or-retain-in-production-code
        Objects.requireNonNull(arr, INVALID_ARGUMENT_MSG);

        // ensure that an array is sorted
        Arrays.sort(arr);
        this.arr = arr;
    }

    /**
     * Check if the value is present in the array and return an index.
     * @param v - value to find
     * @return index of the target value, -1 if not found
     */
    int search(T v){
        return binarySearch(arr, v, 0, arr.length-1);
    }

    private int binarySearch(T[] arr, T target, int leftIdx, int rightIdx){
        while(leftIdx <= rightIdx){
            int medium = (leftIdx + rightIdx) / 2;
            int compareResult = target.compareTo(arr[medium]);
            if(compareResult == 0){
                return medium;
            } else if(compareResult > 0){
                leftIdx = medium + 1;
            } else {
                rightIdx = medium - 1;
            }
        }
        return -1;
    }
}
