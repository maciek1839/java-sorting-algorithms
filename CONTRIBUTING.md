# Contributing rules

## Git commits

- Follow [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/)

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
