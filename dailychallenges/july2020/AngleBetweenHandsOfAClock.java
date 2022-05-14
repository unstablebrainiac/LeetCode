package dailychallenges.july2020;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/
 */
public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        double minuteDegree = minutes * 6;
        double hourDegree = hour * 30 + minuteDegree / 12;
        double diff = Math.abs(hourDegree - minuteDegree);
        return diff > 180 ? 360 - diff : diff;
    }

    public static void main(String[] args) {
        System.out.println(new AngleBetweenHandsOfAClock().angleClock(4, 50)); // 155
    }
}
