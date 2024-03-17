// Experiment 1.3 Java 

import java.util.Scanner;

class Deposit {
    protected double principal;
    protected int tenure; // in months
    protected double rateOfInterest;

    public Deposit(double principal, int tenure, double rateOfInterest) {
        this.principal = principal;
        this.tenure = tenure;
        this.rateOfInterest = rateOfInterest;
    }

    public double calculateInterest() {
        return (principal * rateOfInterest * tenure) / (12 * 100);
    }
}

class FixedDeposit extends Deposit {
    public FixedDeposit(double principal, int tenure, double rateOfInterest) {
        super(principal, tenure, rateOfInterest);
    }

    @Override
    public double calculateInterest() {
        // Additional conditions or calculations specific to Fixed Deposit
        return super.calculateInterest() * 1.5;
    }
}

class RecurringDeposit extends Deposit {

    public RecurringDeposit(double principal, int tenure, double rateOfInterest, int monthlyDeposit) {
        super(principal, tenure, rateOfInterest);
    }

    @Override
    public double calculateInterest() {
        // Additional conditions or calculations specific to Recurring Deposit
        return super.calculateInterest() * 1.2;
    }
}

public class InterestCalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter tenure (in months): ");
        int tenure = scanner.nextInt();

        System.out.print("Enter rate of interest: ");
        double rateOfInterest = scanner.nextDouble();

        System.out.print("Enter monthly deposit amount for RD (enter 0 for FD): ");
        int monthlyDeposit = scanner.nextInt();

        // Creating objects for FD and RD
        Deposit fd = new FixedDeposit(principal, tenure, rateOfInterest);
        Deposit rd = new RecurringDeposit(principal, tenure, rateOfInterest, monthlyDeposit);

        // Calculating and displaying interest
        System.out.println("Interest for Fixed Deposit: " + fd.calculateInterest());
        System.out.println("Interest for Recurring Deposit: " + rd.calculateInterest());

        scanner.close();
    }
}
