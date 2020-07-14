package com.tenzin.flooring.dao;

import com.tenzin.flooring.dto.FMProduct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Tenzin Woesel Jul 6, 2020
 */
public class FMProductDaoImpl implements FMProductDao {

    public String DELIMITER = ",";

    private String PRODUCT_FILE = "Data\\Products.txt";

    private Map<String, FMProduct> productMap = new HashMap<>();

    @Override
    public FMProduct addProduct(FMProduct product) throws FMDataPersistenceException {
        loadProductData();
        FMProduct newProduct = productMap.put(product.getProductType(), product);
        writeProductData();
        return newProduct;
    }

    @Override
    public FMProduct getProduct(String productType) throws FMDataPersistenceException {
        loadProductData();
        return productMap.get(productType);
    }

    @Override
    public List<FMProduct> getAllProduct() throws FMDataPersistenceException {
        loadProductData();
        return new ArrayList(productMap.values());
    }

    @Override
    public FMProduct updateProduct(FMProduct product) throws FMDataPersistenceException {
        loadProductData();
        FMProduct editedProduct = productMap.put(product.getProductType(), product);
        writeProductData();
        return editedProduct;

    }

    @Override
    public FMProduct removeProduct(FMProduct product) throws FMDataPersistenceException {
        loadProductData();
        FMProduct removedProduct = productMap.remove(product.getProductType());
        writeProductData();
        return removedProduct;
    }

    private void loadProductData() throws FMDataPersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));
        } catch (FileNotFoundException e) {
            throw new FMDataPersistenceException("Could not load data", e);
        }

        String currentLine;
        scanner.nextLine(); //will skip reading the header

        FMProduct currentProduct;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentProduct = unmarshallProductData(currentLine);
            productMap.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();

    }

    private FMProduct unmarshallProductData(String productAsText) {
        String[] productTokens = productAsText.split(DELIMITER);
        String productType = productTokens[0];
        String costPerSquareFoot = productTokens[1];
        String laborCostPerSquareFoot = productTokens[2];
        FMProduct productFromFile = new FMProduct(productType, new BigDecimal(costPerSquareFoot), new BigDecimal(laborCostPerSquareFoot));

        return productFromFile;
    }

    private String marshallItem(FMProduct aProduct) {
        String productAsText = aProduct.getProductType() + DELIMITER;

        productAsText += aProduct.getCostPerSquareFoot() + DELIMITER;

        productAsText += aProduct.getLaborCostPerSquareFoot();

        return productAsText;
    }

    private void writeProductData() throws FMDataPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(PRODUCT_FILE));
        } catch (IOException e) {
            throw new FMDataPersistenceException("could not save product data", e);
        }

        String productAsText;

        List<FMProduct> productList = new ArrayList(productMap.values());

        for (FMProduct currentProduct : productList) {
            productAsText = marshallItem(currentProduct);
            out.println(productAsText);
            out.flush();
        }
        out.close();

    }

}
