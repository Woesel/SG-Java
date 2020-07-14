
package com.tenzin.flooring.service;

/**
 *
 * @author Tenzin Woesel
 * Jul 8, 2020
 */
public class FMProductValidationException extends Exception{
    
    public FMProductValidationException(String message) {
        super(message);
    }

    public FMProductValidationException(String message,
            Throwable cause) {
        super(message, cause);
    }

}
