package com.tenzin.vendingmachine.service;

import com.tenzin.vendingmachine.dao.VendingMachineAuditDao;
import com.tenzin.vendingmachine.dao.VendingMachinePersistenceException;

/**
 *
 * @author Tenzin Woesel Jun 12, 2020
 */
public class VendingMachineAudiDaoStubImpl implements VendingMachineAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {

        //...do nothing
    }
}
