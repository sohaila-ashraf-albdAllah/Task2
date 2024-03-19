import org.example.DocPage;
import org.example.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LevelsetTest {
    private WebDriver driver;

    @Test
    public void checkPrice()
    {
        driver = new FirefoxDriver();
        HomePage homePage = new HomePage(driver);
        DocPage docPage = new DocPage(driver, "$449");
        homePage.navigateTOHome();
        boolean flag = docPage.buyDoc();
        System.out.println(flag);
        Assert.assertTrue(flag, "Flag is not true");
    }
    @AfterTest
    public void quit(){
        driver.close();
    }
}
