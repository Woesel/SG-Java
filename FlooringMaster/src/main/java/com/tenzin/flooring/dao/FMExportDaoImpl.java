
package com.tenzin.flooring.dao;

import com.tenzin.flooring.dto.FMOrder;
import java.util.List;

/**
 *
 * @author Tenzin Woesel
 * Jul 6, 2020
 */
public class FMExportDaoImpl implements FMExportDao {
    
     public String DELIMITER=",";
    private String EXPORT_DATAFILE;
            
    @Override
    public void backUpOrder(List<FMOrder> orderList) throws FMDataPersistenceException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String marshallOrder(FMOrder anOrder) {
        return null;
    }

}
