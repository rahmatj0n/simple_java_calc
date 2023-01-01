class SimpleNumberCalculator {

    public static void calculate(int firstNumber, int secondNumber, ActionType action) {
        if (action == ActionType.SUM) {
            sum(firstNumber, secondNumber);
        } else if (action == ActionType.MINUS) {
            minus(firstNumber, secondNumber);
        } else if (action == ActionType.DIVIDE) {
            divide(firstNumber, secondNumber);
        } else {
            multiply(firstNumber, secondNumber);
        }
    }

    public static void sum(int firstNumber, int secondNumber) {
        System.out.println(firstNumber + secondNumber);
    }

    public static void minus(int firstNumber, int secondNumber) {
        System.out.println(firstNumber - secondNumber);
    }

    public static void divide(int firstNumber, int secondNumber) {
        float result = (float) firstNumber / secondNumber;
        System.out.println(Math.round(result));
    }


    public static void multiply(int firstNumber, int secondNumber) {
        System.out.println(firstNumber * secondNumber);
    }
}


class RomanNumberCalculator {

    public static void calculate(int firstNumber, int secondNumber, ActionType action) throws Exception{
        if (action == ActionType.SUM) {
            sum(firstNumber, secondNumber);
        } else if (action == ActionType.MINUS) {
            minus(firstNumber, secondNumber);
        } else if (action == ActionType.DIVIDE) {
            divide(firstNumber, secondNumber);
        } else {
            multiply(firstNumber, secondNumber);
        }
    }

    public static void sum(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        System.out.println(RomanNumeralConverter.intToRoman(result));
    }


    public static void minus(int firstNumber, int secondNumber) throws Exception{
        int result = firstNumber - secondNumber;
        if (result < 1) { throw new Exception("Неправильный формат"); }
        System.out.println(RomanNumeralConverter.intToRoman(result));
    }


    public static void divide(int firstNumber, int secondNumber) throws Exception {
        float result = (float) firstNumber / secondNumber;
        if (result < 1) { throw new Exception("Неправильный формат"); }
        System.out.println(RomanNumeralConverter.intToRoman(Math.round(result)));
    }


    public static void multiply(int firstNumber, int secondNumber) {
        int result = firstNumber * secondNumber;
        System.out.println(RomanNumeralConverter.intToRoman(result));
    }
}
