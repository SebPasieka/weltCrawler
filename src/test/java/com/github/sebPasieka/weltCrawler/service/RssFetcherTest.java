package com.github.sebPasieka.weltCrawler.service;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class RssFetcherTest {
    RssFetcher systemUnderTest = new RssFetcher();

    @Test
    public void testCreateURLWithExistingRessortWithAlias() {
        String givenRessort = "Wissen";
        String actual = systemUnderTest.manageRessortAndReturnUrl(givenRessort);
        String expect = "https://www.welt.de/feeds/section/wissenschaft.rss";

        Assert.assertEquals(expect ,actual);
    }

    @Test
    public void testCreateURLWithExistingRessortWithoutAlias() {
        String givenRessort = "Politik";
        String actual = systemUnderTest.manageRessortAndReturnUrl(givenRessort);
        String expect = "https://www.welt.de/feeds/section/politik.rss";

        Assert.assertEquals(expect ,actual);
    }

    @Test
    public void testShowThatRessortDontExist() {
        String givenRessort = "BILD";

        Assert.assertThrows(IllegalArgumentException.class, () -> systemUnderTest.manageRessortAndReturnUrl(givenRessort));
    }

    @Test
    public void testCreateRssFeedFileWhichIsNotEmpty() throws IOException {
        String givenRessort = "Wissen";
        File file = new File("rssFeed.xml");

        file.delete();
        systemUnderTest.fetchXML(givenRessort);

        Assert.assertTrue(file.exists());
        Assert.assertNotEquals(0, file.length());
    }
}
