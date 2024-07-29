package contests.weekly.weeklycontest192;

import java.util.LinkedList;
import java.util.List;

public class DesignBrowserHistory {

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("google.com");
        browserHistory.visit("let.com");
        browserHistory.visit("fb.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("a.com");
        System.out.println(browserHistory.back(1));
    }

    static class BrowserHistory {

        List<String> urls;
        int currentIndex;

        public BrowserHistory(String homepage) {
            urls = new LinkedList<>();
            urls.add(homepage);
            currentIndex = 0;
        }

        public void visit(String url) {
            urls = urls.subList(0, currentIndex + 1);
            urls.add(url);
            currentIndex++;
        }

        public String back(int steps) {
            if (currentIndex - steps >= 0) {
                currentIndex -= steps;
            } else {
                currentIndex = 0;
            }
            return urls.get(currentIndex);
        }

        public String forward(int steps) {
            if (currentIndex + steps < urls.size()) {
                currentIndex += steps;
            } else {
                currentIndex = urls.size() - 1;
            }
            return urls.get(currentIndex);
        }
    }
}
