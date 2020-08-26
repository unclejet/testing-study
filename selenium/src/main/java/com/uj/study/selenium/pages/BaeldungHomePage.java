package com.uj.study.selenium.pages;

import com.uj.study.selenium.config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaeldungHomePage {

    private SeleniumConfig config;
//    @FindBy(css=".header--menu > a")
    @FindBy(xpath = "/html/head/title")
    private WebElement title;
    @FindBy(css = ".menu-start-here > a")
    private WebElement startHere;

    public BaeldungHomePage(SeleniumConfig config) {
        this.config = config;
        PageFactory.initElements(this.config.getDriver(), this);
    }

    public void navigate() {
        this.config.navigateTo("http://www.baeldung.com/");
    }

    public String getPageTitle() {
//        return title.getAttribute("title");
//        return config.getDriver().findElement(By.xpath("/html/head/title")).getText();
        return title.getText();
    }

    public StartHerePage clickOnStartHere() {
        config.clickElement(startHere);

        StartHerePage startHerePage = new StartHerePage(config);
        PageFactory.initElements(config.getDriver(), startHerePage);

        return startHerePage;
    }
}
