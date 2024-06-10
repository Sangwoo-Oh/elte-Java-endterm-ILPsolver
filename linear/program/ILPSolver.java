package linear.program;

import java.util.*;
import java.lang.*;
import linear.program.utils.*;

public class ILPSolver {
    static private final int MAX_ITERATION_COUNT = 10_000_000;
    private List<Variable> variables;
    private List<Constraint> constraints;
    private Heuristic heuristic;
    public ILPSolver(Heuristic heuristic) {
        this.heuristic = heuristic;
        variables = new ArrayList<>();
        constraints = new ArrayList<>();
    }
    public void addVar(int lowerBound, int upperBound, String name) {
        variables.add(Variable.makeVar(lowerBound, upperBound, name));
    }
    public void addConstraint(Constraint constraint) {
        constraint.setVars(variables);
        constraints.add(constraint);
    }
    public boolean isSatisfied(){return false;}
    private int[] getVariableValues() {
        int[] ret = new int[variables.size()];
        for(int i=0;i<ret.length;i++) {
            ret[i] = variables.get(i).getValue();
        }
        return ret;
    }
    public boolean checkSolved() {
        for (Constraint c : constraints) {
            if (!c.checkConstraint(getVariableValues())) return false;
        }
        return true;
    }
    public boolean solve() {
        for(int i=0;i<MAX_ITERATION_COUNT;i++) {
            if (!heuristic.getNextVariables(variables)) return false;
            // for (Constraint c : constraints){
            //     if (c.checkConstraint(getVariableValues()))return true;
            // }
            if (checkSolved()) return true;
        }
        return false;
    }
    public int[] getSolution() {return null;}
    public List<String> getVariableNames() {return null;}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        for(Constraint c : constraints) {
            if (i != 0) sb.append(", ");
            sb.append(c.toString());
            i++;
        }
        sb.append("],[");
        i = 0;
        for(Variable v : variables) {
            if (i != 0) sb.append(", ");
            sb.append(v.toString());
            i++;
        }
        sb.append("]");

        return sb.toString();

    }
}

