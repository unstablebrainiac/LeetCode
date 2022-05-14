package biweeklycontest28;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/biweekly-contest-28/problems/allocate-mailboxes/
 */
public class AllocateMailboxes {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int[] mailboxes = new int[k];
        for (int i = 0; i < mailboxes.length; i++) {
            mailboxes[i] = i;
        }
        int distance = calculateDistance(houses, mailboxes);
        for (int i = mailboxes.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < houses[houses.length - 1]; j++) {
                System.out.println(Arrays.toString(mailboxes));
                mailboxes[i] = j;
                int newDistance = calculateDistance(houses, mailboxes);
                System.out.println("distance = " + distance);
                System.out.println("newDistance = " + newDistance);
                if (newDistance > distance) {
                    mailboxes[i]--;
                    break;
                }
                distance = newDistance;
            }
        }
        return calculateDistance(houses, mailboxes);
    }

    private int calculateDistance(int[] houses, int[] mailboxes) {
        int distance = 0;
        for (int i = 0; i < houses.length; i++) {
            int index = Arrays.binarySearch(mailboxes, houses[i]);
            if (index == -mailboxes.length - 1) {
                distance += houses[i] - mailboxes[mailboxes.length - 1];
            } else if (index == -1) {
                distance += mailboxes[0] - houses[i];
            } else if (index < -1) {
                distance += Math.min(mailboxes[-index - 1] - houses[i], houses[i] - mailboxes[-index - 2]);
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(new AllocateMailboxes().minDistance(
                new int[]{2, 3, 5, 12, 18},
                2
        ));
    }
}
