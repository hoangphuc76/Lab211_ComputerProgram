package Common;

import Model.Operator;

public class Validation {
    public Double checkin(String inputVal) {
        try {
            return Double.parseDouble(inputVal);
        } catch (NumberFormatException e) {
            return null;
        }

    }
    public Operator checkOperator(String operator) {
        return switch (operator) {
            case "+" -> Operator.add;
            case "-" -> Operator.sub;
            case "*" -> Operator.mul;
            case "/" -> Operator.div;
            case "^" -> Operator.exponent;
            case "=" -> Operator.equals;
            default -> null;
        };
    }
}
