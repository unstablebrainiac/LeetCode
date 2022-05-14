package dailychallenges.june2020;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3362/
 */
public class ValidateIPAddress {

    private static final String IPv4 = "IPv4";
    private static final String IPv6 = "IPv6";
    private static final String NEITHER = "Neither";

    public String validIPAddress(String IP) {
        boolean isV4 = IP.contains(".");
        boolean isV6 = IP.contains(":");
        if ((isV4 && isV6) || (!isV4 && !isV6)) {
            return NEITHER;
        }
        if (isV4) {
            return validIPv4Address(IP);
        } else {
            return validIPv6Address(IP);
        }
    }

    private String validIPv4Address(String IP) {
        String[] split = IP.split("\\.", -1);
        if (split.length != 4) {
            return NEITHER;
        }
        for (String s : split) {
            boolean leadingZero = true;
            if (s.length() == 0 || s.length() > 3) {
                return NEITHER;
            }
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0' && leadingZero && j != s.length() - 1) {
                    return NEITHER;
                } else {
                    leadingZero = false;
                }
                int digit = s.charAt(j) - '0';
                if (!(digit >= 0 && digit < 10)) {
                    return NEITHER;
                }
            }
            if (Integer.parseInt(s) > 255) {
                return NEITHER;
            }
        }
        return IPv4;
    }

    private String validIPv6Address(String IP) {
        String[] split = IP.split(":", -1);
        if (split.length != 8) {
            return NEITHER;
        }
        for (String s : split) {
            s = s.toLowerCase();
            if (s.length() == 0 || s.length() > 4) {
                return NEITHER;
            }
            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                if (!(digit >= 0 && digit < 10) && !(digit >= 48 && digit <= 54)) {
                    return NEITHER;
                }
            }
            if (Integer.parseInt(s, 16) >= Math.pow(2, 16)) {
                return NEITHER;
            }
        }
        return IPv6;
    }

    public static void main(String[] args) {
        System.out.println(new ValidateIPAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")); // IPv6
    }
}
