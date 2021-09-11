package com.example.demo.services;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

@Lazy
@Service
public class ScreenShotService {

    @Value("${screenShot.path}")
    private String path;

    @Autowired
    private ApplicationContext ctx;

    public void takeScreenShot() throws IOException {
        File sourceScreenshot = ((TakesScreenshot) ctx.getBean(WebDriver.class)).getScreenshotAs(OutputType.FILE);
        String targetFileName = path+new SimpleDateFormat("yyyyMMddHHmm").format(new Date())+"-image.png";
        FileCopyUtils.copy(sourceScreenshot,new File(targetFileName));
    }

    public File getScreenShot() throws IOException {
        return ((TakesScreenshot) ctx.getBean(WebDriver.class)).getScreenshotAs(OutputType.FILE);
    }
}
