package parser;

public abstract class UnaryOperation implements Expression3 {
    protected Expression3 exp;
    
    protected UnaryOperation(Expression3 exp) {
        assert exp != null;
        this.exp = exp;
    }
}
