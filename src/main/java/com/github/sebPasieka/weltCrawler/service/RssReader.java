package com.github.sebPasieka.weltCrawler.service;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RssReader {

    public List<Article> readMXL(String rssFeed, int max) {
        try (InputStream stream = new ByteArrayInputStream(rssFeed.getBytes(StandardCharsets.UTF_8))) {
            final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            final DocumentBuilder db = dbf.newDocumentBuilder();

            final List<Article> articles = new ArrayList<>();

            final Document dom = db.parse(stream);

            final Element doc = dom.getDocumentElement();

            final NodeList items = doc.getElementsByTagName("item");

            int numberOfArticles;

            if (max == 0) {
                numberOfArticles = items.getLength();
            } else {
                numberOfArticles = Math.min(max, items.getLength());
            }

            for (int i = 0; i < numberOfArticles; i++) {
                final Article article = new Article();
                Element articleElement = (Element) items.item(i);

                NodeList title = articleElement.getElementsByTagName("title");
                NodeList description = articleElement.getElementsByTagName("description");
                NodeList link = articleElement.getElementsByTagName("link");
                NodeList category = articleElement.getElementsByTagName("category");
                NodeList pubDate = articleElement.getElementsByTagName("pubDate");
                NodeList author = articleElement.getElementsByTagName("author");

                try {
                    article.setArticleTitle(title.item(0).getTextContent());
                    article.setArticleLink(link.item(0).getTextContent());
                } catch (NullPointerException npe) {
                    continue;
                }

                try {
                    article.setArticleDescription(description.item(0).getTextContent());
                } catch (NullPointerException npe) {
                    // nothing to do
                }

                try {
                    article.setArticleCategory(category.item(0).getTextContent());
                } catch (NullPointerException npe) {
                    // nothing to do
                }

                try {
                    article.setArticlePubDate(pubDate.item(0).getTextContent());
                } catch (NullPointerException npe) {
                    // nothing to do
                }

                try {
                    article.setArticleAuthor(author.item(0).getTextContent());
                } catch (NullPointerException npe) {
                    // nothing to do
                }

                articles.add(article);
            }

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
        private String articleCategory;
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

        public String getArticleCategory() {
            return articleCategory;
        }

        public void setArticleCategory(String articleRessort) {
            this.articleCategory = articleRessort;
        }

        public String getArticleDescription() {
            return articleDescription;
        }

        public void setArticleDescription(String articleDescription) {
            this.articleDescription = articleDescription;
        }
    }
}
