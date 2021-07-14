package com.github.sebPasieka.weltCrawler.view;

import com.github.sebPasieka.weltCrawler.service.RssReader;

import java.util.List;

public class TerminalOutput {

    public void print(List<RssReader.Article> articles) {
        for (RssReader.Article article : articles) {
            System.out.println("Titel: " + article.getArticleTitle() + " | vom: " + article.getArticlePubDate());
            System.out.println("Beschreibung: " + article.getArticleDescription());
            if (article.getArticleAuthor() != null) {
                System.out.println("Author: " + article.getArticleAuthor());
            }
            System.out.println("Hier weiterlesen: " + article.getArticleLink());
            System.out.println("Kategorie: " + article.getArticleRessort() + "\n");

        }

        System.out.println("Anzahl: "+articles.size());


    }
}
