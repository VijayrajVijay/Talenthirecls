package Support;

import java.time.Duration;import org.openqa.selenium.support.ui.Select;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap; // import the HashMap class

public class SeleniumMethods {
	
	public static WebDriver driver;
	public static String downloadPath;
	public void seleniumInit() {
		 downloadPath = System.getProperty("user.dir")+"\\src\\main\\resources";

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);


	driver =new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
		
	}
	
	public String getDownloadPath() {
		return downloadPath;
		
	}
	
	public void selectValue(String element,String value) {
		Select s =new Select(driver.findElement(By.xpath(element)));
		s.selectByValue(value);
	}
	
	public void launchUrl(String url) {
		seleniumInit();
		driver.get(url);
	}
	public void clickElement(String element) {
		driver.findElement(By.xpath(element)).click();
	}
	
	public void sendKeys(String element, String text) {
		driver.findElement(By.xpath(element)).sendKeys(text);
	}
	
	public void HoverOnElement(String element) {
		 Actions action = new Actions(driver); 	
		 action.moveToElement(driver.findElement(By.xpath(element))).build().perform();
	}
	
	public void clickListOfWebElements(String element,int i) {
		
		List<WebElement> elements=driver.findElements(By.xpath(element));
		elements.get(i).click();
	}
	
public List<WebElement> getListOfWebElements(String element) {
		
		List<WebElement> elements=driver.findElements(By.xpath(element));
		return elements;
	}
	
	public void printTextOfElement(String element) {
		 
		System.out.println("\033[0;1m"+driver.findElement(By.xpath(element)).getText());
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public String getTextValue(String element) {
		 
		return driver.findElement(By.xpath(element)).getText();
	}
	
}
