package org.example;

import org.example.DocPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    public  HomePage(WebDriver dev)
    {
        this.driver = dev;
    }

    public void navigateTOHome(){
        driver.get("https://www.levelset.com/");
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[1]/header/div/div/div[2]/nav/ul/li[8]/a")));
        WebElement getPaidElement = driver.findElement(By.xpath("//div[1]/header/div/div/div[2]/nav/ul/li[8]/a"));
        new WebDriverWait(driver, Duration.ofSeconds(10));
        if(getPaidElement != null)
        {
            getPaidElement.click();
        }
        else
        {
            System.out.println("getPaidElement is NULL");
        }
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(DocPage.XpathElement)));
    }
}
