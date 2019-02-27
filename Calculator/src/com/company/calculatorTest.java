package com.company;
import java.util.ArrayList;

public final class calculatorTest {

    private Calculator cal;
    private OperactionConvertion convt;
    private ArrayList<String> orgOpsOnly = new ArrayList<>();
    private ArrayList<Float> orgNumsOnly = new ArrayList<>();

    @BeforeMethod
    public void seUp() {
        cal = new Calculator();
        convt = new OperactionConvertion();
    }
    @BeforeMethod
    public void setOp(ArrayList<String> getOperatorOnly) {
        for (int i = 0; i < getOperatorOnly.size(); i++) {
            orgOpsOnly.add(getOperatorOnly.get(i));
        }
    }
    @BeforeMethod
    public void setNums(ArrayList<Float> getNumsOnly) {
        for (int i = 0; i < getNumsOnly.size(); i++) {
            orgNumsOnly.add(getNumsOnly.get(i));
        }
    }

    @Test
    public void testGetOps() {
        // Arrange
        final ArrayList<String> expected= new ArrayList<>();
        final String[] input = new String[1+2-3*4/5];
        expected.add("+");
        expected.add("-");
        expected.add("*");
        expected.add("/");
        // Act

        // Assert
        Assert.assertEquals(orgNumsOnly, expected);
    }

    @Test
    public void testGetNums() {

    }

    @Test
    public void testCalculatWithoutParentheses() {

    }

    @Test
    public void testCalculatAll() {

    }
}
