package com.mlesniak.sap.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Application entry point.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@SpringBootApplication
public class Main extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }

    public static void main(String[] args) {
        new SpringApplication(Main.class).run(args);
    }
}
