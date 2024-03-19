import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class googleStatesBar {
    String URL = "https://www.google.com/";
    String searchWord = "Test automation";
    By statesBar = By.id("result-stats");
    By searcharea = By.name("q");

    @Test
    public void testStatsBar()
    {

        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.findElement(searcharea).sendKeys(searchWord + Keys.ENTER);
        Assert.assertTrue(driver.findElement(statesBar).isDisplayed());
        Assert.assertTrue(driver.findElements(statesBar).contains("7000000"));
    //    driver.close();
    }
}
