package linear.program;

import linear.program.utils.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.api.Test;

public class ILPSolverIntegerProgrammingTest{
    @Test
    public void test_BruteForce() {
        Heuristic b = new BruteForceHeuristic();
        ILPSolver solver = new ILPSolver(b);
        solver.addVar(0,4,"x");
        solver.addVar(0,3,"y");
        solver.addConstraint(new InequalityConstraint(new int[]{-1,1}, 1));
        solver.addConstraint(new InequalityConstraint(new int[]{3,2}, 12));
        solver.addConstraint(new InequalityConstraint(new int[]{2,3}, 12));
        solver.solve();
        assertEquals("[-1x + y <= 1, 3x + 2y <= 12, 2x + 3y <= 12],[x: 1, y: 0]", solver.toString());
    }
    @Test
    public void test_Random() {
        Heuristic b = new RandomHeuristic();
        ILPSolver solver = new ILPSolver(b);
        solver.addVar(0,4,"x");
        solver.addVar(0,3,"y");
        solver.addConstraint(new InequalityConstraint(new int[]{-1,1}, 1));
        solver.addConstraint(new InequalityConstraint(new int[]{3,2}, 12));
        solver.addConstraint(new InequalityConstraint(new int[]{2,3}, 12));
        solver.solve();
        assertEquals("[-1x + y <= 1, 3x + 2y <= 12, 2x + 3y <= 12],[x: 1, y: 0]", solver.toString());
    }
    @Test
    public void test_Random_with_seed() {
        Heuristic b = new RandomHeuristic(0x1337);
        ILPSolver solver = new ILPSolver(b);
        solver.addVar(0,4,"x");
        solver.addVar(0,3,"y");
        solver.addConstraint(new InequalityConstraint(new int[]{-1,1}, 1));
        solver.addConstraint(new InequalityConstraint(new int[]{3,2}, 12));
        solver.addConstraint(new InequalityConstraint(new int[]{2,3}, 12));
        solver.solve();
        assertEquals("[-1x + y <= 1, 3x + 2y <= 12, 2x + 3y <= 12],[x: 1, y: 0]", solver.toString());
    }
}
