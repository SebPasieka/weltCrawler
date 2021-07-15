package com.github.sebPasieka.weltCrawler;

import com.github.sebPasieka.weltCrawler.service.RssFetcher;
import com.github.sebPasieka.weltCrawler.service.RssReader;
import com.github.sebPasieka.weltCrawler.service.ProcessInput;
import com.github.sebPasieka.weltCrawler.view.TerminalOutput;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class.getPackageName());
        context.registerBean("simpleCommandLinePropertySource", SimpleCommandLinePropertySource.class, args);
    }
}
