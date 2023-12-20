package ru.edu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc // нужен так как настраиваем WebMvcConfigurer
@ComponentScan("ru.edu")
public class AppConfig {
}
