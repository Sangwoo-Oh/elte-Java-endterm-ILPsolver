package linear.program;
import java.util.*;

import linear.program.utils.*;
public interface Heuristic {
    public boolean getNextVariables(List<Variable> vars);
}