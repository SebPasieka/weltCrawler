package com.github.sebPasieka.weltCrawler.service;


public class RssFetcher {
    public void fetchXML(String[] args) {
        WeltCrawler arguments = new WeltCrawler();
        String ressort = arguments.getRessort(args);
        String url = createURL(ressort);
        System.out.println(url);
    }

    public String createURL(String ressort) throws IllegalArgumentException {
        String url = "";
        String ressortPath = "";

        // correct the name of the ressort
        if (ressort.equalsIgnoreCase("Bilanz")) {
            ressortPath = Ressorts.BILANZ.ressortPath();
        }
        if (ressort.equalsIgnoreCase("Geld") || ressort.equalsIgnoreCase("Finanzen")) {
            ressortPath = Ressorts.GELD.ressortPath();
        }
        if (ressort.equalsIgnoreCase("Digital") || ressort.equalsIgnoreCase("Webwelt")) {
            ressortPath = Ressorts.DIGITAL.ressortPath();
        }
        if (ressort.equalsIgnoreCase("Wissen") || ressort.equalsIgnoreCase("Wissenschaft")) {
            ressortPath = Ressorts.WISSEN.ressortPath();
        }
        if (ressort.equalsIgnoreCase("Panorama") || ressort.equalsIgnoreCase("Vermischtes")) {
            ressortPath = Ressorts.PANORAMA.ressortPath();
        }
        if (ressort.equalsIgnoreCase("Regional") || ressort.equalsIgnoreCase("Regionales")) {
            ressortPath = Ressorts.REGIONAL.ressortPath();
        }
        if (ressort.equalsIgnoreCase("Meinung") || ressort.equalsIgnoreCase("Debatte")) {
            ressortPath = Ressorts.MEINUNG.ressortPath();
        }


        // check if ressort exists
        Ressorts[] allRessorts = Ressorts.values();
        for (Ressorts r: allRessorts) {
                   if (ressortPath.equalsIgnoreCase(r.ressortPath())) {
                       url = "https://www.welt.de/feeds/section/" + ressortPath + ".rss";
                       return url;
                   }
        }
        throw new IllegalArgumentException("Ressort not found");
    }
}
