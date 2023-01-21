package dailychallenges.january2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(s, 4);
    }

    private List<String> restoreIpAddresses(String s, int numParts) {
        if (numParts == 1) {
            if (s.length() < 1 || s.length() > 3) {
                return Collections.emptyList();
            }
            if (s.charAt(0) == '0' && s.length() > 1) {
                return Collections.emptyList();
            }
            if (Integer.parseInt(s) >= 256) {
                return Collections.emptyList();
            }
            List<String> singleton = new ArrayList<>();
            singleton.add(s);
            return singleton;
        }
        if (!s.isEmpty() && s.charAt(0) == '0') {
            List<String> suffixes = restoreIpAddresses(s.substring(1), numParts - 1);
            suffixes = suffixes.stream().map(suffix -> suffix = "0." + suffix).collect(Collectors.toList());
            return suffixes;
        }

        List<String> result = new ArrayList<>();
        if (!s.isEmpty()) {
            List<String> jumpOne = restoreIpAddresses(s.substring(1), numParts - 1);
            jumpOne = jumpOne.stream().map(suffix -> s.charAt(0) + "." + suffix).collect(Collectors.toList());
            result.addAll(jumpOne);
        }
        if (s.length() >= 2) {
            List<String> jumpTwo = restoreIpAddresses(s.substring(2), numParts - 1);
            jumpTwo = jumpTwo.stream().map(suffix -> s.substring(0, 2) + "." + suffix).collect(Collectors.toList());
            result.addAll(jumpTwo);
        }
        if (s.length() >= 3 && Integer.parseInt(s.substring(0, 3)) < 256) {
            List<String> jumpThree = restoreIpAddresses(s.substring(3), numParts - 1);
            jumpThree = jumpThree.stream().map(suffix -> s.substring(0, 3) + "." + suffix).collect(Collectors.toList());
            result.addAll(jumpThree);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("25525511135"));
    }
}
