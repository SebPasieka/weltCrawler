package service;


import weltCrawler.WeltCrawler;

public class Fetcher {
    public void fetchXML(String[] args) {
        WeltCrawler arguments = new WeltCrawler();
        String ressort = arguments.getRessort(args);
        int number = arguments.getNumber(args);
        System.out.println(ressort);
        System.out.println(number);

        String url = createURL(ressort);
        System.out.println(url);
    }

    public String createURL(String ressort) {
        String url = "";
        String politik = "politik";
        String wirtschaft = "wirtschaft";
        String bilanz = "wirtschaft/bilanz";
        String geld = "finanzen";
        String digital = "wirtschaft/webwelt";
        String wissen = "wissenschaft";
        String kultur = "kultur";
        String sport = "sport";
        String icon = "icon";
        String gesundheit = "gesundheit";
        String panorama = "vermischtes";
        String motor = "motor";
        String reise = "reise";
        String regional = "regionales";
        String meinung = "debatte";

        // correct the name of the ressort
        if (ressort.equalsIgnoreCase("Bilanz")) {
            ressort = bilanz;
        }
        if (ressort.equalsIgnoreCase("Geld") || ressort.equalsIgnoreCase("Finanzen")) {
            ressort = geld;
        }
        if (ressort.equalsIgnoreCase("Digital") || ressort.equalsIgnoreCase("Webwelt")) {
            ressort = digital;
        }
        if (ressort.equalsIgnoreCase("Wissen") || ressort.equalsIgnoreCase("Wissenschaft")) {
            ressort = wissen;
        }
        if (ressort.equalsIgnoreCase("Panorama") || ressort.equalsIgnoreCase("Vermischtes")) {
            ressort = panorama;
        }
        if (ressort.equalsIgnoreCase("Regional") || ressort.equalsIgnoreCase("Regionales")) {
            ressort = regional;
        }
        if (ressort.equalsIgnoreCase("Meinung") || ressort.equalsIgnoreCase("Debatte")) {
            ressort = meinung;
        }

        // check if ressort exists
        if (ressort.equalsIgnoreCase(politik)
                || ressort.equalsIgnoreCase(wirtschaft)
                || ressort.equalsIgnoreCase(bilanz)
                || ressort.equalsIgnoreCase(geld)
                || ressort.equalsIgnoreCase(digital)
                || ressort.equalsIgnoreCase(wissen)
                || ressort.equalsIgnoreCase(kultur)
                || ressort.equalsIgnoreCase(sport)
                || ressort.equalsIgnoreCase(icon)
                || ressort.equalsIgnoreCase(gesundheit)
                || ressort.equalsIgnoreCase(panorama)
                || ressort.equalsIgnoreCase(motor)
                || ressort.equalsIgnoreCase(reise)
                || ressort.equalsIgnoreCase(regional)
                || ressort.equalsIgnoreCase(meinung)) {
            // create URL
            url = "https://www.welt.de/feeds/section/"+ressort+".rss";

        } else {
            // ressort not found
            System.out.println("Ressort not found");
        }

        return url;
    }
}
