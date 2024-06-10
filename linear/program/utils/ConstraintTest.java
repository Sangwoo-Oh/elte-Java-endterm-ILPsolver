package linear.program.utils;

import java.util.*;
import java.lang.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.api.Test;

public class ConstraintTest {
    @ParameterizedTest
    @CsvSource({
        "1, 2, 90, ==, a + 2b == 90",
        "-1, 0, 6, <=, -1a <= 6",
        "3, -4, 11, ==, 3a + -4b == 11",
    })
    public void paramTwoCoeffs(int coeff1, int coeff2, int value, String constraint, String res) {
        Variable var1 = Variable.makeVar(1,2,"a");
        Variable var2 = Variable.makeVar(1,2,"b");
        Constraint c;
        if (constraint.equals("==")) {
            c = new EqualityConstraint(new int[] {coeff1,coeff2}, value);
        } else {
            c = new InequalityConstraint(new int[] {coeff1,coeff2}, value);
        }
        c.setVars(new ArrayList<Variable>(List.of(var1,var2)));
        assertEquals(res, c.toString());
    }
}
