//package com.company.view;
//
//import java.util.Scanner;
//
//public class PurchaseMenu {
//
//    private Scanner in2 = new Scanner(System.in);
//
//    public Object getChoiceFromOptionsPurchaseMenu(Object[] options) {      // gets choice and calls methods to show menu and track
//        Object choice = null;
//        while (choice == null) {
//            displayPurchaseMenuOptions(options);
//            choice = getPurchaseChoiceFromUserInput(options);
//        }
//        return choice;
//    }
//
//    private Object getPurchaseChoiceFromUserInput(Object[] options) {       // tracks what user types
//        Object choice = null;
//        String userInput = in2.nextLine();
//        try {
//            int selectedOption = Integer.valueOf(userInput);
//            if (selectedOption > 0 && selectedOption <= options.length) {
//                choice = options[selectedOption - 1];
//            }
//
//        } catch (NumberFormatException e) {
//            // eat the exception, an error message will be displayed below since choice will be null
//        }
//        if (choice == null) {
//            System.out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
//        }
//        return choice;
//    }
//
//    private void displayPurchaseMenuOptions(Object[] options) {     // displays purchase menu
//        ;
//        System.out.println();
//        for (int i = 0; i < options.length; i++) {
//            int optionNum = i + 1;
//            System.out.println(optionNum + ") " + options[i]);
//        }
//        System.out.print(System.lineSeparator() + "Please choose an option >>> ");
//        System.out.flush();
//    }
//
//}
