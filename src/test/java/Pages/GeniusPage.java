package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class GeniusPage {
    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;

    public GeniusPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        PageFactory.initElements(driver, this);
    }

    // METODE

    public boolean verifyGeniusURL()
    {
        elementsMethods.verifyUrl("https://www.emag.ro/genius?ref=hdr_genius");
        return false;
    }

    public void clickOnEmagDetails() {
        WebElement shadowHost = driver.findElement(By.tagName("emag-genius"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement emagDetails = shadowRoot.findElement(By.cssSelector("#headlessui-tabs-tab-1 > i"));

        elementsMethods.waitForElementToBeClickable(emagDetails);
        elementsMethods.clickOnElement(emagDetails);
        javascriptMethods.scrollByPixels(500);
        ChainTestListener.log("Accessed eMAG tab.");
    }

    public void clickOnTazzDetails() {
        WebElement shadowHost = driver.findElement(By.tagName("emag-genius"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement tazzDetails = shadowRoot.findElement(By.cssSelector("#headlessui-tabs-tab-2 > i"));

        elementsMethods.waitForElementToBeClickable(tazzDetails);
        elementsMethods.clickOnElement(tazzDetails);
        ChainTestListener.log("Accessed Tazz tab.");
    }

    public void clickOnFashionDaysDetails() {
        WebElement shadowHost = driver.findElement(By.tagName("emag-genius"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement fashionDaysDetails = shadowRoot.findElement(By.cssSelector("#headlessui-tabs-tab-3 > i"));

        elementsMethods.waitForElementToBeClickable(fashionDaysDetails);
        elementsMethods.clickOnElement(fashionDaysDetails);
        ChainTestListener.log("Accessed Fashion Days tab.");
    }

    public void clickOnFreshfulDetails() {
        WebElement shadowHost = driver.findElement(By.tagName("emag-genius"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement freshfulDetails = shadowRoot.findElement(By.cssSelector("#headlessui-tabs-tab-4 > i"));

        elementsMethods.waitForElementToBeClickable(freshfulDetails);
        elementsMethods.clickOnElement(freshfulDetails);
        ChainTestListener.log("Accessed Freshful tab.");
    }

    public void clickOnTryFor3Months() {
        WebElement shadowHost = driver.findElement(By.tagName("emag-genius"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement tryFor3Months = shadowRoot.findElement(By.cssSelector("div > div > div.main > div > div:nth-child(5) > button"));

        elementsMethods.waitUntilElementIsPresent(tryFor3Months);
        elementsMethods.clickOnElement(tryFor3Months);
        ChainTestListener.log("Clicked on 'Incearca gratuit 3 luni' button.");

        elementsMethods.waitForSeconds(2);
    }

    public void moveEmagSlider() {
        WebElement shadowHost = driver.findElement(By.tagName("emag-genius"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement emagSlider = shadowRoot.findElement(By.cssSelector("div > div > div.main > div > div.savings-calculator.lg-breakpoint.savings-calculator > fieldset > div:nth-child(2) > label > div.savings-calculator-input.input"));

        elementsMethods.waitUntilElementIsPresent(emagSlider);
        elementsMethods.moveSlider(emagSlider, 50);
    }

    public void moveFashionDaysSlider() {
        WebElement shadowHost = driver.findElement(By.tagName("emag-genius"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement fashionDaysSlider = shadowRoot.findElement(By.cssSelector("div > div > div.main > div > div.savings-calculator.lg-breakpoint.savings-calculator > fieldset > div:nth-child(3) > label > div.savings-calculator-input.input"));

        elementsMethods.waitUntilElementIsPresent(fashionDaysSlider);
        elementsMethods.moveSlider(fashionDaysSlider, 80);
    }

    public void moveTazzSlider() {
        WebElement shadowHost = driver.findElement(By.tagName("emag-genius"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement tazzSlider = shadowRoot.findElement(By.cssSelector("div > div > div.main > div > div.savings-calculator.lg-breakpoint.savings-calculator > fieldset > div:nth-child(4) > label > div.savings-calculator-input.input"));

        elementsMethods.waitUntilElementIsPresent(tazzSlider);
        elementsMethods.moveSlider(tazzSlider, 50);
    }

    public void moveFreshfulSlider() {
        WebElement shadowHost = driver.findElement(By.tagName("emag-genius"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement freshfulSlider = shadowRoot.findElement(By.cssSelector("div > div > div.main > div > div.savings-calculator.lg-breakpoint.savings-calculator > fieldset > div:nth-child(5) > label > div.savings-calculator-input.input"));

        elementsMethods.waitUntilElementIsPresent(freshfulSlider);
        elementsMethods.moveSlider(freshfulSlider, 70);
    }

    public String getTotal() {
        WebElement shadowHost = driver.findElement(By.tagName("emag-genius"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement economyTotal = shadowRoot.findElement(By.cssSelector("div > div > div.main > div > div.savings-calculator.lg-breakpoint.savings-calculator > div.output-price"));

        elementsMethods.waitUntilElementIsPresent(economyTotal);
        ChainTestListener.log("Economy Total: " + economyTotal.getText());
        return null;
    }
}
