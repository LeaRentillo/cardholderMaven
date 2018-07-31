package CardholderMavenProject;

import org.testng.annotations.Test;
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


public class test {
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
   
@Test (priority = 1)
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
  public void Test() {
	
	
	
}


}//main