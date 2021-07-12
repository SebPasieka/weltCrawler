package com.github.sebPasieka.weltCrawler.service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;

public class RssReader {

    private String articleTitle;
    private String articleLink;
    private String articlePubDate;
    private String articleAuthor;
    private String articleRessort;
    private String articleDescription;

    public void readMXL(String fileName) {
        try {
            final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            final DocumentBuilder db = dbf.newDocumentBuilder();
            final Document dom = db.parse(new File(fileName));

            final Element doc = dom.getDocumentElement();

            final Node title = doc.getElementsByTagName("title").item(2);
            articleTitle = title.getTextContent();

            final Node description = doc.getElementsByTagName("description").item(0);
            articleDescription = description.getTextContent();

            final Node ressort = doc.getElementsByTagName("category").item(0);
            articleRessort = ressort.getTextContent();

            final Node link = doc.getElementsByTagName("link").item(0);
            articleLink = link.getTextContent();

            final Node pubDate = doc.getElementsByTagName("pubDate").item(0);
            articlePubDate = pubDate.getTextContent();

            final Node author = doc.getElementsByTagName("author").item(0);
            articleAuthor = author.getTextContent();

            System.out.println(articleTitle);

        } catch (Exception e) {
            //return null;
        }


    }
}
