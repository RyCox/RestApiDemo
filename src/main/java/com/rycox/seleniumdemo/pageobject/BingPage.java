package com.rycox.seleniumdemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class BingPage {

    public By searchBox() {
        return By.id("sb_form_q");
    }

    public By searchButton() {
        return By.id("sb_form_go");
    }

    public void startASearch(WebDriver driver, String searchString) {
        driver.findElement(searchBox()).sendKeys(searchString);
        driver.findElement(searchButton()).click();
    }
}
