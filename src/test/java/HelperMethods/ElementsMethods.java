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
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Normal click failed, trying JS click for: " + element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
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

    public void waitUntilElementIsPresent(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try
        {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
        } catch (Exception e)
        {
            System.out.println("Element is not visible or interactable: " + e.getMessage());
        }
    }

    public void waitForSeconds(int seconds) {
        try
        {
            Thread.sleep(seconds * 500L);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void scrollToHalfPage()
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2);");
        System.out.println("Successfully scrolled to the middle of the page.");
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public boolean isDisplayed(WebElement element)
    {
        return element.isDisplayed();
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void fillElement(WebElement element, String text)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for element to be visible
        wait.until(ExpectedConditions.visibilityOf(element));

        Assert.assertTrue(element.isDisplayed());

        String textelement = element.getAttribute("value");
        Assert.assertTrue(textelement.isEmpty());

        element.sendKeys(text);

        // Wait for text to be updated in the input field
        wait.until(ExpectedConditions.attributeToBe(element, "value", text));

        Assert.assertTrue(!element.getAttribute("value").isEmpty());
        Assert.assertTrue(element.getAttribute("value").equals(text));
    }


}
