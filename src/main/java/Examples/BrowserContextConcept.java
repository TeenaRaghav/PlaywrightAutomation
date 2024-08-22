package Examples;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class BrowserContextConcept {
public static void main(String[] args) {
	Playwright playwright = Playwright.create();
//	Browser browser = playwright.chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false));
	Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
	
	BrowserContext bx1 =browser.newContext();
	Page p1 = bx1.newPage();
	p1.navigate("https://www.orangehrm.com");
	p1.fill("#Form_submitForm_EmailHomePage", "Teena");
	System.out.println(p1.title());
	
	
	
	BrowserContext bx2 = browser.newContext();
	Page p2 = bx2.newPage();
	p2.navigate("http://www.salesforce.com/login");
	p2.fill("#username", "teena@raghav.com");
	p2.fill("#password", "PritishJai@1");
	System.out.println(p2.title());
	
	p1.close();
	bx1.close();
	
	p2.close();
	bx2.close();
}
}
