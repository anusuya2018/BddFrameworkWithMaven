package com.qa.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.pageobjectmodel.CreateAccountPage;
import com.qa.pageobjectmodel.NewRegisterPage;
import com.qa.util.BrowserFactory;
import com.qa.util.Xls_Reader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;





public class Stepdefinition {
	public WebDriver driver;
	Xls_Reader reader=new Xls_Reader("C:\\Users\\anusuya.balamurugan\\eclipse-workspace\\BDD_Jcpenny\\Data\\BDDJcpDataWorksheet.xlsx");

	String firstname= reader.getCellData("Sheet1", "firstname", 2);
	String lastname=reader.getCellData("Sheet1", "lastname", 2);
	String email= reader.getCellData("Sheet1", "email", 2);
	String phone=reader.getCellData("Sheet1", "phone", 2);
	String password=reader.getCellData("Sheet1", "password", 2);
	String country=reader.getCellData("Sheet1", "country", 2);
	String address=reader.getCellData("Sheet1", "address", 2);
	String city=reader.getCellData("Sheet1", "city", 2);
	String state=reader.getCellData("Sheet1", "state", 2);
	String zip=reader.getCellData("Sheet1", "zip", 2);
	String address1=reader.getCellData("Sheet1", "address1", 2);
	String zip1=reader.getCellData("Sheet1", "zip1", 2);
	String city1=reader.getCellData("Sheet1", "city1", 2);
	String state1=reader.getCellData("Sheet1", "state1", 2);
		
@Given("^user opens the browser$")
public void user_open_the_browser() throws Throwable
{
	driver=BrowserFactory.startBrowser("chrome","https://www.jcpenney.com");
}
@Then("^user click register for new user$")
public void user_click_register_for_new_user() throws Throwable
{
	NewRegisterPage Register=PageFactory.initElements(driver,NewRegisterPage.class);
	Register.New_Register_Here();
}
@Then("^user enter username,password,email and phone$")
public void user_enter_username_password_email_and_phone() throws Throwable
{
	CreateAccountPage creAct=PageFactory.initElements(driver,CreateAccountPage.class);
	creAct.Create_acc_click(firstname,lastname,email,phone,password);
	driver.close();
	driver.quit();
}
}
