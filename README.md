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

## Algorithms benchmark

| Algorithm (time/memory) | 10000 elements | 50000 elements | 100000 elements | Best complexity | Average complexity | Worst complexity | Best complexity | Space complexity | Stable |
|-------------------------|----------------|----------------|-----------------|-----------------|--------------------|------------------|-----------------|------------------|--------|
| Bubble sort             | 237/?          |  5281          | 16209           |                 |                    |                  |                 |                  |        |
| Counting sort           |  21/?          |  8             | 8              |                 |                    |                  |                 |                  |        |
| Heap sort               |  219/?         |  3400          | 17267              |                 |                    |                  |                 |                  |        |
| Insert sort             |  0/?           |  2             | 1              |                 |                    |                  |                 |                  |        |
| Merge sort              |  9/?           |  11            | 10              |                 |                    |                  |                 |                  |        |
| Quick sort              |  1/?           |   1            |  2             |                 |                    |                  |                 |                  |        |
| Selection sort          |  72/?          |  518           |  1962             |                 |                    |                  |                 |                  |        |
| Shaker sort             |  1/?           |  1             |   1            |                 |                    |                  |                 |                  |        |
| Shell sort              |  2/?           |  4             |  2             |                 |                    |                  |                 |                  |        |

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
