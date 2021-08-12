package com.github.sebPasieka.weltCrawler.service;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProcessInput {
    public String getRessort(List<String> args) {
        String ressort = "";
        for (String i : args) {
            if (!checkIfStringContainsNumber(i)) {
                ressort = i;
            }
        }
        return ressort;
    }
    public String getRessort(String[] args) {
        return getRessort(Arrays.asList(args));
    }

    public int getNumber(List<String> args) {
        int number = 0;
        for (String i : args) {
            if (checkIfStringContainsNumber(i)) {

                number = Integer.parseInt(i);
            }
        }
        return number;
    }
    public int getNumber(String[] args) {
        return getNumber(Arrays.asList(args));
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
