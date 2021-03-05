# Java sorting algorithms

| Branch        | Pipeline          | Code coverage  |
| ------------- |:-----------------:| --------------:|
| master      | [![pipeline status](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/master/pipeline.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/master)  | [![coverage report](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/master/coverage.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/master) |
| dev         | [![pipeline status](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/dev/pipeline.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/dev)      |   [![coverage report](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/dev/coverage.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/dev) |

[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=alert_status)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=code_smells)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=bugs)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=ncloc)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=sqale_index)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)

The console application shows performance of various sorting algorithms like Bubble Sort, Quick Sort etc.

YouTube video: <https://www.youtube.com/watch?v=nrs-DjTRwkk>

**THIS IS THE OLD PROJECT WHICH NEEDS MORE ATTENTION. ALGORITHMS REQUIRE REFACTORING AND IT WILL BE DONE IN THE FUTURE. PLEASE DO NOT TREAT
IT AS THE FINAL VERSION OF THIS PROJECT.**

## Java main class

```
SortingAlgorithmsAppLauncher
```

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

## Algorithms benchmark

| Algorithm (time/memory) | 10000 elements | 50000 elements | 100000 elements | Best complexity | Average complexity | Worst complexity | Best complexity | Space complexity | Stable |
|-------------------------|----------------|----------------|-----------------|-----------------|--------------------|------------------|-----------------|------------------|--------|
| Bubble sort             | ?/?          |  ?/?          | ?/?          |                 |                    |                  |                 |                  |        |
| Counting sort           |  ?/?          |  ?/?             | ?/?              |                 |                    |                  |                 |                  |        |
| Heap sort               |  ?/?        |  ?/?          | ?/?              |                 |                    |                  |                 |                  |        |
| Insert sort             |  ?/?           |  ?/?             | ?/?              |                 |                    |                  |                 |                  |        |
| Merge sort              |  ?/?           |  ?/?            | ?/?              |                 |                    |                  |                 |                  |        |
| Quick sort              |  ?/?           |  ?/?            |  ?/?             |                 |                    |                  |                 |                  |        |
| Selection sort          |  ?/?          |  ?/?           |  ?/?             |                 |                    |                  |                 |                  |        |
| Shaker sort             |  ?/?           |  ?/?             |  ?/?           |                 |                    |                  |                 |                  |        |
| Shell sort              |  ?/?           |  ?/?             |  ?/?            |                 |                    |                  |                 |                  |        |

Stable - A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in
the input array to be sorted.

Time is measured in milliseconds.

Table generated using: <https://www.tablesgenerator.com/markdown_tables#>

### Space complexity

explain

### Best/Average/Worst complexity

explain

## Test naming convention

````
Should_ExpectedBehavior_When_StateUnderTest
````

Examples:

- Should_ThrowException_When_AgeLessThan18
- Should_FailToWithdrawMoney_ForInvalidAccount
- Should_FailToAdmit_IfMandatoryFieldsAreMissing

Remember about:

- using `IT` suffix for integration tests
- using`Test` suffix for unit tests
