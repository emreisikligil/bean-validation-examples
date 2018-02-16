package org.emreisikligil.validation.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(value = {@PropertySource(value = "classpath:/ws.properties", ignoreResourceNotFound = true),
    @PropertySource(value = "file:${demo.config.path}/config.properties", ignoreResourceNotFound = true)})
public class DemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}