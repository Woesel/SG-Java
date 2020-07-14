package com.tenzin.classroster.dao;

/**
 *
 * @author Tenzin Woesel May 11, 2020
 */
public class ClassRosterPersistenceException extends Exception {

    public ClassRosterPersistenceException(String message) {
        super(message);
    }

    public ClassRosterPersistenceException(String message, Throwable cause) {

        super(message, cause);
    }
}
