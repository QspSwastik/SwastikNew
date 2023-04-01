package com.actiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteSettingsPage 
{
	@FindBy(xpath="(//div[@class='actionButton'])[7]")
	private WebElement deleteactionButton;


	@FindBy(xpath="(//div[.='Delete'])[2]")
	private WebElement deletebutton;

	@FindBy(xpath="//span[.='Delete permanently']")
	private WebElement deletepermanently;

	public  DeleteSettingsPage  ( WebDriver driver)

	{
		PageFactory.initElements(driver, this);
	}

	public void settingActionMethod() throws InterruptedException
	{
		Thread.sleep(5000);
		deleteactionButton.click();
		
	}

	public void deleteMethod() throws InterruptedException
	{
		Thread.sleep(5000);
		deletebutton.click();
	}
	public void deletepermanentelyMethod() throws InterruptedException
	{
		Thread.sleep(5000);
		deletepermanently.click();
	}

}
