package com.tenzin.classroster.service;

/**
 *
 * @author Tenzin Woesel May 26, 2020
 */
public class ClassRosterDuplicateIdException extends Exception {

    public ClassRosterDuplicateIdException(String message) {
        super(message);
    }

    public ClassRosterDuplicateIdException(String message,
            Throwable cause) {
        super(message, cause);
    }

}
