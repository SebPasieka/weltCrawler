package com.github.sebPasieka.weltCrawler.view;

import com.github.sebPasieka.weltCrawler.service.RssReader;

import java.util.List;

public class TerminalOutput {

    public void print(List<RssReader.Article> articles) {
        System.out.println(articles);
    }
}
