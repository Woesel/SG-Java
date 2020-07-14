
package com.tenzin.flooring.dao;

/**
 *
 * @author Tenzin Woesel
 * Jun 27, 2020
 */
public class FMDataPersistenceException extends Exception{
    
    public FMDataPersistenceException(String message){
        super(message);
    }
    
    public FMDataPersistenceException(String message, Throwable cause){
        super(message,cause);
    }

}
