# Contributing rules

## Git commits

- Follow [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/)

## Tests

Remember about:

- using `IT` suffix for integration tests
- using`Test` suffix for unit tests

If you want to run some tests from your IDE,   
you might need to add `--add-opens java.base/java.lang=ALL-UNNAMED` JVM param (some tests require it).

## Release a new version

Run Maven commands using Maven Release plugin.
```text
mvn release:prepare
```
