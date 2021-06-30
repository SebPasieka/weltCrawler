package weltCrawler;

import service.fetcher;

public class app {
    public static void main(String[] args) {
        fetcher fetch = new fetcher();
        fetch.fetchXML(args);
    }
}
