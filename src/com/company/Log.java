package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    public String dirName;
    public File newDirectory;
    public File newLogFile;
    public Inventory inventory;
    public UserMoney money;

    public String toTest;


    public Log(){

    }

    public Log(Inventory inventory, UserMoney money){
        this.dirName = "src\\log-folder";
        this.inventory = inventory;
        this.money = money;
    }

    public void run(){                                  // creates the log file
        this.newDirectory = new File(dirName);
        if(newDirectory.exists()){
            System.out.println(newDirectory + "already exists");
        } else {
            newDirectory.mkdir();
        }

        try{
            this.newLogFile = new File(dirName, "logFile.txt");
            newLogFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

    }

    public void moneyAddedLog(BigDecimal dollarAmount){         // when money added then writes that to log file

        try(PrintWriter writer = new PrintWriter(new FileOutputStream(newLogFile, true))){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh.mm.ss aa");
            String dateToString = dateFormat.format(new Date()).toString();
            String writeString = dateToString + " FEED MONEY: " + "$" + dollarAmount + " $ " + money.getBalance();
            this.toTest = writeString;
            writer.println(writeString);
        } catch (IOException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void itemBoughtLog(String lineItem){                 // when item is bought then logs that to file
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(newLogFile, true))){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh.mm.ss aa");
            String dateToString = dateFormat.format(new Date()).toString();
            writer.println(dateToString + " " + inventory.getItem(lineItem) + " " + inventory.buttonCombo(lineItem) + " $" + inventory.getPrice(lineItem) + " $" + money.getBalance());
        } catch (IOException e){
            System.out.println("Exception: " + e.getMessage());
        }

    }

    public void moneyReturnedLog(){                 // when transaction over then logs money return to file
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(newLogFile, true))){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh.mm.ss aa");
            String dateToString = dateFormat.format(new Date()).toString();
            writer.println(dateToString + " GIVE CHANGE: " + "$" + money.getBalance() + " " + "$0.00");
        } catch (IOException e){
            System.out.println("Exception: " + e.getMessage());
        }

    }

    public String forTesting(){
        return toTest;
    }

}
