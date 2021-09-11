package com.example.demo.libraries;

import com.example.demo.LazyConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.net.URL;

@LazyConfig
@Profile("remote")
public class RemoteWebDriverLibrary {

    @Value("${grid.Url}")
    private URL gridUrl;

    @Bean
    @Scope("driverScope")
    @ConditionalOnProperty(name = "browser",havingValue = "chrome")
    public WebDriver getChromeDriver(){
        return new RemoteWebDriver(gridUrl,DesiredCapabilities.chrome());
    }

    @Bean
    @Scope("driverScope")
    @ConditionalOnProperty(name = "browser",havingValue = "firefox")
    public WebDriver getFirefoxDriver(){
        return new RemoteWebDriver(gridUrl,DesiredCapabilities.firefox());
    }

}
