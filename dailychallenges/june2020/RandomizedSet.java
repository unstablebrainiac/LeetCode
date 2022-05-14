package dailychallenges.june2020;

import java.util.*;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3358/
 */
public class RandomizedSet {

    private final List<Integer> list;
    private final Set<Integer> set;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        set = new LinkedHashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (set.add(val)) {
            list.add(val);
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        while (true) {
            int index = random.nextInt(list.size());
            Integer integer = list.get(index);
            if (set.contains(integer)) {
                return integer;
            }
        }
    }
}
