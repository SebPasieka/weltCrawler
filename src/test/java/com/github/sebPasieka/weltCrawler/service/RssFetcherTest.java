package com.github.sebPasieka.weltCrawler.service;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class RssFetcherTest {
    RssFetcher systemUnderTest = new RssFetcher();

    @Test
    public void rssFetcher_shouldCreateURLWithExistingRessortWithAlias() {
        String givenRessort = "Wissen";
        String actual = systemUnderTest.manageRessortAndReturnUrl(givenRessort);
        String expect = "https://www.welt.de/feeds/section/wissenschaft.rss";

        Assert.assertEquals(expect ,actual);
    }

    @Test
    public void rssFetcher_shouldCreateURLWithExistingRessortWithoutAlias() {
        String givenRessort = "Politik";
        String actual = systemUnderTest.manageRessortAndReturnUrl(givenRessort);
        String expect = "https://www.welt.de/feeds/section/politik.rss";

        Assert.assertEquals(expect ,actual);
    }

    @Test
    public void rssFetcher_shouldShowThatRessortDontExist() {
        String givenRessort = "BILD";

        Assert.assertThrows(IllegalArgumentException.class, () -> systemUnderTest.manageRessortAndReturnUrl(givenRessort));
    }

    @Test
    public void rssFetcher_shouldReturnRssFeed() throws IOException {
        String givenRessort = "Wissen";

        String rssFeed = systemUnderTest.fetchXML(givenRessort);
        int actual = rssFeed.length();
        int expect = 0;

        Assert.assertNotEquals(expect, actual);
    }

    @Test
    public void rssFetcher_fetchLatestRssFeedIfNoRessortGiven() throws IOException {
        String givenRessort = "";

        String actual = systemUnderTest.manageRessortAndReturnUrl(givenRessort);
        String expect = "https://www.welt.de/feeds/latest.rss";


        Assert.assertEquals(expect, actual);
    }
}
