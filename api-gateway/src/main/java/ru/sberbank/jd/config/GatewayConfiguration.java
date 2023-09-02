package ru.sberbank.jd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties({AppProperties.class})
public class GatewayConfiguration {

    private final AppProperties properties;

    public GatewayConfiguration(AppProperties properties) {
        this.properties = properties;
    }

}
