
package com.tenzin.dvd.dao;

/**
 *
 * @author Tenzin Woesel
 * May 18, 2020
 */
public class DVDDaoException extends Exception{
    
    public DVDDaoException(String message){
        super(message);
    }
    
    public DVDDaoException(String message, Throwable cause){
        
        super(message, cause);
    }

}
