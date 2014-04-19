package parser;

public abstract class BinaryOperation implements Expression3 {
    protected Expression3 first, second;
    
    protected BinaryOperation(Expression3 first, Expression3 second) {
        assert first != null;
        assert second != null;
        this.first = first;
        this.second = second;
    }
}
