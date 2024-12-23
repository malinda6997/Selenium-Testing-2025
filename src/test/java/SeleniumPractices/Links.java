package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Links {

    WebDriver driver;

    @BeforeMethod
    public void openPage (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void linkTest(){

        //Take me to dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //Find my destination and find the URL without clicking me.
        WebElement whereToGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = whereToGo.getAttribute("href");
        System.out.println("This link is going to " + path);

        //Am I broken link?
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("This link is Broken");
        }
        else{
            System.out.println("This link is Not Broken");
        }
        driver.navigate().back();

        //Duplicate Link Go to Dashboard
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

       //Count Links How many links in this page?
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int countOfLinks = allLinks.size();
        System.out.println("This Page has " +countOfLinks + "Links");

        //Count Layout Links How many links in this layout?
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countLayout = layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of layout links" + countLayout.size());



    }
}
