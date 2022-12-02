package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    private Map<String, Integer> inventoryMap = new HashMap<>();       // using hashmap to keep inventory
    private File inventoryFile;                                         // to read inventory file


    public Inventory(){
        this.inventoryFile = new File("C:\\Users\\Student\\workspace\\mod-1-capstone-java-team-1\\capstone\\vendingmachine.csv");
    }


    public void setInventory() {            // reads inventory file

        try (Scanner fileScanner = new Scanner(this.inventoryFile)) {

            while (fileScanner.hasNextLine()){
                inventoryMap.put(fileScanner.nextLine(), 5);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

    }

    public void getInventory(){             // displays inventory to user

        for (String itemLine : inventoryMap.keySet()){

            if (inventoryMap.get(itemLine) >= 1){
                System.out.println(itemLine + " Amount left: " + inventoryMap.get(itemLine));

            } else {
                System.out.println(itemLine + " **Sold Out**");
            }

        }

    }

    public Map inventoryData(){         // used to track inventory when prompted
        return inventoryMap;
    }


    public BigDecimal getPrice(String productLine){     // gets price from inventory line

        String[] lineArray = productLine.split("\\|");

        BigDecimal price = new BigDecimal(lineArray[2]);

        return price;

    }

    public String getItem(String productLine){      // gets item from inventory line

        String[] lineArray = productLine.split("\\|");

        String item = lineArray[1];

        return item;

    }

    public String buttonCombo(String productLine){      // gets option/button combo from line

        String[] lineArray = productLine.split("\\|");

        String combo = lineArray[0];

        return combo;

    }

}
