package weltCrawler;

import service.Fetcher;

public class App {
    public static void main(String[] args) {
        Fetcher fetch = new Fetcher();
        fetch.fetchXML(args);
    }
}
