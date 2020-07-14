/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenzin.flooring.dao;

import com.tenzin.flooring.dto.FMOrder;
import java.util.List;

/**
 *
 * @author ttibe
 */
public interface FMExportDao {
    
    public void backUpOrder(List<FMOrder> orderList) throws FMDataPersistenceException;
    
}
