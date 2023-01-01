public class Main {
    public static void main(String[] args) {
        try {
            String input = "";
            calc(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void calc(String input) throws Exception{
        Expression expression = ExpressionValidator.validateExpressionFromInput(input);
        if (expression.type == ExpressionType.SIMPLE_NUMBER) {
            SimpleNumberCalculator.calculate(expression.firstNumber, expression.secondNumber, expression.action);
        } else {
            RomanNumberCalculator.calculate(expression.firstNumber, expression.secondNumber, expression.action);
        }
    }
}
