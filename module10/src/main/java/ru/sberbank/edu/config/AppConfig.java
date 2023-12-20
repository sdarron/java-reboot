package ru.sberbank.edu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc // нужен так как настраиваем WebMvcConfigurer
@ComponentScan("ru.sberbank.edu")
public class AppConfig {
}
