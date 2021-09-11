package com.example.demo.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class DriverWait {

    @Value("${webDriver.Wait:30}")
    private int timeOut;

    @Bean
    public WebDriverWait webDriverWait(WebDriver webDriver){
        return new WebDriverWait(webDriver,this.timeOut);
    }
}
