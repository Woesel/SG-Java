
package com.tenzin.flooring.service;

/**
 *
 * @author Tenzin Woesel
 * Jul 8, 2020
 */
public class FMTaxValidationException extends Exception{

     public FMTaxValidationException(String message) {
        super(message);
    }

    public FMTaxValidationException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
