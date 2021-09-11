package com.example.demo.steps;

import com.example.demo.services.ScreenShotService;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import java.io.IOException;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class stepHook {

    @Autowired
    private ScreenShotService screenShotService;

    @Autowired
    private ApplicationContext ctx;

    @After
    public void closingTest(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            this.screenShotService.takeScreenShot();
        }
        this.ctx.getBean(WebDriver.class).quit();
    }
}
