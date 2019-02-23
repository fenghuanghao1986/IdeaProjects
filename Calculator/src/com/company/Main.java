package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        // Provide instructions for user
        System.out.println("Please provide a function you want me to calculate:");
        System.out.println("Input format: 3 + 3 or 5 / 6 or 3 - 9 or 8 * 8");
        System.out.println("Please make sure there is space between number and operator!");
        System.out.println("You input: ");

        // Getting input from user
        Scanner myObj = new Scanner(System.in);
        String userInput = myObj.nextLine();

        // Convert string type input to a array
        // String[] userOperation = userInput.split(",");
        OperactionConvertion newInput = new OperactionConvertion();
        newInput.Convert(userInput);

        calculator mycal = new calculator();
        mycal.Operator(userOperation);
        float result = mycal.calculate();

        System.out.print(result);
    }
}


// Testcase
// 1 + 2 * 3 * 4 + 5 / 6 - 7
// 1 + 2 * 3 * 4 + 5 / 6