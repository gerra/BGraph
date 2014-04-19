package parser;

public class UnaryMinus extends UnaryOperation {
    UnaryMinus(Expression3 exp) {
        super(exp);
    }
    
    public double evaluate(double x, double y, double z) throws MyCalcException  {
        double e = exp.evaluate(x, y, z);
        return -e;
    }
}
