import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.id("submit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setUsername(String usernameInput) {
        driver.findElement(username).sendKeys(usernameInput);
    }
    public void setPassword(String passwordInput) {
        driver.findElement(password).sendKeys(passwordInput);
    }
    public ResultPage clickSubmit() {
        driver.findElement(loginButton).click();
        return new ResultPage(driver);
    }
}
