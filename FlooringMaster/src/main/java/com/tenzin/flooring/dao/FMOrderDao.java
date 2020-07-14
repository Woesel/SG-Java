
package com.tenzin.flooring.dao;

import com.tenzin.flooring.dto.FMOrder;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Tenzin Woesel
 * Jun 25, 2020
 */
public interface FMOrderDao {
    
    public FMOrder addOrder(FMOrder order) throws FMDataPersistenceException;
            
    public List<FMOrder> getAllOrders(LocalDate orderDate) throws FMDataPersistenceException;
            
    public FMOrder getSelectedOrder(int orderNumber, LocalDate orderDate ) throws FMDataPersistenceException;
    
    public List<FMOrder> getEveryOrder() throws FMDataPersistenceException;
            
    public FMOrder removeOrder(LocalDate orderDate, int orderNumber ) throws FMDataPersistenceException;
    
    public FMOrder editOrder(FMOrder order) throws FMDataPersistenceException;
}


