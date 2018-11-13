package com.qa.pageobjectmodel;

import java.io.File;
import java.io.IOException;
import java.util.EmptyStackException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class CreateAccountPage {
WebDriver driver;
	
 	public  CreateAccountPage(WebDriver ldriver)
 	{
 		this.driver=ldriver;
 	}
 	@FindBy(how=How.CSS,using="section._25CCJ section._2p91w.col12 article.row div._LWd0 div._2aCzL div:nth-child(3) span:nth-child(1) div._1u2qG > button._3urzx.ekTR_._3VfsG._1M6fS")
 	private static WebElement createaccount;
 	@FindBy(how=How.XPATH,using="//input[@data-automation-id='first_name_input']")
 	private static WebElement Firstname;
 	@FindBy(how=How.XPATH,using="//input[@data-automation-id='last_name_input']")
 	private static WebElement Lastname;
 	@FindBy(how=How.XPATH,using="//input[@placeholder='example@domain.com']")
 	private static WebElement Email;
 	@FindBy(how=How.XPATH,using="//div[@class='lf0zX _1Rp3B SignIn-messageBoxLayout']")
 	private static WebElement EmailNotValid;
 	
 	
	@FindBy(how=How.XPATH,using="//input[@id='phone']")
 	private static WebElement Phone;
 	@FindBy(how=How.XPATH,using="//input[@id='password']")
 	private static WebElement Password;
 	@FindBy(how=How.XPATH,using="//button[@data-automation-id='submit_button']")
 	private static WebElement Submit;
 									
 	public static WebElement getEmailNotValid() {
		return EmailNotValid;
	}

	public static void setEmailNotValid(WebElement emailNotValid) {
		EmailNotValid = emailNotValid;
	}
	
 	public static WebElement getCreateaccount() {
		return createaccount;
	}

	public static void setCreateaccount(WebElement createaccount) {
		CreateAccountPage.createaccount = createaccount;
	}

	public static WebElement getFirstname() {
		return Firstname;
	}

	public static void setFirstname(WebElement firstname) {
		Firstname = firstname;
	}

	public static WebElement getLastname() {
		return Lastname;
	}

	public static void setLastname(WebElement lastname) {
		Lastname = lastname;
	}

	public static WebElement getEmail() {
		return Email;
	}

	public static void setEmail(WebElement email) {
		Email = email;
	}

	public static WebElement getPhone() {
		return Phone;
	}

	public static void setPhone(WebElement phone) {
		Phone = phone;
	}

	public static WebElement getPassword() {
		return Password;
	}

	public static void setPassword(WebElement password) {
		Password = password;
	}


	public static WebElement getSubmit() {
		return Submit;
	}


	public static void setSubmit(WebElement submit) {
		Submit = submit;
	}
	
	public void Create_acc_click1()
	{
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		try {
			wait1.until(ExpectedConditions.visibilityOf(createaccount));
			createaccount.click();
		} catch (Exception e) {
			System.out.println("Element not visible");
		}
	}
	
	public void Create_acc_click(String firstname,String lastname,String email,String phone,String password) throws IOException, InterruptedException
 	{
	
	
	/*Random randomGenerator=new Random();
	int randomInt=randomGenerator.nextInt(1000);
	//String email="Rae_"+randomInt+"@gmail.com";
	Email.sendKeys("Rae_"+randomInt+"@gmail.com");*/
				
	Firstname.sendKeys(firstname);
	Lastname.sendKeys(lastname);
	Email.sendKeys(email);
	Phone.sendKeys(phone);
	Password.sendKeys(password);
	Submit.click();
//Assert.assertEquals("My Dashboard - JCPenney", driver.getTitle());
	
	Thread.sleep(10000);
	String x = driver.getTitle();
	try {
		

		if (!x.equalsIgnoreCase("My Dashboard - JCPenney")) {
			

			System.out.println(x);
			System.out.println("Failed - now Take a screenshot");
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,new File("C:\\Users\\anusuya.balamurugan\\eclipse-workspace\\BDD_Jcpenny\\FailedTestCase\\email.png"));
			throw new EmptyStackException();
		} else {
			System.out.println(x);
			//do nothing
		}
	} catch (Exception e) {
		Assert.assertEquals(1, 2);
		// this is where u take screenshot 
	
	}

 	}
}
