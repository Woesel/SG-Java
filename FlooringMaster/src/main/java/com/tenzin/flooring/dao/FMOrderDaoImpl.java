package com.tenzin.flooring.dao;

import com.tenzin.flooring.dto.FMOrder;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tenzin Woesel Jun 27, 2020
 */
public class FMOrderDaoImpl implements FMOrderDao {

    private String DELIMITER = ",";

    private String ORDER_DATA_FOLDER;
    private String ORDER_DATA_FILE;
    Map<Integer, FMOrder> innerMap = new HashMap<>();

    private Map<LocalDate, Map<Integer, FMOrder>> orderMap= new HashMap<>();
    

    @Override
    public FMOrder addOrder(FMOrder order) throws FMDataPersistenceException{
        FMOrder innerOrder = innerMap.put(order.getOrderNumber(), order);
        FMOrder newOrder = (FMOrder) orderMap.put(order.getOrderDate(), (Map<Integer, FMOrder>) innerOrder);
        return newOrder;
    }

    @Override
    public List<FMOrder> getAllOrders(LocalDate orderDate) throws FMDataPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FMOrder getSelectedOrder(int orderNumber, LocalDate orderDate) throws FMDataPersistenceException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FMOrder> getEveryOrder() throws FMDataPersistenceException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FMOrder removeOrder(LocalDate orderDate, int orderNumber) throws FMDataPersistenceException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FMOrder editOrder(FMOrder order) throws FMDataPersistenceException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void writeOrderData() throws FMDataPersistenceException {
    }

    private void loadOrderData() throws FMDataPersistenceException {
    }

    private String marshallOrder(FMOrder anOrder) {
        String orderAsText = anOrder.getOrderNumber()+ DELIMITER;
        orderAsText += anOrder.getCustomerName() + DELIMITER;
        orderAsText += anOrder.getTaxInfo().getStateAbbreviation() + DELIMITER;
        orderAsText += anOrder.getTaxInfo().getTaxRate() + DELIMITER;
        orderAsText += anOrder.getProducts().getProductType() + DELIMITER;
        orderAsText += anOrder.getArea() + DELIMITER;
        orderAsText += anOrder.getProducts().getCostPerSquareFoot() + DELIMITER;
        orderAsText += anOrder.getProducts().getLaborCostPerSquareFoot() + DELIMITER;
        orderAsText += anOrder.getMaterialCost() + DELIMITER;
        orderAsText += anOrder.getLaborCost() + DELIMITER;
        orderAsText += anOrder.getTax() + DELIMITER;
        orderAsText += anOrder.getTotal();
        return orderAsText;
    }

    private FMOrder unmarshallOrder(String orderAsText) {
        return null;
    }

}
