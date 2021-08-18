package com.github.sebPasieka.weltCrawler.view;

import com.github.sebPasieka.weltCrawler.service.RssFetcher;
import com.github.sebPasieka.weltCrawler.service.RssReader;
import com.google.gson.Gson;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Component
public class ServerOutput extends ContextHandler{

    private final RssFetcher fetcher;
    private final RssReader reader;

    @Autowired
    public ServerOutput(RssFetcher fetcher, RssReader reader) {
        super("/api/search");
        this.fetcher = fetcher;
        this.reader = reader;
        this.setHandler(createAbstractHandler());
    }

    public static class ArticleSchema {

        public List<RssReader.Article> articles;

    }

    private AbstractHandler createAbstractHandler() {
        return new AbstractHandler() {

            @Override
            public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
                String ressort = request.getParameter("ressort");
                String stringNumber = request.getParameter("number");
                int number = 0;

                if (stringNumber != null) {
                    number = Integer.parseInt(stringNumber);
                }

                String rssFeed = fetcher.fetchXML(ressort);
                List<RssReader.Article> articles = reader.readMXL(rssFeed, number);

                response.setCharacterEncoding("UTF-8");
                response.addHeader("Content-Type", "application/json" );
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "GET, POST");
                response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type, Authorization");

                PrintWriter writer = response.getWriter();

                Gson gson = new Gson();

                ArticleSchema schema = new ArticleSchema();
                schema.articles = articles;

                gson.toJson(schema, writer);

                writer.flush();

                baseRequest.setHandled(true);
            }
        };
    }
}
