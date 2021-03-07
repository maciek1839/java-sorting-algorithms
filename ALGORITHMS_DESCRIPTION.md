# Algorithms description

Here you can find more detailed information about particular algorithms.

1. [Bubble sort](#bubble-sort)
2. [Counting sort](#counting-sort)
3. [Heap sort](#heap-sort)
4. [Insert sort](#insert-sort)
5. [Merge sort](#merge-sort)
6. [Quick sort](#quick-sort)
7. [Selection sort](#selection-sort)
8. [Shaker sort](#shaker-sort)
9. [Shell sort](#shell-sort)

## What is measured and considered?

- Computation time
- Stability (in other words, preserving the order of initial elements in array when they are correctly sorted)
- Space complexity
    - explain
- Complexity
    - Best
        - explain
    - Average
        - explain
    - Wort
        - explain

## Bubble sort

### Description

todo

### Pseudocode

todo

### Performance

- Worst-case performance O(n^{2})
- Best-case performance O(n)
- Worst-case space complexity O(1)
- Stability? Yes

Case 1) O(n^2) (Worst case) The worst case is if the array is already sorted but in descending order. This means that in the first iteration
it would have to look at n elements, then after that it would look n - 1 elements (since the biggest integer is at the end)
and so on and so forth till 1 comparison occurs. Big Oh = n + n - 1 + n - 2 ... + 1 = (n*(n + 1))/2 = O(n^2)(approximation)

Case 2) O(n) (Best case) This time complexity can occur if the array is already sorted, and that means that no swap occurred and only 1
iteration of n elements

## Counting sort

### Description

todo

### Pseudocode

todo

### Performance

O(N+M) where N is the number of elements to be sorted and K is the number of possible values in the range. but if we add first loop for
searching the lowest and the highest value-> 2n+m 0(M)-memory

## Heap sort

### Description

todo

### Pseudocode

todo

### Performance

Worst-case performance O(n log n) -> because we iterate through all elements(n) and Best-case performance O(n log n)
Worst-case space complexity: O(1)

## Insert sort

### Description

todo

### Pseudocode

todo

### Performance

Worst-case performance O(n^{2})
Best-case performance O(n)
Worst-case space complexity O(1)
Stability? Yes

## Merge sort

### Description

todo

### Pseudocode

todo

### Performance

Worst-case performance O(n log n)
Best-case performance O(n log n)
Worst-case space complexity O(n)

## Quick sort

### Description

todo

### Pseudocode

todo

### Performance

Worst-case performance O(n^2)
Best-case performance O(n log n)
Worst-case space complexity O(1)

## Selection sort

### Description

todo

### Pseudocode

todo

### Performance

Worst-case performance O(n^{2})
Best-case performance O(n^{2})
Worst-case space complexity O(1)
Stability? No

## Shaker sort

### Description

todo

### Pseudocode

todo

### Performance

Worst-case performance O(n^{2})
Best-case performance O(n)
Worst-case space complexity O(1)
Stability? Yes

## Shell sort

### Description

todo

### Pseudocode

todo

### Performance

depends on paramatere i_hole Stability? Yes
