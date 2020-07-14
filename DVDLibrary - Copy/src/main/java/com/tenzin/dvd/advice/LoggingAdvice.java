
package com.tenzin.dvd.advice;

import com.tenzin.dvd.dao.DVDAuditDao;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Tenzin Woesel
 * Jun 22, 2020
 */
public class LoggingAdvice {
    
    DVDAuditDao auditDao;

    public LoggingAdvice(DVDAuditDao auditDao) {
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
