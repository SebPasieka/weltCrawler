package com.github.sebPasieka.weltCrawler.view;

import com.github.sebPasieka.weltCrawler.service.RssReader;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class ServerOutput {

    public ContextHandler serverPrint(List< RssReader.Article> articles) throws Exception {
        final ContextHandler context = new ContextHandler("/api/content");
        context.setHandler(new AbstractHandler() {

            @Override
            public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
                for (RssReader.Article article : articles) {
                    if (article.getArticleCategory() != null) {
                        response.getWriter().println(article.getArticleCategory());
                    }

                    response.getWriter().println(article.getArticleTitle());
                    response.getWriter().println(article.getArticlePubDate());
                    if (article.getArticleDescription() != null) {
                        response.getWriter().println(article.getArticleDescription());
                    }

                    if (article.getArticleAuthor() != null) {
                        response.getWriter().println(article.getArticleAuthor());
                    }

                    response.getWriter().println(article.getArticleLink());
                }

                baseRequest.setHandled(true);
            }
        });
        return context;
    }

}
