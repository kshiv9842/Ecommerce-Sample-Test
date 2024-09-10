package org.Shiv.driver;

import org.Shiv.utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void setupDriver() {
        driver = new ChromeDriver();
        driver.manage()
                .window()
                .maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("implicitTimeout.seconds"))));
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setupDriver();
            return driver;
        } else
            return driver;
    }

    public static void navigateURL(String url) {
        driver.get(url);
    }
    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public static String getTitle(){
        return driver.getTitle();
    }
}
