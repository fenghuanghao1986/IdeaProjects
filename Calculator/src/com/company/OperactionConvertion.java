package com.company;
import java.util.*;

public class OperactionConvertion {

    private String tempStr;
    private ArrayList<Float> numsOnly = new ArrayList<Float>();
    private ArrayList<String> operatorOnly = new ArrayList<String>();

    public ArrayList<Float> ConvertNums(String[] userInput) {

        for (int i = 0; i < userInput.length; i++) {

            ArrayList<String> tempStrArr = new ArrayList<String>();
            tempStrArr.add(userInput[i]);

            if (userInput[i].equals("+") || userInput[i].equals("-")
                    || userInput[i].equals("*") || userInput[i].equals("/")
                    || userInput[i].equals("(") || userInput[i].equals(")")) {

                tempStr = tempStrArr.toString();
                numsOnly.add(Float.parseFloat(tempStr));
                i += 1;

            }

        }
        return numsOnly;
    }
}
