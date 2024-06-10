package linear.program.utils;

public class EqualityConstraint extends Constraint {
    public EqualityConstraint(int[] coeffs, int value) {
        super(coeffs, value);
    }

    public boolean compare(int op1, int op2) {
        return op1 == op2;
    }
    public String getCompareString() {
        return " == ";
    }
}
