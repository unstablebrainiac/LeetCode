package dailychallenges.february2023;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/ipo/
 */
public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> initialPossibleProfits = new PriorityQueue<>(Comparator.reverseOrder());
        List<Project> projects = IntStream.range(0, capital.length)
                .mapToObj(index -> new Project(capital[index], profits[index]))
                .sorted()
                .collect(Collectors.toList());
        int i;
        for (i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            if (project.capital > w) {
                break;
            }
            initialPossibleProfits.offer(project.profit);
        }
        return findMaximizedCapital(k, w, i, projects, initialPossibleProfits);
    }

    private int findMaximizedCapital(int k, int w, int index, List<Project> projects, PriorityQueue<Integer> possibleProfits) {
        if (k == 0 || possibleProfits.isEmpty()) {
            return w;
        }
        Integer currentProfit = possibleProfits.poll();
        int i;
        for (i = index; i < projects.size(); i++) {
            Project project = projects.get(i);
            if (project.capital > w + currentProfit) {
                break;
            }
            possibleProfits.offer(project.profit);
        }
        return findMaximizedCapital(k - 1, w + currentProfit, i, projects, possibleProfits);
    }

    public static void main(String[] args) {
        System.out.println(new IPO().findMaximizedCapital(
                2,
                0,
                new int[]{1,2,3},
                new int[]{0,1,1}
        )); // 4
    }

    static class Project implements Comparable<Project> {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Project o) {
            return capital - o.capital;
        }
    }
}
