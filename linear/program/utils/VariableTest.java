package linear.program.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.api.Test;

public class VariableTest {
    @ParameterizedTest
    @CsvSource({
        "1, 3, test1, 3",
        "1, 4, test2, 4"
    })
    public void paramTest(int lower, int upper, String name, int expectedRange) {
        Variable v = Variable.makeVar(lower, upper, name);
        assertEquals(lower, v.getLowerBound());
        assertEquals(upper, v.getUpperBound());
        assertEquals(name, v.getName());
        assertEquals(expectedRange, v.getRange());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, test1",
        "1, -1, test2"
    })
    public void paramTestBadBounds(int lower, int upper, String name) {

        try {
            Variable v = Variable.makeVar(lower, upper, name);
            fail();
        } catch(IllegalArgumentException e) {
            // test passes
        }
    }
}