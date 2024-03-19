package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DocPage {
    WebDriver driver;
    public static String XpathElement = "(//div[@class=\"panel-heading left-right-pair\"])[3]";
    String price;
    public DocPage(WebDriver dev, String pr)
    {
        this.driver = dev;
        this.price = pr;
    }

    public boolean buyDoc(){
        boolean flag = false;
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(XpathElement)));
        String priceXpath = "((//div[@class=\"panel-heading left-right-pair\"])[3]/div[@class=\"right panel-heading--price\"]/span)[1][text()=\"%s\"]";
        String PriceText = String.format(priceXpath, price);

        WebElement getPriceElement = driver.findElement(By.xpath(PriceText));

        new WebDriverWait(driver, Duration.ofSeconds(10));

        if(getPriceElement != null)
        {
            flag = true;
        }
        return flag;
    }
}
