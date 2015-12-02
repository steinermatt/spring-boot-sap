package com.mlesniak.sap.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * Application entry point.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@EnableSwagger
@SpringBootApplication
public class Main extends SpringBootServletInitializer {
    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }

    public static void main(String[] args) {
        
    	SpringApplication app = new SpringApplication(Main.class);
    	
    	app.addInitializers(new EnvironmentContextInitializer());
    	
    	app.run(args);
    }

    /**
     * Configuration options for swagger, the REST API documentation tool.
     *
     * @return configuration
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        ApiInfo apiInfo = new ApiInfo(
                "MessageBoard API documentation",
                "Demo application for Spring-Boot and SAP HCP",
                "n/a",
                "mail@mlesniak.com",
                "n/a",
                "n/a");
        return new SwaggerSpringMvcPlugin(springSwaggerConfig)
                .apiInfo(apiInfo)
                .includePatterns("/rest/.*");
    }
}
