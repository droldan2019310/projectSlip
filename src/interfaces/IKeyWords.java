package interfaces;

import stacks.Stack;

public interface IKeyWords {
    
    public void commentNestable();

    public void commentEndLine();

    public void greaterThan();

    public void lowerThan();

    public void greaterIqualThan();

    public void lowerIqualThan();

    public void defun();

    public void equal();

    public void equalP();

    public void setQ();

    public void setF();

    public void set();

    public void cond();

    public void loop();

    public boolean print(String value);

    public Stack<String> separateWithPairs(String string);

}
