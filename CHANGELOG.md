# Java sorting algorithms

## 2.5.0 (02.04.2021)

### Added

- Unify the generated benchmark report with the benchmark table in README.md. Thanks to this change, it is possible to copy the generated
  result directly to Markdown file.

### Changed

- Use an executor service instead creating a new thread each time for the waiting mechanism.

### Fixed

- Sonar warnings

## 2.4.0 (23.03.2021)

### Changed

- Update benchmark results and verify remaining algorithms.

## 2.3.0 (21.03.2021)

### Changed

- Update benchmark results and verify a few algorithms.

### Fixed

- The benchmark table formatting.

## 2.2.0 (16.03.2021)

### Added

- Create the benchmark results file when it does not exist.
- Show logs during benchmark calculations
- The benchmark table contains execution and algorithms details.
- Measure memory during an algorithm execution.

### Changed

- Change a format of saving benchmark results.
- Change milliseconds to nanoseconds as a default time execution unit.
- Refactor a part of algorithms: Bubble Sort, Insertion Sort, Counting Sort, Selection Sort.

## 2.1.0 (05.03.2021)

### Added

- A new benchmark option in GUI.
- A benchmark table in README.md (it's still empty because algorithms need refactoring).
- Improve code coverage and add missing tests.

### Changed

- Adjust packages structure.
- Adjust Logback configuration to not show redundant information.

## 2.0.1 (25.02.2021)

## Added

- Display code coverage as a badge on Gitlab using Jacoco plugin

## 2.0.0 (20.02.2021)

## Added

- Add new logger library (SLF4J & Logback)
- SonarQube support (using SonarCloud).

## Changed

- Change the root package name to com.showmeyourcode.algorithms
- Upgrade JUnit 4.12 to JUnit 5.1
- Upgrade Maven compiler plugin 3.5.1 to 3.8.0
- General code refactor regarding variable naming (use camelCase instead of snakecase)
- Change program and classes structure according to good design principles.

## 1.0.0 (2016-11-05)

First release
