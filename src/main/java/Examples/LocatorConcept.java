package Examples;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class LocatorConcept {
public static void main(String[] args) {
	Playwright playwright = Playwright.create();
	System.out.println("playwright server started");
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

//	locators
	
	BrowserContext brcx = browser.newContext();
	System.out.println("Browser context is created.");
	
//	trace viewer start
//	brcx.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
	Page page = brcx.newPage();
	page.navigate("https://www.orangehrm.com");
	System.out.println("page opened succesfully");
	
//	single elements
//	Locator contactSales = page.locator("xpath =//div[@class=\"d-flex web-menu-btn\"]/ul/li[2]/a/button");
//	contactSales.click();
	Locator contactSales = page.locator("text = Contact Sales");
//	int totalBtn =contactSales.count();
//	System.out.println(totalBtn);
//	System.out.println("element successfully located");
	contactSales.last().click();
	System.out.println("clicked succesfully");
	
	
	
// multiple elements
	Locator selectElement = page.locator("select#Form_getForm_Country");
	page.waitForSelector("select#Form_getForm_Country");
	System.out.println(selectElement.count());
	Locator countryOptions = page.locator("select#Form_getForm_Country option");
	System.out.println(countryOptions.count());
	
	
//	iterating through country options
	
//	for(int i = 0; i < countryOptions.count(); i++) {
//		String countryNames = countryOptions.nth(i).textContent();
//		System.out.println(countryNames);
//	}
	
	List<String> countryNames = countryOptions.allTextContents();
//	for(String e : countryNames) {
//		System.out.println(e);
//	}
//	

//	with lambda
	countryNames.forEach(ele -> System.out.println(ele));
	
//	trace viewer Stops
//	brcx.tracing().stop(new Tracing.StopOptions()
//			.setPath(Paths.get("trace.zip")));



}
}
