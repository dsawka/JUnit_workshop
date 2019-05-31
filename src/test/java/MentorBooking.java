import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

//***********Zadanie 4***********
public class MentorBooking {

    private WebDriver driver;
    private static final String URL = "https://men-men-s-01.codersguru.pl/";
    private static final String EMAIL_INPUT_SENT = "main-page-top__email-input-sent";
    private static final String EMAIL_FIELD = "fos_user_registration_form_email";
    private static final String NAME_FIELD = "fos_user_registration_form_name";
    private static final String LAST_NAME_FIELD = "fos_user_registration_form_lastname";
    private static final String PASSWORD_FIELD = "fos_user_registration_form_plainPassword_first";
    private static final String PASSWORD_SECOND_FIELD = "fos_user_registration_form_plainPassword_second";
    private static final String CITY_FIELD = "form_city";
    private static final String POSTAL_CODE_FIELD = "form_postal_code";
    private static final String STREET_FIELD = "form_street";
    private static final String STREET_NUMBER_FIELD = "form_number";
    private static final String INPUT_CHECKBOX_FIELD = "//input[@type='checkbox']";
    private static final String REGISTER_SUBMIT_BTN = "register-submit-btn";
    private static final String LOGGED_USER_NAME = "user-name";

    private static String EMAIL_VALUE;
    private static final String NAME_VALUE = "Karol";
    private static final String LAST_NAME_VALUE = "Kowalski";
    private static final String PASSWORD_VALUE = "pass123";
    private static final String CITY_VALUE = "Kraków";
    private static final String POSTAL_CODE_VALUE = "30-001";
    private static final String STREET_VALUE = "Basztowa";
    private static final String STREET_NUMBER_VALUE = "66";



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
    public void generateEmailAdres() {
        driver.get("https://owlymail.com/en/#");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current-tmail-id")));
        EMAIL_VALUE = driver.findElement(By.id("current-tmail-id")).getText();
        System.out.println(EMAIL_VALUE);
    }

    @Test
    public void singUpAndBook() {
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.className(EMAIL_INPUT_SENT)).submit();
        driver.findElement(By.id(EMAIL_FIELD)).sendKeys(EMAIL_VALUE);
        driver.findElement(By.id(NAME_FIELD)).sendKeys(NAME_VALUE);
        driver.findElement(By.id(LAST_NAME_FIELD)).sendKeys(LAST_NAME_VALUE);
        driver.findElement(By.id(PASSWORD_FIELD)).sendKeys(PASSWORD_VALUE);
        driver.findElement(By.id(PASSWORD_SECOND_FIELD)).sendKeys(PASSWORD_VALUE);
        driver.findElement(By.id(CITY_FIELD)).sendKeys(CITY_VALUE);
        driver.findElement(By.id(POSTAL_CODE_FIELD)).sendKeys(POSTAL_CODE_VALUE);
        driver.findElement(By.id(STREET_FIELD)).sendKeys(STREET_VALUE);
        driver.findElement(By.id(STREET_NUMBER_FIELD)).sendKeys(STREET_NUMBER_VALUE);
        driver.findElement(By.xpath(INPUT_CHECKBOX_FIELD)).click();
        driver.findElement(By.id(REGISTER_SUBMIT_BTN)).click();
        String new_user = driver.findElement(By.id(LOGGED_USER_NAME)).getText();
        assertEquals(new_user, NAME_VALUE);
        driver.findElement(By.className("select-text-desktop")).click();
        List<WebElement> subjects = driver.findElements(By.tagName("li"));
        for (WebElement subject : subjects) {
            subject.getText();
            if (subject.getText().equals("GIT")) {
                subject.click();
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-page-top__select-btn")));
        driver.findElement(By.className("main-page-top__select-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
        driver.findElements(By.tagName("button")).get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dateSelect']/ul[1]/li[1]")));
        driver.findElement(By.xpath("//div[@id='dateSelect']/ul[1]/li[1]")).click();
        driver.findElement(By.xpath("//div[@id='hourSelect']/ul[1]/li[1]")).click();
        driver.findElement(By.tagName("textarea")).sendKeys("I have problem with GIT.");
        driver.findElement(By.xpath("//button[@class='reservation-modal__summary-button button']")).click();
        wait.until(ExpectedConditions.titleIs("PayU"));
        assertEquals("PayU", driver.getTitle());

    }

}
