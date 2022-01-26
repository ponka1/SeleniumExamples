package selenuim_test.market;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
private WebDriver driver;
	
	private WebDriverWait wait;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	private By articles = By.xpath("//article[@data-autotest-id='product-snippet']");
	
	public ArrayList<ArticleElement> loadArticles(){
		ArrayList<ArticleElement>list = new ArrayList<ArticleElement>();
		
		for (WebElement we: wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(articles))) {
			list.add(new ArticleElement(we));
		}
		return list;
	}
	
	public CartPage goToCartAfterAdd() {
		WebElement btnGoToBusket = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='zsSJk _2sWJL _16jAB _36y1j _2_x8r _1GRkj']")));
		btnGoToBusket.click();
		return new CartPage(driver);
	}
	
	public class ArticleElement{
		private String offerId;
		private WebElement article;
		private By btnAddInCart;
		
		public ArticleElement(WebElement article) {
			this.article = article;
			this.offerId = Util.defineOfferIdFromDataZoneData(article);
			btnAddInCart = By.xpath("//article[@data-autotest-id='product-snippet' and contains(@data-zone-data, '"+offerId+"')]//button[@class='zsSJk _16jAB gjdzW LS3-2 _2Sz75 _1Xumh _2VlTH']");
		}
		public WebElement getWebElement() {
			return this.article;
		}
		public void addInCart() {
			WebElement btnAdd = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddInCart));
			btnAdd.click();
		}
		public String getOfferId() {
			return offerId;
		}
	}
}
