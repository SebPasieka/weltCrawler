package com.github.sebPasieka.weltCrawler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class App implements InitializingBean {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(CustomCommandLinePropertySource.class, () -> new CustomCommandLinePropertySource(args));
        context.scan(App.class.getPackageName());
        context.refresh();
    }

    private final WeltCrawler weltCrawler;

    @Autowired
    public App(WeltCrawler weltCrawler) {
        this.weltCrawler = weltCrawler;
    }

    public void execute() {
        weltCrawler.crawlWelt();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        execute();
    }

    public static class CustomCommandLinePropertySource extends SimpleCommandLinePropertySource {

        public CustomCommandLinePropertySource(String[] args) {
            super(args);
        }

        @Override
        public List<String> getNonOptionArgs() {
            return super.getNonOptionArgs();
        }

        @Override
        public List<String> getOptionValues(String name) {
            return super.getOptionValues(name);
        }
    }
}
