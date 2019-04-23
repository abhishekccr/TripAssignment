package com.trip.qa.testcases;

import java.io.IOException;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.trip.qa.base.TestBase;
import com.trip.qa.pages.LandingPage;
import com.trip.qa.pages.SearchResultsPage;
import com.trip.qa.util.TestUtil;

public class LandingPageTest extends TestBase{
	
	
	public static LandingPage LP;
	public static SearchResultsPage srp;
	public static TestUtil testutil;
	String SheetName = "TripTestData";
	
	@BeforeMethod
	public  void setup() throws IOException 
	{
		
		 driver = initialization();
		
		 testutil = new TestUtil();
		
		driver.get(" https://transportnsw.info/trip");
		 LP  = new LandingPage();
	
		
	}
	
	
	@DataProvider
	public Object[][] getTripTestData() throws IOException
	{
		 Object data[][] = TestUtil.getTestData(SheetName);
		 return data;
		
	}
	
	@Test(dataProvider="getTripTestData")
	public void SearchOptionstest(String frmorig , String todest) throws IOException, InterruptedException
	
	{
		srp = LP.FindOptions(frmorig, todest);
		
	}
	
	
@AfterMethod
	public void teardown() throws InterruptedException
	{
	   Thread.sleep(2000);
		driver.quit();
	}

}
