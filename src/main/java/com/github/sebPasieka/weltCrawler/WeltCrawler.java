package com.github.sebPasieka.weltCrawler;

import com.github.sebPasieka.weltCrawler.service.ProcessInput;
import com.github.sebPasieka.weltCrawler.service.RssFetcher;
import com.github.sebPasieka.weltCrawler.service.RssReader;
import com.github.sebPasieka.weltCrawler.view.TerminalOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class WeltCrawler implements ApplicationListener<ContextRefreshedEvent> {

    private final ProcessInput processInput;
    private final RssFetcher fetcher;
    private final RssReader reader;
    private final TerminalOutput output;
    private final SimpleCommandLinePropertySource cli;

    @Autowired
    public WeltCrawler(ProcessInput processInput, RssFetcher fetcher, RssReader reader, TerminalOutput output, SimpleCommandLinePropertySource cli) {
        this.processInput = processInput;
        this.fetcher = fetcher;
        this.reader = reader;
        this.output = output;
        this.cli = cli;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String ressort = null;// TODO processInput.getRessort(args);
        int number = 0;// TODO processInput.getNumber(args);

        String rssFeed = null;
        try {
            rssFeed = fetcher.fetchXML(ressort);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<RssReader.Article> articles = reader.readMXL(rssFeed, number);

        output.print(articles);
    }
}
