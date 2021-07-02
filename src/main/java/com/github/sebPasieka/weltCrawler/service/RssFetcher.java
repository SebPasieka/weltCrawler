package com.github.sebPasieka.weltCrawler.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RssFetcher {
    public void fetchXML(String[] args) throws IOException {
        WeltCrawler arguments = new WeltCrawler();
        String ressort = arguments.getRessort(args);
        String url = createURL(ressort);
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

        /*BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

         */

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

    public String createURL(String ressort) throws IllegalArgumentException {
        String url = "";
        String ressortPath = "";

        // correct the name of the ressort

        if (ressort.equalsIgnoreCase(Ressorts.POLITIK.name())) {
            ressortPath = Ressorts.POLITIK.ressortPath();
        }
        if (ressort.equalsIgnoreCase(Ressorts.WIRTSCHAFT.name())) {
            ressortPath = Ressorts.WIRTSCHAFT.ressortPath();
        }
        if (ressort.equalsIgnoreCase(Ressorts.BILANZ.name())) {
            ressortPath = Ressorts.BILANZ.ressortPath();
        }
        if (containsCaseInsensitive(ressort, Ressorts.GELD.alias())) {
            ressortPath = Ressorts.GELD.ressortPath();
        }
        if (containsCaseInsensitive(ressort, Ressorts.DIGITAL.alias())) {
            ressortPath = Ressorts.DIGITAL.ressortPath();
        }
        if (containsCaseInsensitive(ressort, Ressorts.WISSEN.alias())) {
            ressortPath = Ressorts.WISSEN.ressortPath();
        }
        if (ressort.equalsIgnoreCase(Ressorts.KULTUR.name())) {
            ressortPath = Ressorts.KULTUR.ressortPath();
        }
        if (ressort.equalsIgnoreCase(Ressorts.SPORT.name())) {
            ressortPath = Ressorts.SPORT.ressortPath();
        }
        if (ressort.equalsIgnoreCase(Ressorts.ICON.name())) {
            ressortPath = Ressorts.ICON.ressortPath();
        }
        if (ressort.equalsIgnoreCase(Ressorts.GESUNDHEIT.name())) {
            ressortPath = Ressorts.GESUNDHEIT.ressortPath();
        }
        if (containsCaseInsensitive(ressort, Ressorts.PANORAMA.alias())) {
            ressortPath = Ressorts.PANORAMA.ressortPath();
        }
        if (ressort.equalsIgnoreCase(Ressorts.MOTOR.name())) {
            ressortPath = Ressorts.MOTOR.ressortPath();
        }
        if (ressort.equalsIgnoreCase(Ressorts.REISE.name())) {
            ressortPath = Ressorts.REISE.ressortPath();
        }
        if (containsCaseInsensitive(ressort, Ressorts.REGIONAL.alias())) {
            ressortPath = Ressorts.REGIONAL.ressortPath();
        }
        if (containsCaseInsensitive(ressort, Ressorts.MEINUNG.alias())) {
            ressortPath = Ressorts.MEINUNG.ressortPath();
        }


        // check if ressort exists
        Ressorts[] allRessorts = Ressorts.values();
        for (Ressorts r: allRessorts) {
                   if (ressortPath.equalsIgnoreCase(r.ressortPath())) {
                       url = "https://www.welt.de/feeds/section/" + ressortPath;
                       return url;
                   }
        }
        throw new IllegalArgumentException("Ressort not found");
    }
}
