package com.tenzin.classroster.service;

import com.tenzin.classroster.dao.ClassRosterAuditDao;
import com.tenzin.classroster.dao.ClassRosterPersistenceException;

/**
 *
 * @author Tenzin Woesel May 31, 2020
 */
public class ClassRosterAuditDaoStubImpl implements ClassRosterAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {

        //...do nothing
    }

}
