package com.actiTime.testcase;

import java.io.IOException;
import org.testng.annotations.Test;
import com.actiTime.generic.BaseTest;
import com.actiTime.pages.ActitimeHomePage;
import com.actiTime.pages.ActitimeLoginPage;
import com.actiTime.pages.ActitimeSettingPage;
import com.actiTime.pages.ActitimeTypeOfWorkPage;

public class DeleteTypeofWork extends BaseTest
{@Test
	public void deletetypeofwork() throws IOException, InterruptedException
	{
	ActitimeLoginPage loginPage=new ActitimeLoginPage(driver);
	loginPage.loginMethod();
	
	ActitimeHomePage home =  new ActitimeHomePage(driver);
	home.settingmethod();
	
	ActitimeSettingPage setting = new ActitimeSettingPage(driver);
	setting.typesofwork();
	
	ActitimeTypeOfWorkPage work = new ActitimeTypeOfWorkPage(driver);
	work.DeletenameMethod();
	
	}
	
}
