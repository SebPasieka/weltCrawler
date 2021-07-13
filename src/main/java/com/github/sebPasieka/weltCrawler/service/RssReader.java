package com.github.sebPasieka.weltCrawler.service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RssReader {

    public List<Article> readMXL(String fileName, int max) {
        try {
            final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            final DocumentBuilder db = dbf.newDocumentBuilder();

            final List<Article> articles = new ArrayList<>();

            final Article article = new Article();
            final Document dom = db.parse(new File(fileName));

            final Element doc = dom.getDocumentElement();


            final Node title = doc.getElementsByTagName("title").item(max);
            article.articleTitle = title.getTextContent();

            final Node description = doc.getElementsByTagName("description").item(max);
            article.articleDescription = description.getTextContent();

            final Node ressort = doc.getElementsByTagName("category").item(max);
            article.articleRessort = ressort.getTextContent();

            final Node link = doc.getElementsByTagName("link").item(max);
            article.articleLink = link.getTextContent();

            final Node pubDate = doc.getElementsByTagName("pubDate").item(max);
            article.articlePubDate = pubDate.getTextContent();

            final Node author = doc.getElementsByTagName("author").item(max);
            article.articleAuthor = author.getTextContent();

            return articles;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static class Article {

        private String articleTitle;
        private String articleLink;
        private String articlePubDate;
        private String articleAuthor;
        private String articleRessort;
        private String articleDescription;

        public String getArticleTitle() {
            return articleTitle;
        }

        public void setArticleTitle(String articleTitle) {
            this.articleTitle = articleTitle;
        }

        public String getArticleLink() {
            return articleLink;
        }

        public void setArticleLink(String articleLink) {
            this.articleLink = articleLink;
        }

        public String getArticlePubDate() {
            return articlePubDate;
        }

        public void setArticlePubDate(String articlePubDate) {
            this.articlePubDate = articlePubDate;
        }

        public String getArticleAuthor() {
            return articleAuthor;
        }

        public void setArticleAuthor(String articleAuthor) {
            this.articleAuthor = articleAuthor;
        }

        public String getArticleRessort() {
            return articleRessort;
        }

        public void setArticleRessort(String articleRessort) {
            this.articleRessort = articleRessort;
        }

        public String getArticleDescription() {
            return articleDescription;
        }

        public void setArticleDescription(String articleDescription) {
            this.articleDescription = articleDescription;
        }
    }
}
