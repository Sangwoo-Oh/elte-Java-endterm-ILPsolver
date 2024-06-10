package linear.program;
import java.util.*;
import linear.program.utils.*;
public class RandomHeuristic implements Heuristic {
    private Random random;
    public RandomHeuristic() {
        random = new Random();
    }
    public RandomHeuristic(int seed) {
        random = new Random(seed);
    }
    public boolean getNextVariables(List<Variable> vars) {
        for (Variable var : vars) {
            var.setValue(var.getLowerBound() + random.nextInt(var.getRange()));
        }
        return true;
    }
}
