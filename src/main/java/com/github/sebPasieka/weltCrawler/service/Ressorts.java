package com.github.sebPasieka.weltCrawler.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Ressorts {
    POLITIK("politik.rss"),
    WIRTSCHAFT("wirtschaft.rss"),
    BILANZ("wirtschaft/bilanz.rss"),
    GELD("finanzen.rss", "Geld, Finanzen"),
    DIGITAL("wirtschaft/webwelt.rss", "Digital", "Webwelt"),
    WISSEN("wissenschaft.rss", "Wissen", "Wissenschaft"),
    KULTUR("kultur.rss"),
    SPORT("sport.rss"),
    ICON("icon.rss"),
    GESUNDHEIT("gesundheit.rss"),
    PANORAMA("vermischtes.rss", "Panorama", "Vermischte"),
    MOTOR("motor.rss"),
    REISE("reise.rss"),
    REGIONAL("regionales.rss", "Regional", "Regionales"),
    MEINUNG("debatte.rss", "Meinung", "Debatte");

    private final String ressortPath;
    private final List<String> aliases;

    Ressorts(String ressortPath) {
        this.ressortPath = ressortPath;
        this.aliases = Collections.singletonList(this.name());
    }

    Ressorts(String ressortPath, String...aliases) {
        this.ressortPath = ressortPath;
        this.aliases = Arrays.asList(aliases);
    }

    public String ressortPath() {
        return this.ressortPath;
    }

    public List<String> alias() {
        return this.aliases;
    }
}
