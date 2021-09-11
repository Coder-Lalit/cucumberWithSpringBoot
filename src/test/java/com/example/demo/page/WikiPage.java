package com.example.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WikiPage extends BasePage {

    @FindBy(id = "searchInput")
    public WebElement searchInput;

    @FindBy(xpath = "//button/i[text()='Search']")
    public WebElement searchIcon;

    public void search(String data){
        searchInput.clear();
        searchInput.sendKeys(data);
        searchIcon.click();
    }
}
