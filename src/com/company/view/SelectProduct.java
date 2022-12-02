package com.company.view;

import com.company.Inventory;
import com.company.Log;
import com.company.UserMoney;

import java.util.Scanner;

public class SelectProduct {

    public void run(Inventory inventory, UserMoney money, Log log){         // runs selection menu and uses objects
        inventory.getInventory();           // displays options

        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("************************");
        System.out.print("Please select an item: ");

        String choice = input.nextLine();

        boolean containsKey = false;
        boolean containsSoldOut = false;

        for (Object itemLine : inventory.inventoryData().keySet()){     // for each loop to check users input against each option using a hashmap
            String itemLineInLoop = itemLine.toString();        // makes object a sting so we can compare

            if (choice.length() != 2){      // choice should be a 2 button combo so if not then break loop and show error message
                break;
            }

            if (itemLineInLoop.substring(0, 2).equals(choice)){     // checks if user input is an option
                containsKey = true;

                if ((int)inventory.inventoryData().get(itemLineInLoop) < 1){        // if sold out then break loop and show message
                    containsSoldOut = true;
                    break;
                }
                if (money.getBalance().compareTo(inventory.getPrice(itemLineInLoop)) >= 0){     // to check if balance is enough
                    System.out.println("Item Dispensed: " + itemLineInLoop);
                    money.purchase(inventory.getPrice(itemLineInLoop));         // uses money function to subtract price
                    System.out.println("Money remaining: " + money.getBalance());
                    log.itemBoughtLog(itemLineInLoop);                              // logs purchase
                    inventory.inventoryData().put(itemLine, (int)inventory.inventoryData().get(itemLineInLoop) - 1);    // updates inventory left in machine
                    if (itemLineInLoop.contains("Chip")){                               // messages required
                        System.out.println("Crunch Crunch, Yum!");
                    } else if (itemLineInLoop.contains("Candy")){
                        System.out.println("Munch Munch, Yum!");
                    } else if (itemLineInLoop.contains("Drink")){
                        System.out.println("Glug Glug, Yum!");
                    } else if (itemLineInLoop.contains("Gum")){
                        System.out.println("Chew Chew, Yum!");
                    }

                } else {
                    System.out.println("Not enough funds. Please add more money");
                }

            }

        }

        if (containsKey == false){
            System.out.println("Invalid choice. Please try again");
        }

        if (containsSoldOut){
            System.out.println("Item Sold Out. Please pick again");
        }

    }

}
