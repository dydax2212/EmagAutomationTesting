package HelperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementsMethods
{
    WebDriver driver;

    public ElementsMethods(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnElement(WebElement element)
    {
        element.click();
    }

    public void hoverOnElement(WebElement element)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void waitForElementToBeClickable(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollToHalfPage()
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2);");
        System.out.println("Successfully scrolled to the middle of the page.");
    }

    public void scrollToElement(WebElement element)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("Successfully scrolled to the element.");
    }

    public boolean isDisplayed(WebElement element)
    {
        return element.isDisplayed();
    }

    public void fillElement(WebElement element, String text)
    {
        Assert.assertTrue(isDisplayed(element));
        Assert.assertTrue(element.isDisplayed());

        String textelement = element.getText();
        Assert.assertTrue(textelement.isEmpty());
        element.sendKeys(text);
        Assert.assertTrue(!element.getText().isEmpty());
        Assert.assertTrue(element.getText().equals(text));
    }

}
