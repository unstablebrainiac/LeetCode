package dailychallenges.june2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        return suggestedProducts(Arrays.stream(products).collect(Collectors.toList()), searchWord, 1);
    }

    private List<List<String>> suggestedProducts(List<String> products, String searchWord, int endIndex) {
        if (endIndex > searchWord.length()) {
            return new ArrayList<>();
        }
        List<String> filteredProducts = products.stream()
                .filter(product -> product.startsWith(searchWord.substring(0, endIndex)))
                .collect(Collectors.toList());
        List<List<String>> next = suggestedProducts(filteredProducts, searchWord, endIndex + 1);
        next.add(
                0,
                filteredProducts.stream()
                        .sorted()
                        .limit(3)
                        .collect(Collectors.toList())
        );
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new SearchSuggestionSystem().suggestedProducts(
                new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"},
                "mouse"
        )); // [[mobile, moneypot, monitor], [mobile, moneypot, monitor], [mouse, mousepad], [mouse, mousepad], [mouse, mousepad]]
    }
}
