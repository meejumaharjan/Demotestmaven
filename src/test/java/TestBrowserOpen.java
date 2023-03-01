import Base.Baseclass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBrowserOpen {
    WebDriver driver;
    Baseclass b=new Baseclass();
    @Before
    public void Beforemethod()
    {
        driver=new ChromeDriver();

        driver.get(b.Url);

    }
    @Test
    public void Testmethod() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(b.link_Camera_xpath)).click();
        driver.findElement(By.xpath(b.link_Canon_xpath)).click();

        String Actual_title = driver.findElement(By.xpath(b.item_title_xpath)).getText();

        Assert.assertEquals(b.Expected_item_title, Actual_title);
        System.out.println("Test is Pass");
    }

    @After
    public void Aftermethod(){
        driver.close();
        driver.quit();

    }

}
