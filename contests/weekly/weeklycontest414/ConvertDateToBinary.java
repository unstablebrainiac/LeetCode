package contests.weekly.weeklycontest414;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/*
 * https://leetcode.com/problems/convert-date-to-binary/
 */
public class ConvertDateToBinary {

    public String convertDateToBinary(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int year = formatter.parse(date).get(ChronoField.YEAR);
        int month = formatter.parse(date).get(ChronoField.MONTH_OF_YEAR);
        int day = formatter.parse(date).get(ChronoField.DAY_OF_MONTH);
        return Integer.toBinaryString(year) + "-" + Integer.toBinaryString(month) + "-" + Integer.toBinaryString(day);
    }

    public static void main(String[] args) {
        System.out.println(new ConvertDateToBinary().convertDateToBinary("2080-02-29")); // 100000100000-10-11101
    }
}
