package com.github.sebPasieka.weltCrawler;

import com.github.sebPasieka.weltCrawler.service.RssFetcher;
import com.github.sebPasieka.weltCrawler.service.RssReader;
import com.github.sebPasieka.weltCrawler.service.ProcessInput;
import com.github.sebPasieka.weltCrawler.view.TerminalOutput;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        ProcessInput processInput = new ProcessInput();
        String ressort = processInput.getRessort(args);
        int number = processInput.getNumber(args);

        RssFetcher fetch = new RssFetcher();
        String rssFeed = fetch.fetchXML(ressort);

        RssReader read = new RssReader();
        List<RssReader.Article> articles = read.readMXL(rssFeed, number);

        TerminalOutput output = new TerminalOutput();
        output.print(articles);
    }
}
