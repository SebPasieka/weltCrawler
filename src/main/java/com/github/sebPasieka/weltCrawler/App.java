package com.github.sebPasieka.weltCrawler;

import com.github.sebPasieka.weltCrawler.service.RssFetcher;

public class App {
    public static void main(String[] args) {
        RssFetcher fetch = new RssFetcher();
        fetch.fetchXML(args);
    }
}
