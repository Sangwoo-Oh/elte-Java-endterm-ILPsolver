package linear.program;

import java.util.List;
import linear.program.utils.*;

public class BruteForceHeuristic implements Heuristic {
    public boolean getNextVariables(List<Variable> vars) {
        for (Variable var : vars) {
            if (var.getValue() == var.getUpperBound()) {
                var.setValue(var.getLowerBound());
            } else {
                var.setValue(var.getValue() + 1);
                return true;
            }
        }
        return false;
    }
}
