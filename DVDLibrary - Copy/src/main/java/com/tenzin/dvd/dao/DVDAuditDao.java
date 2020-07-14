package com.tenzin.dvd.dao;

/**
 *
 * @author Tenzin Woesel Jun 22, 2020
 */
public interface DVDAuditDao {

    public void writeAuditEntry(String entry) throws Exception;

}
