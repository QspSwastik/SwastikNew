package com.actiTime.testcase;

import java.io.IOException;
import org.testng.annotations.Test;
import com.actiTime.generic.BaseTestFacebook;
import com.actiTime.pages.FacebookCreateCustomerpage;
import com.actiTime.pages.Facebookloginpage;

public class Facebook extends BaseTestFacebook
{
	 @Test
	public void fbcustomer () throws InterruptedException, IOException 
	{
		Facebookloginpage login =new Facebookloginpage(driver);
		login.NewaccountMethod();
		
		FacebookCreateCustomerpage newcustomer = new FacebookCreateCustomerpage(driver);
		newcustomer.FirstnameMethod();
		newcustomer.LastnameMethod();
		newcustomer.MobilenoMethod();
		newcustomer.PasswordMethod();
		newcustomer.dateofbirth();
		newcustomer.malemethod();

	}
}
