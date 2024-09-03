package Examples;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

//	frame locator with css selector
		String h1 = page.frameLocator("frame[name='main']").locator("h2").textContent();
		System.out.println(h1);

//	frame locator with xpath
		String h2 = page.frameLocator("//frame[@name='main']").locator("h2").textContent();
		System.out.println(h2);

//	frame with name
		String h3 = page.frame("main").locator("h2").textContent();
		System.out.println(h3);
////		iframe
//		page.frameLocator("iframe[contains(@id,'frame-one')")
//		.locator("#RESULT_TextField-8").fill("Naveen Automation");
	}
}
