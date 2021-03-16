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

## Roadmap

- Implement properly sorting algorithms
- Do the benchmark

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

| Algorithm (time(ns)/memory(B))  | 50000 elements   | 100000 elements   | 150000 elements   | Best complexity   | Average complexity   | Worst complexity   | Space complexity (the worst)   | Stable   | In place  |
|:--------------------------------|:----------------:|:-----------------:|:-----------------:|:-----------------:|:--------------------:|:------------------:|:------------------------------:|:--------:|:---------:|
| Bubble sort                     | 4760574500       |  20139760400      | 40703039600       |     O(n)          |     O(n^2)           |       O(n^2)       |        O(1)                    |   yes    |  yes      |
| Selection sort                  |  528612800       |  2640280500       |  4902623300       |    O(n^2)         |    O(n^2)            |       O(n^2)       |        O(1)                    |    no    |  yes      |
| Insertion sort                  |  1603100         |  1342200          | 499500            |     O(n^2)        |   O(n^2)             | O(n)               |        O(1)                    |   yes    |  yes      |
| Counting sort                   |  17973900        |  3729000          | 8716100           |    O(n+k)         |    O(n+k)            |       O(n+k)       |        O(k)                    |  yes/no* |  no/yes*  |
| Heap sort               |  ?/?        |  ?/?          | ?/?              |                 |                    |                  |                 |                  |        |

| Merge sort              |  ?/?           |  ?/?            | ?/?              |                 |                    |                  |                 |                  |        |
| Quick sort              |  ?/?           |  ?/?            |  ?/?             |                 |                    |                  |                 |                  |        |
| Shaker sort             |  ?/?           |  ?/?             |  ?/?           |                 |                    |                  |                 |                  |        |
| Shell sort              |  ?/?           |  ?/?             |  ?/?            |                 |                    |                  |                 |                  |        |

Table generated using: <https://www.tablesgenerator.com/markdown_tables#>

Symbol explanations:

- n
  - number of elements in an array
- k
  - the dataset/array elements range

Remarks:

- *The counting sort can be implemented as:
  - not in-place: stable, O(N) space complexity.
  - in-place: none stable, O(1) space complexity.
