package stepDefinations;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class Steps extends BaseClass{
	
	 
	  
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		 System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		Ip=new LoginPage(driver);
	  }
		 
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		 driver.get(url);
		 driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		Ip.setUserName(email);
		Ip.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login()throws InterruptedException  {
	    Ip.clickLogin();
	    Thread.sleep(3000);
	}

	/* @Then("Page title Should be\"Dashboard \\/ nopCommerce administration\"")
	public void page_title_should_be_dashboard_nop_commerce_administration() {
	  
	   
	}  */

	

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title)throws InterruptedException   {
	   if(driver.getPageSource().contains("Login was Unsuccessfully."))
	   {
		   driver.close();
		   Assert.assertTrue(false);
	   }
	   else
	   {
		   Assert.assertEquals(title,driver.getTitle());
	   }
	   Thread.sleep(3000);
	}
	
	
	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		Ip.clickLogout();
		Thread.sleep(3000);
	   
	   
	}
	

	@Then("close browser")
	public void close_browser() {
	   driver.close();
	}


	                                //  Customer Feature Step definitions..//
	
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		addCust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	  
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu()throws InterruptedException{
		Thread.sleep(3000);
		addCust.clickOnCustomerMenu();
		
	   
	}
	@When("User click on customers Menu Item")
	public void user_click_on_customers_menu_item()throws InterruptedException{
		Thread.sleep(3000);
		addCust.clickOnCustomerMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button()throws InterruptedException{
		Thread.sleep(2000);
		addCust.clickOnAddnew();
		
	    
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
	 
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email=randomestring()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		//Registered -default
		// The Customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		addCust.setCustomerrole("Guest");
		Thread.sleep(3000);
		
		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Female");
		addCust.setFirstName("Roji");
		addCust.setLastName("Sahu");
		addCust.setDOB("07/16/1993");
		addCust.setCompnyname("Infosys");
		addCust.setAdminContent("This is For Testing....");
		
	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickOnSave();
		Thread.sleep(2000);
	   
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	    
	}
	
	
}
