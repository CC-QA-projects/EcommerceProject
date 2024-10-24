package com.ect.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ect.pages.BaseClass;
import com.ect.pages.Loginpages;
import com.ect.utilities.ReadExcelFile;

public class LoginTest extends BaseClass{
	String fileName = System.getProperty("user.dir")+"\\TestData\\ETestData.xlsx";
	
	@Test (dataProvider = "logindataProvider")
	public void verify (String user, String pass) throws IOException{
		Loginpages lp = new Loginpages (driver);
		lp.portalLogin(user, pass);  
		
		if (user.equals("ravi@dhiyotech.in") && pass.equals("Demo")) 
		{ 
			Assert.assertTrue(true);
			lp.logout();
		}
		else 
		{
			captureScreenShot(driver, "verify");
			Assert.assertTrue(false);
			
		}
	}
	
	@DataProvider
	public String [][] logindataProvider() 
	{
		  // Print the Excel file path
        System.out.println("Excel file path: " + fileName);
        
		int row=ReadExcelFile.getRowCount(fileName, "Login");
		int col=ReadExcelFile.getColCount(fileName, "Login");
		   if (row <= 1) {
		        throw new RuntimeException("Not enough data in the Excel sheet 'Login'. Row count: " + row);
		    }
		String [] [] data=new String [row-1] [col];
		
		for (int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "Login", i, j); 
			}
		}
		return data;
			
	}
}
