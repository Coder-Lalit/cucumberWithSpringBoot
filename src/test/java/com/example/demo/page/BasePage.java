package com.example.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

public abstract class BasePage {

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected WebDriverWait wait;

    @Value("${appUrl}")
    private String appUrl;

    public void goToApp(){
        this.webDriver.navigate().to(appUrl);
    }

    @PostConstruct
    public void init(){
        PageFactory.initElements(this.webDriver,this);
    }
}
