package Examples;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SelectingVisibleElement {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.walmart.com/");
		List<String> linksText = page.locator("a:visible").allTextContents();

//	for(int i=0;i<linksText.size();i++) {
//		System.out.println(linksText.get(i));
//	}
		for (String link : linksText) {
			System.out.println(link);
		}
		int imagesCount = page.locator("xpath=//img >> visible=true").count();
		System.out.println(imagesCount);
		
	}
}
