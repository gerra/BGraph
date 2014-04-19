package parser;

public class Power extends BinaryOperation {
    Power(Expression3 first, Expression3 second) {
        super(first, second);
    }
    
    public double evaluate(double x, double y, double z) throws MyCalcException {
        double f = first.evaluate(x, y, z);
        double s = second.evaluate(x, y, z);
    
        if (s < 0 && Math.abs(f) <= 1e-7) {
            throw new NegativePower("negative power");
        }
    
        double res = Math.pow(f, s);
         
        return (double)res;
    }
}
