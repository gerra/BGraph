package parser;

public class Abs extends UnaryOperation {
    Abs(Expression3 exp) {
        super(exp);
    }
    
    public double evaluate(double x, double y, double z) throws MyCalcException {
        double e = exp.evaluate(x, y, z);
        double res = (e < 0 ? -e : e);
        return res;
    }
}
