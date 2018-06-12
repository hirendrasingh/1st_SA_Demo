package com.sa.js.login;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.sa.testsuitebase.SuiteBase;

public class JsLogin extends SuiteBase {
	
	//XSSFSheet srcsheet; 
	String jsuser;
	String jspass;
	
  /*@Test
  public void Jslogin() {
	  srcsheet = srcbook.getSheet("JsLogins");
		
		int totalrow = srcsheet.getLastRowNum();
		int lastcell = srcsheet.getRow(totalrow).getLastCellNum();
		
		for(int i=1;i<=totalrow;i++)
		{
			srcrow = srcsheet.getRow(i);
			
			for(int j=0;j<lastcell;j++)
			{
				srccell = srcrow.getCell(j);
				jsuser = srcsheet.getRow(i).getCell(0).getStringCellValue();
				jspass = srcsheet.getRow(i).getCell(1).getStringCellValue();
			}
		}
		
		String jsuser = srcsheet.getRow(1).getCell(0).getStringCellValue();
		String jspass = srcsheet.getRow(1).getCell(1).getStringCellValue();
	  
	  driver.findElement(By.xpath(allsitedata.getProperty("JsMenu"))).click();
	  driver.findElement(By.id(allsitedata.getProperty("JsEmail"))).sendKeys(jsuser);
	  System.out.println(jsuser);
	  driver.findElement(By.id(allsitedata.getProperty("JsPass"))).sendKeys(jspass);
	  driver.findElement(By.id(allsitedata.getProperty("JsLoginbtn"))).click();
	  //driver.findElement(By.id(allsitedata.getProperty("JaLogout"))).click();
	  
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }*/
  
  @Test(priority=1)
  public void Salogin() {
	  srcsheet = srcbook.getSheetAt(1);
				
		String sauser = srcsheet.getRow(1).getCell(0).getStringCellValue();
		String sapass = srcsheet.getRow(1).getCell(1).getStringCellValue();
	  
		driver.findElement(By.id(allsitedata.getProperty("SaMenu"))).click();
	  //driver.findElement(By.xpath(allsitedata.getProperty("SaMenu"))).click();
	  driver.findElement(By.id(allsitedata.getProperty("SaEmail"))).sendKeys(sauser);
	  driver.findElement(By.id(allsitedata.getProperty("SaPass"))).sendKeys(sapass);
	  driver.findElement(By.id(allsitedata.getProperty("SaLoginbtn"))).click();
	  //driver.findElement(By.id(allsitedata.getProperty("SaLogout"))).click();
	  
  }
  
  @Test(priority=2)
  public void Matches() throws Exception {
	  Select AManagerDD = new Select(driver.findElement(By.id(allsitedata.getProperty("AM_DD"))));
	  AManagerDD.selectByVisibleText("HIrendra  rajawat");
	  driver.findElement(By.xpath(allsitedata.getProperty("src_btn"))).click();
	  driver.findElement(By.xpath(allsitedata.getProperty("reset_btn"))).click();
	  /*Select JobsCheckboxes = new Select(driver.findElement(By.id(allsitedata.getProperty("chkselect"))));
	  JobsCheckboxes.selectByIndex(1);*/
	  driver.findElement(By.xpath(allsitedata.getProperty("Match3-btn"))).click();
	  	  	  
	  /*Set<String> window = driver.getWindowHandles();
	  Iterator<String> newwin = window.iterator();
	  String tab1 = newwin.next();
	  String tab2 = newwin.next();
	  System.out.println("win--> "+tab2);
	  if(!tab2.equalsIgnoreCase(tab1))
	  driver.switchTo().window(tab2);*/
	  
	  String parenttab = driver.getWindowHandle();
	  Set<String> window = driver.getWindowHandles();
	  for(String newwin:window)
		  if(!newwin.equalsIgnoreCase(parenttab))
			  driver.switchTo().window(newwin);
	  
	  driver.findElement(By.id(allsitedata.getProperty("AC_btn"))).click();
	  Thread.sleep(3000);
	  
	  String parenttab2 = driver.getWindowHandle();
	  Set<String> window2 = driver.getWindowHandles();
	  for(String newwin2:window2)
		  if(!newwin2.equalsIgnoreCase(parenttab2))
			  driver.switchTo().window(newwin2);
	 
	  driver.findElement(By.id(allsitedata.getProperty("ZC_txtbox"))).clear();
	  driver.findElement(By.id(allsitedata.getProperty("ACsrc_btn"))).click();
	  
  }
  
  
}
