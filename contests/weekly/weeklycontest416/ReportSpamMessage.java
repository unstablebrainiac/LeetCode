package contests.weekly.weeklycontest416;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/report-spam-message/
 */
public class ReportSpamMessage {

    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> banned = Arrays.stream(bannedWords).collect(Collectors.toSet());
        return Arrays.stream(message).filter(banned::contains).count() >= 2;
    }

    public static void main(String[] args) {
        System.out.println(new ReportSpamMessage().reportSpam(new String[]{"hello", "world", "leetcode"}, new String[]{"world", "hello"})); // true
    }
}
