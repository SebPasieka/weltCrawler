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

        if (ressort.equalsIgnoreCase(Ressorts.POLITIK.name())) {
            url = Ressorts.POLITIK.url();
        }
        if (ressort.equalsIgnoreCase(Ressorts.WIRTSCHAFT.name())) {
            url = Ressorts.WIRTSCHAFT.url();
        }
        if (ressort.equalsIgnoreCase(Ressorts.BILANZ.name())) {
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
        if (ressort.equalsIgnoreCase(Ressorts.KULTUR.name())) {
            url = Ressorts.KULTUR.url();
        }
        if (ressort.equalsIgnoreCase(Ressorts.SPORT.name())) {
            url = Ressorts.SPORT.url();
        }
        if (ressort.equalsIgnoreCase(Ressorts.ICON.name())) {
            url = Ressorts.ICON.url();
        }
        if (ressort.equalsIgnoreCase(Ressorts.GESUNDHEIT.name())) {
            url = Ressorts.GESUNDHEIT.url();
        }
        if (containsCaseInsensitive(ressort, Ressorts.PANORAMA.alias())) {
            url = Ressorts.PANORAMA.url();
        }
        if (ressort.equalsIgnoreCase(Ressorts.MOTOR.name())) {
            url = Ressorts.MOTOR.url();
        }
        if (ressort.equalsIgnoreCase(Ressorts.REISE.name())) {
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
