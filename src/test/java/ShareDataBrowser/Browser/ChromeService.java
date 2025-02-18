package ShareDataBrowser.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeService implements BrowserServiceInterface
{
    private WebDriver driver;

    @Override
    public void openBrowser()
    {
        ChromeOptions options = (ChromeOptions) browserOptions();
        driver = new ChromeDriver(options);
    }
    @Override
    public Object browserOptions()
    {
        String ci_cd = System.getProperty("ci_cd");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=2560,1440");
        options.addArguments("--disable-blink-features=BlockCredentialedSubresources");

        //These might help with CAPTCHAs:
        options.addArguments("--disable-features=IsolateOrigins,site-per-process"); // Avoid detection via site isolation
        options.addArguments("--disable-web-security"); // Might prevent some bot detections
        options.addArguments("--disable-popup-blocking"); // Allow popups (some CAPTCHAs use them)
        options.addArguments("--disable-features=MediaSessionService"); // Prevent fingerprinting
        options.addArguments("--disable-extensions"); // Some extensions trigger CAPTCHA detection

        // Optional: Set a real user-agent to avoid detection
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36 Edg/119.0.0.0");

        if (Boolean.parseBoolean(ci_cd))
            options.addArguments("--headless");

        return options;
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
