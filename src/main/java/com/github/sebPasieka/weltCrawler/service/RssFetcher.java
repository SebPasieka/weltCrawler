package com.github.sebPasieka.weltCrawler.service;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RssFetcher {
    public void fetchXML(String[] args) throws IOException {
        WeltCrawler arguments = new WeltCrawler();
        String ressort = arguments.getRessort(args);
        String url = manageInputAndReturnUrl(ressort);
        System.out.println(url);

        // HTTP GET Request
        URL fetchUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) fetchUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int statusCode = connection.getResponseCode();

        System.out.println(statusCode);

        connection.disconnect();
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

        if (containsCaseInsensitive(ressort, Ressorts.POLITIK.alias())) {
            url = Ressorts.POLITIK.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.WIRTSCHAFT.alias())) {
            url = Ressorts.WIRTSCHAFT.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.BILANZ.alias())) {
            url = Ressorts.BILANZ.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.GELD.alias())) {
            url = Ressorts.GELD.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.DIGITAL.alias())) {
            url = Ressorts.DIGITAL.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.WISSEN.alias())) {
            url = Ressorts.WISSEN.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.KULTUR.alias())) {
            url = Ressorts.KULTUR.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.SPORT.alias())) {
            url = Ressorts.SPORT.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.ICON.alias())) {
            url = Ressorts.ICON.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.GESUNDHEIT.alias())) {
            url = Ressorts.GESUNDHEIT.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.PANORAMA.alias())) {
            url = Ressorts.PANORAMA.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.MOTOR.alias())) {
            url = Ressorts.MOTOR.url();
        }
        if (containsCaseInsensitive(ressort ,Ressorts.REISE.alias())) {
            url = Ressorts.REISE.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.REGIONAL.alias())) {
            url = Ressorts.REGIONAL.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.MEINUNG.alias())) {
            url = Ressorts.MEINUNG.url();
        }

        if (url == null) {
            throw new IllegalArgumentException("Ressort not found");
        }

        return url;
    }
}
