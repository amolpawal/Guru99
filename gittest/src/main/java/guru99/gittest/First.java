package guru99.gittest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class First {
	@Test
	public void linkTest(){
		System.setProperty("webdriver.gecko.driver", "D:/Selenium_Driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://newtours.demoaut.com/";
		String underConsTitle = "Under Construction: Mercury Tours";
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    int i = 0;
		driver.get(baseUrl);
		
		List<WebElement> lst = driver.findElements(By.tagName("a"));
		
		String[] lstText = new String[lst.size()];
		
		for(WebElement e:lst){
			lstText[i] = e.getText();
			i++;
		}
		
		//Test Each Link
		for(String t : lstText){
			driver.findElement(By.linkText(t)).click();
			if(driver.getTitle().equals(underConsTitle)){
				System.out.println( "\n" + t + " Under construct");
			}
		}
	}

   
  }
