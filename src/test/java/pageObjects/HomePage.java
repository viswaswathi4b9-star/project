package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//i[@class='fa fa-user']")
	WebElement LinkAccount;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement LinkRegister;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement LinkLogin;
	
	
   public void ClickMyAccount()
   {
	   LinkAccount.click();
   }
   public void ClickRegister()
   {
	   LinkRegister.click();
   }
   public void ClickLogin()
   {
	   LinkLogin.click();
   }

}
