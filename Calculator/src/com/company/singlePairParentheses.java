package com.company;
import java.util.*;

public class singlePairParentheses {

    private ArrayList<String> innerOps = new ArrayList<>();
    private ArrayList<Float> innerNums = new ArrayList<>();
    private ArrayList<String> orgOpsOnly = new ArrayList<>();
    private ArrayList<Float> orgNumsOnly = new ArrayList<>();
    private ArrayList<String> newOpsOnly = new ArrayList<>();
    private ArrayList<Float> newNumsOnly = new ArrayList<>();
    private ArrayList<Integer> pIndex = new ArrayList<>();
    private int tempIndex;
    private int cntPrentheses = 0;
    private float innerResult;

    public void setOp(ArrayList<String> getOperatorOnly) {
        for (int i = 0; i < getOperatorOnly.size(); i++) {
            orgOpsOnly.add(getOperatorOnly.get(i));
        }
    }

    public void setNums(ArrayList<Float> getNumsOnly) {
        for (int i = 0; i < getNumsOnly.size(); i++) {
            orgNumsOnly.add(getNumsOnly.get(i));
        }
    }

    public void findOps(ArrayList<String> orgOpsOnly) {
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
                        pIndex.add(i-1);
                        break;
                    }
                }
                break;
            }
        }
    }

    public void findInnerNums(ArrayList<Float> orgNumsOnly) {
        // starting from the first index of "("
        for (int i = pIndex.get(0); i < cntPrentheses; i++) {
            innerNums.add(orgNumsOnly.get(i));
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
