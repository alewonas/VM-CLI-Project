package com.company;

import com.company.view.PurchaseMenu;
import com.company.view.SelectProduct;

import java.awt.*;

public class VendingMachineCLI {

//    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
//    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
//    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
//    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
//
//    private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
//    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
//    private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
//    private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION };

    private Menu menu;


    public VendingMachineCLI(Menu menu) {		// constructor
        this.menu = menu;
    }


//    public void run() {
//        boolean isRunning = true;
        Inventory inventory = new Inventory();		// instantiates/make new object called inventory from the Inventory class
        inventory.setInventory();					// used to call the set inventory and this will set up our Hash Map with the inventory
        UserMoney money = new UserMoney();			// class for to track and modify balance during use
        Log log = new Log(inventory, money);		// for keeping log, passes in money and inventory to log each
        log.run();									// creates the log file
//        while (isRunning) {
//            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS); 	// uses menu class to show and track picks
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                inventory.getInventory();											// Calls Inventory class object to display vending machine items
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                boolean isPurchaseRunning = true;						// to control if purchase menu being used
                while (isPurchaseRunning){
                    PurchaseMenu purchaseMenu = new PurchaseMenu();		// create purchase menu
                    System.out.println();
                    System.out.println("Current Money Provided: $" + money.getBalance());		// displays balance
                    String choice2 = (String) purchaseMenu.getChoiceFromOptionsPurchaseMenu(PURCHASE_MENU_OPTIONS);		// similar to above, tracks pick
                    if (choice2.equals(PURCHASE_MENU_FEED_MONEY)){
                        money.addMoney(log);											// add money functionality
                    } else if (choice2.equals(PURCHASE_MENU_SELECT_PRODUCT)){
                        SelectProduct selection = new SelectProduct();					// for selecting product menu
                        selection.run(inventory, money, log);						//
                    } else if (choice2.equals(PURCHASE_MENU_FINISH_TRANSACTION)){
                        log.moneyReturnedLog();		// logs
                        money.returnBalance();		// returns balance
                        isPurchaseRunning = false;		// to end loop and go back to previous menu
                    }
                }

            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
                isRunning = false;						// ends application
            }
        }
    }

//    public static void main(String[] args) {
//        Menu menu = new Menu(System.in, System.out);				// creates menu
//        VendingMachineCLI cli = new VendingMachineCLI(menu);		// passes in menu functionality
//        cli.run();													// runs application
//
//    }

}
