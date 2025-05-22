package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    public void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv", true))) {
            if (contract instanceof SalesContract) {
                SalesContract sale = (SalesContract) contract;
                bw.write(contract.getDate() +
                    contract.getCustomerName() +
                    contract.getCustomerEmail() + Vehicle);
            }

        // Write vehicle inventory



            System.out.println("Dealership saved successfully to dealership.csv.");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
