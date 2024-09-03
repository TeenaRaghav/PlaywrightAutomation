package Examples;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathLocator {
public static void main(String[] args) {
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page = browser.newPage();
//	page.navigate("https://www.amazon.com");
//	page.locator("//input[@id='twotabsearchtextbox']").fill("mackbook pro");
//	Locator links =page.locator("xpath=//a[contains(text(),'Amazon')]");
//	int countOfLinks= links.count();
//	System.out.println(countOfLinks);
//	List<String> textList =links.allInnerTexts();
//	for(String e : textList) {
//		System.out.println(e);
//	}
	page.navigate("https://selectorshub.com/xpath-practice-page/");
//	page.locator("xpath=//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']").click();
//	String text =page.locator("//a[text()='Joe.Root']/parent::td/following-sibling::td[contains(text(),'ESS')]").textContent();
//	System.out.println(text);
//	Locator checkboxes = page.locator("//table[@id='resultTable']//input[@type='checkbox']");
//	for(int i=0; i<checkboxes.count();i++) {
//		checkboxes.nth(i).click();
//	}
//	
	page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[4]").click();
	page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[last()]").click();

	
}
}
