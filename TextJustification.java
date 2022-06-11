import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/text-justification/
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        return justify(words, maxWidth, 0);
    }

    private List<String> justify(String[] words, int maxWidth, int startIndex) {
        int length = words[startIndex].length();
        int currentIndex = startIndex + 1;
        while (currentIndex < words.length) {
            if (length + words[currentIndex].length() + 1 > maxWidth) {
                break;
            }
            length += words[currentIndex].length() + 1;
            currentIndex++;
        }
        if (currentIndex == words.length) {
            List<String> lastLine = new ArrayList<>();
            lastLine.add(leftAlign(words, maxWidth, startIndex, currentIndex));
            return lastLine;
        } else {
            List<String> nextLines = justify(words, maxWidth, currentIndex);
            nextLines.add(0, justifyLine(words, maxWidth, startIndex, currentIndex));
            return nextLines;
        }
    }

    private String justifyLine(String[] words, int maxWidth, int startIndex, int endIndex) {
        int numWords = endIndex - startIndex;
        int numGaps = numWords - 1;
        if (numGaps == 0) {
            return leftAlign(words, maxWidth, startIndex, endIndex);
        }
        int wordLength = Arrays.stream(words).limit(endIndex).skip(startIndex).mapToInt(String::length).sum();
        int totalSpaces = maxWidth - wordLength;
        if (totalSpaces % numGaps == 0) {
            return Arrays.stream(words).limit(endIndex).skip(startIndex).collect(Collectors.joining(" ".repeat(totalSpaces/numGaps)));
        } else {
            StringBuilder line = new StringBuilder();
            for (int i = startIndex; i < endIndex - 1; i++) {
                line.append(words[i]);
                line.append(" ".repeat(totalSpaces / numGaps));
                if (i - startIndex < totalSpaces % numGaps) {
                    line.append(" ");
                }
            }
            line.append(words[endIndex - 1]);
            return line.toString();
        }
    }

    private String leftAlign(String[] words, int maxWidth, int startIndex, int endIndex) {
        String left = Arrays.stream(words).limit(endIndex).skip(startIndex).collect(Collectors.joining(" "));
        return left + " ".repeat(maxWidth - left.length());
    }

    public static void main(String[] args) {
        System.out.println(new TextJustification().fullJustify(
                new String[]{"This", "is", "an", "example", "of", "text", "justification."},
                16
        ));
    }
}
