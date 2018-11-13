package com.qa.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewRegisterPage {
	WebDriver driver;
 	public  NewRegisterPage(WebDriver ldriver)
 	{
 		this.driver=ldriver;
 	}
 	@FindBy(how=How.XPATH,using="//div[@data-automation-id='acc-info-state']")
 	private static WebElement Sign_In;
 	
 	@FindBy(how=How.XPATH,using="//a[@data-automation-id='acc-signup-register-anchor']")
 	private static WebElement Register_Here;
 	
	public static WebElement getSign_In() {
		return Sign_In;
	}
	public static void setSign_In(WebElement sign_In) {
		Sign_In = sign_In;
	}
	public static WebElement getRegister_Here() {
		return Register_Here;
	}
	public static void setRegister_Here(WebElement register_Here) {
		Register_Here = register_Here;
	}
 	
 	
	public void New_Register_Here() {
	Sign_In.click();
	Register_Here.click();
	}
 	
 	
}
