import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/license-key-formatting/
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        List<Character> characters = Arrays.stream(s.split("-"))
                .flatMapToInt(String::chars)
                .mapToObj(value -> (char) value)
                .map(Character::toUpperCase)
                .collect(Collectors.toList());

        int extraCharacters = characters.size() % k;
        String firstGroup = toString(characters.subList(0, extraCharacters));

        String end = IntStream.range(0, characters.size() / k)
                .mapToObj(i -> characters.subList(i * k + extraCharacters, (i + 1) * k + extraCharacters))
                .map(this::toString)
                .collect(Collectors.joining("-"));

        if (end.isEmpty()) {
            return firstGroup;
        }
        if (firstGroup.isEmpty()) {
            return end;
        }
        return firstGroup + '-' + end;
    }

    private String toString(List<Character> characters) {
        return characters
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting(
                "2-5g-3-J",
                2
        )); // 2-5G-3J
    }
}
