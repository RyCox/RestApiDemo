package com.rycox.seleniumdemo;

import com.rycox.configuration.EnvironmentConfiguration;
import com.rycox.seleniumdemo.pageobject.BingPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {EnvironmentConfiguration.class})
@TestPropertySource("classpath:test-${test.environment}.properties")
public class SeleniumBase {
    WebDriver driver;

    @Autowired
    private BingPage bingPage;

    @Before
    public void initialize() {
        driver = new FirefoxDriver();
    }

    @After
    public void cleanup() {
        driver.close();
    }


    @Test
    public void testBingSearch() {
        driver.get("https://bing.com");
        bingPage.startASearch(driver, "Alligators");
        Assert.assertEquals("Alligators", driver.findElement(bingPage.searchBox()).getAttribute("value"));
    }

}
