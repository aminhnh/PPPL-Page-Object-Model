import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {
    WebDriver driver;
    public static String BASE_URL = "https://practicetestautomation.com/practice-test-login/";
    @BeforeEach
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get(BASE_URL);
    }
    @AfterEach
    public void terminateBrowser() {
        driver.quit();
        this.driver = null;
    }
    @Test
    public void positiveLoginTest() {
        LoginPage login = new LoginPage(driver);

        login.setUsername("student");
        login.setPassword("Password123");
        ResultPage resultPage =  login.clickSubmit();

        assertAll(
                () -> assertEquals("Logged In Successfully | Practice Test Automation", resultPage.getWebTitle()),
                () -> assertEquals("https://practicetestautomation.com/logged-in-successfully/", resultPage.getCurrentUrl()),
                () -> assertTrue(resultPage.getPageSource().contains("Congratulations")),
                () -> assertTrue(resultPage.isLogoutButtonDisplayed())
        );
    }
    @Test
    public void negativeUsernameTest() {
        LoginPage login = new LoginPage(driver);

        login.setUsername("incorrectUser");
        login.setPassword("Password123");
        ResultPage resultPage =  login.clickSubmit();

        assertAll(
                () -> assertEquals("Test Login | Practice Test Automation", resultPage.getWebTitle()),
                () -> assertEquals(BASE_URL, resultPage.getCurrentUrl()),
                () -> assertTrue(resultPage.getPageSource().contains("Your username is invalid!"))
        );
    }
    @Test
    public void negativePasswordTest() {
        LoginPage login = new LoginPage(driver);

        login.setUsername("student");
        login.setPassword("incorrectPassword");
        ResultPage resultPage =  login.clickSubmit();

        assertAll(
                () -> assertEquals("Test Login | Practice Test Automation", resultPage.getWebTitle()),
                () -> assertEquals(BASE_URL, resultPage.getCurrentUrl()),
                () -> assertTrue(resultPage.getPageSource().contains("Your password is invalid!"))
        );
    }
}
