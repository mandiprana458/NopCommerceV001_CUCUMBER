package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver Idriver;
	public WebElement listitem;
	public AddCustomerPage(WebDriver rdriver)
	{
		Idriver= rdriver;
		PageFactory.initElements(Idriver, this);
	}
  
	By lnkCustomer_menu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By lnkcustomer_menuitem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By btnAddnew=By.xpath("//a[@class='btn btn-primary']");   //AddNew
    By txtEmail=By.xpath("//input[@id='Email']");
    By txtPassword=By.xpath("//input[@id='Password']");
    By txtCustomerFirstname=By.xpath("//input[@id='FirstName']");
    By txtCustomerLastname=By.xpath("//input[@id='LastName']");
    By txtDob=By.xpath("//input[@id='DateOfBirth']");
    By txtMSex=By.xpath("//label[@for='Gender_Male']");
    By txtFSex=By.xpath("//label[@for='Gender_Female']");
    By txtCompanyName=By.xpath("//input[@id='Company']");
    By txtcustomerroles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
    
    By lstitemAdministrators=By.xpath("//li[normalize-space()='Administrators']");
    By lstitemRegistered=By.xpath("//li[normalize-space()='Registered']");
    By lstitemGuests=By.xpath("//li[normalize-space()='Guests']");
    By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
   
    By drpmgrofVendor=By.xpath("//*[@id=\"VendorId\"]");
    By txtAdminContent=By.xpath("//textarea[@class='form-control']");
    By savedetails=By.xpath("//button[@class='btn btn-primary'and@name='save']");
   
    
              // Action Methods //
    
    public String getPageTitle()
    {
    	return Idriver.getTitle();
    }
    
    public void clickOnCustomerMenu() {
    	Idriver.findElement(lnkCustomer_menu).click();
    }
    public void clickOnCustomerMenuItem() {
    	Idriver.findElement(lnkcustomer_menuitem).click();
    }
    public void clickOnAddnew() {
    	Idriver.findElement(btnAddnew).click();
    }
    public void setEmail(String email) {
    	Idriver.findElement(txtEmail).sendKeys(email);
    }
    public void setPassword(String password) {
    	Idriver.findElement(txtPassword).sendKeys(password);
    }
    
	public void setCustomerrole(String role)throws InterruptedException
    {
    	/*if(!role.equals("Vendors")) //
    	{
        Idriver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div"));
    	} */
    	Idriver.findElement(txtcustomerroles).click();
    	
    	Thread.sleep(3000);
    	if(role.equals("Administrators"))
    	{
    		listitem=Idriver.findElement(lstitemAdministrators);
    	}
    	else if(role.equals("Guests"))
    	{
    		listitem=Idriver.findElement(lstitemGuests);
    	}
    	else if(role.equals("Registered"))
    	{
    		listitem=Idriver.findElement(lstitemRegistered);
    	}
    	else if(role.equals("Vendors"))
    	{
    		listitem=Idriver.findElement(lstitemVendors);
    	}
    }
    public void setFirstName(String Firstname) {
    	Idriver.findElement(txtCustomerFirstname).sendKeys(Firstname);
    }
    public void setLastName(String LastName) {
    	Idriver.findElement(txtCustomerLastname).sendKeys(LastName);
    }
    public void setDOB(String BirthDate) {
    	Idriver.findElement(txtDob).sendKeys(BirthDate);
    }
    public void setManagerOfVendor(String Value) {
    	Select drp=new Select(Idriver.findElement(drpmgrofVendor));
    	drp.selectByVisibleText(Value);
    }
    public void setAdminContent(String comment) {
    	Idriver.findElement(txtAdminContent).sendKeys(comment);
    }
    public void setGender(String gender)
    {
    	if(gender.equals("Male"))
    	{
    		Idriver.findElement(txtMSex).click();
    	}
    	else
    		if(gender.equals("Female"))
        	{
        		Idriver.findElement(txtFSex).click();
        	}
    		
    }
    public void setCompnyname(String CompanyName) {
    	Idriver.findElement(txtCompanyName).sendKeys(CompanyName);
    }
    public void clickOnSave() {
    	Idriver.findElement(savedetails).click();
    
    }
}
    

