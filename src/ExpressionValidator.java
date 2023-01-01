import java.util.Arrays;

class ExpressionValidator {
    public static final String[] allowedActions = {"+", "-", "/", "*"};
    public static Expression validateExpressionFromInput(String input) throws Exception{
        String[] elements = _splitInput(input);
        if (elements.length != 3) { throw new Exception("Неправильное выражение"); }

        int firstNumber = _validateValue(elements[0]);
        int secondNumber = _validateValue(elements[2]);
        ActionType action = _validateAction(elements[1]);
        String[] unvalidatedNumbers = {elements[0], elements[2]};
        ExpressionType expressionType = _getExpressionType(unvalidatedNumbers);

        return new Expression(firstNumber, secondNumber, action, expressionType);
    }


    private static String[] _splitInput(String input) {
        String pattern = " ";
        return input.split(pattern);
    }


    private static int _validateValue(String value) throws Exception {
        try {
            int number = Integer.parseInt(value);
            if (number < 1 || number > 10) {
                throw new Exception("Неправильное значение");
            }
            return number;
        } catch (NumberFormatException e) {
            return _validateRomanNumber(value);
        }
    }


    private static int _validateRomanNumber(String value) throws Exception {
        int result = RomanNumeralConverter.romanToInt(value);
        if (result > 10) { throw new Exception("Неправильное значение"); }
        return result;
    }


    private static ActionType _validateAction(String value) throws Exception {
        if (!Arrays.asList(allowedActions).contains(value)) {
            throw new Exception("Направильное действие");
        }

        return switch (value) {
            case "+" -> ActionType.SUM;
            case "-" -> ActionType.MINUS;
            case "/" -> ActionType.DIVIDE;
            default -> ActionType.MULTIPLY;
        };
    }

    private static ExpressionType _getExpressionType(String[] unvalidatedNumbers) throws Exception {
        int intNumbersLength = 0;
        int romanNumbersLength = 0;
        for (String unvalidatedNumber : unvalidatedNumbers) {
            try {
                Integer.parseInt(unvalidatedNumber);
                intNumbersLength += 1;
            } catch (Exception e) {
                romanNumbersLength += 1;
            }
        }
        if (intNumbersLength == 1 && romanNumbersLength == 1) {
            throw new Exception("Неправильный формат");
        }
        if (intNumbersLength == 2) {
            return ExpressionType.SIMPLE_NUMBER;
        }
        return ExpressionType.ROMAN_NUMBER;
    }
}

class Expression {
    public int firstNumber;
    public int secondNumber;
    public ActionType action;
    public ExpressionType type;
    Expression(int firstNumber, int secondNumber, ActionType action, ExpressionType type) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.action = action;
        this.type = type;
    }
}
