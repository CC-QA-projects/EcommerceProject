package com.ect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpages {
	
	WebDriver driver;
	public Loginpages (WebDriver ldriver) {
		this.driver=ldriver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//a[@class='btn ml-3']") WebElement logimage;
	@FindBy (id="email") WebElement email;
	@FindBy (id="password") WebElement pass;
	@FindBy (id="customerloginForm") WebElement signinbtn; 
	@FindBy (xpath="//li[2]//div[1]//button[1]") WebElement logoutdropdown; 
	@FindBy (xpath="//*[@id=\"navbarText\"]/ul/li[2]/div/div/a[2]") WebElement logoutbtn; 
	

	
	public void portalLogin (String username, String password) {
		
		logimage.click();
		email.sendKeys(username);
		pass.sendKeys(password);
		signinbtn.click();
		
	}
	public void logout() 
	{
		logoutdropdown.click(); 
		logoutbtn.click();
	}
}
