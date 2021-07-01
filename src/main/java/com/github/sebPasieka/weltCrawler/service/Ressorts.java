package com.github.sebPasieka.weltCrawler.service;

public enum Ressorts {
    POLITIK("politik"),
    WIRTSCHAFT("wirtschaft"),
    BILANZ("wirtschaft/bilanz"),
    GELD("finanzen"),
    DIGITAL("wirtschaft/webwelt"),
    WISSEN("wissenschaft"),
    KULTUR("kultur"),
    SPORT("sport"),
    ICON("icon"),
    GESUNDHEIT("gesundheit"),
    PANORAMA("vermischtes"),
    MOTOR("motor"),
    REISE("reise"),
    REGIONAL("regionales"),
    MEINUNG("debatte");

    private final String ressortPath;

    Ressorts(String ressortPath) {
        this.ressortPath = ressortPath;
    }

    public String ressortPath() {
        return this.ressortPath;
    }
}
