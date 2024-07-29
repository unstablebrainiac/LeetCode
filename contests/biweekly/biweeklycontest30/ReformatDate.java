package contests.biweekly.biweeklycontest30;

import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/contest/biweekly-contest-30/problems/reformat-date/
 */
public class ReformatDate {
    public String reformatDate(String date) {
        String day, month, year;
        List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        if (date.charAt(4) == ' ') {
            day = date.substring(0, 2);
            month = date.substring(5, 8);
            year = date.substring(9);
        } else {
            day = "0" + date.substring(0, 1);
            month = date.substring(4, 7);
            year = date.substring(8);
        }
        int monthValue = months.indexOf(month) + 1;
        return year + "-" + (monthValue > 9 ? "" : "0") + monthValue + "-" + day;
    }

    public static void main(String[] args) {
        System.out.println(new ReformatDate().reformatDate("26th May 1960"));
    }
}
