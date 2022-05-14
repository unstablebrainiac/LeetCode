package dailychallenges.september2020;

/*
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3455/
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int A = 0, B = 0;
        int[] cnt = new int[10];
        for(int i=0; i<secret.length(); ++i){
            if(secret.charAt(i) == guess.charAt(i)) ++A;
            else{
                if(++cnt[secret.charAt(i)-'0'] <= 0)    ++B;
                if(--cnt[guess.charAt(i)-'0']>=0)   ++B;
            }
        }
        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("1123", "0111")); // 1A1B
    }
}
