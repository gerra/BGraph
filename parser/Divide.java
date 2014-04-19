package parser;

public class Divide extends BinaryOperation {
    public Divide(Expression3 f, Expression3 s) {
        super(f, s);
    }
    
    public double evaluate(double x, double y, double z) throws MyCalcException {
        double divident = second.evaluate(x, y, z);
        if (Math.abs(divident) <= 1e-7) {
            throw new DBZException("division by zero");
        }
        double f = first.evaluate(x, y, z);
        return f / divident;
    }
}
