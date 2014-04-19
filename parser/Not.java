package parser;

public class Not extends UnaryOperation {
    Not(Expression3 exp) {
        super(exp);
    }
    
    public double evaluate(double x, double y, double z) throws MyCalcException  {
        return (double)(~(int)exp.evaluate(x, y, z));
    }
}
