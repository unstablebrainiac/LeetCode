import java.util.*;

public class IdentifyPairing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int C = Integer.parseInt(scanner.nextLine());
        int[] pairings = new int[N + 1];
        Map<Integer, List<Integer>> notPairings = new HashMap<>();

        for (int i = 0; i < C; i++) {
            String clue = scanner.nextLine();
            String[] components = clue.split(" ");
            if (components[0].equals("=")) {
                pairings[Integer.parseInt(components[1])] = Integer.parseInt(components[2]);
            } else {
                int key = Integer.parseInt(components[1]);
                if (notPairings.containsKey(key)) {
                    notPairings.get(key).add(Integer.parseInt(components[2]));
                } else {
                    notPairings.put(key, Collections.singletonList(Integer.parseInt(components[2])));
                }
            }
        }

        print(findPairings(pairings, notPairings));
    }

    private static void print(int[] pairings) {
        for (int i = 1; i < pairings.length - 1; i++) {
            System.out.print(pairings[i] + " ");
        }
        System.out.println(pairings[pairings.length - 1]);
    }

    private static int[] findPairings(int[] pairings, Map<Integer, List<Integer>> notPairings) {
        for (int i = 1; i < pairings.length; i++) {
            if (pairings[i] == 0) {
                List<Integer> notPairs = notPairings.getOrDefault(i, Collections.emptyList());
                for (int j = 1; j < pairings.length; j++) {
                    if (notPairs.contains(j) || contains(pairings, j)) {
                        continue;
                    }
                    pairings[i] = j;
                    if (!findPairings(pairings, notPairings).equals(new int[]{})) {
                        return pairings;
                    }
                }
            }
        }
        return new int[]{};
    }

    private static boolean contains(int[] pairings, int j) {
        return Arrays.stream(pairings).anyMatch(value -> value == j);
    }
}
