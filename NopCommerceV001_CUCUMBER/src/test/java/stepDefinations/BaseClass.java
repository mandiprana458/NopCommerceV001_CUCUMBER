package stepDefinations;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.*;

public class BaseClass {

	 public WebDriver driver;
	 public LoginPage Ip;
	 public AddCustomerPage addCust;
	 
	 //Created for Generating random String For unique Email
	 public static String randomestring() {
		 String generatedString1=RandomStringUtils.randomAlphabetic(5);
		 return(generatedString1);
	 }
}
