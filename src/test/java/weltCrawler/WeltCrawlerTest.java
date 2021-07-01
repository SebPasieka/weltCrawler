package weltCrawler;

import org.junit.Assert;
import org.junit.Test;

public class WeltCrawlerTest {
     WeltCrawler systemUnderTest = new WeltCrawler();

    @Test
    public void testRecognizeParameterAsNumber() {
        String[] givenArgs = {"Wissen", "42"};
        int actual = systemUnderTest.getNumber(givenArgs);
        int expect = 42;

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testRecognizeParameterAsString() {
        String[] givenArgs = {"42", "Wissen"};
        String actual = systemUnderTest.getRessort(givenArgs);
        String expect = "Wissen";

        Assert.assertEquals(expect, actual);
    }
}

