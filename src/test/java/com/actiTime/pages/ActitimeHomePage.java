package com.actiTime.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.actiTime.generic.AutoConstant;
import com.actiTime.generic.BasePage;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class ActitimeHomePage extends BasePage implements AutoConstant
{
	public WebDriver driver;
	//intialization

	@FindBy(xpath="//div[@id='container_tasks']")
	private WebElement taskbutton;



	@FindBy(xpath="(//div[@class='popup_menu_icon'])[2]")
	private WebElement settingbutton;

	@FindBy(id="logoutLink")
	private WebElement logoutLink;

	@FindBy(xpath="//div[@id='container_users']")
	private WebElement userlink;	

	// declaration
	public ActitimeHomePage ( WebDriver driver)
	{this.driver= driver;
	PageFactory.initElements(driver, this);
	}

	//utilization


	public void logoutMethod() throws InterruptedException
	{
		Thread.sleep(5000);
		logoutLink.click();
	}
	public void settingmethod() throws InterruptedException 
	{  
		visibilityofelementlocated(driver, By.xpath("(//div[@class='popup_menu_icon'])[2]"));
		javascriptclick(driver, settingbutton);
		
	}
	public void tasksmethod() throws InterruptedException
	{
		Thread.sleep(5000);
		javascriptclick(driver, taskbutton);
		
	} 
	public void userlinkmethod()
	{
		userlink.click();
	}
}

