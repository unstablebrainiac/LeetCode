package dailychallenges.july2020;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3394/
 */
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = findOrder(numCourses, prerequisites, new boolean[numCourses]).stream().mapToInt(value -> value).toArray();
        return ans.length == numCourses ? ans : new int[]{};
    }

    private List<Integer> findOrder(int numCourses, int[][] prerequisites, boolean[] completedCourses) {
        Set<Integer> coursesWithRemainingPrerequisites = Arrays.stream(prerequisites)
                .filter(ints -> !completedCourses[ints[1]])
                .map(ints -> ints[0])
                .collect(Collectors.toSet());
        List<Integer> courses = IntStream.range(0, numCourses)
                .filter(value -> !completedCourses[value])
                .filter(value -> !coursesWithRemainingPrerequisites.contains(value))
                .boxed()
                .collect(Collectors.toList());
        if (courses.size() == 0) {
            return courses;
        }
        courses.forEach(integer -> completedCourses[integer] = true);
        List<Integer> nextCourses = findOrder(numCourses, prerequisites, completedCourses);
        courses.addAll(nextCourses);
        return courses;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseSchedule2().findOrder(
                4,
                new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}
        ))); // [0, 1, 2, 3]
    }
}
