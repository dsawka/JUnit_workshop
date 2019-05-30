import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//**********ZADANIE 1*********
public class CodersGuru {

    private static final String URL = "https://men-men-s-01.codersguru.pl/";
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/damian/IDEA/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void goToCodersGuruLinks() {
        driver.get(URL);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<String> linkList = new ArrayList<>();
        for (WebElement link : links) {
            String name = link.getAttribute("href");
            assertTrue(linkList.add(name));
        }
        for (String linkAdres : linkList) {
            driver.get(linkAdres);
            if (linkAdres.contains("@")) {
                System.out.println(linkAdres);
            } else {
                assertEquals(linkAdres, driver.getCurrentUrl());
            }
        }

    }

}
