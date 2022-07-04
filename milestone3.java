package com.mindtree.seleniumclass;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class milestone3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//li[@cid='8']//a[@title='Personal Finance']"))).build().perform();
		
		driver.findElement(By.xpath("(//a[@title='Income Tax Calculator'])[2]")).click();
		
		driver.findElement(By.xpath("//ul[@class='calralist']/li[2]/label/span")).click();	
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("23");
		 WebElement element= driver.findElement(By.xpath("//select[@class='custselect']"));
		
		Select sel = new Select(element);
		sel.selectByVisibleText("Stay in Non Metro city");
		driver.findElement(By.xpath("//a[@title='Next']")).click();
		
		driver.findElement(By.id("annual_salary")).sendKeys("15000");
	
        driver.findElement(By.id("other_income")).sendKeys("15000");
        String s=driver.findElement(By.id("display_tax")).getText();
       System.out.println(s);
       
       a.moveToElement( driver.findElement(By.xpath("//li[@class='menu_l1 ']//a[@title='Mutual Funds']"))).build().perform();
       
       driver.findElement(By.xpath("//li[@class='menu_12']//a[@title='Top Ranked Funds']")).click();
       
       driver.findElement(By.xpath("(//td[@class='sorting_2']/a)[6]")).click();
       
       Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String p=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		
		 String s2=driver.findElement(By.xpath("(//span[@class='amt'])[2]")).getText();
		 System.out.println("Fund Size ="+s2);
		 driver.close();
		 driver.quit();
      
       
       
        
		
		
		
			
		
		
		

	}

}
