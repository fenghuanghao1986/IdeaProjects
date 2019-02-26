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
        float result = 0;
        ArrayList<Float> nums1 = new ArrayList<Float>();
        ArrayList<String> op1 = new ArrayList<String>();

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


    // calculate inner operation result
    public void calInner() {
        findOps();
        findInnerNums();
        innerResult = CalculateWithoutParentheses(innerNums, innerOps);
    }


}
