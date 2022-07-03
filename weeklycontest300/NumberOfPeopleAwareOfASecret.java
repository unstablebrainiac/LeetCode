package weeklycontest300;

import java.math.BigInteger;
import java.util.LinkedList;

/*
 * https://leetcode.com/problems/number-of-people-aware-of-a-secret/submissions/
 */
public class NumberOfPeopleAwareOfASecret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        LinkedList<BigInteger> stages = new LinkedList<>();
        stages.offer(BigInteger.ONE);
        for (int i = 1; i < n; i++) {
            if (i >= forget) {
                stages.poll();
            }
            if (i >= delay) {
                stages.offer(stages.stream().limit(Math.min(forget - 1, i) - delay + 1).reduce(BigInteger::add).orElse(BigInteger.ZERO));
            } else {
                stages.offer(BigInteger.ZERO);
            }
        }
        BigInteger factor = new BigInteger("1000000007");
        return stages.stream().reduce(BigInteger::add).orElse(BigInteger.ZERO).mod(factor).intValue();
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfPeopleAwareOfASecret().peopleAwareOfSecret(684,18,496));
    }
}
