package selenuim_test.market;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketPage {
	private WebDriver driver;
	
	public MarketPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By searchField = By.xpath("//input[@id='header-search']");
	
	public SearchPage searchText(String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(searchField));
		search.sendKeys(text);
		search.submit();
		return new SearchPage(driver);
	}
}
