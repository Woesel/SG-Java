
package com.tenzin.flooring.service;

/**
 *
 * @author Tenzin Woesel
 * Jul 8, 2020
 */
public class FMOrderValidationException extends Exception {
    
    public FMOrderValidationException(String message) {
        super(message);
    }

    public FMOrderValidationException(String message,
            Throwable cause) {
        super(message, cause);
    }

}
