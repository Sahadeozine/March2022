package flipkart01;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumbermap.ConfigReader;

public class seleniumoperation3 

{
	public static ConfigReader config;
	public static WebDriver d=null;
	public static Hashtable< String, Object> outputParameters=new Hashtable<String, Object>();
	
	public static Hashtable< String, Object> browserlaunch(Object[]inputparameter)
	{
		try{
		String bname=(String)inputparameter[0];
		
		
		if(bname.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",config.getDriverPathChrome());
		
		 d= new ChromeDriver();
		 d.manage().window().maximize();
		}
		else if(bname.equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.geckodriver.driver",config.getDriverPathFF());
			
		    d= new FirefoxDriver();
		    d.manage().window().maximize();
		 
		 }
		
		outputParameters.put("STATUS", "PASS");	
		outputParameters.put("MESSAGE", "methodUsed; browserLaunch,Input Given:"+inputparameter[0].toString());	
		
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");	
			outputParameters.put("MESSAGE", "methodUsed; browserLaunch,Input Given:"+inputparameter[0].toString());	
			
			
		}
		return outputParameters;
		}
		
	public static Hashtable< String, Object> openapplication()
	{
		try
		{
        d.get(config.getApplicationUrl());	
        
        outputParameters.put("STATUS", "PASS");	
		outputParameters.put("MESSAGE", "methodUsed; openapplication,Input Given:"+config.getApplicationUrl().toString());	
		
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");	
			outputParameters.put("MESSAGE", "methodUsed; openapplication,Input Given:"+config.getApplicationUrl().toString());				
		}
		return outputParameters;

	}
	public static Hashtable< String, Object> clickonElement(Object[]inputparameter)
	{
		try{
			d.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
			String xpath=(String) inputparameter[0];
			d.findElement(By.xpath(xpath)).click();
			
			outputParameters.put("STATUS", "PASS");
		    outputParameters.put("MESSAGE", "methodUsed: ClickonElement,Input Given"+inputparameter[0].toString());
			}
			catch(Exception e)
			{
				outputParameters.put("STATUS", "FAIL");
			    outputParameters.put("MESSAGE", "methodUsed:ClickonElement,Input Given"+inputparameter[0].toString());
			}
			return outputParameters;

	}
	public static Hashtable< String, Object> mouseover(Object[]inputparameter) throws InterruptedException
	{
		try
		{
		d.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
		String XPATH=(String) inputparameter[0];
		 Actions act=new Actions(d);
		 d.findElement(By.xpath(XPATH));
		 WebElement abc=d.findElement(By.xpath(XPATH));
		 act.moveToElement(abc).build().perform();
		 Thread.sleep(5000);
		
		 outputParameters.put("STATUS", "PASS");	
			outputParameters.put("MESSAGE", "methodUsed; mouseover,Input Given:"+inputparameter[0].toString());	
	
		}
		catch(Exception e)
		{
			 outputParameters.put("STATUS", "FAIL");	
				outputParameters.put("MESSAGE", "methodUsed; mouseover,Input Given:"+inputparameter[0].toString());	

		}
		return outputParameters;

	}
	
	public static Hashtable< String, Object> Sendkeys(Object[]inputparameter)
	{
		try{
		d.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
		String XPATH=(String) inputparameter[0];
		String Value=(String) inputparameter[1];
		 d.findElement(By.xpath(XPATH)).sendKeys(Value);
		 
		 outputParameters.put("STATUS", "PASS");	
		 outputParameters.put("MESSAGE", "methodUsed;Sendkeys,Input Given:"+inputparameter[1].toString());	

		}
		catch(Exception e)
		{
			 outputParameters.put("STATUS", "FAIL");	
			 outputParameters.put("MESSAGE", "methodUsed; Sendkeys,Input Given:"+inputparameter[1].toString());	

		}
		return outputParameters;

	}
	public static Hashtable< String, Object> validation(Object[]inputparameter)
	{
		try{
		d.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
		String XPATH=(String) inputparameter[0];
		String Value=(String) inputparameter[1];
		
		String actualText=d.findElement(By.xpath(XPATH)).getText();
		
		if(actualText.equalsIgnoreCase(Value))
		{
			System.out.println("Test case pass");
		}
		else
		{
			System.out.println("Test case fail");
		}
		 outputParameters.put("STATUS", "PASS");	
		 outputParameters.put("MESSAGE", "methodUsed;validation,Input Given:"+inputparameter[0].toString());	
		}
		catch(Exception e)
		{
			 outputParameters.put("STATUS", "FAIL");	
			 outputParameters.put("MESSAGE", "methodUsed;validation,Input Given:"+inputparameter[0].toString());	

		}
		return outputParameters;

	}
	public static Hashtable< String, Object> validationForInvalid(Object[]inputparameter)
	{
		d.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
		String XPATH=(String) inputparameter[0];
		String Value=(String) inputparameter[1];
		
		String actualText=d.findElement(By.xpath(XPATH)).getText();
		
		if(actualText.equalsIgnoreCase(Value))
		{
			System.out.println("Test case pass");
		}
		else
		{
			System.out.println("Test case fail");
		}
		return outputParameters;

	}

  
}
