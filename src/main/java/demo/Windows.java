package demo;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
//import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.remote.BrowserType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.openqa.selenium.support.ui.Select;

public class Windows {
    ChromeDriver driver;

    public Windows() {
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
        driver.get(" https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().frame("iframeResult");

        WebElement tryButton = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryButton.click();

        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String childWindowURL = driver.getCurrentUrl();
        String childWindowTitle = driver.getTitle();

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "C:\\Users\\mukad\\Downloads\\screenshot.png";
        try {
            org.apache.commons.io.FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Child Window URL: " + childWindowURL);
        System.out.println("Child Window Title: " + childWindowTitle);

        driver.switchTo().window(parentWindowHandle);

        System.out.println("Current Window URL: " + driver.getCurrentUrl());
        System.out.println("Current Window Title: " + driver.getTitle());

    }

}