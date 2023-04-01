package com.actiTime.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import com.actiTime.generic.AutoConstant;
import com.actiTime.generic.BasePage;
import com.actiTime.generic.ExcelLibrary;

public class CreateNewCustomer extends BasePage implements AutoConstant
{    
	public WebDriver driver;
@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
private WebElement customertextfield;

@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
private WebElement customerdescriptiontextfield;

@FindBy(xpath="//div[.='Create Customer']")
private WebElement createcustomerlink;

@FindBy(xpath="//div[@class='greyButton cancelBtn']")
private WebElement cancellink;

@FindBy(xpath="(//div[.='swastik'])[1]/../..//div[@class='editButton']")
private WebElement settingsbutton;

@FindBy(xpath="//div[.='Customer with the specified name already exists']")
private WebElement errormessage;

public CreateNewCustomer ( WebDriver driver)

{   
	this.driver= driver;
	PageFactory.initElements(driver, this);
	
}

public void customertextfieldMethod() throws IOException
 {
    customertextfield.sendKeys(ExcelLibrary.getcellvalue(sheet_name2, 1, 0));
 }
public void customerdescriptiontextfieldMethod() throws IOException
{
	customerdescriptiontextfield.sendKeys(ExcelLibrary.getcellvalue(sheet_name2, 1, 1));
}
public void createcustomerMethod() throws InterruptedException
{
   javascriptclick(driver,createcustomerlink );
}
public void cancellinkMethod()
{
	cancellink.click();
}
public void alertMethod()
{
	driver.switchTo().alert().accept();
}
public void settingsMethod() throws InterruptedException
{   Thread.sleep(4000);
	settingsbutton.click();
	
} 	
public void verifyerrormessage() throws InterruptedException
{
	Thread.sleep(2000);
	String actualErrorMessage = errormessage.getText();	
	SoftAssert s=new SoftAssert();
	s.assertEquals(actualErrorMessage,"Customer with the specified name already exists");
	s.assertAll();
 } 	
}