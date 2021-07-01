package com.github.sebPasieka.weltCrawler.service;


public class WeltCrawler {
    public String getRessort(String[] args) {
        String ressort = "";
        for (String i : args) {
            if (!checkIfStringContainsNumber(i)) {
                ressort = i;
            }
        }
        return ressort;
    }

    public int getNumber(String[] args) {
        int number = 0;
        for (String i : args) {
            if (checkIfStringContainsNumber(i)) {

                number = Integer.parseInt(i);
            }
        }
        return number;
    }

    public boolean checkIfStringContainsNumber(String arg) {
        try {
            int intArgument = Integer.parseInt(arg);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
