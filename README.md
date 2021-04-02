# Java sorting algorithms

| Branch        | Pipeline          | Code coverage  |
| ------------- |:-----------------:| --------------:|
| master      | [![pipeline status](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/master/pipeline.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/master)  | [![coverage report](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/master/coverage.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/master) |
| dev         | [![pipeline status](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/dev/pipeline.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/dev)      |   [![coverage report](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/dev/coverage.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/dev) |

[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=alert_status)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=code_smells)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=bugs)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=ncloc)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=sqale_index)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)

**Java console application**  
**Sorting problem: Total number of item to be sorted**

- YouTube video
  - <https://www.youtube.com/watch?v=nrs-DjTRwkk>
- Contributing guidelines
  - [CONTRIBUTING](./CONTRIBUTING.md)
- All details and explanation about the benchmark
  - [ALGORITHMS_DESCRIPTION](./ALGORITHMS_DESCRIPTION.md)
- Interesting exercises about sorting algorithms found on the Internet - ``exercises`` folder

## Technology stack

- Maven
- Java 11 (AWS Corretto)
- Lombok
- vavr
  - https://github.com/vavr-io/vavr
- SonarCloud
  - https://sonarcloud.io/
  - https://sonarcloud.io/organizations/showmeyourcodeyoutube/projects
- JUnit 5
- Mockito 1.9.5

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

Table generated using: <https://www.tablesgenerator.com/markdown_tables#>

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
