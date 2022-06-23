package dailychallenges.june2022;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/course-schedule-iii/
 */
public class CourseSchedule3 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparing((int[] course) -> course[1]));
        int currentTotalTime = 0, numCourses = 0;
        PriorityQueue<Integer> longestCourses = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] course : courses) {
            if (currentTotalTime + course[0] <= course[1]) {
                currentTotalTime += course[0];
                longestCourses.add(course[0]);
                numCourses++;
            } else {
                if (longestCourses.isEmpty()) {
                    continue;
                }
                if (longestCourses.peek() <= course[0]) {
                    continue;
                }
                currentTotalTime -= longestCourses.poll();
                currentTotalTime += course[0];
                longestCourses.add(course[0]);
            }
        }
        return numCourses;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule3().scheduleCourse(
                new int[][]{
                        new int[]{100, 200},
                        new int[]{200, 1300},
                        new int[]{1000, 1250},
                        new int[]{2000, 3200}
                }
        ));
    }
}
