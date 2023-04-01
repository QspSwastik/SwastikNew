package com.actiTime.testcase;

import java.io.IOException;
import org.testng.annotations.Test;
import com.actiTime.generic.BaseTest;
import com.actiTime.pages.ActitimeLoginPage;

public class ActitimeLoginLogout extends BaseTest
{
	@Test
	public void loginlogout() throws IOException, InterruptedException
	{
		ActitimeLoginPage loginPage=new ActitimeLoginPage(driver);
		loginPage.loginMethod();

	
	}
} 