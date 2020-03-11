package calculator;

/**
 * Class for calculate operation between two numbers (operands).
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class InteractCalc {
    /**
     * Command to finish calculating.
     */
    private static final String EXIT = "E";

    /**
     * Command to operation add.
     */
    private static final String ADD = "+";

    /**
     * Command to operation subtract.
     */
    private static final String SUBTRACT = "-";

    /**
     * Command to operation divide.
     */
    private static final String DIV = "/";

    /**
     * Command to operation multiply.
     */
    private static final String MULTIPLY = "*";

    /**
     * Command to get the result of previous operation.
     */
    private static final String PREVIOUS = "M";

    /**
     * Result of calculating.
     */
    private double result;

    /**
     * Object, realized the input of values.
     */
    private Input input;

    /**
     * Constructor.
     *
     * @param input realized the input of values
     */
    public InteractCalc(Input input) {
        this.input = input;
    }

    /**
     * Summarizes two numbers.
     *
     * @param first first operand
     * @param second second operand
     * @return result of operation
     */
    private double add(double first, double second) {
        return first + second;
    }

    /**
     * Subtracts one number from another.
     *
     * @param first first operand
     * @param second second operand
     * @return result of operation
     */
    private double subtract(double first, double second) {
        return first - second;
    }

    /**
     * Multiplies one number by another..
     *
     * @param first first operand
     * @param second second operand
     * @return result of operation
     */
    private double multiply(double first, double second) {
        return first * second;
    }

    /**
     * Divides one number by another.
     *
     * @param first first operand
     * @param second second operand
     * @return result of operation
     */
    private double div(double first, double second) {
        return first / second;
    }

    /**
     * Calculates operation between two numbers (operands).
     * Operands are entered via the object input.
     * The result is saved to result variable and  output to the console.
     */
    public void calculate() {
        String operand1;
        String operand2;
        String operation;
        boolean finish = false;
        do {
            operand1 = inputOperand("Enter the first operand (or M, E): ");
            if (EXIT.equals(operand1)) {
                finish = true;
                continue;
            }
           operand2 = inputOperand("Enter the second operand (or M, E): ");
            if (EXIT.equals(operand2)) {
                finish = true;
                continue;
            }
            operation = inputOperation();
            if (EXIT.equals(operation)) {
                finish = true;
                continue;
            }
            this.result = calcResult(operand1, operand2, operation);
            System.out.println(String.format("The result of operation: %s\n", this.result));
        } while (!finish);
        System.out.println("The finishing of the calculation.");
    }

    /**
     * Inputs any operands.
     * If the "m" character is entered, than take the operand from result variable.
     *
     * @param question message, explaining what to enter
     * @return entered operand
     */
    private String inputOperand(String question) {
        String operand = input.ask(question).toUpperCase();
        if (PREVIOUS.equals(operand)) {
            operand = String.valueOf(this.result);
            System.out.println(operand);
        }
        return operand;
    }

    /**
     * Inputs operation.
     *
     * @return entered operation
     */
    private String inputOperation() {
       String operation = input.ask("Enter the operation (+, -, /, *, E): ").toUpperCase();
       return operation;
    }

    /**
     * Calculates the operation between two operands and returns the result of it.
     *
     * @param operand1 first operand
     * @param operand2 second operand
     * @param operation operation to calculate
     * @return result of calculating
     */
    private double calcResult(String operand1, String operand2, String operation) {
        double result = 0;
        if (ADD.equals(operation)) {
            result = add(Double.parseDouble(operand1), Double.parseDouble(operand2));
        } else if (SUBTRACT.equals(operation)) {
            result = subtract(Double.parseDouble(operand1), Double.parseDouble(operand2));
        } else if (DIV.equals(operation)) {
            result = div(Double.parseDouble(operand1), Double.parseDouble(operand2));
        } else if (MULTIPLY.equals(operation)) {
            result = multiply(Double.parseDouble(operand1), Double.parseDouble(operand2));
        }
        return result;
    }

    /**
     * Returns result of calculating.
     *
     * @return result of calculating
     */
    public double getResult() {
        return this.result;
    }

    public static void main(String[] args) {
        InteractCalc ic = new InteractCalc(new ConsoleInput());
        ic.calculate();
    }
}
