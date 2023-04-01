package com.actiTime.testcase;

import java.io.IOException;

import org.testng.annotations.Test;
import com.actiTime.generic.BaseTest;
import com.actiTime.pages.ActitimeHomePage;
import com.actiTime.pages.ActitimeLoginPage;
import com.actiTime.pages.AddNewTaskPage;
import com.actiTime.pages.CreateNewCustomer;
import com.actiTime.pages.DeleteSettingsPage;

public class ActitimeCreateCustomer extends BaseTest
  {
   @Test
   public void createcustomer () throws IOException, InterruptedException
    {
	ActitimeLoginPage loginPage=new ActitimeLoginPage(driver);
	loginPage.loginMethod();
	
	ActitimeHomePage home =  new ActitimeHomePage(driver);
	home.tasksmethod();
	
	AddNewTaskPage opentaskpage = new AddNewTaskPage(driver);
	opentaskpage.addnewtaskmethod();
	opentaskpage.createnewcustomerMethod();


	CreateNewCustomer addnewcustomer = new CreateNewCustomer(driver);
	addnewcustomer.customertextfieldMethod();
	addnewcustomer.customerdescriptiontextfieldMethod();
	addnewcustomer.createcustomerMethod();	
	addnewcustomer.settingsMethod();
	DeleteSettingsPage delete = new DeleteSettingsPage(driver);
	delete.settingActionMethod();
	delete.deleteMethod();
	delete.deletepermanentelyMethod();
   }
}