package com.github.sebPasieka.weltCrawler.view;

import com.github.sebPasieka.weltCrawler.service.RssReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TerminalOutputTest {
    TerminalOutput systemUnderTest = new TerminalOutput();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void print_shouldDontPrintAuthorIfAuthorIsNull() {
        List<RssReader.Article> articles = new ArrayList<>();
        RssReader.Article article = new RssReader.Article();
        article.setArticleRessort("testRessort");
        article.setArticleTitle("testTitle");
        article.setArticlePubDate("testPubDate");
        article.setArticleDescription("testDescription");
        article.setArticleAuthor(null);
        article.setArticleLink("testLink");
        articles.add(article);

        systemUnderTest.print(articles);

        Assert.assertEquals("Kategorie: testRessort\n" +
                "Titel: testTitle | vom: testPubDate\n" +
                "Beschreibung: testDescription\n" +
                "Hier weiterlesen: testLink\n\n" +
                "Anzahl: 1\n",
                outContent.toString());
    }

}