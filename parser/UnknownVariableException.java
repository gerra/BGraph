package parser;

public class UnknownVariableException extends MyCalcException {
    public UnknownVariableException() {
        super();
    }
    public UnknownVariableException(String message) {
        super(message);
    }
}
