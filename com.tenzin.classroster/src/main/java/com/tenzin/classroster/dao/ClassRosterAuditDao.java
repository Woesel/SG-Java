package com.tenzin.classroster.dao;

/**
 *
 * @author Tenzin Woesel
 */
public interface ClassRosterAuditDao {

    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;

}
