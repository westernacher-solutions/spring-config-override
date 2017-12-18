package com.westernacher.sample.configoverride;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringConfigOverrideApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {

        final String[] myArgs = new String[]{"--spring.config.location=classpath:/override.yml,classpath:/override-extra.yml"};
        SpringApplication.run(SpringConfigOverrideApplication.class, myArgs);
    }

    @Autowired
    public void logConfig(@Value("${mainkey}") String mainValue, @Value("${extrakey}") String extraValue) {
        logger.info("main: {}, extra: {}", mainValue, extraValue);
    }
}
