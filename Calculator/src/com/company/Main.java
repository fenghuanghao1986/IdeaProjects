package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        // Provide instructions for user
        System.out.println("Please provide a function you want me to calculate:");
        System.out.println("Input format: 1+2*3*(4+5)/6");
        System.out.println("You input: ");
        // Getting input from user
        Scanner myObj = new Scanner(System.in);
        String userInput = myObj.nextLine();
        // Convert string type input to a array
        String[] realInput = userInput.split("");

        // Create operactionconvertion object
        OperactionConvertion newInput = new OperactionConvertion();
        // Extract all numbers
        newInput.ConvertNums(realInput);
        ArrayList<Float> nums = newInput.getNumsOnly();

        // Extract all operators
        newInput.ConvertOps(realInput);
        ArrayList<String> ops = newInput.getOperatorOnly();

        // Do the calculation
        // Create calculator object
        Calculator mycal = new Calculator();

        // Set operators and numbers to mycal
        mycal.setNums(nums);
        mycal.setOp(ops);
        // Calculate result and print
        float result = mycal.CalculateWithoutParentheses();
        System.out.print(result);
    }
}

// Testcase
// 1+2*3*4+5/6-7
// 1+2*3*(4+5)/6
// 12222.22*2321321-5151