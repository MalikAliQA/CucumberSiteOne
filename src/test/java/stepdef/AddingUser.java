package stepdef;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddingUser {
	
	private static WebDriver driver;
	private static String URL = "http://thedemosite.co.uk/";
	
	@Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://thedemosite.co.uk/");
    }
	
	@After
    public void tearDown() {
        driver.close();
    }	
	
	@Given("^I can access the demo site$")
	public void i_can_access_the_demo_site() throws Throwable {
		driver.get(URL);
	}

	@When("^I create an account$")
	public void i_create_an_account() throws Throwable {
		WebElement addUser = driver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
    	addUser.click();
        WebElement username = driver.findElement(By.name("username"));
        String user = "root";
    	username.sendKeys(user);
        WebElement password = driver.findElement(By.name("password"));
        String pass = "root";
        password.sendKeys(pass);
        WebElement submit = driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=button]"));
        submit.click();

	}

	@Then("^I can login with the account$")
	public void i_can_login_with_the_account() throws Throwable {
		String user = "root";
        String pass = "root";
        WebElement logIn = driver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
        logIn.click();
        WebElement usernameLog = driver.findElement(By.name("username"));
    	usernameLog.sendKeys(user);
        WebElement passwordLog = driver.findElement(By.name("password"));
        passwordLog.sendKeys(pass);
        WebElement submitLog = driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=button]"));
        submitLog.click();
        WebElement cssText = driver.findElement(By.cssSelector("center > b"));
        assertEquals("**Successful Login**", cssText.getText());
	}


}
