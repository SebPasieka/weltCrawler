package com.github.sebPasieka.weltCrawler.service;

import org.junit.Assert;
import org.junit.Test;

public class RssFetcherTest {
    RssFetcher systemUnderTest = new RssFetcher();

    @Test
    public void testCreateURLWithExistingRessortWithAlias() {
        String givenRessort = "Wissen";
        String actual = systemUnderTest.manageInputAndReturnUrl(givenRessort);
        String expect = "https://www.welt.de/feeds/section/wissenschaft.rss";

        Assert.assertEquals(expect ,actual);
    }

    @Test
    public void testCreateURLWithExistingRessortWithoutAlias() {
        String givenRessort = "Politik";
        String actual = systemUnderTest.manageInputAndReturnUrl(givenRessort);
        String expect = "https://www.welt.de/feeds/section/politik.rss";

        Assert.assertEquals(expect ,actual);
    }

    @Test
    public void testShowThatRessortDontExist() {
        String givenRessort = "BILD";

        Assert.assertThrows(IllegalArgumentException.class, () -> systemUnderTest.manageInputAndReturnUrl(givenRessort));
    }

    @Test
    public void testStatusCodeToBe200() {

    }
}
