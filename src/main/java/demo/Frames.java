package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Frames {
    ChromeDriver driver;

    public Frames() {
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
        //Open Url  "https://the-internet.herokuapp.com/nested_frames'"
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //switchToFrame("parent_frame") Using Locator "Tag Name" "frame-top"
        driver.switchTo().frame("frame-top");

        //switchToFrame("middle") & print Using Locator "Name" "//frame[@name='frame-left']"
        driver.switchTo().frame("frame-middle");
        String middleText = driver.findElement(By.xpath("//div[@id='content']")).getText();
        System.out.println(middleText);

        driver.switchTo().parentFrame();
        //driver.switchTo().frame("frame-top");

        //switchToFrame("left") & print Using Locator "Name" "//frame[@name='frame-left']"
        driver.switchTo().frame("frame-left");
        String leftText = driver.findElement(By.tagName("body")).getText();
        System.out.println(leftText);

        driver.switchTo().parentFrame();
        //driver.switchTo().frame("frame-top");

        //switchToFrame("right") & print Using Locator "Name" "//frame[@name='frame-right']"
        driver.switchTo().frame("frame-right");
        WebElement rightText = driver.findElement(By.tagName("body"));
        System.out.println(rightText.getText());

        driver.switchTo().defaultContent();
        //switchToFrame("bottom) & print Using Locator "Name" "frame-bottom"
        driver.switchTo().frame("frame-bottom");
        WebElement bottomText = driver.findElement(By.tagName("body"));
        System.out.println(bottomText.getText());

    }

}