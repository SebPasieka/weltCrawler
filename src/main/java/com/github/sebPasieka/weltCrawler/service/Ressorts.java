package com.github.sebPasieka.weltCrawler.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Ressorts {
    POLITIK("https://www.welt.de/feeds/section/politik.rss"),
    WIRTSCHAFT("https://www.welt.de/feeds/section/wirtschaft.rss"),
    BILANZ("https://www.welt.de/feeds/section/wirtschaft/bilanz.rss"),
    GELD("https://www.welt.de/feeds/section/finanzen.rss", "Geld", "Finanzen"),
    DIGITAL("https://www.welt.de/feeds/section/wirtschaft/webwelt.rss", "Digital", "Webwelt"),
    WISSEN("https://www.welt.de/feeds/section/wissenschaft.rss", "Wissen", "Wissenschaft"),
    KULTUR("https://www.welt.de/feeds/section/kultur.rss"),
    SPORT("https://www.welt.de/feeds/section/sport.rss"),
    ICON("https://www.welt.de/feeds/section/icon.rss"),
    GESUNDHEIT("https://www.welt.de/feeds/section/gesundheit.rss"),
    PANORAMA("https://www.welt.de/feeds/section/vermischtes.rss", "Panorama", "Vermischte"),
    MOTOR("https://www.welt.de/feeds/section/motor.rss"),
    REISE("https://www.welt.de/feeds/section/reise.rss"),
    REGIONAL("https://www.welt.de/feeds/section/regionales.rss", "Regional", "Regionales"),
    MEINUNG("https://www.welt.de/feeds/section/debatte.rss", "Meinung", "Debatte");

    private final String url;
    private final List<String> aliases;

    Ressorts(String url) {
        this.url = url;
        this.aliases = Collections.singletonList(this.name());
    }

    Ressorts(String url, String...aliases) {
        this.url = url;
        this.aliases = Arrays.asList(aliases);
    }

    public String url() {
        return this.url;
    }

    public List<String> alias() {
        return this.aliases;
    }
}
