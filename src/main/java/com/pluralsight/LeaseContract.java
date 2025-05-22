package com.pluralsight;

public class LeaseContract extends Contract {

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {

        super(date, customerName, customerEmail, vehicle);
        expectedEndingValue = vehicle.getPrice() * 0.5;
        leaseFee = vehicle.getPrice() * 0.07;
    }

    @Override
    double getTotalPrice() {
        return getVehicleSold().getPrice() + leaseFee;
    }

    @Override
    double getMonthlyPayment(){
        double interestRate = 0.04;
        double monthlyInterestRate = interestRate / 12;
        int loanTermMonths = 36;
        double totalPrice = getTotalPrice();

        return (totalPrice * monthlyInterestRate) / loanTermMonths;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

}
