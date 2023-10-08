# Java sorting algorithms

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/), and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [3.0.0 (2023-xx-xx)]()

## Added

- Use Fork/Join Framework (ForkJoinPool)
- Introduce new benchmark settings to application.properties
- Use Java Microbenchmark Harness (JMH) to measure algorithms performance

## Changed

- Replace JUnit with Spock
- Use Java Faker to generate random test data
- Migrate from JDK 11 to JDK 17

## Fixed

- Include integration tests in JaCoCo code coverage
- Remove "v" from the release configuration (Git tags) to follow Semantic Versioning 2.0.0

## [2.6.0 (2023-06-11)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/compare/java-sorting-2.5.0...java-sorting-2.6.0)

### Added

- Static Application Security Testing (SAST)
- Lombok annotations for generated fields (improve code coverage)
- Maven release plugin
- LICENSE file
- Missing unit tests

### Changed

- Display a message in Markdown files if a PDF document is not supported
- Update EXERCISES.md and README.md files
- Replace Vavr tuples with javatuples library

### Fixed

- Code coverage displayed on GitLab
- SonarCloud integration (configure it again accordingly to an official guide)

## [2.5.0 (2021-04-02)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/compare/java-sorting-2.4.0...java-sorting-2.5.0)

### Added

- PROFILER.md file

### Changed

- Use an executor service instead of creating a new thread each time for the waiting mechanism
- Unify the generated benchmark report with the benchmark table in README.md (thanks to this change, it is possible to copy the generated result directly to Markdown file)

### Fixed

- Sonar warnings

## [2.4.0 (2021-03-23)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/compare/java-sorting-2.3.0...java-sorting-2.4.0)

### Changed

- Update benchmark results
- Refactor sorting algorithms (QuickSort)

## [2.3.0 (2021-03-21)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/compare/java-sorting-2.2.0...java-sorting-2.3.0)

### Changed

- Update benchmark results
- Improve sorting algorithms (CocktailShakerSort, HeapSort, MergeSort, QuickSort, SelectionSort, ShellSort)

### Fixed

- The benchmark table formatting

## [2.2.0 (2021-03-16)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/compare/java-sorting-2.1.0...java-sorting-2.2.0)

### Added

- The benchmark table contains execution and algorithms details
- Measure memory during an algorithm execution

### Changed

- The format of saving benchmark results
- Milliseconds to nanoseconds as a default time execution unit
- Refactor a part of algorithms: Bubble Sort, Insertion Sort, Counting Sort, Selection Sort
- Create the benchmark results file when it does not exist
- Show logs during benchmark calculations

## [2.1.0 (2021-03-05)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/compare/java-sorting-2.0.1...java-sorting-2.1.0)

### Added

- A new benchmark option in GUI
- A benchmark table in README.md (it's still empty because algorithms need refactoring)

### Changed

- Adjust packages structure
- Adjust Logback configuration to not show redundant information

## [2.0.1 (2021-02-25)](https://gitlab.com/ShowMeYourCodeYouTube/java-sorting-algorithms/-/compare/java-sorting-2.0.0...java-sorting-2.0.1)

## Added

- Code coverage as a badge on Gitlab using JaCoCo plugin

## 2.0.0 (2021-02-20)

## Added

- New logger library (SLF4J & Logback)
- SonarQube support (using SonarCloud)

## Changed

- The root package name is set to com.showmeyourcode.algorithms
- Upgrade JUnit 4.12 to JUnit 5.1
- Upgrade Maven compiler plugin 3.5.1 to 3.8.0
- General code refactoring (use camelCase instead of snake_case for variables)
- Adjust Java classes structure according to good design principles

## 1.0.0 (2016-11-05)

The first release 🎉🎉🎉

## Added

- Sorting algorithms
  - BubbleSort
  - CountingSort
  - HeapSort
  - InsertSort
  - MergeSort
  - QuickSort
  - SelectionSort
  - ShakerSort
  - ShellSort
