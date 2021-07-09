package com.github.sebPasieka.weltCrawler.service;


import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RssFetcher {
    public void fetchXML(String ressort) throws IOException {
        String url = manageInputAndReturnUrl(ressort);

        try (CloseableHttpClient client = HttpClients.createDefault()) {

            HttpGet request = new HttpGet(url);

            String response = client.execute(request, new BasicResponseHandler());

            BufferedWriter writer = new BufferedWriter(new FileWriter("rssFeed.xml"));
            writer.write(response);
            writer.close();
        }
    }

    public boolean containsCaseInsensitive(String s, List<String> l){
        for (String string : l){
            if (string.equalsIgnoreCase(s)){
                return true;
            }
        }
        return false;
    }

    public String manageInputAndReturnUrl(String ressort) throws IllegalArgumentException {
        String url = null;

        if (containsCaseInsensitive(ressort, Ressorts.POLITIK.aliases())) {
            url = Ressorts.POLITIK.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.WIRTSCHAFT.aliases())) {
            url = Ressorts.WIRTSCHAFT.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.BILANZ.aliases())) {
            url = Ressorts.BILANZ.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.GELD.aliases())) {
            url = Ressorts.GELD.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.DIGITAL.aliases())) {
            url = Ressorts.DIGITAL.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.WISSEN.aliases())) {
            url = Ressorts.WISSEN.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.KULTUR.aliases())) {
            url = Ressorts.KULTUR.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.SPORT.aliases())) {
            url = Ressorts.SPORT.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.ICON.aliases())) {
            url = Ressorts.ICON.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.GESUNDHEIT.aliases())) {
            url = Ressorts.GESUNDHEIT.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.PANORAMA.aliases())) {
            url = Ressorts.PANORAMA.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.MOTOR.aliases())) {
            url = Ressorts.MOTOR.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.REISE.aliases())) {
            url = Ressorts.REISE.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.REGIONAL.aliases())) {
            url = Ressorts.REGIONAL.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.MEINUNG.aliases())) {
            url = Ressorts.MEINUNG.url();
        }

        if (url == null) {
            throw new IllegalArgumentException("Ressort not found");
        }

        return url;
    }
}
