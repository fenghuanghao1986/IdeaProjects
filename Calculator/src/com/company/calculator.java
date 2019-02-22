package com.company;
import java.util.*;

public class calculator {

    private ArrayList<String> op = new ArrayList<String>();
    private ArrayList<Float> nums = new ArrayList<Float>();
    private ArrayList<Float> nums1 = new ArrayList<Float>();
    private ArrayList<String> op1 = new ArrayList<String>();

    // Separating numbers and operator
    public void Operator(String[] list) {

        for (int i = 0; i < list.length; i++) {
            if (list[i].equals("+") || list[i].equals("-") || list[i].equals("*") || list[i].equals("/")) {
                // Get all operators
                op.add(list[i]);

            } else {
                // Get all numbers
                nums.add(Float.parseFloat(list[i]));
            }
        }
        op.add("+");
        System.out.println(op);
        System.out.println(nums);

    }

    public float calculate() {
        // Do calculations

        float result = 0;
        // nums[last] not considered

        for (int i = 0; i < op.size(); i++) {
            if (op.get(i).equals("+") || op.get(i).equals("-")) {
                nums1.add(nums.get(i));
                op1.add(op.get(i));
                System.out.println("xxx0");
                System.out.println(op1);

            } else {
                float temp = nums.get(i);
                System.out.println("xxxx1");
                System.out.println(temp);
                int nexti = -1;
                for (int k = i; k < op.size(); k++) {
                    if (op.get(k).equals("+") || op.get(k).equals("-")) {
                        nexti = k;
                        op1.add(op.get(k));
                        System.out.println("kkkkk");
                        System.out.println(k);
                        break;
                    }
                    if (op.get(k).equals("*")) {
                        temp *= nums.get(k+1);
                        System.out.println("xxxx2");
                        System.out.println(temp);
                    } else if (op.get(k).equals("/")) {
                        temp /= nums.get(k+1);
                        System.out.println("xxxx3");
                        System.out.println(temp);
                    }
                }
                nums1.add(temp);
                //i = nexti - 1;
                if (nexti != -1) {
                    i = nexti;
                    System.out.println("iiiiii");
                    System.out.println(i);
                } else {
                    break;
                }
            }
        }

        System.out.println("xxxx4");
        System.out.println(op1);
        System.out.println("xxxx5");
        System.out.println(nums1);
        if (op1.size() == 0){
            result = nums1.get(0);
        }
        else {
            result = nums1.get(0);
            for (int i = 0; i < op1.size()-1; i++) {
                if (op1.get(i).equals("+")) {
                    result += nums1.get(i+1);
                    System.out.println(result);
                } else {
                    result -= nums1.get(i+1);
                    System.out.println(result);
                }
            }
        }

        return result;
    }
}


