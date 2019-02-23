package com.company;
import java.util.*;

public class OperactionConvertion {

<<<<<<< HEAD
    public void Convert(String[] userInput) {

        private ArrayList<String> newInput = new ArrayList<String>();

        for (int i = 0; i < userInput.length; i ++) {
            newInput.add(userInput[i]);


=======
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
>>>>>>> 28642273d2734ab7240a502cee785b7010407589
        }

    }
}
