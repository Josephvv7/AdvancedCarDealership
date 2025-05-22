package com.pluralsight;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private double recordingFee = 100.0;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean isFinanced) {

        super(date, customerName, customerEmail, vehicle);
        this.isFinanced = isFinanced;
        salesTaxAmount = vehicle.getPrice() * 0.05;
        processingFee = vehicle.getPrice() < 10000 ? 295 : 495;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    @Override
    double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    double getMonthlyPayment() {

        if (!isFinanced) {
        return 0;
    }
//        int numberOfPayments = 0;

        // If price of a sold vehicle is less than or equal to $10,000 loan term is 48 months, else time of the loan is 24 months.
        int loanTime = getVehicleSold().getPrice() >= 10000 ? 48 : 24;

        // If time of the loan is 48 months interest rate is 4.25% else interest rate is 5.25%.
        double interestRate = loanTime == 48 ? 0.0425 : 0.0525;

        // My own methods
        double monthlyInterestRate = interestRate / 12;
        double totalPrice = getTotalPrice();
        double monthlyPayment;
        monthlyPayment = (totalPrice * monthlyInterestRate) / loanTime;

        //Raymond's Methods
//        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
//        monthlyPayment = Math.round(monthlyPayment * 100);
//        monthlyPayment /= 100;

        return monthlyPayment;
    }
}
