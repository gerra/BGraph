package parser;

public class Multiply extends BinaryOperation {
    public Multiply(Expression3 f, Expression3 s) {
        super(f, s);
    }
    
    public double evaluate(double x, double y, double z) throws MyCalcException {
        double f = first.evaluate(x, y, z);
        double s = second.evaluate(x, y, z);
        return f * s;
    }
}
