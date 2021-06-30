package weltCrawler;

import org.junit.Assert;
import org.junit.Test;
import service.fetcher;

public class fetcherTest {
    fetcher systemUnderTest = new fetcher();

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
        String actual = systemUnderTest.createURL(givenRessort);
        String expect = "";

        Assert.assertEquals(expect, actual);
    }
}
