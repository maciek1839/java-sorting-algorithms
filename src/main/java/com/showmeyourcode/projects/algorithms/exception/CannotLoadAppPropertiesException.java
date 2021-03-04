package com.showmeyourcode.projects.algorithms.exception;

public class CannotLoadAppPropertiesException extends Exception {
    public CannotLoadAppPropertiesException(Throwable cause) {
        super("Cannot load application properties. Ensure that the file exists!", cause);
    }
}
