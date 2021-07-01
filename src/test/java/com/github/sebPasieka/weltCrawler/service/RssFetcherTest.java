package com.github.sebPasieka.weltCrawler.service;

import org.junit.Assert;
import org.junit.Test;
import com.github.sebPasieka.weltCrawler.service.RssFetcher;

public class RssFetcherTest {
    RssFetcher systemUnderTest = new RssFetcher();

    @Test
    public void testCreateURLWithExistingRessort() {
        String givenRessort = "Wissen";
        String actual = systemUnderTest.createURL(givenRessort);
        String expect = "https://www.welt.de/feeds/section/wissenschaft.rss";

        Assert.assertEquals(expect ,actual);
    }

    @Test
    public void testShowThatRessortDontExist() {
        String givenRessort = "BILD";

        Assert.assertThrows(IllegalArgumentException.class, () -> systemUnderTest.createURL(givenRessort));
    }
}
