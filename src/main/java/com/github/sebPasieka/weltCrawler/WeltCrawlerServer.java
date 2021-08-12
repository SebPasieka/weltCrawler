package com.github.sebPasieka.weltCrawler;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.springframework.stereotype.Component;

@Component
public class WeltCrawlerServer {

    public void startServer(ContextHandler context) throws Exception {
        final String port = System.getenv().getOrDefault("PORT", "8080");
        final Server server = new Server(Integer.parseInt(port));
        server.setHandler(context);
        server.start();
        server.join();
    }
}
