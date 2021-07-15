package com.github.sebPasieka.weltCrawler.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RssReaderTest {

    RssReader systemUnderTest = new RssReader();

    String givenXml =
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<rss xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:media=\"http://search.yahoo.com/mrss/\" xmlns:welt=\"https://www.welt.de/spec\" version=\"2.0\">\n" +
                    "  <channel>\n" +
                    "    <title>Wissenschaft - WELT</title>\n" +
                    "    <link>https://www.welt.de/feeds/section/wissenschaft.rss</link>\n" +
                    "    <description>Wissenschaft - Aktuelle Nachrichten von WELT</description>\n" +
                    "    <language>de</language>\n" +
                    "    <pubDate>Tue, 13 Jul 2021 14:20:58 GMT</pubDate>\n" +
                    "    <image>\n" +
                    "      <title>Wissenschaft - WELT</title>\n" +
                    "      <url>https://www.welt.de/rss-logo.png</url>\n" +
                    "      <link>https://www.welt.de/feeds/section/wissenschaft.rss</link>\n" +
                    "      <width>90</width>\n" +
                    "      <height>36</height>\n" +
                    "    </image>\n" +
                    "    <item>\n" +
                    "      <title>Vermehrung des Coronavirus lässt sich im Labor mit Crispr-Methode stoppen</title>\n" +
                    "      <link>https://www.welt.de/wissenschaft/article232478185/Australien-Vermehrung-des-Coronavirus-laesst-sich-im-Labor-mit-Crispr-Methode-stoppen.html</link>\n" +
                    "      <description>Wissenschaftler aus Australien konnten mithilfe der Gen-Schere Crispr dem Coronavirus Einhalt gebieten. Die Vermehrung von SARS-CoV-2 in einer Zelle wurde gestoppt. Bislang wurde die Methode jedoch nur unter Laborbedingungen getestet.</description>\n" +
                    "      <enclosure url=\"https://img.welt.de/img/wissenschaft/mobile232478679/1301621237-ci23x11-w780/227887503.jpg\" type=\"image/jpeg\" />\n" +
                    "      <category>Wissenschaft</category>\n" +
                    "      <pubDate>Tue, 13 Jul 2021 14:20:58 GMT</pubDate>\n" +
                    "      <guid>232478185</guid>\n" +
                    "      <welt:premium>false</welt:premium>\n" +
                    "      <dc:subject>Australien</dc:subject>\n" +
                    "      <welt:topic>Australien</welt:topic>\n" +
                    "      <dc:source>AFP/fav</dc:source>\n" +
                    "      <welt:source>AFP/fav</welt:source>\n" +
                    "      <media:group>\n" +
                    "        <media:content duration=\"126\" type=\"application/vnd.apple.mpegurl\" url=\"https://weltsfclips-vh.akamaihd.net/i/2021/07/13/20210713-070956_onl_MAZ_Impfpflicht_0705_oL/20210713-070956_onl_MAZ_Impfpflicht_0705_oL_,2000,1500,1000,200,.mp4.csmil/master.m3u8\" />\n" +
                    "        <media:content duration=\"126\" type=\"video/mp4\" url=\"https://weltn24sfthumb-a.akamaihd.net/2021/07/13/20210713-070956_onl_MAZ_Impfpflicht_0705_oL/20210713-070956_onl_MAZ_Impfpflicht_0705_oL_200.mp4\" />\n" +
                    "        <media:content duration=\"126\" type=\"video/mp4\" url=\"https://weltn24sfthumb-a.akamaihd.net/2021/07/13/20210713-070956_onl_MAZ_Impfpflicht_0705_oL/20210713-070956_onl_MAZ_Impfpflicht_0705_oL_1000.mp4\" />\n" +
                    "        <media:content duration=\"126\" type=\"video/mp4\" url=\"https://weltn24sfthumb-a.akamaihd.net/2021/07/13/20210713-070956_onl_MAZ_Impfpflicht_0705_oL/20210713-070956_onl_MAZ_Impfpflicht_0705_oL_1500.mp4\" />\n" +
                    "        <media:content duration=\"126\" type=\"video/mp4\" url=\"https://weltn24sfthumb-a.akamaihd.net/2021/07/13/20210713-070956_onl_MAZ_Impfpflicht_0705_oL/20210713-070956_onl_MAZ_Impfpflicht_0705_oL_2000.mp4\" />\n" +
                    "      </media:group>\n" +
                    "    </item>\n" +
                    "    <item>\n" +
                    "      <title>„Wenn Sie Ihr Gehirn nicht benutzen, wird es schneller absterben“</title>\n" +
                    "      <link>https://www.welt.de/wissenschaft/plus232473957/Demenz-Wenn-Sie-Ihr-Gehirn-nicht-benutzen-wird-es-schneller-absterben.html</link>\n" +
                    "      <description>Viele von uns kennen es: Man verlegt den Schlüssel, erinnert sich nicht mehr an Namen oder vergisst einen Termin. Doch wann werden solche Symptome bedenklich? Ein Neurologe erklärt, was vorbeugend hilft – und warum ein Gentest nur bedingt empfehlenswert ist. (Videos und Transkript)</description>\n" +
                    "      <enclosure url=\"https://img.welt.de/img/wissenschaft/mobile232398915/7091627097-ci23x11-w780/217736306-jpg.jpg\" type=\"image/jpeg\" />\n" +
                    "      <category>Wissenschaft</category>\n" +
                    "      <pubDate>Tue, 13 Jul 2021 12:21:28 GMT</pubDate>\n" +
                    "      <author>Tanja Boldt</author>\n" +
                    "      <guid>232473957</guid>\n" +
                    "      <welt:premium>true</welt:premium>\n" +
                    "      <dc:creator>Tanja Boldt</dc:creator>\n" +
                    "      <dc:subject>Demenz</dc:subject>\n" +
                    "      <welt:topic>Demenz</welt:topic>\n" +
                    "    </item>\n" +
                    "    </channel>\n" +
                    "</rss>";

    @Test
    public void readXml_shouldReadXmlAndReturnAllArticles() {
        List<RssReader.Article> articleList = systemUnderTest.readMXL(givenXml, 0);

        Assert.assertEquals(2, articleList.size());
    }
    @Test
    public void readXml_shouldReadXmlAndReturnMaxArticles() {
        List<RssReader.Article> articleList = systemUnderTest.readMXL(givenXml, 1);

        Assert.assertEquals(1, articleList.size());
    }

    @Test
    public void readXml_shouldReturnEmptyListIfXmlIsNotFound() {
        String emptyXml = "";
        List<RssReader.Article> articleList = systemUnderTest.readMXL(emptyXml, 0);

        Assert.assertTrue(articleList.isEmpty());
    }

    @Test
    public void readXml_shouldReturnArticleWithoutAuthorIfXmlDoesNotContainAuthor() {
        List<RssReader.Article> articleList = systemUnderTest.readMXL(givenXml, 1);

        for (RssReader.Article article : articleList) {
            Assert.assertNull(article.getArticleAuthor());
        }
    }


}