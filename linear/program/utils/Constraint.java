package linear.program.utils;

import java.util.*;
import java.lang.*;

public class Constraint {
    protected int[] coeffs;
    protected int value;
    private List<Variable> vars;
    public void setVars(List<Variable> vars) {
        if (vars.size() != coeffs.length) throw new IllegalArgumentException();
        this.vars = vars;
    }
    public Constraint(int[] coeffs, int value) {
        this.coeffs = coeffs;
        this.value = value;
        this.vars = new ArrayList();
    }
    public boolean compare(int a, int b) {
        throw new UnsupportedOperationException();
    }

    public String getCompareString() {
        throw new UnsupportedOperationException();
    }

    public boolean checkConstraint(int[] values) {
        if (coeffs.length != values.length) throw new IllegalArgumentException();
        int sum = 0;
        for (int i = 0; i < coeffs.length; i++) {
            sum += coeffs[i]*values[i];
        }
        return compare(sum, value);
    }

    @Override
    public String toString() {
        if (vars.size() != coeffs.length) throw new IllegalStateException();
        if (this.vars == null) return Arrays.toString(coeffs) + getCompareString() + value;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coeffs.length; i++) {
            if (i != 0 && coeffs[i] != 0) sb.append(" + ");
            if (coeffs[i] == 1) {
                sb.append(vars.get(i).getName());
            } else if (coeffs[i] != 0) {
                sb.append(coeffs[i]).append(vars.get(i).getName());
            }
        }
        sb.append(getCompareString()).append(value);

        return sb.toString();
    }
}
