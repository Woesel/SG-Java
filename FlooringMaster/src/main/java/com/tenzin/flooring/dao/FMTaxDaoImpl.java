package com.tenzin.flooring.dao;

import com.tenzin.flooring.dto.FMProduct;
import com.tenzin.flooring.dto.FMTax;
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
public class FMTaxDaoImpl implements FMTaxDao {

    public String DELIMITER = ",";

    private String TAX_FILE = "Data\\Taxes.txt";

    private Map<String, FMTax> taxMap = new HashMap<>();

    @Override
    public FMTax addTax(FMTax tax) throws FMDataPersistenceException {
        loadTaxData();
        FMTax newTax = taxMap.put(tax.getStateAbbreviation(), tax);
        writeTaxData();
        return newTax;
    }

    @Override
    public FMTax getTax(String stateAbbreviation) throws FMDataPersistenceException {
        loadTaxData();
        return taxMap.get(stateAbbreviation);

    }

    @Override
    public List<FMProduct> getAllTax() throws FMDataPersistenceException {
        loadTaxData();
        return new ArrayList(taxMap.values());
    }

    @Override
    public FMTax updateTax(FMTax tax) throws FMDataPersistenceException {
        loadTaxData();
        FMTax updatedTax = taxMap.put(tax.getStateAbbreviation(), tax);
        writeTaxData();
        return updatedTax;
    }

    @Override
    public FMTax removeTax(FMTax tax) throws FMDataPersistenceException {
        loadTaxData();
        FMTax removedTax = taxMap.remove(tax.getStateAbbreviation());
        writeTaxData();
        return removedTax;

    }

    public void loadTaxData() throws FMDataPersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(TAX_FILE)));
        } catch (FileNotFoundException e) {
            throw new FMDataPersistenceException("Could not load data", e);
        }

        String currentLine;
        scanner.nextLine(); //will skip reading the header

        FMTax currentTax;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTax = unmarshallTaxData(currentLine);
            taxMap.put(currentTax.getStateAbbreviation(), currentTax);
        }
        scanner.close();

    }

    public FMTax unmarshallTaxData(String taxAsText) {
        String[] taxTokens = taxAsText.split(DELIMITER);
        String state = taxTokens[0];
        String stateName = taxTokens[1];
        String taxRate = taxTokens[2];
        FMTax taxFromFile = new FMTax(state, stateName, new BigDecimal(taxRate));

        return taxFromFile;
    }

    private String marshallItem(FMTax aTax) {
        String taxAsText = aTax.getStateAbbreviation() + DELIMITER;

        taxAsText += aTax.getStateName() + DELIMITER;

        taxAsText += aTax.getTaxRate();

        return taxAsText;
    }

    private void writeTaxData() throws FMDataPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(TAX_FILE));
        } catch (IOException e) {
            throw new FMDataPersistenceException("could not save product data", e);
        }

        String taxAsText;

        List<FMTax> taxList = new ArrayList(taxMap.values());

        for (FMTax currentTax : taxList) {
            taxAsText = marshallItem(currentTax);
            out.println(taxAsText);
            out.flush();
        }
        out.close();

    }

}
