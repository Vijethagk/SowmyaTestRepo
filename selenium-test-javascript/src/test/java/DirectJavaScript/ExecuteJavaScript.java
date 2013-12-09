package DirectJavaScript;

import org.junit.After;
import org.junit.Test;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class ExecuteJavaScript {

	Selenium selenium;

	@After
	public void stopBrowser(){
		selenium.close();
		selenium.stop();
	}
	
	@Test
	public void test() {
		selenium = new DefaultSelenium("localhost", 4444, "*iexplore",
				"https://emtrack-ng.qa.intermedix.com/app");
		selenium.start();
		selenium.open("/");
		selenium.windowMaximize();
		selenium.getEval("window.document.getElementById('name').value = 'autoregadmin4';");
		selenium.getEval("window.document.getElementById('password').value = 'abc123';");
		selenium.getEval("window.document.getElementById('loginBttn').click();");
		selenium.getEval("window.location.reload();");
	}
}
