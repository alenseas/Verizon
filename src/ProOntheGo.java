import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProOntheGo {

    public static void main(String[] args) throws InterruptedException {
        ProOntheGoApp app = new ProOntheGoApp();
        app.run();
    }
}

class ProOntheGoApp {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProOntheGoApp() {
        System.setProperty("webdriver.gecko.driver", "E:\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    public void run() {
        try {
            driver.get(""); //vERIZON WEBSITE
            login();
            selectProduct();
            configureProduct();
            checkout();
            retrieveOrderInfo();
        } finally {
            driver.quit();
        }
    }

    private void login() {
        WebElement signInButton = driver.findElement(By.xpath("//button[@id='gnav20-sign-id-mobile']//span//span[contains(text(),'Sign in')]"));
        WebElement clickSign = driver.findElement(By.cssSelector("#gnav20-sign-id-list-item-1-mobile"));

        clickSign.click();
        WebElement userId = driver.findElement(By.cssSelector("#IDToken1"));
        userId.sendKeys("7138998035"); // Send MDN
        WebElement continueButton = driver.findElement(By.cssSelector("#continueBtn"));
        continueButton.click();
        WebElement password = driver.findElement(By.cssSelector("#IDToken2"));
        password.sendKeys(""); // Send password
        WebElement clickSignIn = driver.findElement(By.xpath("//button[@id='continueBtn']"));
        clickSignIn.click();
    }

    private void selectProduct() {
        driver.get("https://www.verizon.com/smartphones/apple-iphone-14-pro-max/");
        WebElement deepPurple = driver.findElement(By.xpath("//label[@for='clr12200029']//span[contains(@class,'h-9 w-9 rounded-full flex flex-0 border border-"));
        deepPurple.click();
        WebElement storage = driver.findElement(By.xpath("//span[contains(text(),'128 GB')]"));
        storage.click();
        WebElement addLine = driver.findElement(By.xpath("//span[contains(text(),'Adding a new line')]"));
        addLine.click();
    }

    private void configureProduct() {
        WebElement paymentOptions = driver.findElement(By.xpath("//span[@id='label-clm752d6k000m35bcfcu7y3xp']//span[@class='ChildWrapper-VDS__sc-n9jxr1-2 ieTKol']//div//div//div[@class='flex justify-between']"));
        paymentOptions.click();
        WebElement tradeIn = driver.findElement(By.xpath("//span[@id='label-clm74mzd3000435bcwjf8vseh']"));
        tradeIn.click();
        WebElement nextStepButton = driver.findElement(By.xpath("button[aria-label='Next steps'] span[class='HitArea-VDS__sc-bc3yhn-0 hpcSge']"));
        nextStepButton.click();
        WebElement selectAddLine = driver.findElement(By.xpath("//button[@aria-label='Add a Line']//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        selectAddLine.click();
        WebElement goToCart = driver.findElement(By.xpath("//button[@aria-label='Go to cart']//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        goToCart.click();
    }

    private void checkout() {
        WebElement continueIncart = driver.findElement(By.xpath("//button[@aria-label='Continue']//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        WebElement continueToGetNumber = driver.findElement(By.xpath("//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        continueToGetNumber.click();
        WebElement continueToChoose = driver.findElement(By.xpath("//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        continueToChoose.click();
        WebElement selectPopular = driver.findElement(By.cssSelector("div.ButtonWrapper-VDS__sc-mtl1r3-0.gxCfhc button#select_for_tile1 span.HitArea-VDS__sc-bc3yhn-0.fvPnCk"));
        selectPopular.click();
        WebElement confirm = driver.findElement(By.xpath("//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        confirm.click();
        WebElement proOnTheGo = driver.findElement(By.xpath("//span[normalize-space()='Pro On the Go']"));
        proOnTheGo.click();
        WebElement selectWindow = driver.findElement(By.xpath("//select[@id='6a678b67-dc02-4b6c-8c6b-0738db4287bd']"));
        Select select = new Select(selectWindow);
        select.selectByIndex(0);
        WebElement continueToOrder = driver.findElement(By.xpath("//button[@aria-label='Continue']//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        continueToOrder.click();
        WebElement addCardPayment = driver.findElement(By.xpath("//input[@id='ed3b46ec-a145-4bf7-91bb-94d168dccf84']"));
        addCardPayment.sendKeys(""); // Send credit card payment
        WebElement securityCode = driver.findElement(By.xpath("//input[@id='8bd8230c-bf76-4769-a53d-9a7177af75b8']"));
        securityCode.sendKeys(""); // Send code 123
        WebElement expirationDate = driver.findElement(By.xpath("//input[@id='ab949e8d-6145-46e5-801e-b33550adc60d']"));
        expirationDate.sendKeys(""); // Date of exp (could be 01/26)
        WebElement continuePaying = driver.findElement(By.xpath("//button[@aria-label='Continue']//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        continuePaying.click();
        WebElement clickOnAgreements = driver.findElement(By.xpath("//a[@id='confirmPurchaseButton']//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        clickOnAgreements.click();
        WebElement clickOnReview = driver.findElement(By.xpath("//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        clickOnReview.click();
        WebElement agreeFirst = driver.findElement(By.cssSelector(".HitArea-VDS__sc-bc3yhn-0.fvPnCk"));
        agreeFirst.click();
        WebElement agreeSecond = driver.findElement(By.xpath("//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        agreeSecond.click();
        WebElement agreeThird = driver.findElement(By.xpath("//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        agreeThird.click();
        WebElement agreeFinal = driver.findElement(By.xpath("//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        agreeFinal.click();
        WebElement placeOrder = driver.findElement(By.xpath("//span[@class='HitArea-VDS__sc-bc3yhn-0 fvPnCk']"));
        placeOrder.click();
    }

    private void retrieveOrderInfo() {
        WebElement digitalOrder = driver.findElement(By.xpath("//span[normalize-space()='997987462893912']"));
        String digitalOrderId = digitalOrder.getText();
        // This is the final step, but from here you need to retrieve the order ID, location code, and end-to-end session from dev tools
    }
}
