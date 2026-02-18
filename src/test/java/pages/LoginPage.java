package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='nav-user-section']")
    WebElement navLoginButton;

    @FindBy(id = "login-email")
    WebElement usernameField;

    @FindBy(id = "login-password")
    WebElement passwordField;

    @FindBy(id = "login-submit")
    WebElement loginButton;

    @FindBy(xpath = "//h2[contains(text(),'Welcome back, ')]")
    WebElement loginSuccessMessage;

    @FindBy(id = "login-card")
    WebElement loginCard;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickElement(WebElement element, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    private void typeText(WebElement element, String text, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    private boolean isElementVisible(WebElement element, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    private String getText(WebElement element, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element)).getText();
    }

    // ================= Methods =================
    public void clickNavLoginButton() { clickElement(navLoginButton, 10); }
    public void enterUsername(String username) { typeText(usernameField, username, 10); }
    public void enterPassword(String password) { typeText(passwordField, password, 10); }
    public void clickLoginButton() { clickElement(loginButton, 10); }
    public String getLoginSuccessMessage() { return getText(loginSuccessMessage, 10); }
    public boolean loginFailed() { return isElementVisible(loginCard, 10); }
}
