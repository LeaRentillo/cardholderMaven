package CardholderMavenProject;

import CardholderMavenProject.settings;
import CardholderMavenProject.InputValidationTestCase;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

public class Cardholder  {
	 
	public  WebDriver driver,driverProgram,driverRegister;
	public  WebDriverWait wait;
	public  String User = "G00003@100002.com";
	public  String Pass = "nQr6n6Td!9";
	public  String EUUser = "lea.eu.cholder@gmail.com";
	public  String EUPass = "Testing123!-!";
	public  String NonEUUser = "lea.noneu.cholder@gmail.com";
	public  String NonEUPass = "Testing123!-!";
	public  String userProgram = "dev_program";
	public  String passProgram = "Testing1234!!";
	public  String newPasswordTest = "@Password123";
	public static String PIN =  "1234";
	public static String nPIN = "9999";
	public static String cPIN = "9999";
	public static String asd = "Test"; 
	public static String cardNumberCC = "4000000000000002";
	public static String securityNumber = "123";
	public static String testEmail = "lea@iscale-solutuions.com";
	
	DateFormat dateFormat = new SimpleDateFormat("MM-dd-YYYY HH:mm:ss");
	DateFormat timeFormat = new SimpleDateFormat("dd-HHmmss");
	Date date = new Date();
   

@Test (priority = settings.registrationTest , alwaysRun = true)
	  public void Registration() {
		settings testSettings = new settings();
		 if(testSettings.skipTest("registrationTest")){
			 
			 InputValidationTestCase InputValidation = new InputValidationTestCase();
			
			//** FOR FIREFOX BROWSER **//
			   //driver = new firefoxDriver();``
			//********************************** //	 
				
			//** FOR CHROME BROWSER ** //
			   System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Documents\\LEA\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
			   driverRegister = new ChromeDriver();
			//**********************************//	   
			   
			   wait = new WebDriverWait(driverRegister, 20);   
			   
			   driverRegister.manage().window().maximize();
			   driverRegister.get("https://dev.cardholder.an-other.co.uk/user/register/glenmore-consultants-ltd");
				
			   //Fill-up Form"			
				Select dropdownTitle = new Select(driverRegister.findElement(By.name("RegistrationForm[title]")));									
				WebElement ParseFirstName = driverRegister.findElement (By.name("RegistrationForm[firstname]"));
				WebElement ParselastName = driverRegister.findElement (By.name("RegistrationForm[lastname]"));
				WebElement CheckGender = new WebDriverWait(driverRegister, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"registrationform-sex\"]/label[2]/input")));								
				
				Select dropdownDay = new Select(driverRegister.findElement(By.xpath("//*[@id=\"date-dd\"]")));			
				Select dropdownMonth = new Select(driverRegister.findElement(By.xpath("//*[@id=\"date-mm\"]")));			
				Select dropdownYear = new Select(driverRegister.findElement(By.xpath("//*[@id=\"date-yyyy\"]")));			
				WebElement ParseAddress1 = driverRegister.findElement (By.name("RegistrationForm[address1]"));
				WebElement ParseCity = driverRegister.findElement (By.name("RegistrationForm[city]"));
				WebElement ParseZipCode = driverRegister.findElement (By.name("RegistrationForm[postcode]"));
				Select dropdownCountry = new Select(driverRegister.findElement(By.name("RegistrationForm[country]")));			
				WebElement ParseMobile = driverRegister.findElement (By.name("RegistrationForm[mobile_number]"));
				WebElement ParseEmail = driverRegister.findElement (By.name("RegistrationForm[email]"));
				WebElement ParseCaptha = driverRegister.findElement (By.name("RegistrationForm[verifyCode]"));
				WebElement register = driverRegister.findElement(By.xpath("//*[@id=\"RegistrationForm\"]/button"));
				WebElement agree = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"registrationform-agreed_to_terms\"]")));
				
				dropdownTitle.selectByValue("Miss");
				ParseFirstName.sendKeys("Lea "+ timeFormat.format(date));
				ParselastName.sendKeys("Test");		
				CheckGender.click();
				dropdownDay.selectByValue("01");
				dropdownMonth.selectByValue("04");
				dropdownYear.selectByValue("1992");
				ParseAddress1.sendKeys("QA Address 1");
				ParseCity.sendKeys("QA City");
				ParseZipCode.sendKeys("53100");
				dropdownCountry.selectByValue("IT");			  
				ParseMobile.sendKeys("1234567890001");	
				ParseEmail.sendKeys("qa.test."+timeFormat.format(date)+"@email.com");
				//perform duplicate email address
				//ParseEmail.sendKeys("lea@iscale-solutions.com");
				
				
				agree.click();
				ParseCaptha.sendKeys("captcha123");				
				//register.click();
				
				//Assert.assertTrue(true, ParseEmail.getAttribute("aria-invalid"));
				//InputValidation.duplicateFieldValue(ParseEmail);
				
				//input valid email address
				//ParseEmail.clear();
				
				register.click();
				
				WebElement ParseRegistrationStatus =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"w0\"]"))); 
				String registrationStatus = ParseRegistrationStatus.getText();
				System.out.println(registrationStatus);
				Assert.assertTrue(registrationStatus.contains("Your account has been created and a message with further instructions has been sent to your email."));
							 
		}else{
			throw new SkipException("Skipping registrationTest case. ");
		}
	}	
	
@Test (priority = settings.loginTest , alwaysRun = true)
  public void Login() {
	settings testSettings = new settings();
	
	 if(testSettings.skipTest("loginTest")){
		//** FOR FIREFOX BROWSER **//
		   //driver = new firefoxDriver();
		//********************************** //	 
			
		//** FOR CHROME BROWSER ** //
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Documents\\LEA\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
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
	}else{
		throw new SkipException("Skipping LoginTest case. ");
	}
}

@Test (priority = settings.accountTest,alwaysRun = true)
  public void Account() {
	settings testSettings = new settings();
	if(testSettings.skipTest("accountTest")){
		String Email; 
		String textProfile;
		
		
		
		WebElement Profile = driver.findElement(By.xpath("//*[@id=\"lnk-account-settings\"]"));
		Profile.click();
		WebElement Account = driver.findElement(By.cssSelector("a[href='/user/settings/account']"));
		Account.click();
		
		Email = driver.findElement(By.xpath("//*[@id=\"email\"]")).getAttribute("value");
		textProfile = driver.findElement(By.xpath("//*[@id=\"lnk-account-settings\"]")).getAttribute("innerHTML");

		
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
	}else{
		throw new SkipException("Skipping accountTest case. ");
	}
	
  }	
@Test (priority = settings.profileTest,alwaysRun = true)
  public void Profile() {
	settings testSettings = new settings();
	if(testSettings.skipTest("profileTest")){
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

	}else{
		throw new SkipException("Skipping profileTest case. ");
	}
	
	
}

@Test (priority = settings.loadByBankTransfertest, alwaysRun = true)
public void LoadByBankTransfer() {	
	settings testSettings = new settings();
	if(testSettings.skipTest("loadByBankTransfertest")){
		String loadByBankStatusNotes,loadByBankStatus;
		String inputAmount = "50";
		String bankName = "Automated Testing" + dateFormat.format(date);
		String accountNumber = "12345678911";
		String accountName = "Testing Account Name";
		driver.get("https://dev.cardholder.an-other.co.uk/");
		
		WebElement loadButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-load-card']"));
		loadButton.click();
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Load by Bank Transfer')]"))).click();
		
		
		wait = new WebDriverWait(driver, 30);
		
		WebElement loadAmount = driver.findElement(By.xpath("//*[@id=\"load-amount\"]"));
		WebElement i_nameOfBank = driver.findElement(By.xpath("//*[@id=\"bank-name\"]"));
		WebElement i_accountName = driver.findElement(By.xpath("//*[@id=\"account-name\"]"));
		WebElement i_accountNumber = driver.findElement(By.xpath("//*[@id=\"account-number\"]"));
		loadAmount.sendKeys(inputAmount);
		i_nameOfBank.sendKeys(bankName);
		i_accountName.sendKeys(accountName);
		i_accountNumber.sendKeys(accountNumber);
		
		
		WebElement agreeTerms = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='loadcard-agreed_to_terms']")));
		agreeTerms.click();
		WebElement Proceed = driver.findElement(By.cssSelector("button[class='btn btn-default btn-pay-bank']"));
		Proceed.click(); 
		
		wait = new WebDriverWait(driver, 30);
		WebElement loadByBank = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-content\"]/div/div/h1")));
				
		loadByBankStatusNotes = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/p[2]/strong")).getText();
		loadByBankStatus = loadByBank.getText();
		System.out.println(loadByBankStatus);
		System.out.println(loadByBankStatusNotes);
		Assert.assertTrue(loadByBankStatus.contains("Please transfer your payment to our bank details below"));	
		Assert.assertTrue(loadByBankStatusNotes.contains("banktransfer-"));		
		
	}else{
		throw new SkipException("Skipping loadByBankTransfertest case. ");
	}
  

}
@Test (priority = settings.suspendedTest,alwaysRun = true) 
  public void Suspend() {
	settings testSettings = new settings();
	if(testSettings.skipTest("suspendedTest")){
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
	}else{
		throw new SkipException("Skipping suspendedTest case. ");
	}

	
	
}
@Test (priority = settings.pinTest,alwaysRun = true)
  public void PIN() {
	if (driver != null)
		driver.quit();
	
	settings testSettings = new settings();
	if(testSettings.skipTest("pinTest")){
		//** FOR CHROME BROWSER ** //
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Documents\\LEA\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//**********************************//	   
				
		wait = new WebDriverWait(driver, 20);   
				   
		driver.manage().window().maximize();
		driver.get("https://dev.cardholder.an-other.co.uk/");

		WebElement SignIn1 = driver.findElement(By.xpath("//*[@id=\"LoginForm\"]/button"));
		WebElement Username1 = driver.findElement(By.xpath("//*[@id=\"loginform-login\"]"));
		Username1.sendKeys(EUUser);
		WebElement Password1 = driver.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
		Password1.sendKeys(EUPass);
		SignIn1.click();
				
		String successPIN;
		driver.get("https://dev.cardholder.an-other.co.uk/");

		//WebElement buttonPIN = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"prepaid-cards-container\"]/table/tbody/tr[1]/td[4]/span[4]/button")));
		WebElement buttonPIN = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-default btn-pin-card']")));
		buttonPIN.click();

		
		WebElement currentPIN = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("changepinform-current_pin")));
		//WebElement currentPIN = driver.findElement(By.id("changepinform-current_pin"));
		currentPIN.sendKeys(PIN);
		
		
		
		WebElement newPIN = driver.findElement(By.cssSelector("input[id='changepinform-new_pin']"));
		newPIN.sendKeys(nPIN);

		WebElement confirmPIN = driver.findElement(By.cssSelector("input[id='changepinform-confirm_pin']"));
		confirmPIN.sendKeys(nPIN);
		
		
		Actions action = new Actions(driver);
		
		//WebElement Sumbit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		WebElement Sumbit = driver.findElement(By.xpath("//*[@id=\"changePinModal\"]/div/div/div[3]/button[2]"));
		action.moveToElement(Sumbit).click().perform();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		successPIN = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert-dismissible alert-success change-pin alert fade in']"))).getText();
		//successPIN = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alert-dismissible alert-danger error-updating-pin alert fade in']"))).getText();
		
		
	//** Validation when user change his/her PIN there should be a message on upper right displayed "The PIN is successfully changed" **//
		Assert.assertTrue(successPIN.contains("Your PIN has been changed."));

	//** Reverting Back to old PIN ** //
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
		
		WebElement buttonPIN2 = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-default btn-pin-card']")));
		buttonPIN2.click();

		WebElement currentPIN2 = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("changepinform-current_pin")));		
		currentPIN2.sendKeys(nPIN);		
		WebElement newPIN1 = driver.findElement(By.cssSelector("input[id='changepinform-new_pin']"));
		newPIN1.sendKeys(PIN);
		System.out.println(PIN);
		System.out.println(nPIN);
		WebElement confirmPIN1 = driver.findElement(By.cssSelector("input[id='changepinform-confirm_pin']"));
		confirmPIN1.sendKeys(PIN);
		WebElement Sumbit2 = driver.findElement(By.xpath("//*[@id=\"changePinModal\"]/div/div/div[3]/button[2]"));
		action.moveToElement(Sumbit2).click().perform();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}else{
		throw new SkipException("Skipping pinTest case. ");
	}
	
	

	
	
}
@Test (priority = settings.statementTest,alwaysRun = true)
  public void Statement() {
	settings testSettings = new settings();
	if(testSettings.skipTest("statementTest")){
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
	}else{
		throw new SkipException("Skipping statementTest case. ");
	}
	
	
}
@Test (priority = settings.unloadTest, alwaysRun = true)
  public void Unload() {
	settings testSettings = new settings();
	if(testSettings.skipTest("unloadTest")){	
		
		String input = "10";
		String Name = "Automated Testing" + dateFormat.format(date);
		String BankName = "Bank1";
		String Country = "United Kingdom";
		String AccountNumber = "9090-8080-7070";
		String SortCode = "1234";
		String SwiftCode = "7890";
		String IBAN = "GB82 WEST 1234 5678 9";
		String RFT = "Automated Testing" + dateFormat.format(date);
		String notes = "Automated Testing" + dateFormat.format(date);
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
		
		
		Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"load-fee-range-error\"]")).size() > 0;
		if(!isPresent) {
			WebElement Agree = driver.findElement(By.name("agreed_to_terms"));
			Agree.click();
			/*wait = new WebDriverWait(driver, 10); 
			WebElement Agree = wait.until(ExpectedConditions.elementToBeClickable(By.name("agreed_to_terms")));
			Agree.click();*/
			
			WebElement Proceed = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"proceed-unload\"]")));
			Proceed.click();
				
			
			wait = new WebDriverWait(driver, 30);
			WebElement Beneficiary =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='withdrawalform-beneficiaryname']")));	
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
			
			WebElement Submit = driver.findElement(By.cssSelector("#w0 > div:nth-child(13) > div > button"));
			Submit.click();
			
			wait = new WebDriverWait(driver, 30);
			
			if (wait.until(ExpectedConditions.titleContains("Cardholder Dashboard"))) {
				WebElement ParseUnloadStatus = driver.findElement(By.xpath("//*[@id=\"w0\"]"));
				String unloadStatus = ParseUnloadStatus.getText();
				System.out.println(unloadStatus);	
				Assert.assertTrue(unloadStatus.contains("Unload card request has been processed. Changes may take a few moments to reflect in your balance."));
				
		}else {
			WebElement ParseUnloadStatus = driver.findElement(By.xpath("//*[@id=\"load-fee-range-error\"]"));
			String unloadStatus = ParseUnloadStatus.getText();
			System.out.println(unloadStatus);	
			Assert.assertTrue(unloadStatus.contains("Insufficient"));
		}
		
		
	}
		
		
		
	}else{
		throw new SkipException("Skipping unloadTest case. ");
	}
	
	
	
}
@Test (priority = settings.viewImageTest, alwaysRun = true)
  public void ViewImage() throws IOException {
	settings testSettings = new settings();
	if(testSettings.skipTest("viewImageTest")){
		//String fileWithPath = "C:\\Another Screenshots\\ViewImage.png";
		driver.get("https://dev.cardholder.an-other.co.uk/");
		WebElement ViewImage = driver.findElement(By.xpath("//button[@class='btn btn-default btn-view-cardimage new-card']"));
		ViewImage.click();
		
		WebElement ModalViewImage = driver.findElement(By.xpath("//img[@id='card-image-frame']"));
		Assert.assertTrue(ModalViewImage.isEnabled());
	}else{
		throw new SkipException("Skipping viewImageTest case. ");
	}
	
}


@Test (priority = settings.orderCardEUTest, alwaysRun = true)	
public void OrderCardEU(){
	if (driver != null)
		driver.quit();
	
	  // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary']"))).click();
	
	settings testSettings = new settings();
	if(testSettings.skipTest("orderCardEUTest")){

		//** FOR CHROME BROWSER ** //
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Documents\\LEA\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//**********************************//	   
		wait = new WebDriverWait(driver, 20);   
			   
		//driver.manage().window().maximize();
		driver.get("https://dev.cardholder.an-other.co.uk/");

		WebElement SignIn1 = driver.findElement(By.xpath("//*[@id=\"LoginForm\"]/button"));
		WebElement Username1 = driver.findElement(By.xpath("//*[@id=\"loginform-login\"]"));
		Username1.sendKeys(EUUser);
		WebElement Password1 = driver.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
		Password1.sendKeys(EUPass);
		SignIn1.click();
			   

		WebElement orderButton =  new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-default btn-activate-new-card']")));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(orderButton).click().perform();
					
		//WebElement PINcode = driver.findElement();
		//WebElement oCheckBox = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ordercardform-card_type\"]/label[1]/input")));
		//oCheckBox.click();
		
		WebElement PINcode = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='ordercardform-pin']")));
		PINcode.sendKeys(PIN);
		
		WebElement Submit = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderCardModal\"]/div/div/div[3]/button[2]")));
		Submit.click();
		wait = new WebDriverWait(driver, 30);
		
		WebElement agree = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='loadcard-agreed_to_terms']")));
		agree.click();
			
		WebElement payment = driver.findElement(By.cssSelector("button[class='btn btn-default btn-pay-order-card']"));
		payment.click();
			
			
		wait = new WebDriverWait(driver, 60);	
		WebElement creditcard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new_card_num")));
		creditcard.sendKeys(cardNumberCC);
	  
		WebElement securityCode = driver.findElement(By.name("new_card_cvv"));
		securityCode.sendKeys(securityNumber);
		  
		Select dropdownMonth = new Select(driver.findElement(By.name("new_card_exp_m")));
		dropdownMonth.selectByValue("12");
		 
		Select dropdownYear = new Select(driver.findElement(By.name("new_card_exp_y")));
		dropdownYear.selectByValue("2019");
		  
		WebElement paymentEmail = driver.findElement(By.name("new_user_email"));
		paymentEmail.sendKeys("testEmail");
		  
	  	WebElement submitPay = driver.findElement(By.name("ok"));
		submitPay.click();
		  
		wait = new WebDriverWait(driver, 30);	
		WebElement nextPaymentForm = wait.until(ExpectedConditions.visibilityOfElementLocated( By.cssSelector("form[id='nxt']")));
		Assert.assertTrue(nextPaymentForm.isEnabled());
		wait = new WebDriverWait(driver, 10);
	 
		WebElement confirmPayment = driver.findElement(By.name("ok"));
		confirmPayment.click();
		  
		wait = new WebDriverWait(driver, 50);
		WebElement displayCard = wait.until(ExpectedConditions.visibilityOfElementLocated( By.id("card-image-frame")));
			
		if(displayCard.isEnabled()) {
			Assert.assertTrue(displayCard.isEnabled());
			wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//*[@id=\"cardImageModal\"]/div/div/div[3]/button"))).click();

			WebElement ParseOrderCardStatus = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"w0\"]")));
			String OrderCardStatus = ParseOrderCardStatus.getText();
			Assert.assertTrue(OrderCardStatus.contains("Card successfully created! Please wait for the popup to view the card image or click the link below the card number."));
			
		}else {
			System.out.println("Error with reference.");
		}
	}else{
		throw new SkipException("Skipping orderCardEUTest case. ");
	}
	
}

@Test (priority = settings.orderCardNonEUTest, alwaysRun = true)	
public void OrderCardNonEU(){
	if (driver != null)
		driver.quit();
	
	settings testSettings = new settings();
	if(testSettings.skipTest("orderCardNonEUTest")){
		//** FOR CHROME BROWSER ** //
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Documents\\LEA\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//**********************************//	   
		
		wait = new WebDriverWait(driver, 20);   
			   
		driver.manage().window().maximize();
		driver.get("https://dev.cardholder.an-other.co.uk/");

		WebElement SignIn1 = driver.findElement(By.xpath("//*[@id=\"LoginForm\"]/button"));
		WebElement Username1 = driver.findElement(By.xpath("//*[@id=\"loginform-login\"]"));
		Username1.sendKeys(NonEUUser);
		WebElement Password1 = driver.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
		Password1.sendKeys(NonEUPass);
		SignIn1.click();
			   
		// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary']"))).click();
			   

		WebElement orderButton =  new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-default btn-activate-new-card']")));
		Actions actions = new Actions(driver);
		actions.moveToElement(orderButton).click().perform();

		
		//WebElement PINcode = driver.findElement();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		WebElement oCheckBox = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ordercardform-card_type\"]/label[1]/input")));
			
			
		oCheckBox.click();
		WebElement PINcode = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='ordercardform-pin']")));
		PINcode.sendKeys(PIN);
			
		WebElement Submit = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderCardModal\"]/div/div/div[3]/button[2]")));
		Submit.click();
		wait = new WebDriverWait(driver, 30);
			
		WebElement agree = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='loadcard-agreed_to_terms']")));
		agree.click();
			
		WebElement payment = driver.findElement(By.cssSelector("button[class='btn btn-default btn-pay-order-card']"));
		payment.click();
			
		//For nonEu members, ordering card will skip the cashflow payment page
		wait = new WebDriverWait(driver, 30);
		WebElement displayCard = wait.until(ExpectedConditions.visibilityOfElementLocated( By.id("card-image-frame")));
			
		if(displayCard.isEnabled()) {
			Assert.assertTrue(displayCard.isEnabled());
			wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//*[@id=\"cardImageModal\"]/div/div/div[3]/button"))).click();

			WebElement ParseOrderCardStatus = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"w0\"]")));
			String OrderCardStatus = ParseOrderCardStatus.getText();
			Assert.assertTrue(OrderCardStatus.contains("Card successfully created! Please wait for the popup to view the card image or click the link below the card number."));
			Assert.assertTrue(OrderCardStatus.contains("Thank you for your order. You will receive a call from our call center to process the payment."));
				
		}else {
			System.out.println("Error with reference.");
		}
	}else{
		throw new SkipException("Skipping orderCardNonEUTest case. ");
	}	
}

@Test (priority = settings.loadByCardEUTest, alwaysRun = true)
public void LoadByCardEU() {	
	String programName,TotalAmount,TotalText,cardNumber;
	String inputAmount = "50";
	double Total;
	double LoadAmountInt;
	double Fee;
	double percent = 0.02;
	double loadFee = 2;
	
	if (driver != null)
		driver.quit();
	
	
	settings testSettings = new settings();
	if(testSettings.skipTest("loadByCardEUTest")){
		//** FOR CHROME BROWSER ** //
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Documents\\LEA\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//**********************************//	   
		
		wait = new WebDriverWait(driver, 20);   
		   
		driver.manage().window().maximize();
		driver.get("https://dev.cardholder.an-other.co.uk/");

		WebElement SignIn1 = driver.findElement(By.xpath("//*[@id=\"LoginForm\"]/button"));
		WebElement Username1 = driver.findElement(By.xpath("//*[@id=\"loginform-login\"]"));
		Username1.sendKeys(EUUser);
		WebElement Password1 = driver.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
		Password1.sendKeys(EUPass);
		SignIn1.click();
		   
		wait = new WebDriverWait(driver, 30);
		WebElement loadedCard = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"prepaid-cards-container\"]/table/tbody/tr[1]/td[1]/span")));
		WebElement loadButton = driver.findElement(By.cssSelector("#prepaid-cards-container > table > tbody > tr:nth-child(1) > td:nth-child(4) > span:nth-child(1) > button"));
		loadButton.click();
		
		cardNumber = loadedCard.getText();
		cardNumber = cardNumber.substring (0,16);
		System.out.println(cardNumber);
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Load from Card')]"))).click();
		
		
		wait = new WebDriverWait(driver, 30);
		
		WebElement loadAmount = driver.findElement(By.xpath("//*[@id=\"load-amount\"]"));
		loadAmount.sendKeys(inputAmount);	
		
		loadAmount.sendKeys(Keys.ENTER);			
		
		WebElement agreeTerms = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='loadcard-agreed_to_terms']")));
		agreeTerms.click();
		
		LoadAmountInt = Double.parseDouble(inputAmount);
		
		//programName = driver.findElement(By.cssSelector("span[class='filter-option pull-left']")).getText();
		
		//if(programName.equals("Global Sourcing Solutions"))
		//{
			Fee = ((LoadAmountInt * percent) + LoadAmountInt) ;
			
			Total = Fee + loadFee;
			
			TotalText = Double.toString(Total);
			WebElement ParseTotalAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#load-card-form > h3.load-total")));
			TotalAmount = ParseTotalAmount.getText();
			
			//Assert.assertTrue(TotalAmount.contains(TotalText));		
		//}
		
		
		WebElement Proceed = driver.findElement(By.cssSelector("button[class='btn btn-default btn-pay']"));
		Proceed.click();
		
		wait = new WebDriverWait(driver, 60);	
		WebElement creditcard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new_card_num")));
		creditcard.sendKeys(cardNumberCC);
	  
		WebElement securityCode = driver.findElement(By.name("new_card_cvv"));
		securityCode.sendKeys(securityNumber);
	  
		Select dropdownMonth = new Select(driver.findElement(By.name("new_card_exp_m")));
		dropdownMonth.selectByValue("12");
	 
		Select dropdownYear = new Select(driver.findElement(By.name("new_card_exp_y")));
		dropdownYear.selectByValue("2019");
	  
		WebElement paymentEmail = driver.findElement(By.name("new_user_email"));
		paymentEmail.sendKeys("testEmail");

		WebElement submitPay = driver.findElement(By.name("ok"));
		submitPay.click();
	  
		wait = new WebDriverWait(driver, 30);	
		WebElement nextPaymentForm = wait.until(ExpectedConditions.visibilityOfElementLocated( By.cssSelector("form[id='nxt']")));
		Assert.assertTrue(nextPaymentForm.isEnabled());
		wait = new WebDriverWait(driver, 20);
	 
		WebElement confirmPayment = driver.findElement(By.name("ok"));
		confirmPayment.click();	
		
		WebElement ParseUnloadStatus =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"w0\"]"))); 
		String unloadStatus = ParseUnloadStatus.getText();
		System.out.println(unloadStatus);
		Assert.assertTrue(unloadStatus.contains("Your funds will be on your card shortly."));
		
		//Check Programs if load request created record in payment request
	
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Documents\\LEA\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		   driverProgram = new ChromeDriver();
		
		wait = new WebDriverWait(driverProgram, 20);   
		   
		driverProgram.manage().window().maximize();
		driverProgram.get("https://dev.program.an-other.co.uk/");
		   
			WebElement LoginLogo = driverProgram.findElement (By.cssSelector("img[class='login-logo']"));
			Assert.assertTrue(LoginLogo.isDisplayed());			
			WebElement SignIn2 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"LoginForm\"]/button")));
			   WebElement Username2 = driverProgram.findElement(By.xpath("//*[@id=\"loginform-login\"]"));
			   Username2.sendKeys(userProgram);
			   WebElement Password2 = driverProgram.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
			   Password2.sendKeys(passProgram);
			   SignIn2.click();
			   
			   wait = new WebDriverWait(driverProgram, 30);   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/form/div[1]/select")));
			   Select dropdownProgram = new Select(driverProgram.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/form/div[1]/select")));
			   dropdownProgram.selectByValue("100003");
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary']"))).click();
			   
			 //LoginPage User
			 	String AccountVisible;
			 			
			 	
			 	AccountVisible = driverProgram.findElement(By.cssSelector("a[href='/user/settings/account']")).getAttribute("innerHTML");
			 	
			 	if (AccountVisible.equals(userProgram))
			 	{
			 		
			 	}
			 	else
			 	{
			 		System.out.println("ERROR");
			 	}
			 	
			 	//Payments	#w0 > li:nth-child(2) 
				/*WebElement Payment = driverProgram.findElement(By.cssSelector("#w0 > li:nth-child(2) > a"));
				Payment.click();
				
				WebElement SendPayment = driverProgram.findElement(By.cssSelector("#w1 > li:nth-child(1) > a"));
				SendPayment.click();
				
				WebElement CardNumber = driverProgram.findElement(By.name("PaymentRequestSearch[card_number]"));
				CardNumber.sendKeys(cardNumber);
				
				//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary']"))).click();
				Select paymentType = new Select(driverProgram.findElement(By.name("PaymentRequestSearch[type]")));
				paymentType.selectByValue("cashflows_payment");
				wait = new WebDriverWait(driverProgram, 30);*/
			 	
			 	driverProgram.get("https://dev.program.an-other.co.uk/payment-request?PaymentRequestSearch[payment_request_id]=&PaymentRequestSearch[card_number]="+cardNumber+"&PaymentRequestSearch[type]=cashflows_payment&PaymentRequestSearch[fname]=&PaymentRequestSearch[lname]=&sort=-payment_request_id");
			 					
				//if (wait.until(ExpectedConditions.urlContains("PaymentRequestSearch[payment_request_id]=&&PaymentRequestSearch%5Bcard_number%5D="+cardNumber+"&PaymentRequestSearch%5Btype%5D=cashflows_payment"))) {
					WebElement baseTable = driverProgram.findElement(By.xpath("//*[@id=\"table-payment-requests-pjax\"]"));
					WebElement LoadValue = baseTable.findElement(By.xpath("//*[@id=\"table-payment-requests-container\"]/table/tbody/tr/td[7]"));
										
					System.out.println(LoadValue.getText());
					Assert.assertTrue(LoadValue.getText().contains(inputAmount+".00"));		
					
				//}
				driverProgram.quit();
	}else{
		throw new SkipException("Skipping loadByCardEUTest case. ");
	}
  

}

@Test (priority = settings.loadByCardNonEUTest, alwaysRun = true)
public void LoadByCardNonEU() {	
	String programName,TotalAmount,TotalText,cardNumber;
	String inputAmount = "50";
	double Total;
	double LoadAmountInt;
	double Fee;
	double percent = 0.02;
	double loadFee = 2;
	
	if (driver != null) {
		driver.quit();
	}
	
	settings testSettings = new settings();
	if(testSettings.skipTest("loadByCardNonEUTest")){
		
	//** FOR CHROME BROWSER ** //
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Documents\\LEA\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	//**********************************//	   
		wait = new WebDriverWait(driver, 20);  
		driver.manage().window().maximize();
		driver.get("https://dev.cardholder.an-other.co.uk/");

		WebElement SignIn1 = driver.findElement(By.xpath("//*[@id=\"LoginForm\"]/button"));
		WebElement Username1 = driver.findElement(By.xpath("//*[@id=\"loginform-login\"]"));
		Username1.sendKeys(NonEUUser);
		WebElement Password1 = driver.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
		Password1.sendKeys(NonEUPass);
		SignIn1.click();
		
		wait = new WebDriverWait(driver, 30);
		WebElement loadedCard = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"prepaid-cards-container\"]/table/tbody/tr[1]/td[1]/span")));
		WebElement loadButton = driver.findElement(By.cssSelector("#prepaid-cards-container > table > tbody > tr:nth-child(1) > td:nth-child(4) > span:nth-child(1) > button"));
		loadButton.click();
		
		cardNumber = loadedCard.getText();
		cardNumber = cardNumber.substring (0,16);
		System.out.println(cardNumber);
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Load from Card')]"))).click();
		
		
		wait = new WebDriverWait(driver, 30);
		
		WebElement loadAmount = driver.findElement(By.xpath("//*[@id=\"load-amount\"]"));
		loadAmount.sendKeys(inputAmount);	
		
		loadAmount.sendKeys(Keys.ENTER);			
		
		WebElement agreeTerms = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='loadcard-agreed_to_terms']")));
		agreeTerms.click();
		
		LoadAmountInt = Double.parseDouble(inputAmount);
		
		//programName = driver.findElement(By.cssSelector("span[class='filter-option pull-left']")).getText();
		
		//if(programName.equals("Global Sourcing Solutions"))
		//{
			Fee = ((LoadAmountInt * percent) + LoadAmountInt) ;
			
			Total = Fee + loadFee;
			
			TotalText = Double.toString(Total);
			WebElement ParseTotalAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#load-card-form > h3.load-total")));
			TotalAmount = ParseTotalAmount.getText();
			
			//Assert.assertTrue(TotalAmount.contains(TotalText));		
		//}
		
		
		WebElement Proceed = driver.findElement(By.cssSelector("button[class='btn btn-default btn-pay']"));
		Proceed.click();
		
		wait = new WebDriverWait(driver, 30);
		WebElement ParseloadStatus =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-dismissible.alert-success.order-payment.alert.fade.in"))); 
		String loadStatus = ParseloadStatus.getText();

		System.out.println("ss");
		System.out.println(loadStatus+"aa");
		Assert.assertTrue(loadStatus.contains("You will receive a call from our call center to process the payment."));
		
		//Check Programs if load request created record in payment request
	
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Documents\\LEA\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		   driverProgram = new ChromeDriver();
		
		wait = new WebDriverWait(driverProgram, 20);   
		   
		driverProgram.manage().window().maximize();
		driverProgram.get("https://dev.program.an-other.co.uk/");
		   
			WebElement LoginLogo = driverProgram.findElement (By.cssSelector("img[class='login-logo']"));
			Assert.assertTrue(LoginLogo.isDisplayed());			
			WebElement SignIn2 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"LoginForm\"]/button")));
			   WebElement Username2 = driverProgram.findElement(By.xpath("//*[@id=\"loginform-login\"]"));
			   Username2.sendKeys(userProgram);
			   WebElement Password2 = driverProgram.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
			   Password2.sendKeys(passProgram);
			   SignIn2.click();
			   
			   wait = new WebDriverWait(driverProgram, 30);   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/form/div[1]/select")));
			   Select dropdownProgram = new Select(driverProgram.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/form/div[1]/select")));
			   dropdownProgram.selectByValue("100003");
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary']"))).click();
			   
			 //LoginPage User
			 	String AccountVisible;
			 			
			 	
			 	AccountVisible = driverProgram.findElement(By.cssSelector("a[href='/user/settings/account']")).getAttribute("innerHTML");
			 	
			 	if (AccountVisible.equals(userProgram))
			 	{
			 		
			 	}
			 	else
			 	{
			 		System.out.println("ERROR");
			 	}
			 	
			 	//Payments	#w0 > li:nth-child(2) 
				/*WebElement Payment = driverProgram.findElement(By.cssSelector("#w0 > li:nth-child(2) > a"));
				Payment.click();
				
				WebElement SendPayment = driverProgram.findElement(By.cssSelector("#w1 > li:nth-child(1) > a"));
				SendPayment.click();
				
				WebElement CardNumber = driverProgram.findElement(By.name("PaymentRequestSearch[card_number]"));
				CardNumber.sendKeys(cardNumber);
				
				//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary']"))).click();
				Select paymentType = new Select(driverProgram.findElement(By.name("PaymentRequestSearch[type]")));
				paymentType.selectByValue("cashflows_payment");
				wait = new WebDriverWait(driverProgram, 30);*/
			 	
			 	driverProgram.get("https://dev.program.an-other.co.uk/payment-request?PaymentRequestSearch[payment_request_id]=&PaymentRequestSearch[card_number]="+cardNumber+"&PaymentRequestSearch[type]=cashflows_payment&PaymentRequestSearch[fname]=&PaymentRequestSearch[lname]=&sort=-payment_request_id");
			 					
				//if (wait.until(ExpectedConditions.urlContains("PaymentRequestSearch[payment_request_id]=&&PaymentRequestSearch%5Bcard_number%5D="+cardNumber+"&PaymentRequestSearch%5Btype%5D=cashflows_payment"))) {
					WebElement baseTable = driverProgram.findElement(By.xpath("//*[@id=\"table-payment-requests-pjax\"]"));
					WebElement LoadValue = baseTable.findElement(By.xpath("//*[@id=\"table-payment-requests-container\"]/table/tbody/tr/td/div"));
										
					System.out.println(LoadValue.getText());
					Assert.assertTrue(LoadValue.getText().contains("No results found.")); //there should no record inserted. load payment will be manually created after NonEu Member pays the amount.
					
				//}
				driverProgram.quit();
	}else{
		throw new SkipException("Skipping loadByCardNonEUTest case. ");
	}
  

}

}//main