package webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

public class JavaScriptExecutor {

	@Test
	public void testDriver() throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://emtrack-ng.qa.intermedix.com/app");
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver)
					.executeScript("window.location.reload();");
		}	
		
		String script = "driver.findElement(By.name(\"name\")).sendKeys(\"autoregadmin4\");"+
				"driver.findElement(By.name(\"password\")).sendKeys(\"autoregadmin4\");"+
				"driver.findElement(By.name(\"loginBttn\")).click();";
		
		
		script = "window.document.getElementById('name').value = 'autoregadmin4';"+
				 "window.document.getElementById('password').value = 'abc123';"+
				 "window.document.getElementById('loginBttn').click();";
		
		
		long sec=convert(30,TimeUnit.SECONDS);
		waitFor(driver,50,TimeUnit.SECONDS,script);
		
		System.out.println(sec);
		driver.quit();
	}

	public void waitFor(WebDriver driver, long time, TimeUnit unit, String script) throws Exception {
		time = convert(time,unit);
		time = time/1000;
		while(--time >0){		
			try{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(script);
				System.out.println(time);
				break;
			}catch(Exception Ae){
				Thread.sleep(1000);
			}
		}
	}
	
	public long convert	(long time,TimeUnit unit){
		long sourceDuration = time ;
		TimeUnit sourceUnit = unit;
		if(sourceUnit.compareTo(TimeUnit.SECONDS)==0){
			sourceDuration = TimeUnit.SECONDS.toMillis(sourceDuration);
		}
		if(sourceUnit.compareTo(TimeUnit.MINUTES)==0){
			sourceDuration = TimeUnit.MINUTES.toMillis(sourceDuration);
		}
		return sourceDuration;
	}
}
