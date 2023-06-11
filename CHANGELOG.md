# Java sorting algorithms

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/), and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## 2.6.0 (2023-06-11)

### Added

- Static Application Security Testing (SAST).
- Lombok annotations for generated fields.
- Maven release plugin.
- LICENSE.

### Changes

- Display a message in Markdown files if a PDF document is not supported.
- Update EXERCISES.md and README.md.
- Add missing tests.
- Replace Vavr tuples with javatuples library.

### Fixed

- Code coverage displayed on Gitlab.
- SonarCloud integration (configure it again accordingly to an official guide).

## 2.5.0 (2021-04-02)

### Added

- Unify the generated benchmark report with the benchmark table in README.md. Thanks to this change, it is possible to copy the generated result directly to Markdown file.

### Changed

- Use an executor service instead creating a new thread each time for the waiting mechanism.

### Fixed

- Sonar warnings.

## 2.4.0 (2021-03-23)

### Changed

- Update benchmark results and verify remaining algorithms.

## 2.3.0 (2021-03-21)

### Changed

- Update benchmark results and verify a few algorithms.

### Fixed

- The benchmark table formatting.

## 2.2.0 (2021-03-16)

### Added

- Create the benchmark results file when it does not exist.
- Show logs during benchmark calculations.
- The benchmark table contains execution and algorithms details.
- Measure memory during an algorithm execution.

### Changed

- Change a format of saving benchmark results.
- Change milliseconds to nanoseconds as a default time execution unit.
- Refactor a part of algorithms: Bubble Sort, Insertion Sort, Counting Sort, Selection Sort.

## 2.1.0 (2021-03-05)

### Added

- A new benchmark option in GUI.
- A benchmark table in README.md (it's still empty because algorithms need refactoring).
- Improve code coverage and add missing tests.

### Changed

- Adjust packages structure.
- Adjust Logback configuration to not show redundant information.

## 2.0.1 (2021-02-25)

## Added

- Display code coverage as a badge on Gitlab using Jacoco plugin.

## 2.0.0 (2021-02-20)

## Added

- Add new logger library (SLF4J & Logback).
- SonarQube support (using SonarCloud).

## Changed

- Change the root package name to com.showmeyourcode.algorithms.
- Upgrade JUnit 4.12 to JUnit 5.1.
- Upgrade Maven compiler plugin 3.5.1 to 3.8.0
- General code refactor regarding variable naming (use camelCase instead of snakecase).
- Change program and classes structure according to good design principles.

## 1.0.0 (2016-11-05)

First release 🎉🎉🎉
