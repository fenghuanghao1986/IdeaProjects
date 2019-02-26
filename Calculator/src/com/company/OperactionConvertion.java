package com.company;
import java.util.*;

public class OperactionConvertion {

    private String tempStr;
    private ArrayList<Float> orgNumsOnly = new ArrayList<>();
    private float tempNum;
    private ArrayList<String> orgOpsOnly = new ArrayList<>();
    private ArrayList<String> tempStrArr = new ArrayList<>();

    // Collect all numbers and store in one arraylist for calculation purpose
    public void ConvertNums(String[] userInput) {
        // Outer loop to go through all elements from userInput
        for (int j = 0; j < userInput.length; j++) {
            // Inner loop to collect all non-symbols and convert them to a single float number
            for (int i = j; i < userInput.length; i++) {
                // Once meet next operator exit inner loop
                if (userInput[i].equals("+") || userInput[i].equals("-")
                        || userInput[i].equals("*") || userInput[i].equals("/")
                        || userInput[i].equals("(") || userInput[i].equals(")")) {
                    break;
                }
                // Collect everything before a operator symbol and store them in a temp string array: tempStrArr
                tempStrArr.add(userInput[i]);
                // Convert array list to a string which only contains number look string: tempStr
                tempStr = String.join("", tempStrArr);
                // Convert string to a float number: tempNum
                tempNum = Float.valueOf(tempStr.trim()).floatValue();
                // Add 1 to j, for outer loop, in order to start the next number position properly
                j += 1;
            }
            // Add number to a float list
            orgNumsOnly.add(tempNum);
            // Clean the tempStrArr for next float number
            tempStrArr = new ArrayList<>();
        }
    }

    // Save all non-numbers including all operator symbols
    public void ConvertOps(String[] userInput) {

        for (int i = 0; i < userInput.length; i++) {

            if (userInput[i].equals("+") || userInput[i].equals("-")
                    || userInput[i].equals("*") || userInput[i].equals("/")
                    || userInput[i].equals("(") || userInput[i].equals(")")) {
                orgOpsOnly.add(userInput[i]);

            } else {
                continue;
            }
        }
        // Add a "+" at the end for calculation purpose
        orgOpsOnly.add("+");
        //return operatorOnly;
    }
    public ArrayList<String> getOperatorOnly() {
        return orgOpsOnly;
    }
    public ArrayList<Float> getNumsOnly() {
        return orgNumsOnly;
    }

    public void findOps() {

        for (int i = 0; i < orgOpsOnly.size(); i++) {
            // creating newOpsOnly
            newOpsOnly.add(orgOpsOnly.get(i));
            // creating innerOps
            if (orgOpsOnly.get(i).equals("(")) {
                // collecting "(" index in the orgOps
                tempIndex = i;
                pIndex.add(i);
                for (int j = i + 1; j < orgOpsOnly.size(); j++) {
                    innerOps.add(orgOpsOnly.get(j));
                    // find the right end parentheses and update operatorOnly
                    if (orgOpsOnly.get(j).equals(")")) {
                        // exit inner ops search and move on to next op for outter loop
                        i = j + 1;
                        cntPrentheses += 1;
                        pIndex.add(i - 1);
                        break;
                    }
                }
            }
        }
    }

    public void findInnerNums() {
        // get innerNums
        for (int i = pIndex.get(0); i < pIndex.size(); i++) {
            innerNums.add(orgNumsOnly.get(i));
        }

    }

    public void buildNewNums() {
        for (int i = 0; i < orgNumsOnly.size(); i++) {
            newNumsOnly.add(orgNumsOnly.get(i));
            if (i == pIndex.get(0)) {
                i = pIndex.get(cntPrentheses);
                newNumsOnly.add(innerResult);
                continue;
            }
        }
    }
}
