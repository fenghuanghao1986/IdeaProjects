package com.company;
import java.util.*;

public class OperactionConvertion {

    private ArrayList<String> newInput = new ArrayList<String>();
    private Float<String>
    public String Convert(String[] userInput) {


        for (int i = 0; i < userInput.length; i++) {
            newInput.add(userInput[i]);
            if (userInput[i].equals("+") || userInput[i].equals("-") || userInput[i].equals("*") || userInput[i].equals("/")) {
                i += 1;
                break;
            }
            return newInput;
        }

    }
}
