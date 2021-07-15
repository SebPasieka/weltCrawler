package com.github.sebPasieka.weltCrawler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(CustomCommandLinePropertySource.class, () -> new CustomCommandLinePropertySource(args));
        context.scan(App.class.getPackageName());
        context.refresh();
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
