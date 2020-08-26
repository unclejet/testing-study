package com.uj.study.selenium.pages;

import com.uj.study.selenium.config.SeleniumConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartHerePage {

    private SeleniumConfig config;

    @FindBy(css = ".page-title")
    private WebElement title;

    public StartHerePage(SeleniumConfig config) {
        this.config = config;
    }

    public String getPageTitle() {
        return title.getText();
    }
}
