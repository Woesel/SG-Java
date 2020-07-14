package com.tenzin.classroster.service;

/**
 *
 * @author Tenzin Woesel May 26, 2020
 */
public class ClassRosterDataValidationException extends Exception {

    public ClassRosterDataValidationException(String message) {
        super(message);
    }

    public ClassRosterDataValidationException(String message,
            Throwable cause) {
        super(message, cause);
    }   
}
