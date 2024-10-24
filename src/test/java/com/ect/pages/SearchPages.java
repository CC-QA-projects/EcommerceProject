package com.ect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPages {
	
	WebDriver driver;
	public SearchPages (WebDriver ldriver)
	{
		this.driver = ldriver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy (linkText="Home") WebElement homeTxt;
	@FindBy (name="frm_search") WebElement searchProductTextbox;
	@FindBy (id="btn_search") WebElement searchProductBtn;
	@FindBy (xpath="//*[@id=\"container\"]/div/div[1]/div[2]/div/div/div/a/h3") WebElement tvproduct;
	@FindBy (xpath="//*[@id=\"container\"]/div/div/div[1]/div[2]/div/div[2]/button") WebElement addtocartbtn;
	@FindBy (xpath="//*[@id=\"navbarText\"]/ul/li[3]/a") WebElement cartbtn;
	@FindBy (xpath="//*[@id=\"cart\"]/div[2]/div/a") WebElement checkoutbtn;
	
	public void searchProduct()
	{
		homeTxt.click();
		searchProductTextbox.sendKeys("Android Tv"); 
		searchProductBtn.click();
		tvproduct.click();
		addtocartbtn.click();
		cartbtn.click();
		checkoutbtn.click();
		
	}
}
