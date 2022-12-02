package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserMoney {

    private double nickel = 0.05;
    private double dime = 0.1;
    private double quarter = 0.25;

    private BigDecimal balance = new BigDecimal(0.00);


    public UserMoney(){

    }

    public BigDecimal getBalance(){
        return this.balance;
    }

    public void addMoney(Log log){           // to show money add options and updates balance when added

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Select dollar amount to deposit");
        System.out.println("1) $1.00");
        System.out.println("2) $5.00");
        System.out.println("3) $10.00");
        System.out.println();

        System.out.print("Please enter option: ");
        int moneyChoice = Integer.parseInt(scanner.nextLine());

        BigDecimal dollar = new BigDecimal(1.00);
        BigDecimal fiveBill = new BigDecimal(5.00);
        BigDecimal tenBill = new BigDecimal(10.00);

        if (moneyChoice == 1){
            this.balance = this.balance.add(dollar);
            log.moneyAddedLog(dollar);
        } else if (moneyChoice == 2){
            this.balance = this.balance.add(fiveBill);
            log.moneyAddedLog(fiveBill);
        } else if (moneyChoice == 3){
            this.balance = this.balance.add(tenBill);
            log.moneyAddedLog(tenBill);
        } else {
            System.out.println("Invalid option. No money added");
        }


    }

    public void purchase(BigDecimal price){             // updates balance when item purchased
        this.balance = this.balance.subtract(price);

    }

    public void returnBalance(){        //  Use loops to return least change possible until all balance returned
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;

        BigDecimal quarter = new BigDecimal(0.25);
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickel = new BigDecimal("0.05");

        while (getBalance().compareTo(quarter) >= 0){
            quarterCount++;
            this.balance = this.balance.subtract(quarter);
        }

        while (getBalance().compareTo(dime) >= 0){
            dimeCount++;
            this.balance = this.balance.subtract(dime);
        }

        while (getBalance().compareTo(nickel) >= 0){
            nickelCount++;
            this.balance = this.balance.subtract(nickel);
        }
        System.out.println();
        System.out.println("You received back: " + quarterCount + " quarters, " + dimeCount + " dimes, and " + nickelCount + " nickels");

    }

    public void setBalanceForTestingPurpose(){                   // for testing
        BigDecimal toAdd = new BigDecimal("7.50");
        this.balance = this.balance.add(toAdd);
    }

}
