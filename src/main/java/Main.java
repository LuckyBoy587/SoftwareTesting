import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

Logger logger = Logger.getLogger(this.getClass());

void main() {
    System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    test1(driver);
}

private void test1(WebDriver driver) {
    driver.get("https://www.amazon.in/");
    logger.info(driver.getTitle());
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    hoverOnElement(driver, By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
    driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
    driver.navigate().back();
    driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Vivo v25");
    driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
    logger.info("Over");
    driver.close();
}

private void hoverOnElement(WebDriver driver, By locator) {
    Actions action = new Actions(driver);
    action.moveToElement(driver.findElement(locator)).perform();
}