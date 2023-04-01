package com.actiTime.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage 
{

	//Select Class
	public void selectbyvisibletext(WebElement element , String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectbyvalue(WebElement element , String text)
	{
		Select select=new Select(element);
		select.selectByValue(text);
	}

	public void selectbyindex(WebElement element , int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void deselectbyvisibletext(WebElement element , String text)
	{
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	
	public void deselectbyvalue(WebElement element , String text)
	{
		Select select=new Select(element);
		select.deselectByValue(text);
	}
	
	public void deselectbyindex(WebElement element , int index)
	{
		Select select=new Select(element);
		select.deselectByIndex(index);
	}
	
	public boolean ismultiple(WebElement element) 
	{
		Select select = new Select(element);
		return select.isMultiple();
	}
	
	public List<WebElement> getoptions(WebElement element) 
	{
		Select select = new Select(element);
		return select.getOptions();
	}
	public WebElement getfirstselectedoption(WebElement element) 
	{
		Select select = new Select(element);
		return select.getFirstSelectedOption();
	}
	public List<WebElement> getallselectedoptions(WebElement element) 
	{
		Select select = new Select(element);
		return select.getAllSelectedOptions();
	}


	//Navigation Interface
	public void moveback(WebDriver driver)
	{
		driver.navigate().back();
	}
	public void forword(WebDriver driver)
	{
		driver.navigate().forward();
	}
	public void refresh(WebDriver driver)
	{
		driver.navigate().refresh();	
	}
	
	// TargetLocator Interface 
	public void window(WebDriver driver ,String text) //doubt
	{
		driver.switchTo().window(text);
	}
	public void newwindow(WebDriver driver ,WindowType window) 
	{
		driver.switchTo().newWindow(window);
	}
	public void frame(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}
	public void frame(WebDriver driver,String name) 
	{
		driver.switchTo().frame(name);
	}
	public void parentframe(WebDriver driver) 
	{
		driver.switchTo().parentFrame();
	}
	public void framenameattribute(WebDriver driver,String id) 
	{
		driver.switchTo().frame(id);
	}


	// WebDriverWait Class
	public void implicitlywait(WebDriver driver,Duration duration)
	{
		driver.manage().timeouts().implicitlyWait(duration);
	}
	public void visibilityofelementlocated(WebDriver driver , By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void titleis(WebDriver driver , String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs(title));
	}
	public void fluentwait(WebDriver driver , By locator)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void pageloadtimeout(WebDriver driver,Duration duration)
	{
		driver.manage().timeouts().pageLoadTimeout(duration);
	}
	public void Scripttimeout(WebDriver driver,Duration duration)
	{
		driver.manage().timeouts().scriptTimeout(duration);
	}
	public void getpageloadtimeout(WebDriver driver)
	{
		driver.manage().timeouts().getPageLoadTimeout();
	}
	public void getscripttimeout(WebDriver driver)
	{
		driver.manage().timeouts().getScriptTimeout();
	}
	public void getimplicitwaittimeout(WebDriver driver)
	{
		driver.manage().timeouts().getImplicitWaitTimeout();
	}
	
	//Window Interface 
	public void fullscreen(WebDriver driver )
	{
		driver.manage().window().fullscreen();
	}
	public void maximize(WebDriver driver )
	{
		driver.manage().window().maximize();
	}
	public void minimize(WebDriver driver )
	{
		driver.manage().window().minimize();
	}
	

	//Options Interface
	public void getallcookies(WebDriver driver)
	{
		Set<Cookie> allCookies=driver.manage().getCookies();
		System.out.println("all cookies are" + allCookies);
	}
	public void getcookieName(WebDriver driver,String text)
	{
		driver.manage().getCookieNamed(text);
	}
	public void deleteallcookies(WebDriver driver)
	{
		driver.manage().deleteAllCookies();
	}
	public void deletecookienamed(WebDriver driver,String text)
	{
		driver.manage().deleteCookieNamed(text);
	}
	public void deletecookie(WebDriver driver,Cookie cookie)
	{
		driver.manage().deleteCookie(cookie);
	}


	//Actions Class
	public void movetoelement(WebDriver driver , WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void click(WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.click().perform();
	}
	public void contextclick(WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.contextClick().perform();
	}
	public void doubleclick (WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick().perform();
	}
	public void draganddrop(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(element,element).perform();;
	}
	public void draganddropaxis(WebDriver driver,WebElement element,int source,int target)
	{
		Actions actions=new Actions(driver);
		actions.dragAndDropBy(element, source, target).perform();;
	}
	public void clickandhold(WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.clickAndHold().perform();
	}
	public void clickandholdtarget(WebDriver driver,WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.clickAndHold(target).perform();
	}
	public void release(WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.release().perform();
	}
	public void releasetarget(WebDriver driver,WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.release(target).perform();
	}
	public void scrolltoelement(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.scrollToElement(element).perform();
	}
	public void build(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.build().perform();
	}


	//Robot Class
	public void robottab() throws AWTException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}



	//Alert Interface
	public void alertaccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void alertdismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	public void alertenter(WebDriver driver , String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	public void alerttext(WebDriver driver)
	{
		System.out.println(driver.switchTo().alert().getText());
	}



	//JavascriptExecutor Interface
	public void javascriptclick(WebDriver driver , WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	

	//WebDriver Interface
	public void gettitle(WebDriver driver , String text)
	{
		String actualTitle=driver.getTitle();
		if(actualTitle.contains(text))
		{
			System.out.println("titles are matching");
		}
		else
		{
			System.out.println("titles are not matching");
		}
	}

	public void getcurrenturl(WebDriver driver , String expectedUrl)
	{
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}
	
	//ChromeOptions Class
	public void headless()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
	}
	
	public void disablenotification()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-notifications");
	}
	
	public void startmaximized()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
	}
	
	//Rectangle Class
	public void getdimensionheight(Point p , Dimension d)
	{
		Rectangle r=new Rectangle(p, d);
		System.out.println("height is :" +r.height);
		
	}
}