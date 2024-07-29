package contests.weekly.weeklycontest194;

/*
 * https://leetcode.com/contest/weekly-contest-194/problems/xor-operation-in-an-array/
 */
public class XOROperationInAnArray {
    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            start += 2;
            ans ^= start;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new XOROperationInAnArray().xorOperation(10, 5));
    }
}
