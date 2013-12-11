package DirectJavaScript;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class ExecuteJavaScript {

	Selenium selenium;

	@After
	public void stopBrowser(){
		//selenium.close();
		//selenium.stop();
	}
	
	@Test
	public void test() {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox",
				"https://emtrack-ng.qa.intermedix.com/app");
		selenium.start();
		selenium.getEval("window.open('/');");
		selenium.open("/");
		selenium.windowMaximize();
		selenium.getEval("window.document.getElementById('name').value = 'autoregadmin4';");
		selenium.getEval("window.document.getElementById('password').value = 'abc123';");
		selenium.getEval("window.document.getElementById('loginBttn').click();");
		selenium.getEval("window.location.reload();");
	}
	
	@Test
	public void testDriver() {
	WebDriver driver = new FirefoxDriver();
	driver.get("https://emtrack-ng.qa.intermedix.com/app");
	/*if (driver instanceof JavascriptExecutor) {
		((JavascriptExecutor) driver)
			.executeScript("window.location.reload();");
		((JavascriptExecutor) driver).executeScript(script, args)
	}*/
	driver.quit();
	
	}
}
