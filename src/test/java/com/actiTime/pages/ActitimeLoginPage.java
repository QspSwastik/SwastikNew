package com.actiTime.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.actiTime.generic.AutoConstant;
import com.actiTime.generic.BasePage;
import com.actiTime.generic.ExcelLibrary;
import com.actiTime.generic.Helper;

public class ActitimeLoginPage extends BasePage implements AutoConstant
{
	public WebDriver driver;
	
	@FindBy(id = "username")
	private WebElement usernameTextfield;
	
	@FindBy(name = "pwd")
	private WebElement passwordTextfield;
	
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	public ActitimeLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginMethod() throws IOException, InterruptedException
	{
		Helper.highlightelement(driver, usernameTextfield);
		usernameTextfield.sendKeys(ExcelLibrary.getcellvalue(sheet_name, 1, 0));
		Helper.highlightelement(driver,passwordTextfield);
		passwordTextfield.sendKeys(ExcelLibrary.getcellvalue(sheet_name, 1, 1));
		javascriptclick(driver, loginButton);
		Thread.sleep(5000);
		gettitle(driver, "Time-Track");
	}
}