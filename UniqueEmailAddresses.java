import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        return Arrays.stream(emails)
                .map(s -> {
                    String[] split = s.split("@");
                    String user = split[0];
                    String domain = split[1];
                    int indexOfPlus = user.indexOf('+');
                    if (indexOfPlus != -1) {
                        user = user.substring(0, indexOfPlus);
                    }
                    user = user.replace(".", "");
                    return user + '@' + domain;
                })
                .collect(Collectors.toSet())
                .size();
    }

    public static void main(String[] args) {
        System.out.println(new UniqueEmailAddresses().numUniqueEmails(
                new String[]{
                        "test.email+alex@leetcode.com",
                        "test.e.mail+bob.cathy@leetcode.com",
                        "testemail+david@lee.tcode.com"
                }
        ));
    }
}
