package dailychallenges.june2022;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public int minPartitions(String n) {
        return n.chars().max().orElse(49) - 48;
    }

    public static void main(String[] args) {
        System.out.println(new PartitioningIntoMinimumNumberOfDeciBinaryNumbers().minPartitions("27346209830709182346")); // 9
    }
}
