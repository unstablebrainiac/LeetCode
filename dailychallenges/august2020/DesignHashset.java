package dailychallenges.august2020;
/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3410/
 */
public class DesignHashset {

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    } // true,false,true,false

    static class MyHashSet {
        boolean[] container;

        /** Initialize your data structure here. */
        public MyHashSet() {
            container = new boolean[1000001];
        }

        public void add(int key) {
            container[key] = true;
        }

        public void remove(int key) {
            container[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return container[key];
        }
    }
}
