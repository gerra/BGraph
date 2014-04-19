package parser;

public class Log2 extends UnaryOperation {
    Log2(Expression3 exp) {
        super(exp);
    }
    
    public double evaluate(double x, double y, double z) throws MyCalcException {
        double res = exp.evaluate(x, y, z);
        if (res < -1e-7) {
            throw new LogNegException("log of negative expression");
        }
        if (Math.abs(res) <= 1e-7) {
            throw new LogNegException("log of nil expression");
        }
        res = Math.log(res) / Math.log(2.0);
        return res;
    }
}
