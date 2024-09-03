package Examples;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ElementContainsOtherElements {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
//		page.navigate("https://www.orangehrm.com");
//		page.locator("input#Form_submitForm_action_request").click();
//		Locator options = page.locator("select#Form_getForm_Country:has(option[value='India'])");
//		// options.allInnerTexts().forEach(e -> System.out.println(e));
//		List<String> allText = options.allInnerTexts();
////	allText.stream().forEach(e -> System.out.println(e));
//		for (String e : allText) {
//			System.out.println(e);
//		}
		
		page.navigate("https://www.amazon.com");
		Locator footerList =page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
		List<String> contents =footerList.allInnerTexts();
	for(String e : contents) {
		System.out.println(e);
	}
	}
}
