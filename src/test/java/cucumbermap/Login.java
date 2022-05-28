package cucumbermap;

import java.util.Hashtable;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import flipkart01.HTMLReportGenerator;
import flipkart01.seleniumoperation3;

public class Login 
{

	@When ("^User open \"(.*)\" browser with exe as$")
	public void bLaunch(String bname)
	{
		 Object[] input=new Object[1];
		    input[0]=bname;
		    seleniumoperation3.browserlaunch(input);
	
	}
	
	@When ("^user enter URL as$") 
	public void openapp()
	{
		     seleniumoperation3.openapplication();
		
		
	}
	
	@When ("^user cancle initial Login window$")
	public void user_cancle_initial_Login_window() throws Throwable {
		Object []input2=new Object[1];
		input2[0]="//*[@class='_2KpZ6l _2doB4z']";
		seleniumoperation3.clickonElement(input2);
		
	}
	@When ("^user navigate on Login button$")
	public void navigateLogin() throws InterruptedException
	{
		Object[] input3=new Object[1];
	     input3[0]="//*[@class='_1_3w1N']";
	    
	     Hashtable< String,Object> output3=seleniumoperation3.mouseover(input3);
	     HTMLReportGenerator.StepDetails(output3.get("STATUS").toString(), "^user navigate on Login button$", output3.get("MESSAGE").toString());
    		
	}
	@When ("^user click on MyProfile$") 
			public void clickonMyprofile()
			{
		Object[] input4=new Object[1];
	     input4[0]="//*[text()='My Profile']";
	     Hashtable< String,Object> output4=seleniumoperation3.clickonElement(input4);
	     HTMLReportGenerator.StepDetails(output4.get("STATUS").toString(), "^user navigate on Login button$", output4.get("MESSAGE").toString());
	     
			}
			
	@When ("^user enter \"(.*)\" as username$") 
	public void username(String username)
	{
		 Object[] input5=new Object[2];
	     input5[0]="(//*[@type='text'])[2]";
	     input5[1]=username;
	     Hashtable< String,Object> output5= seleniumoperation3.Sendkeys(input5);
	     HTMLReportGenerator.StepDetails(output5.get("STATUS").toString(), "^user enter \"(.*)\" as username$", output5.get("MESSAGE").toString());
	     
	}
	@When ("^user enter \"(.*)\" as password$")
	   public void password(String password)
	   {     Object[] input6=new Object[2];
		     input6[0]="//*[@type='password']";
		     input6[1]=password;
		     Hashtable< String,Object> output6=seleniumoperation3.Sendkeys(input6);
		     HTMLReportGenerator.StepDetails(output6.get("STATUS").toString(), "^user enter \"(.*)\" as password$", output6.get("MESSAGE").toString());
		     
 }

	   @When ("^user click on Login button$")
	   public void LoginB()
	   {Object[] input7=new Object[1];
     	input7[0]="//*[@class='_2KpZ6l _2HKlqd _3AWRsL']";
     	 Hashtable< String,Object> output7=seleniumoperation3.clickonElement(input7);
     	HTMLReportGenerator.StepDetails(output7.get("STATUS").toString(), "^user click on Login button$", output7.get("MESSAGE").toString());
	     
		   
	   }
	   @Then ("^Application shows user profile to user$")
	   public void valid() throws InterruptedException
	   {
		   Thread.sleep(5000);
		   Object[] input8=new Object[2];
		     input8[0]="//*[@class='_1ruvv2']";
		     input8[1]="Sahadeo Zine";
		     Hashtable< String,Object> output8=seleniumoperation3.validation(input8);
		     HTMLReportGenerator.StepDetails(output8.get("STATUS").toString(), "^Application shows user profile to user$", output8.get("MESSAGE").toString());
		     
		    }
	   @Then ("^Application shows appropriate error message$")
	   public void invalid() throws InterruptedException
	   {
		   Thread.sleep(5000);
		   Object[] input9=new Object[2];
		   input9[0]="(//*[text()='Login'])[2]";
			 input9[1]="Login";
			 Hashtable< String,Object> output9=seleniumoperation3.validationForInvalid(input9);
			 HTMLReportGenerator.StepDetails(output9.get("STATUS").toString(), "^Application shows appropriate error message$", output9.get("MESSAGE").toString());
		     
		    }

	   @When ("^user enters (.+) as username$") 
	   public void unameP(String given)
	   {
		   Object[] input10=new Object[2];
		     input10[0]="(//*[@type='text'])[2]";
		     input10[1]=given;
		     seleniumoperation3.Sendkeys(input10);   
		   
	   }
	   @When ("^user enters (.+) as password$")
	   public void pass(String given)
	   {
		   Object[] input11=new Object[2];
		     input11[0]="//*[@type='password']";
		     input11[1]=given;
		     seleniumoperation3.Sendkeys(input11);
		     
	   }

}
