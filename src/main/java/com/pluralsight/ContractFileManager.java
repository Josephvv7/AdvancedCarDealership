package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    public void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv", true))) {

            if (contract instanceof SalesContract) {
                SalesContract sale = (SalesContract) contract;
                Vehicle vehicle = contract.getVehicleSold();
                bw.write("SALE|" +
                    contract.getDate() + "|" +
                    contract.getCustomerName() + "|" +
                    contract.getCustomerEmail() + "|" +
                    vehicle.getVin() + "|" +
                    vehicle.getYear() + "|" +
                    vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" +
                    vehicle.getVehicleType() + "|" +
                    vehicle.getColor() + "|" +
                    vehicle.getPrice() + "|" +
                    sale.getSalesTaxAmount() + "|" +
                    sale.getRecordingFee() + "|" +
                    sale.getProcessingFee() + "|" +
                    sale.getTotalPrice() + "|" +
                    (sale.isFinanced() ? "YES" : "NO") + "|" +
                    sale.getMonthlyPayment());
            }
            bw.newLine();

            System.out.println("Dealership saved successfully to dealership.csv.");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
