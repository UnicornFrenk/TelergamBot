package com.github.forResliv.configuration;

import com.github.forResliv.bot.TelegramBot;
import com.github.forResliv.bot.TelegramBotProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@Configuration
@PropertySource("classpath:bot.properties")
public class TelegramBotConfiguration {

    @Autowired
    private ServiceConfiguration serviceConfig;

    public TelegramBotConfiguration(ServiceConfiguration serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    @Bean
    public TelegramBotsApi getTelegramBotsApi() {
        return new TelegramBotsApi();
    }


    @Bean
    public TelegramBot getBot(TelegramBotsApi telegramBotsApi, TelegramBotProperty botProperty) {
        return new TelegramBot(telegramBotsApi, botProperty, serviceConfig.getCityService());
    }

    @Bean
    public TelegramBotProperty getBotProperty() {
        return new TelegramBotProperty();
    }

}
