package com.trip.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.trip.qa.base.TestBase;

public class LandingPage extends TestBase {
	
	
	//Define the PageFactory
		@FindBy(id="search-input-From")
		WebElement searchFrom;
		
		@FindBy(id="search-input-To")
		WebElement searchTo;
		
		@FindBy(id="search-button")
		WebElement searchButton;
	

	public LandingPage() throws IOException {
		//super();  //to call the TestBase class constructor
	   PageFactory.initElements(driver, this); 
	}

	
	/* defining the action to be performed on the page*/
	public SearchResultsPage FindOptions(String frm , String t) throws IOException, InterruptedException
	{
		
		searchFrom.sendKeys(frm);

		searchTo.sendKeys(t);
		Thread.sleep(1000);
	
		searchButton.click();
		return new SearchResultsPage();
		
	}
	
}
