package Examples;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementSelectors {
	public static void main(String[] args) {
		
			Playwright playwright = Playwright.create();
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			page.navigate("https://www.bigbasket.com/");
			String firstEle= page.locator("div.pr-4 li a >> nth=0").textContent();
			System.out.println(firstEle);
//			nth=0 means first element , nth=-1 means last element
			page.locator("div.pr-4 li a >> nth=0").click();
			
	}
}
