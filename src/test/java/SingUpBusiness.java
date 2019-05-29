import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

//*****ZADANIE 2******
public class SingUpBusiness {

    private static final String URL = "https://men-men-s-01.codersguru.pl/";
    private static final String EMAIL_INPUT_SENT = "main-page-top__email-input-sent";
    private static final String COMPANY_BUTTON_ID = "company";
    private static final String EMAIL_FIELD = "fos_user_registration_form_email";
    private static final String NAME_FIELD = "fos_user_registration_form_name";
    private static final String LAST_NAME_FIELD = "fos_user_registration_form_lastname";
    private static final String PASSWORD_FIELD = "fos_user_registration_form_plainPassword_first";
    private static final String PASSWORD_SECOND_FIELD = "fos_user_registration_form_plainPassword_second";
    private static final String CITY_FIELD = "form_city";
    private static final String POSTAL_CODE_FIELD = "form_postal_code";
    private static final String STREET_FIELD = "form_street";
    private static final String STREET_NUMBER_FIELD = "form_number";
    private static final String COMPANY_NAME_FIELD = "fos_user_registration_form_company_name";
    private static final String NIP_FIELD = "fos_user_registration_form_nip";
    private static final String INPUT_CHECKBOX_FIELD = "//input[@type='checkbox']";
    private static final String REGISTER_SUBMIT_BTN = "register-submit-btn";
    private static final String LOGGED_USER_NAME = "user-name";

    private static final String EMAIL_VALUE = "coders@lab.pl";
    private static final String NAME_VALUE = "Karol";
    private static final String LAST_NAME_VALUE = "Kowalski";
    private static final String PASSWORD_VALUE = "pass123";
    private static final String CITY_VALUE = "Kraków";
    private static final String POSTAL_CODE_VALUE = "30-001";
    private static final String STREET_VALUE = "Basztowa";
    private static final String STREET_NUMBER_VALUE = "66";
    private static final String COMPANY_NAME_VALUE = "Coders Lab";

    private static String RANDOM_NIP_VALUE;
    private static String NEW_USER;


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
    public void getNipNumber() {
        driver.get("http://generatory.it/");
        driver.findElement(By.className("material-icons")).click();
        RANDOM_NIP_VALUE = driver.findElement(By.id("nipBox")).getText();
        System.out.println(RANDOM_NIP_VALUE);

    }

    @Test
    public void signUpCodersGuruBusiness() {
        driver.get(URL);
        driver.findElement(By.className(EMAIL_INPUT_SENT)).submit();
        driver.findElement(By.id(COMPANY_BUTTON_ID)).click();
        driver.findElement(By.id(EMAIL_FIELD)).sendKeys(EMAIL_VALUE);
        driver.findElement(By.id(NAME_FIELD)).sendKeys(NAME_VALUE);
        driver.findElement(By.id(LAST_NAME_FIELD)).sendKeys(LAST_NAME_VALUE);
        driver.findElement(By.id(PASSWORD_FIELD)).sendKeys(PASSWORD_VALUE);
        driver.findElement(By.id(PASSWORD_SECOND_FIELD)).sendKeys(PASSWORD_VALUE);
        driver.findElement(By.id(CITY_FIELD)).sendKeys(CITY_VALUE);
        driver.findElement(By.id(POSTAL_CODE_FIELD)).sendKeys(POSTAL_CODE_VALUE);
        driver.findElement(By.id(STREET_FIELD)).sendKeys(STREET_VALUE);
        driver.findElement(By.id(STREET_NUMBER_FIELD)).sendKeys(STREET_NUMBER_VALUE);
        driver.findElement(By.id(COMPANY_NAME_FIELD)).sendKeys(COMPANY_NAME_VALUE);
        driver.findElement(By.id(NIP_FIELD)).sendKeys(RANDOM_NIP_VALUE);
        driver.findElement(By.xpath(INPUT_CHECKBOX_FIELD)).click();
        driver.findElement(By.id(REGISTER_SUBMIT_BTN)).click();
        NEW_USER = driver.findElement(By.id(LOGGED_USER_NAME)).getText();
        assertEquals(NEW_USER, NAME_VALUE);
    }

}