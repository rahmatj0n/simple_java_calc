import java.util.Arrays;


class RomanNumeralConverter {
    private static final String[] romanNumbers = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] numbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static int romanToInt(String romanNumber) {
        int sum = 0;
        int romanNumberLength = romanNumber.length();

        for(int i = 0; i < romanNumberLength; i++)
        {
            int first_number = _getRealNumberFromRomanNumberByIndex(romanNumber, i);
            if (i != romanNumberLength - 1 && first_number <
                    _getRealNumberFromRomanNumberByIndex(romanNumber, i + 1)) {
                sum += _getRealNumberFromRomanNumberByIndex(romanNumber, i + 1) - first_number;
                i++;
            } else {
                sum += first_number;
            }
        }
        return sum;
    }

    public static String intToRoman(int number) {
        StringBuilder romanNumber = new StringBuilder();
        for(int i = 0; i < numbers.length; i++)
        {
            while(number >= numbers[i])
            {
                number = number - numbers[i];
                romanNumber.append(romanNumbers[i]);
            }

        }
        return romanNumber.toString();
    }

    private static int _getRealNumberFromRomanNumberByIndex(String romanNumber, int index) {
        return numbers[_getIndexOfValueFromArray(String.valueOf(romanNumber.charAt(index)))];
    }

    private static int _getIndexOfValueFromArray(String value) {
        return Arrays.asList(romanNumbers).indexOf(value);
    }
}
