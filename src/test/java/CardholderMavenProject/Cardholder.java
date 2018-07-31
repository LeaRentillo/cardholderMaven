package CardholderMavenProject;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class Cardholder {
   public  WebDriver driver;
   public  WebDriverWait wait;
   public  String User = "G00003@100002.com";
   public  String Pass = "nQr6n6Td!9";
   public  String newPasswordTest = "@Password123";
   public static String PIN =  "1234";
   public static String nPIN = "9999";
   public static String cPIN = "9999";
   public static String asd = "Test"; 
   public static String cardNumber = "5100000000000511";
   public static String securityNumber = "123";
   
@Test (priority = 1, alwaysRun = true)
  public void Login() {
	
//** FOR FIREFOX BROWSER **//
   //driver = new firefoxDriver();
//********************************** //	 
	
//** FOR CHROME BROWSER ** //
   System.setProperty("webdriver.chrome.driver","C:\\Selenium\\ChromeDriver\\chromedriver.exe");
   driver = new ChromeDriver();
//**********************************//	   
   
   
   wait = new WebDriverWait(driver, 20);
   
   
   driver.manage().window().maximize();
   driver.get("https://dev.cardholder.an-other.co.uk/");
   
	WebElement LoginLogo = driver.findElement (By.cssSelector("img[class='login-logo']"));
	Assert.assertTrue(LoginLogo.isDisplayed());
	WebElement forgotPassword = driver.findElement (By.xpath("//a[@href='/user/recovery/request']"));
	forgotPassword.click();
	WebElement ForgotPassword = driver.findElement (By.cssSelector("h3[class='panel-title'"));
	WebElement Sumbit = driver.findElement(By.cssSelector ("button[class='btn btn-primary btn-block']"));
	if (ForgotPassword.isDisplayed()  &&  Sumbit.isDisplayed() )
	{ 
		
	}
	else
	{
		System.out.println("ERROR");
	}
	
//Navigate Back
	driver.navigate().back();
	
//Didn't receive confirmation message?
	driver.findElement(By.xpath("//*[@id=\"login-panel\"]/div/p/a")).click();
	WebElement EmailText = driver.findElement(By.xpath("//*[@id=\"resendform-email\"]"));
	WebElement ConfirmButton = driver.findElement(By.xpath("//*[@id=\"ResendForm\"]/button"));
	if (EmailText.isDisplayed()  &&  ConfirmButton.isDisplayed())
	{ 
		
	}
	else
	{
		System.out.println("ERROR");
	}
	
//Navigate Back
	driver.navigate().back();
	
//Tick "Remember me next time"
	WebElement Remember = driver.findElement(By.xpath("//*[@id=\"loginform-rememberme\"]"));
	Remember.click();
	Assert.assertTrue(Remember.isSelected());
	
	
   WebElement SignIn1 = driver.findElement(By.xpath("//*[@id=\"LoginForm\"]/button"));
   WebElement Username1 = driver.findElement(By.xpath("//*[@id=\"loginform-login\"]"));
   Username1.sendKeys(User);
   WebElement Password1 = driver.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
   Password1.sendKeys(Pass);
   SignIn1.click();
   
   wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary']"))).click();
   
 //LoginPage User
 	String AccountVisible;
 	String Verification;
 			
 	
 	AccountVisible = driver.findElement(By.cssSelector("a[href='/user/settings/profile']")).getAttribute("innerHTML");
 	Verification = driver.findElement(By.cssSelector("span[class='card-status verified']")).getAttribute("innerHTML");
 	if (Verification.equals("Verified") && AccountVisible.equals(User))
 	{
 		
 	}
 	else
 	{
 		System.out.println("ERROR");
 	}
 	
 	
}
@Test (priority = 2,alwaysRun = true)
  public void Account() {
	String Email; 
	String textProfile;
	
	
	
	WebElement Profile = driver.findElement(By.xpath("//*[@id=\"lnk-account-settings\"]"));
	Profile.click();
	WebElement Account = driver.findElement(By.cssSelector("a[href='/user/settings/account']"));
	Account.click();
	
	Email = driver.findElement(By.xpath("//*[@id=\"email\"]")).getAttribute("value");
	textProfile = driver.findElement(By.xpath("//*[@id=\"lnk-account-settings\"]")).getAttribute("innerHTML");
	
	//System.out.println(Email);
	//System.out.println(textProfile);
	
	if (User.equals(Email) && User.equals(textProfile))
	{
		
		
		//** Current Password **//
		WebElement currentPassword = driver.findElement(By.cssSelector("input[id='settingsform-current_password']"));
		currentPassword.sendKeys(Pass);
		
		//** New Password **//
		WebElement newPassword = driver.findElement(By.cssSelector("input[name='SettingsForm[new_password]'"));
		newPassword.sendKeys(newPasswordTest);
		WebElement repeatNewPassword = driver.findElement(By.cssSelector("input[name='SettingsForm[password_repeat]'"));
		repeatNewPassword.sendKeys(newPasswordTest);
//** changing password must consider other class that the password has changed. - Creating a String method. OR Reset back to the original Password. **//
		
		//WebElement Submit =  Login.driver.findElement(By.cssSelector("button[class='btn btn-block btn-success']"));
		//Submit.click();
		
	}
	else
	{
		System.out.println("ERROR");
	}  
	
	driver.navigate().back(); 
  }	
@Test (priority = 3,alwaysRun = true)
  public void Profile() {
	String displayProfile;
	String profileUpdate;
	
	
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 20);	
	
	
	WebElement Profile = driver.findElement(By.xpath("//*[@id=\"lnk-account-settings\"]"));
	Profile.click();


	displayProfile = driver.findElement(By.cssSelector("li[class='active']")).getText();

	if (displayProfile.equals("Profile"))
	{
		
	}
	else
	{
		System.out.println ("ERROR");
	}
	WebElement saveButton = driver.findElement(By.cssSelector("button[class='btn btn-block btn-success']"));
	saveButton.click();
	
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//*** checking of profile has been updated ***//
	profileUpdate = driver.findElement(By.cssSelector("div[class='alert-dismissible alert-success alert fade in']")).getAttribute("innerHTML");

	if (profileUpdate.contains("Your profile has been updated")) 
	{
		//System.out.println(profileUpdate);
		
	}
	else
	{
		System.out.println("Error");
	}

//*** Profile Picture ***//
	WebElement profilePicture = driver.findElement(By.cssSelector("a[class='gravatar']"));
	profilePicture.click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//*** uploading pictures process ***//
	WebElement avatarChangePopUp = driver.findElement(By.cssSelector("h5[class='modal-title']"));
	if (avatarChangePopUp.isEnabled() )
	{
		
//*** Open file for Profile picture ***//
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary']"))).click(); //** click save changes modal element (Pop-up)**//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
	}
	else
	{
		System.out.println("ERROR");
	}

}
@Test (priority = 4, alwaysRun = true)	
  public void OrderCard(){

	
	driver.get("https://dev.cardholder.an-other.co.uk/");
	WebElement orderButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-activate-new-card']"));
	orderButton.click();
	
	WebElement PINcode = driver.findElement(By.cssSelector("input[id='ordercardform-pin']"));
	PINcode.sendKeys(PIN);
	
	WebElement Submit = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderCardModal\"]/div/div/div[3]/button[2]")));
	Submit.click();
	
	WebElement agree = driver.findElement(By.cssSelector("input[id='loadcard-agreed_to_terms']"));
	agree.click();
	
	WebElement payment = driver.findElement(By.cssSelector("button[class='btn btn-default btn-pay-order-card']"));
	payment.click();
	wait = new WebDriverWait(driver, 60);
	
	driver.switchTo().frame("payment_page");
	

	new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[7]/form/input[5]"))).click();
	

	
    driver.switchTo().defaultContent();
    driver.switchTo().frame("payment_page");
    //WebElement creditcard = driver.findElement(By.id("st-pan-textfield"));
    WebElement creditcard = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("st-pan-textfield")));
    creditcard.sendKeys(cardNumber);
    
    
    driver.switchTo().defaultContent();
    driver.switchTo().frame("payment_page");
    Select dropdownMonth = new Select(driver.findElement(By.id("st-expirymonth-dropdown")));
    dropdownMonth.selectByValue("12");
    
    
    driver.switchTo().defaultContent();
    driver.switchTo().frame("payment_page");
    Select dropdownYear = new Select(driver.findElement(By.id("st-expiryyear-dropdown")));
    dropdownYear.selectByValue("2030");
    
    
    driver.switchTo().defaultContent();
    driver.switchTo().frame("payment_page");
    WebElement securityCode = driver.findElement(By.id("st-securitycode-textfield"));
    securityCode.sendKeys(securityNumber);
	
    driver.switchTo().defaultContent();
    driver.switchTo().frame("payment_page");
    WebElement submitPay = driver.findElement(By.id("submit"));
    submitPay.click();
    
    driver.switchTo().defaultContent();
    wait = new WebDriverWait(driver, 80);

	
}
@Test (priority = 5, alwaysRun = true)
  public void Load() {	
    String programName;
	String TotalAmount;
	String TotalText;
	String inputAmount = "50";
	double Total;
	double LoadAmountInt;
	double Fee;
	double percent = 0.03;
	double loadFee = 2;
	driver.get("https://dev.cardholder.an-other.co.uk/");
	
	WebElement loadButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-load-card']"));
	loadButton.click();
	
	new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Load from Card')]"))).click();
	
	
	wait = new WebDriverWait(driver, 30);
	
	WebElement loadAmount = driver.findElement(By.xpath("//*[@id=\"load-amount\"]"));
	loadAmount.sendKeys(inputAmount);
	//loadAmount.sendKeys(Keys.ENTER);	
	
	 

	WebElement agreeTerms = driver.findElement(By.cssSelector("input[id='loadcard-agreed_to_terms']"));
	agreeTerms.click();
	WebElement Proceed = driver.findElement(By.cssSelector("button[class='btn btn-default btn-pay']"));
	Proceed.click();
	
	
	LoadAmountInt = Double.parseDouble(inputAmount);
	
	programName = driver.findElement(By.cssSelector("span[class='filter-option pull-left']")).getText();
	if(programName.equals("Global Sourcing Solutions"))
	{
		Fee = ((LoadAmountInt * percent) + loadFee) ;
		
		Total = Fee + LoadAmountInt;
		
		TotalText = Double.toString(Total);
		TotalAmount = "53.5";//	
		Assert.assertTrue(TotalText.equals(TotalAmount));		
	}
	
	
	driver.switchTo().frame("payment_page");
	

	new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[7]/form/input[5]"))).click();


    driver.switchTo().defaultContent();
    driver.switchTo().frame("payment_page");
    //WebElement creditcard = driver.findElement(By.id("st-pan-textfield"));
    WebElement creditcard = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("st-pan-textfield")));
    creditcard.sendKeys(cardNumber);
    
    
    driver.switchTo().defaultContent();
    driver.switchTo().frame("payment_page");
    Select dropdownMonth = new Select(driver.findElement(By.id("st-expirymonth-dropdown")));
    dropdownMonth.selectByValue("12");
    
    
    driver.switchTo().defaultContent();
    driver.switchTo().frame("payment_page");
    Select dropdownYear = new Select(driver.findElement(By.id("st-expiryyear-dropdown")));
    dropdownYear.selectByValue("2030");
    
    
    driver.switchTo().defaultContent();
    driver.switchTo().frame("payment_page");
    WebElement securityCode = driver.findElement(By.id("st-securitycode-textfield"));
    securityCode.sendKeys(securityNumber);
    
    driver.switchTo().defaultContent();
    driver.switchTo().frame("payment_page");
    WebElement submitPay = driver.findElement(By.id("submit"));
    submitPay.click();
    
    
	
  
}
@Test (priority = 6,alwaysRun = true) 
  public void Suspend() {

	String UnsuspendText;	
	driver.get("https://dev.cardholder.an-other.co.uk/");

		WebElement Suspend = driver.findElement(By.cssSelector("button[class='btn btn-default btn-block-card '"));
		Suspend.click();
		

// ** Validation if PIN and LOAD Button is disabled ** //
		WebElement LOADbutton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-load-card']"));		
		Assert.assertEquals(false,LOADbutton.isEnabled());
		
			
		WebElement PINbutton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-pin-card']"));
		Assert.assertEquals(false,PINbutton.isEnabled());
		


//** 'UNfreeze' Card and Validation **//
	UnsuspendText = driver.findElement(By.cssSelector("span[class='card-status suspended col-sm-12']")).getAttribute("innerHTML");
	if(UnsuspendText.contains("Suspended"))
	{ 
		WebElement Unfreeze =driver.findElement(By.cssSelector("button[class='btn btn-default btn-block-card btn-unblock-card']"));
		Unfreeze.click();	
		WebElement unLOADbutton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-load-card']"));		
		WebElement unPINbutton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-pin-card']"));
		Assert.assertTrue(unLOADbutton.isEnabled(),"Text1");
	
		Assert.assertTrue(unPINbutton.isEnabled());
		
	
	}
	else
	{
		System.out.println("ERROR");
	}
	
	
}
@Test (priority = 7,alwaysRun = true)
  public void PIN() {
	String successPIN;
	driver.get("https://dev.cardholder.an-other.co.uk/");

	//WebElement buttonPIN = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"prepaid-cards-container\"]/table/tbody/tr[1]/td[4]/span[4]/button")));
	WebElement buttonPIN = driver.findElement(By.cssSelector("button[class='btn btn-default btn-pin-card']"));
	buttonPIN.click();

	
	WebElement currentPIN = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("changepinform-current_pin")));
	//WebElement currentPIN = driver.findElement(By.id("changepinform-current_pin"));
	currentPIN.sendKeys(PIN);
	
	
	
	WebElement newPIN = driver.findElement(By.cssSelector("input[id='changepinform-new_pin']"));
	newPIN.sendKeys(nPIN);

	WebElement confirmPIN = driver.findElement(By.cssSelector("input[id='changepinform-confirm_pin']"));
	confirmPIN.sendKeys(cPIN);
	
	
	Actions action = new Actions(driver);
	
	//WebElement Sumbit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
	WebElement Sumbit = driver.findElement(By.xpath("//*[@id=\"changePinModal\"]/div/div/div[3]/button[2]"));
	action.moveToElement(Sumbit).click().perform();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	
	//successPIN = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert-dismissible alert-success change-pin alert fade in']"))).getText();
	successPIN = driver.findElement(By.cssSelector("div[class='alert-dismissible alert-danger error-updating-pin alert fade in']")).getText();
	
	
//** Validation when user change his/her PIN there should be a message on upper right displayed "The PIN is successfully changed" **//
	Assert.assertTrue(successPIN.contains("Your PIN has been changed."));

//** Reverting Back to old PIN ** //
/*	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
	
	buttonPIN.click();

	currentPIN.sendKeys(nPIN);		
	WebElement newPIN1 = driver.findElement(By.cssSelector("input[id='changepinform-new_pin']"));
	newPIN1.sendKeys(PIN);
	System.out.println("8");
	WebElement confirmPIN1 = driver.findElement(By.cssSelector("input[id='changepinform-confirm_pin']"));
	confirmPIN1.sendKeys(PIN);*/
	

	
	
}
@Test (priority = 8,alwaysRun = true)
  public void Statement() {

	driver.get("https://dev.cardholder.an-other.co.uk/");
	

	WebElement buttonStatement = driver.findElement(By.cssSelector("button[class='btn btn-default btn-view-statement']"));
	buttonStatement.click();
	
	WebElement dropdown = driver.findElement(By.cssSelector("span[class='pull-right']"));
	dropdown.click();
	
	WebElement option = driver.findElement(By.cssSelector("li[data-range-key='Last 30 Days']"));
	option.click();

	
	WebElement Submit = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"card-statement-filter\"]/button")));
	Submit.click();

	wait = new WebDriverWait(driver, 60);
	WebElement cardStatement = driver.findElement(By.cssSelector("div[class='grid-view hide-resize']"));
	Assert.assertTrue(cardStatement.isDisplayed());
	

//** Export PDF and CSV FILE ** //
	
Actions  action = new Actions(driver);
	
    try {
    	WebElement ExportButton = driver.findElement(By.id("w3"));
    	action.moveToElement(ExportButton).click().perform();

    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
	{
    	WebElement ExportButton = driver.findElement(By.id("w3"));
    	action.moveToElement(ExportButton).click().perform();
	}	    
    
	try {
		WebElement saveCSV = driver.findElement(By.xpath("//a[@class='export-csv']"));
		action.moveToElement(saveCSV).click().perform();
	}
	catch(org.openqa.selenium.StaleElementReferenceException ex)
	{
		WebElement saveCSV = driver.findElement(By.xpath("//a[@class='export-csv']"));
		action.moveToElement(saveCSV).click().perform();
	}
	
	
	//WebElement okButton =  driver.findElement(By.xpath("//button[contains(text(),' Ok')]"));
	//WebElement okButton =  driver.findElement(By.xpath("//*[@class=\"btn btn-warning\"]"));
	//wait.until(ExpectedConditions.elementToBeClickable(okButton));
	
	
	
	//action.moveToElement(okButton).click().perform();

	//PDF 	
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
	driver.navigate().refresh();
	
    try {
    WebElement ExportButton = driver.findElement(By.id("w3"));
    action.moveToElement(ExportButton).click().perform();

    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
	{
    	  WebElement ExportButton = driver.findElement(By.id("w3"));
    	    action.moveToElement(ExportButton).click().perform();
	}	
	try {
		WebElement saveCSV = driver.findElement(By.xpath("//a[@class='export-pdf']"));
		action.moveToElement(saveCSV).click().perform();
	}
	catch(org.openqa.selenium.StaleElementReferenceException ex)
	{
		WebElement saveCSV = driver.findElement(By.xpath("//a[@class='export-pdf']"));
		action.moveToElement(saveCSV).click().perform();
	}
	
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
	WebElement ButtonPDF =  driver.findElement(By.xpath("//button[contains(text(),' Ok')]"));
	action.moveToElement(ButtonPDF).click().perform();
	driver.get("https://dev.cardholder.an-other.co.uk/");
	
}
@Test (priority = 9)
  public void Unload() {
	String input = "10";
	String Name = "QA Testing";
	String BankName = "Bank1";
	String Country = "United Kingdom";
	String AccountNumber = "9090-8080-7070";
	String SortCode = "1234";
	String SwiftCode = "7890";
	String IBAN = "GB82 WEST 1234 5678 9";
	String RFT = "For Testing";
	String notes = "for testing";
	String forWait = "Balance: Fetching...";
	
	wait = new WebDriverWait(driver, 100);
	   
	driver.get("https://dev.cardholder.an-other.co.uk/");
	
	WebElement Unload = driver.findElement(By.xpath("//button[contains(text(),'Unload')]"));
	Unload.click();
	driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	


	WebElement FetchingBalance = driver.findElement(By.xpath("//h3[@class='unld-card-balance text-right']"));
	wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(FetchingBalance, forWait)));
		
	WebElement inputUnload = driver.findElement(By.xpath("//*[@id=\"unload-amount\"]"));
	inputUnload.sendKeys(input);
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	WebElement Agree = driver.findElement(By.xpath("//div[@class='form-group field-registrationform-agreed_to_terms']"));
	Agree.click();
	
	WebElement Proceed = driver.findElement(By.xpath("//*[@id=\"proceed-unload\"]"));
	Proceed.click();
	

	WebElement Beneficiary =  driver.findElement(By.xpath("//input[@id='withdrawalform-beneficiaryname']"));
	Beneficiary.sendKeys(Name);
	
	WebElement Bank = driver.findElement(By.xpath("//*[@id=\"withdrawalform-bankname\"]"));
	Bank.sendKeys(BankName);
	
	Select SelectCountry = new Select(driver.findElement(By.id("withdrawalform-bankcountry")));
	SelectCountry.selectByVisibleText(Country);
	
	
	WebElement Account = driver.findElement(By.xpath("//*[@id=\"withdrawalform-accountnumber\"]"));
	Account.sendKeys(AccountNumber);
	
	WebElement sort = driver.findElement(By.xpath("//*[@id=\"withdrawalform-sortcode\"]"));
	sort.sendKeys(SortCode);
	
	WebElement swift = driver.findElement(By.xpath("//*[@id=\"withdrawalform-swiftcode\"]"));
	swift.sendKeys(SwiftCode);
	
	WebElement iban = driver.findElement(By.xpath("//*[@id=\"withdrawalform-iban\"]"));
	iban.sendKeys(IBAN);
	
	WebElement ReasonTransfer = driver.findElement(By.xpath("//*[@id=\"withdrawalform-reasonfortransfer\"]"));
	ReasonTransfer.sendKeys(RFT);
	
	WebElement Remarks = driver.findElement(By.xpath("//*[@id=\"withdrawalform-notes\"]"));
	Remarks.sendKeys(notes);
	
	//WebElement Submit = driver.findElement(By.xpath("//button[contains(text(),'Submit']"));
	//Submit.click();
	
	
}
@Test (priority = 10)
  public void ViewImage() throws IOException {
	//String fileWithPath = "C:\\Another Screenshots\\ViewImage.png";
	driver.get("https://dev.cardholder.an-other.co.uk/");
	WebElement ViewImage = driver.findElement(By.xpath("//button[@class='btn btn-default btn-view-cardimage new-card']"));
	ViewImage.click();
	
	WebElement ModalViewImage = driver.findElement(By.xpath("//img[@id='card-image-frame']"));
	Assert.assertTrue(ModalViewImage.isEnabled());
	
	
}

}//main