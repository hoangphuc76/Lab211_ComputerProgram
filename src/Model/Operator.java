package Model;

public enum Operator {
    add("+"), sub("-"), mul("*"), div("/"), exponent("^"), equals("=");
    private final String symbol;

    private Operator(String symbol) {
        this.symbol = symbol;
    }
}