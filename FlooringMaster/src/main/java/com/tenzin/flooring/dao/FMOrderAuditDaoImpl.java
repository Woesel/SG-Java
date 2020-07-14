package com.tenzin.flooring.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Tenzin Woesel Jun 27, 2020
 */
public class FMOrderAuditDaoImpl implements FMOrderAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws FMDataPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter("audit.txt", true));
        } catch (IOException e) {
            throw new FMDataPersistenceException("Could not persist audit information.", e);
        }
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }

}
