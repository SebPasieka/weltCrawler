package com.github.sebPasieka.weltCrawler;

import com.github.sebPasieka.weltCrawler.service.RssFetcher;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        RssFetcher fetch = new RssFetcher();
        fetch.fetchXML(args);
    }
}
