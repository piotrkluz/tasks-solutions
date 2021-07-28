package lib;

import static lib.Utils.arrToString;

public class CalculatorException extends RuntimeException {
    public CalculatorException(String message) {
        super(message);
    }
    public CalculatorException(String message, Integer[] input) {
        super(message +"\nACTUAL LIST: " + arrToString(input) + "\n");
    }
}
