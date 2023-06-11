# Java sorting algorithms

**Java console application**  
**Sorting problem: Total number of item to be sorted**

| Branch |                                                                                               Pipeline                                                                                               |                                                                                            Code coverage                                                                                             |                                     Test report                                     |
|:------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------:|
| master | [![pipeline status](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/master/pipeline.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/master) | [![coverage report](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/master/coverage.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/master) | [link](https://showmeyourcodeyoutube.gitlab.io/java-sorting-algorithms/test-report) |

- YouTube video
  - <https://www.youtube.com/watch?v=nrs-DjTRwkk>
- All details and explanation about the benchmark
  - [ALGORITHMS_DESCRIPTION](./ALGORITHMS_DESCRIPTION.md)
- Exercises about sorting algorithms found on the Internet
  - [EXERCISES](./EXERCISES.md)

## Technology stack

- Maven
- Java 11 (AWS Corretto)
- Lombok
- JUnit 5
- Mockito
- LogCaptor

## Getting started

1. Enable annotation processing in your IDE (Lombok requires it)
2. Install Maven dependencies/Import this repository as Maven project.
3. Run application using a main class:

```
SortingAlgorithmsAppLauncher
```

## Algorithms benchmark

```
An algorithm is a set of instructions designed to perform a specific task.
Sometimes an algorithm might produce a different output when given the same input.
This relates to the area of deterministic and non-deterministic algorithms.
Sorting algorithms are deterministic.
```

| Algorithm  | 50000&#160;elements&#160;(ns)   | 100000&#160;elements&#160;(ns)    | 150000&#160;elements&#160;(ns)    | Best&#160;complexity   | Average&#160;complexity   | Worst&#160;complexity   | Space&#160;complexity&#160;(the&#160;worst)   | Stable   | In&#160;place  |
|:--------------------------------|:----------------:|:-----------------:|:-----------------:|:-----------------:|:--------------------:|:------------------:|:------------------------------:|:--------:|:---------:|
| Bubble&#160;sort |  4928230700  | 20074524300 |  37438477400 |  O(n)  |  O(n^2)  |  O(n^2) |  O(1) |   yes  |  yes  |
| Cocktail&#160;Shaker&#160;sort <br/> (Bidirectional&#160;bubble&#160;sort)   |  1622600  | 1603300 |  1278200 |  O(n)  |  O(n^2)  |  O(n^2) |  O(1) |   yes  |  yes  |
| Selection&#160;sort |  469744400  | 1834796800 |  4116949900 |  O(n^2)  |  O(n^2)  |  O(n^2) |  O(1) |   no  |  yes  |
| Insertion&#160;sort   |  1595300  | 1352000 |  208500 |  O(n)  |  O(n^2)  |  O(n^2) |  O(1) |   yes  |  yes  |
| Shell&#160;sort |  6446800  | 2566500 |  1116300 |  O(n log n)  |  depends on gap sequence  |  O(n^2) |  O(1) |   no  |  yes  |
| Counting&#160;sort |  16629700  | 6919800 |  7940500 |  O(n+k)  |  O(n+k)  |  O(n+k) |  O(n+k) |   yes/no*  |  no/yes*  |
| Heap&#160;sort |  11219900  | 33287900 |  16133000 |  O(n log n)  |  O(n log n)  |  O(n log n) |  O(1) |   no  |  yes  |
| Merge&#160;sort |  11539000  | 8662800 |  18594200 |  O(n log n)  |  O(n log n)  |  O(n log n) |  O(n) |   yes  |  no  |
| Quick&#160;sort |  4743300  | 2344100 |  3392600 |  O(n log n)  |  O(n log n)  |  O(n^2) |  O(log n) |   no  |  yes  |

*The table is auto generated using the app. Choose `10` to generate new results and copy the table from `resources`.*

Table generated using: https://www.tablesgenerator.com/markdown_tables#  
Big O Notation reference: https://www.bigocheatsheet.com/

Symbol explanations:
- ns
  - nanoseconds
- B
  - Bytes
- n
  - number of elements in an array
- k
  - the dataset/array elements range

Remarks:
- *The counting sort can be implemented as:
  - not in-place: stable, O(N) space complexity.
  - in-place: none stable, O(1) space complexity.

## Release a new version

Run Maven commands using Maven Release plugin.
```text
mvn release:prepare
```

If you want to only update versions, use below command:
```
mvn release:update-versions -DautoVersionSubmodules=true
```
