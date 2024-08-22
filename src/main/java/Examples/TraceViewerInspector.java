package Examples;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

public class TraceViewerInspector {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      context.tracing().start(new Tracing.StartOptions()
    		  .setScreenshots(true)
    		  .setSnapshots(true)
    		  .setSources(true));
      
      Page page = context.newPage();
      page.navigate("https://www.amazon.com/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hello, sign in Account & Lists")).click();
      page.getByLabel("Email or mobile phone number").click();
      page.getByLabel("Email or mobile phone number").fill("teenaraghav3017@gmail.com");
      page.getByLabel("Continue").click();
      page.getByLabel("Password").fill("pritishtina@1");
      page.getByLabel("Sign in").click();
      page.navigate("https://www.amazon.com/?ref_=nav_ya_signin");
     
      context.tracing().stop(new Tracing.StopOptions()
      .setPath(Paths.get("trace.zip")));
    }
  }
}