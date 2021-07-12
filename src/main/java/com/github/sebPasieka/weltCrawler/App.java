package com.github.sebPasieka.weltCrawler;

import com.github.sebPasieka.weltCrawler.service.RssFetcher;
import com.github.sebPasieka.weltCrawler.service.RssReader;
import com.github.sebPasieka.weltCrawler.service.ProcessInput;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ProcessInput processInput = new ProcessInput();
        String ressort = processInput.getRessort(args);
        int number = processInput.getNumber(args);

        RssFetcher fetch = new RssFetcher();
        fetch.fetchXML(ressort);

        RssReader read = new RssReader();
        read.readMXL("rssFeed.xml");
    }
}
