package com.company;
import java.util.*;

public class Calculator {

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
    private float finalResult;


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

    public float CalculateWithoutParentheses(ArrayList<Float> inNums, ArrayList<String> inOps) {
        // Do calculations
        float result;
        ArrayList<Float> nums1 = new ArrayList<>();
        ArrayList<String> op1 = new ArrayList<>();

        for (int i = 0; i < inOps.size(); i++) {
            if (inOps.get(i).equals("+") || inOps.get(i).equals("-")) {
                nums1.add(inNums.get(i));
                op1.add(inOps.get(i));
            } else {
                float temp = inNums.get(i);
                int nexti = -1;
                for (int k = i; k < inOps.size(); k++) {
                    if (inOps.get(k).equals("+") || inOps.get(k).equals("-")) {
                        nexti = k;
                        op1.add(inOps.get(k));
                        break;
                    }
                    if (inOps.get(k).equals("*")) {
                        temp *= inNums.get(k+1);
                    } else if (inOps.get(k).equals("/")) {
                        temp /= inNums.get(k+1);
                    }
                }
                nums1.add(temp);

                if (nexti != -1) {
                    i = nexti;

                } else {
                    break;
                }
            }
        }

        if (op1.size() == 0){
            result = nums1.get(0);
        }
        else {
            result = nums1.get(0);
            for (int i = 0; i < op1.size()-1; i++) {
                if (op1.get(i).equals("+")) {
                    result += nums1.get(i+1);
                } else {
                    result -= nums1.get(i+1);
                }
            }
        }
        return result;
    }

    public void calWithParentheses() {

        for (int i = 0; i < orgOpsOnly.size(); i++) {
            if (!orgOpsOnly.get(i).equals("(")) {
                // creating newOpsOnly
                newOpsOnly.add(orgOpsOnly.get(i));
            }
            // creating innerOps
            if (orgOpsOnly.get(i).equals("(")) {
                // collecting "(" index in the orgOps
                tempIndex = i;
                pIndex.add(i);
                for (int j = i + 1; j < orgOpsOnly.size(); j++) {
                    // find the right end parentheses and update operatorOnly
                    if (orgOpsOnly.get(j).equals(")")) {
                        // exit inner ops search and move on to next op for outter loop
                        i = j + 1;
                        cntPrentheses += 1;
                        pIndex.add(i-1);
                        newOpsOnly.add(orgOpsOnly.get(i));
                        break;
                    }
                    innerOps.add(orgOpsOnly.get(j));
                }
                innerOps.add("+");
            }

        }
        // creating innerNums
        for (int i = pIndex.get(0); i < pIndex.get(pIndex.size()-1); i++) {
            if (i == pIndex.get(0)) {
                innerNums.add(orgNumsOnly.get(i+1));
                continue;
            }
            innerNums.add(orgNumsOnly.get(i+1));
        }

        // calculate the inner result
        innerResult = CalculateWithoutParentheses(innerNums, innerOps);

        // build newNumsOnly
        for (int i = 0; i < orgNumsOnly.size(); i++) {
            if (i == pIndex.get(0)) {
                i = pIndex.get(pIndex.size()-1) + 1;
                newNumsOnly.add(innerResult);
                continue;
            }
            newNumsOnly.add(orgNumsOnly.get(i));
        }
        /*
        below print outs is for debuging the logic in the code.
        System.out.println("innerops");
        System.out.println(innerOps);
        System.out.println("pindex");
        System.out.println(pIndex);
        System.out.println("innernums");
        System.out.println(innerNums);
        System.out.println("innerresult");
        System.out.println(innerResult);
        System.out.println("newNums");
        System.out.println(newNumsOnly);
        System.out.println("newops");
        System.out.println(newOpsOnly);
        */
        finalResult = CalculateWithoutParentheses(newNumsOnly, newOpsOnly);
    }
    public float getFinalResult() {
        return finalResult;
    }
}

