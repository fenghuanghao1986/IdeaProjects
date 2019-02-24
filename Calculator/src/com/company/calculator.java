package com.company;
import java.util.*;

public class Calculator {

    private ArrayList<String> op = new ArrayList<String>();
    private ArrayList<Float> nums = new ArrayList<Float>();
    private ArrayList<Float> nums1 = new ArrayList<Float>();
    private ArrayList<String> op1 = new ArrayList<String>();

    public void setOp(ArrayList<String> getOperatorOnly) {
        for (int i = 0; i < getOperatorOnly.size(); i++) {
            op.add(getOperatorOnly.get(i));
        }
    }

    public void setNums(ArrayList<Float> getNumsOnly) {
        for (int i = 0; i < getNumsOnly.size(); i++) {
            nums.add(getNumsOnly.get(i));
        }
    }

    public float Calculate() {

        // Do calculations
        float result = 0;

        for (int i = 0; i < op.size(); i++) {
            if (op.get(i).equals("+") || op.get(i).equals("-")) {
                nums1.add(nums.get(i));
                op1.add(op.get(i));
            } else {
                float temp = nums.get(i);
                int nexti = -1;
                for (int k = i; k < op.size(); k++) {
                    if (op.get(k).equals("+") || op.get(k).equals("-")) {
                        nexti = k;
                        op1.add(op.get(k));
                        break;
                    }
                    if (op.get(k).equals("*")) {
                        temp *= nums.get(k+1);
                    } else if (op.get(k).equals("/")) {
                        temp /= nums.get(k+1);
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
}


