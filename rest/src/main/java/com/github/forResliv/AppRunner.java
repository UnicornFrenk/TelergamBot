package com.github.forResliv;

import com.github.forResliv.configuration.DaoConfiguration;
import com.github.forResliv.configuration.ServiceConfiguration;
import com.github.forResliv.configuration.TelegramBotConfiguration;
import com.github.forResliv.configuration.RestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import({DaoConfiguration.class, ServiceConfiguration.class, TelegramBotConfiguration.class,
        RestConfiguration.class})

public class AppRunner extends SpringBootServletInitializer {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(AppRunner.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AppRunner.class);
    }
}
