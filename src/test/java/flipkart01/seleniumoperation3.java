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
		try
		{
		d.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
		String XPATH=(String) inputparameter[0];
		 d.findElement(By.xpath(XPATH)).click();
		
		 outputParameters.put("STATUS", "PASS");	
		 outputParameters.put("MESSAGE", "methodUsed; clickonElement,Input Given:"+inputparameter[0].toString());	
		
		
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");	
			outputParameters.put("MESSAGE", "methodUsed; clickonElement,Input Given:"+inputparameter[0].toString());	
					
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

  public static Hashtable< String, Object> main (String[]args) throws InterruptedException
  {
	  
	  // browser launch
	  
	  Object[] input=new Object[2];
	    input[0]="chrome";
	    input[1]= "E:\\automation support\\chromedriver.exe";
	    seleniumoperation3.browserlaunch(input);
	 
	    // open application
	  Object[] input1=new Object[1];
	    input1[0]="https://www.flipkart.com/";
	    
	     seleniumoperation3.openapplication();  
	     
	     //cancel the login page
	     Object[] input2=new Object[1];
	     input2[0]="//*[@class='_2KpZ6l _2doB4z']";
	     seleniumoperation3.clickonElement(input2);
	     
	     // mouse
	     Object[] input3=new Object[1];
	     input3[0]="//*[@class='_1_3w1N']";
	     seleniumoperation3.mouseover(input3);
	     
	     // click on my profile
	     Object[] input4=new Object[1];
	     input4[0]="//*[text()='My Profile']";
	     seleniumoperation3.clickonElement(input4);
	     
	     // sendkeys
	     Object[] input5=new Object[2];
	     input5[0]="(//*[@type='text'])[2]";
	     input5[1]="9588406397";
	     seleniumoperation3.Sendkeys(input5);
	     
	     Object[] input6=new Object[2];
	     input6[0]="//*[@type='password']";
	     input6[1]="Sahadeo@123";
	     seleniumoperation3.Sendkeys(input6);
	     
	     // click 0n log
	      	Object[] input7=new Object[1];
	      	input7[0]="//*[@class='_2KpZ6l _2HKlqd _3AWRsL']";
	        seleniumoperation3.clickonElement(input7);
	        
	     // manage adress 
	       Thread.sleep(5000);
	       Object[] input8=new Object[1];
	       input8[0]="(//*[@class='NS64GK'])[1]";
	       seleniumoperation3.clickonElement(input8);
	       
	       Object[] input9=new Object[1];
	       input9[0]="//*[@class='_2KpZ6l _3lI646 _3dESVI']";
	       seleniumoperation3.clickonElement(input9);
	       
	       Object[] input10=new Object[2];
	       input10[0]="(//*[@class='_1w3ZZo _2mFmU7'])[1]";
	       input10[1]="Sahadeo";
	       seleniumoperation3.Sendkeys(input10);
	       
	       Object[] input11=new Object[2];
	       input11[0]="//*[@name='phone']";
	       input11[1]= "9588406397";
	       seleniumoperation3.Sendkeys(input11);
	       
	       Object[] input12=new Object[2];
	       input12[0]="//*[@name='pincode']";
	    	input12[1]="414006"; 
	        seleniumoperation3.Sendkeys(input12);
	        
	        Object[] input13=new Object[2];
	        input13[0]="(//*[@type='text'])[5]";
	        input13[1]="nagar";
	        seleniumoperation3.Sendkeys(input13);	
	        
	        Object[] input14=new Object[2];
	        input14[0]="//*[@name='addressLine1']";
	        input14[1]="A/p- Baburdi Ghumat";
	        seleniumoperation3.Sendkeys(input14);
	        
	        Object[] input15=new Object[1];
	        input15[0]="(//*[@class='_1XFPmK'])[1]";
	        seleniumoperation3.clickonElement(input15);
	        
	        Object[] input16=new Object[1];
	        input16[0]="(//*[@type='button'])[2]";
	  return seleniumoperation3.clickonElement(input16);
  }
  
}
