import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
    private WebDriver driver;
    By logoutButton = By.linkText("Log out");
    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getWebTitle() {
        return driver.getTitle();
    }
    public String getPageSource() {
        return driver.getPageSource();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public WebElement getLogoutButton() {
        return driver.findElement(logoutButton);
    }

    public void clickLogout() {
        getLogoutButton().click();
    }

    public boolean isLogoutButtonDisplayed() {
        return getLogoutButton().isDisplayed();
    }
}
