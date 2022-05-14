/*
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        if (num == 0) {
            return "";
        }
        int numDigits = (int) Math.floor(Math.log10(num) + 1);
        int firstDigit = (int) (num / Math.pow(10, numDigits - 1));

        return getRomanRepresentation(firstDigit, numDigits - 1) + intToRoman((int) (num % Math.pow(10, numDigits - 1)));
    }

    private String getRomanRepresentation(int digit, int index) {
        return switch (index) {
            case 0 -> getRomanRepresentation(digit, 'I', 'V', 'X');
            case 1 -> getRomanRepresentation(digit, 'X', 'L', 'C');
            case 2 -> getRomanRepresentation(digit, 'C', 'D', 'M');
            case 3 -> getRomanRepresentation(digit, 'M', ' ', ' ');
            default -> "";
        };
    }

    private String getRomanRepresentation(int digit, char singleChar, char fiveChar, char tenChar) {
        return switch (digit) {
            case 0, 1, 2, 3 -> new String(new char[digit]).replace('\0', singleChar);
            case 5, 6, 7, 8 -> fiveChar + getRomanRepresentation(digit - 5, singleChar, fiveChar, tenChar);
            case 4 -> String.valueOf(singleChar) + fiveChar;
            case 9 -> String.valueOf(singleChar) + tenChar;
            default -> "";
        };
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(1994)); // MCMXCIV
    }
}
