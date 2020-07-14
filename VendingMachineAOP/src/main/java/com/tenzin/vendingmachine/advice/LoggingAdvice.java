
package com.tenzin.vendingmachine.advice;

import com.tenzin.vendingmachine.dao.VendingMachineAuditDao;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Tenzin Woesel
 * Jun 23, 2020
 */
public class LoggingAdvice {
    
    VendingMachineAuditDao auditDao;

    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (Exception e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

}
