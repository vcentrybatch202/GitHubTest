package sample2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest2 {

WebDriver wd=null;
	
	@Test
	public void loadGoogle() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "");
		wd=new ChromeDriver();
		wd.get("https://www.bing.com/");
		wd.findElement(By.name("q")).sendKeys("chennai");
		wd.findElement(By.name("q")).submit();
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
	
		File src= ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\A.L.PALANIAPPAN\\eclipse-workspace\\GitHubTest\\screenshot\\bing.png"));
	}
}
