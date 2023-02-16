import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n != 1) {
            if (visited.contains(n)) {
                return false;
            }
            visited.add(n);
            n = String.valueOf(n).chars().map(value -> value - '0').map(value -> value * value).sum();
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19)); // true
    }
}
