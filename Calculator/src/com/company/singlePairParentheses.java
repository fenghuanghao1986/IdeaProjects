package com.company;
import java.util.*;

public class singlePairParentheses {

    private ArrayList<String> innerOps = new ArrayList<>();
    private ArrayList<Float> innerNums = new ArrayList<>();
    private ArrayList<String> operatorOnly = new ArrayList<>();
    private ArrayList<Float> numsOnly = new ArrayList<>();
    private float innerResult;

    public void setOp(ArrayList<String> getOperatorOnly) {
        for (int i = 0; i < getOperatorOnly.size(); i++) {
            operatorOnly.add(getOperatorOnly.get(i));
        }
    }

    public void setNums(ArrayList<Float> getNumsOnly) {
        for (int i = 0; i < getNumsOnly.size(); i++) {
            numsOnly.add(getNumsOnly.get(i));
        }
    }

    public void findOps(ArrayList<String> operatorOnly) {
        for (int i = 0; i < operatorOnly.size(); i++) {
            if (operatorOnly.get(i).equals("(")) {
                for (int j = i + 1; j < operatorOnly.size(); j++) {
                    innerOps.add(operatorOnly.get(j));
                    if (operatorOnly.get(i).equals(")")) {
                        break;
                    }
                }
            }
        }
    }

    public void findNums(ArrayList<Float> numsOnly) {
        for (int i = 0; i < numsOnly.size(); i++) {
            if (operatorOnly.get(i).equals("(")) {
                for (int j = i; j < numsOnly.size(); j++) {
                    innerNums.add(numsOnly.get(j));
                    if (operatorOnly.get(i).equals(")")) {
                        break;
                    }
                }
            }
        }
    }

    public void calculateInnerResult() {

    }

    public ArrayList<String> getInnerOps() {
        return innerOps;
    }
    public ArrayList<Float> getInnerNums() {
        return innerNums;
    }
    public float getInnerResult() {
        return innerResult;
    }
}
