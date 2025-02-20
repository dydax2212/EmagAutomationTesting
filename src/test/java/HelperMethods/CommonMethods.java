package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonMethods {

    WebDriver driver;
    ElementsMethods elementsMethods;

    public CommonMethods(WebDriver driver)
    {
        this.driver = driver;
        //this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver,this);
    }
    public boolean isDisplayed(WebElement element)
    {
        return element.isDisplayed();
    }



}
