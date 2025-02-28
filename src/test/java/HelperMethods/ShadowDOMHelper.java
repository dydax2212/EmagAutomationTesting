package HelperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDOMHelper
{
    private WebDriver driver;

    public ShadowDOMHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getShadowElement(String shadowHostSelector, String shadowElementSelector) {
        WebElement shadowHost = driver.findElement(By.cssSelector(shadowHostSelector));
        return (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot.querySelector(arguments[1]);", shadowHost, shadowElementSelector);
    }

    public String getShadowElementText(String shadowHostSelector, String shadowElementSelector) {
        WebElement shadowElement = getShadowElement(shadowHostSelector, shadowElementSelector);
        return shadowElement.getText();
    }

    public void clickShadowElement(String shadowHostSelector, String shadowElementSelector) {
        WebElement shadowElement = getShadowElement(shadowHostSelector, shadowElementSelector);
        shadowElement.click();
    }

}
