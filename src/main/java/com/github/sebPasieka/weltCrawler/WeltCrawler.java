package com.github.sebPasieka.weltCrawler;

import com.github.sebPasieka.weltCrawler.App.CustomCommandLinePropertySource;
import com.github.sebPasieka.weltCrawler.service.ProcessInput;
import com.github.sebPasieka.weltCrawler.service.RssFetcher;
import com.github.sebPasieka.weltCrawler.service.RssReader;
import com.github.sebPasieka.weltCrawler.service.RunServer;
import com.github.sebPasieka.weltCrawler.view.ServerOutput;
import com.github.sebPasieka.weltCrawler.view.TerminalOutput;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class WeltCrawler {

    private final ProcessInput processInput;
    private final RssFetcher fetcher;
    private final RssReader reader;
    private final TerminalOutput output;
    private final CustomCommandLinePropertySource cli;
    private final ServerOutput serverOutput;
    private final RunServer runServer;

    @Autowired
    public WeltCrawler(ProcessInput processInput, RssFetcher fetcher, RssReader reader, TerminalOutput output, CustomCommandLinePropertySource cli, ServerOutput serverOutput, RunServer runServer) {
        this.processInput = processInput;
        this.fetcher = fetcher;
        this.reader = reader;
        this.output = output;
        this.cli = cli;
        this.serverOutput = serverOutput;
        this.runServer = runServer;
    }

    public void crawlWelt() throws Exception {
        List<String> args = cli.getNonOptionArgs();
        String ressort = processInput.getRessort(args);
        int number = processInput.getNumber(args);

        String rssFeed = null;
        try {
            rssFeed = fetcher.fetchXML(ressort);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<RssReader.Article> articles = reader.readMXL(rssFeed, number);

        //output.print(articles);
        ContextHandler content = serverOutput.serverPrint(articles);
        runServer.startServer(content);
    }
}
