package com.sa.testsuitebase;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteBase {
	
	public static WebDriver driver=null;
	public static Properties allsitedata=null;
	public static File propfile=null;
	public static FileInputStream fispath=null;
	public static File srcexcel=null;
	public static FileInputStream excelfis=null;
	public static XSSFWorkbook srcbook=null;
	public static XSSFSheet srcsheet=null;
	public static XSSFRow srcrow=null;
	public static XSSFCell srccell=null;
	//public static String browserval = allsitedata.getProperty("Browser");
	
	/*public static String coluser=null;
	public static String colpass=null;*/
	
	//@BeforeSuite
	@BeforeTest
	public void LoadPropertie() {
		
		propfile = new File(System.getProperty("user.dir")+"\\Properties\\AllSiteData.properties");
		try {
			fispath = new FileInputStream(propfile);
			allsitedata = new Properties();
			allsitedata.load(fispath);
			System.out.println("Properties File Loaded Successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Load Properties File --> "+e.getMessage());
		}
	}
	
	//@BeforeSuite
	@BeforeClass
	public static void ReadExcelFile() {
		
		srcexcel = new File(System.getProperty("user.dir")+"\\Excels\\Logins.xlsx");
		try {
			excelfis = new FileInputStream(srcexcel);
			srcbook = new XSSFWorkbook(excelfis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to get data from Excel file --> "+e.getMessage());
		}
		}
		/*srcsheet = srcbook.getSheetAt(0);
		
		int totalrow = srcsheet.getLastRowNum();
		int lastcell = srcsheet.getRow(totalrow).getLastCellNum();
		
		String coluser = srcsheet.getRow(1).getCell(0).getStringCellValue();
		String colpass = srcsheet.getRow(1).getCell(1).getStringCellValue();
		
		System.out.println(coluser);
		
	}*/
 
	@BeforeClass
  public void LoadDriver() throws InterruptedException {
		//if (driver==null)
		
		String browserval = allsitedata.getProperty("Browser");
		
		if (browserval.equalsIgnoreCase("Chrome"))
				{
			System.out.println("Launching Chrome Browser");
			System.setProperty("webdriver.chrome.driver", allsitedata.getProperty("Chromepath"));
			driver = new ChromeDriver();
				}
		else if (browserval.equalsIgnoreCase("Firefox"))
		{
			System.out.println("Launching Firefox Browser");
			System.setProperty("webdriver.gecko.driver", allsitedata.getProperty("FFpath"));
			driver = new FirefoxDriver();
		}
		else if (browserval.equalsIgnoreCase("IE"))
		{
			System.out.println("Launching IE Browser");
			System.setProperty("webdriver.ie.driver", allsitedata.getProperty("IEpath"));
			driver = new InternetExplorerDriver();
		}
		
		/*System.out.println("Initializing Browser");				
		System.setProperty("webdriver.chrome.driver", allsitedata.getProperty("Chromepath"));
		driver = new ChromeDriver();
		System.out.println("Driver Loaded Successfully");*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(allsitedata.getProperty("siteurl"));
		Thread.sleep(3000);
		
  }
	
	@AfterClass
	public void CloseBrowser() {		
		//driver.close();
		driver.quit();
		//System.out.println("Browser Closed Test Complete");
		Reporter.log("Test Complete Browser Quit", true);
	}

}
