package com.mindtree.moneycontrolc;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class moneycontrol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver(1).exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.moneycontrol.com/");
		driver.manage().window().maximize();
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//ul[@class='clearfix main_nav']//li[@cid='8']"))).build().perform();
		driver.findElement(By.xpath("//a[@title='Income Tax Calculator']")).click();
		
		String u=driver.getCurrentUrl();
		driver.get(u);
		driver.findElement(By.xpath("//span[@class='styspri icradio_mid checked']//input[@value='without']")).click();
		driver.findElement(By.xpath("//div[@class='input_box']//input[@id='age']")).sendKeys("23");
		Select s=new Select(driver.findElement(By.className("custselect")));
		s.selectByVisibleText("Stay in Non Metro city");
		driver.findElement(By.xpath("//a[@class='btn_common nextfrm MR10 calculateTax']")).click();
		driver.findElement(By.xpath("//input[@id='annual_salry']")).sendKeys("15000");
		driver.findElement(By.xpath("//input[@id='other_income']")).sendKeys("15000");
		driver.findElement(By.xpath("//a[@id='income_tab_next']")).click();
		a.moveToElement(driver.findElement(By.xpath("//ul[@class='clearfix main_nav']//li[@cid='2']"))).build().perform();
		driver.findElement(By.xpath("//a[@title='Top Ranked Funds']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/bank-of-india-tax-advantage-fund-direct-plan-growth/')][1]")).click();
		Set <String> ids=driver.getWindowHandles();
		Iterator <String> it=ids.iterator();
		String parentid=it.next();
		String childid=it.next();
		driver.switchTo().window(childid);
		WebElement p=driver.findElement(By.xpath("//table[@class='navdetails']//span[@class='amt']"));
		String amt=p.getText();
		System.out.println("The Fund Size is"+amt);
		
		

	}

}
