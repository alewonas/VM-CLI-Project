//package com.company.view;
//
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
//public class Menu {
//
//    private PrintWriter out;
//    private Scanner in;
//
//    public Menu(InputStream input, OutputStream output) {		// constructor
//        this.out = new PrintWriter(output);
//        this.in = new Scanner(input);
//    }
//
//    public Object getChoiceFromOptions(Object[] options) {
//        Object choice = null;				// starts null until user selects something
//        while (choice == null) {
//            displayMenuOptions(options);				// uses below method to show options
//            choice = getChoiceFromUserInput(options);	// object to get choice selected
//        }
//        return choice;
//    }
//
//    private Object getChoiceFromUserInput(Object[] options) {		// gets what user types in for choice
//        Object choice = null;
//        String userInput = in.nextLine();
//        try {
//            int selectedOption = Integer.valueOf(userInput);
//            if (selectedOption > 0 && selectedOption <= options.length) {
//                choice = options[selectedOption - 1];
//            }
//        } catch (NumberFormatException e) {
//            // eat the exception, an error message will be displayed below since choice will be null
//        }
//        if (choice == null) {
//            out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
//        }
//        return choice;
//    }
//
//    private void displayMenuOptions(Object[] options) {		// displays options
//        out.println();
//        for (int i = 0; i < options.length; i++) {
//            int optionNum = i + 1;
//            out.println(optionNum + ") " + options[i]);
//        }
//        out.print(System.lineSeparator() + "Please choose an option >>> ");
//        out.flush();
//    }
//}
//
//
//}
