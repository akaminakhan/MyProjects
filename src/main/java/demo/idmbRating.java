package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.remote.BrowserType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.openqa.selenium.support.ui.Select;


public class idmbRating {
    ChromeDriver driver;
    public idmbRating()
    {
        System.out.println("Constructor: idmbRating");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testcase01(){
        System.out.println("Start Test case: testcase01");
        driver.get("https://www.imdb.com/chart/top");
        WebElement highRatedMovieElement = driver.findElement(By.xpath("//table[@data-caller-name='chart-top250movie']//tr[1]/td[@class='ratingColumn imdbRating']/strong"));
        String highestRatedMovie = highRatedMovieElement.getText();
        System.out.println("Highest rated movie: " + highestRatedMovie);

        List<WebElement> movieElements = driver.findElements(By.xpath("//table[@data-caller-name='chart-top250movie']//tr[position()>1]"));
        int totalMovies = movieElements.size();
        System.out.println("Total movies: " + totalMovies);

        WebElement oldestMovieElement = driver.findElement(By.xpath("//table[@data-caller-name='chart-top250movie']//tr[2]/td[@class='titleColumn']/a"));
        String oldestMovie = oldestMovieElement.getText();
        System.out.println("Oldest movie: " + oldestMovie);

        WebElement mostRecentMovieElement = driver.findElement(By.xpath("//table[@data-caller-name='chart-top250movie']//tr[last()]/td[@class='titleColumn']/a"));
        String mostRecentMovie = mostRecentMovieElement.getText();
        System.out.println("Most recent movie: " + mostRecentMovie);




    }

}