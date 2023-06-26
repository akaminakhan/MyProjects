package demo;

import java.util.List;
//import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.BrowserType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.Select;

public class imageUrls {
    ChromeDriver driver;

    public imageUrls() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testcase01() {
        System.out.println("Start Test case: testcase01");
        driver.get(" https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> recommendedMovies = driver
                .findElements(By.xpath("(//div[(@class = 'sc-lnhrs7-0 hCzkOF')])[1]//img"));
        for (WebElement movieImage : recommendedMovies) {
            String imageURL = movieImage.getAttribute("src");
            System.out.println("Recommended Movie Image URL: " + imageURL);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement movieName = driver.findElement(By.xpath("(//div[contains(@class,'fyTNyu')])[2]"));
        String movieText = movieName.getText();
        System.out.println("Second Movie Name: " + movieText);

    }
}
