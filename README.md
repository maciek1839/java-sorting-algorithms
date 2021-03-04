# Java sorting algorithms

| Branch        | Pipeline          | Code coverage  |
| ------------- |:-----------------:| --------------:|
| master      | [![pipeline status](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/master/pipeline.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/master)  | [![coverage report](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/master/coverage.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/master) |
| dev         | [![pipeline status](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/dev/pipeline.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/dev)      |   [![coverage report](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/badges/dev/coverage.svg)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/commits/dev) |

[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=alert_status)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=code_smells)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=bugs)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=ncloc)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)  [![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=ShowMeYourCodeYouTube_java-sorting-algorithms&metric=sqale_index)](https://sonarcloud.io/dashboard?id=ShowMeYourCodeYouTube_java-sorting-algorithms)

The console application shows performance of various sorting algorithms like Bubble Sort, Quick Sort etc.

**This is the old project which needs more attention. Algorithms require refactoring and it will be done in the future. Please do not treat
it as the final version of this project.**

## Technology stack

- Maven
- Java 11 (AWS Coretto)
- Lombok
- vavr
  - https://github.com/vavr-io/vavr
- SonarCloud
  - https://sonarcloud.io/
  - https://sonarcloud.io/organizations/showmeyourcodeyoutube/projects


- Testing
  - JUnit 5
  - Mockito 1.9.5
  - Hamcrest

## Algorithms benchmark

| Algorithm (time/memory) | 1000 elements | 2000 elements | 5000 elements | Best complexity | Average complexity | Worst complexity | Best complexity | Space complexity | Stable |
|-------------------------|---------------|---------------|---------------|-----------------|--------------------|------------------|-----------------|------------------|--------|
| Bubble sort             | time/memory   |               |               |                 |                    |                  |                 |                  |        |
| Counting sort           |               |               |               |                 |                    |                  |                 |                  |        |
| Heap sort               |               |               |               |                 |                    |                  |                 |                  |        |
| Insert sort             |               |               |               |                 |                    |                  |                 |                  |        |
| Merge sort              |               |               |               |                 |                    |                  |                 |                  |        |
| Quick sort              |               |               |               |                 |                    |                  |                 |                  |        |
| Selection sort          |               |               |               |                 |                    |                  |                 |                  |        |
| Shaker sort             |               |               |               |                 |                    |                  |                 |                  |        |
| Shell sort              |               |               |               |                 |                    |                  |                 |                  |        |

Stable - A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in
the input array to be sorted.

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

Others:

- use `IT` suffix for integration tests
- use `Test` suffix for unit tests

## Todo

- Use functional approach, rewrite the algorithm implementations
- Sorting algorithms benchmark - time & memory
- generate Markdown table with result and present them in README
- Compare implementation with Vavr and without
- Use thread pool
- Generate 1000, 2000 and 5000 elements for test. The data should be always the same!
