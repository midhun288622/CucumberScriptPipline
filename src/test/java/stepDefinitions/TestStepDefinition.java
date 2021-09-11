package stepDefinitions;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MyRunner.Configuration;
import MyRunner.Utils;
import bsh.util.Util;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStepDefinition {
	WebDriver driver;

	@Before
	public void initializeTest() throws MalformedURLException{

		System.setProperty("webdriver.chrome.driver","/Users/mriyas/eclipse-workspace/TEST123/DriverFor_system/chromedriver");
		driver = new ChromeDriver();
	}


	@Given("^Create the test data$")
	public void createTestData() {

		Utils.fileWriter("AB_BOOKING_CB", Utils.getRandomNumber(10));
		Utils.fileWriter("ABA_BOOKING_CB", Utils.getRandomNumber(10));
		Utils.fileWriter("ABACDA_BOOKING_CB", Utils.getRandomNumber(10));
		Utils.fileWriter("AB_Rebook_CB", Utils.getRandomNumber(10));
		Utils.fileWriter("ABA_Rebook_CB", "ABA_Rebook_CB_Test123");
		String previousJobDir=System.getProperty("user.dir");
		System.out.println("Test data preparation "+previousJobDir);
	}

	@Given("^user is already on Login Page$")
	public void i_want_to_launch_the_facebook_in_firefox_browser() {

		driver.get("https://github.com/");

	}

	@When("^title of login page is Git hub$")
	public void i_want_to_authenticate_with_valid_credentails() {

		
		//String projectName1=Configuration.getConfiguration().getProperty("projectName");
		//String projectName2=Configuration.getConfiguration().getProperty("previousProject");
		
		String previousJobDir=System.getProperty("user.dir");
		System.out.println("Test execution "+previousJobDir);
		
		System.out.println("AB_BOOKING_CB  :- "+Utils.fileReader( "AB_BOOKING_CB"));
		System.out.println("ABA_BOOKING_CB  :- "+Utils.fileReader("ABA_BOOKING_CB"));
		System.out.println("ABACDA_BOOKING_CB  :- "+Utils.fileReader( "ABACDA_BOOKING_CB"));
		System.out.println("AB_Rebook_CB  :- "+Utils.fileReader( "AB_Rebook_CB"));
		System.out.println("ABA_Rebook_CB  :- "+Utils.fileReader( "ABA_Rebook_CB"));
		
//		System.out.println("AB_BOOKING_CB  :- "+Utils.fileReader(previousJobDir, "AB_BOOKING_CB"));
//		System.out.println("ABA_BOOKING_CB  :- "+Utils.fileReader(previousJobDir, "ABA_BOOKING_CB"));
//		System.out.println("ABACDA_BOOKING_CB  :- "+Utils.fileReader(previousJobDir, "ABACDA_BOOKING_CB"));
//		System.out.println("AB_Rebook_CB  :- "+Utils.fileReader(previousJobDir, "AB_Rebook_CB"));
//		System.out.println("ABA_Rebook_CB  :- "+Utils.fileReader(previousJobDir, "ABA_Rebook_CB"));
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.MINUTES);
		driver.findElement(By.xpath("//a[@href='/login']")).click();
	}

	@Then("^loginpage is displayed$")
	public void i_want_to_verify_whether_user_navigated_to_home_page_or_not() throws InterruptedException {

		WebElement uname = driver.findElement(By.id("login_field"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement logButton = driver.findElement(By.name("commit"));


		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_field")));

		uname.sendKeys(Configuration.getConfiguration().getProperty("Username"));
		password.sendKeys(Configuration.getConfiguration().getProperty("password"));
		
		Thread.sleep(2000);
		logButton.click();

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='flash flash-full flash-error ']")));


		WebElement errorMsg = driver.findElement(By.xpath("//*[@class='flash flash-full flash-error ']"));

		if(errorMsg.isDisplayed())
		{
			System.out.println("#####################################");
			System.out.println("#####################################");
			System.out.println("#####################################");
			System.out.println("                                     ");
			System.out.println("Test case is passsed");
			System.out.println(Configuration.getConfiguration().getProperty("Username"));
			System.out.println("                                     ");
			System.out.println("#####################################");
			System.out.println("#####################################");
			System.out.println("#####################################");
		}
		else
		{
			System.out.println("#####################################");
			System.out.println("#####################################");
			System.out.println("#####################################");
			System.out.println("                                     ");
			System.out.println("Test case is Failed");
			System.out.println("                                     ");
			System.out.println("#####################################");
			System.out.println("#####################################");
			System.out.println("#####################################");

		}

	}

	@After
	public void ac()
	{
		driver.quit();
	}
}