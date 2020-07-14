package com.tenzin.flooring;

import com.tenzin.flooring.controller.FMController;
import com.tenzin.flooring.dao.FMDataPersistenceException;
import com.tenzin.flooring.dao.FMProductDao;
import com.tenzin.flooring.dao.FMProductDaoImpl;
import com.tenzin.flooring.dao.FMTaxDao;
import com.tenzin.flooring.dao.FMTaxDaoImpl;
import com.tenzin.flooring.dto.FMProduct;
import com.tenzin.flooring.dto.FMTax;
import com.tenzin.flooring.view.FMView;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Tenzin Woesel Jun 25, 2020
 */
public class App {

    public static void main(String[] args) throws FMDataPersistenceException, IOException {

        FMController controller = new FMController();
        controller.run();
        FMView view = new FMView();

        FMProductDao pd = new FMProductDaoImpl();
//        Iterable<FMProduct> allProducts = pd.getAllProduct();
        FMTaxDao td = new FMTaxDaoImpl();

        List<FMProduct> allProducts = pd.getAllProduct();

        for (FMProduct prod : allProducts) {

            System.out.print(prod.getProductType());
            System.out.print(prod.getCostPerSquareFoot());
            System.out.print(prod.getLaborCostPerSquareFoot());

        }

        FMProduct product = new FMProduct("Aluminium", new BigDecimal("1.22"), new BigDecimal("1.79"));

        pd.addProduct(product);
        pd.addProduct(product);

        FMProduct product1 = new FMProduct("Aluminium3", new BigDecimal("2.999"), new BigDecimal("22.9"));
        FMProduct product2 = new FMProduct("AluminiumZ", new BigDecimal("2.222"), new BigDecimal("22.9"));
        FMProduct product3 = new FMProduct("Aluminium1", new BigDecimal("2.979"), new BigDecimal("22.9"));

        pd.updateProduct(product3);
        pd.updateProduct(product2);
        pd.removeProduct(product);

        product = new FMProduct("Gold", new BigDecimal("2.22"), new BigDecimal("1.79"));
        pd.updateProduct(product);

        FMTax tax = new FMTax("NI", "NewIndia", new BigDecimal("99"));

        td.addTax(tax);

        System.out.println("++++++++++++++++++++++++++++++++++++++");
        allProducts = pd.getAllProduct();
        for (FMProduct prod : allProducts) {

            System.out.print(prod.getProductType());
            System.out.print(prod.getCostPerSquareFoot());
            System.out.print(prod.getLaborCostPerSquareFoot());

        }

        view.getNewOrderInfo(allProducts);
    }
}
