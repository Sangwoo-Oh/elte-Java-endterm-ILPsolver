package linear.program.utils;

import java.util.*;
import java.lang.*;

public class Variable {
    private int lowerBound;
    public int getLowerBound(){return lowerBound;}
    private int upperBound;
    public int getUpperBound() {return upperBound;}
    private String name;
    public String getName() {return name;}
    private int value;
    public int getValue() {return value;}
    public void setValue(int value) {this.value = value;}
    private Variable(int lowerBound, int upperBound, String name) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.name = name;
    }
    public int getRange() {
        return upperBound - lowerBound + 1;
    }
    public static Variable makeVar(int lowerBound, int upperBound, String name) {
        if (upperBound <= lowerBound) throw new IllegalArgumentException();
        return new Variable(lowerBound, upperBound, name);
    }
    @Override
    public String toString() {
        return name + ": " + value;
    }
}