
package com.tenzin.flooring.dao;

/**
 *
 * @author Tenzin Woesel
 * Jun 25, 2020
 */
public interface FMOrderAuditDao {
    
    public void writeAuditEntry(String entry) throws FMDataPersistenceException;

}
