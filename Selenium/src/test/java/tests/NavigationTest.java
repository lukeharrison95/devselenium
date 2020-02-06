package tests;



import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import pages.FreezerPage;
import pages.IndexPage;
import pages.IndividualFreezerPage;

public class NavigationTest {
	
	private WebDriver driver;

	@Before
	public void setup() {
	System.setProperty(Constants.PROPERTY, Constants.PATH);
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(true);
		driver = new ChromeDriver(opt);
	}
	
	@Test
	public void test() throws InterruptedException {
		this.driver.manage().window().setSize(new Dimension(1600,700));
		this.driver.get(Constants.ip);
		Thread.sleep(1000);
		
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.clickFreezerApp();
		assertEquals(driver.getCurrentUrl(),Constants.ip+"/index.html");
		indexPage.clickHome();
		assertEquals(driver.getCurrentUrl(),Constants.ip+"/index.html");
		indexPage.clickGitHub();
		assertEquals(driver.getCurrentUrl(),"https://github.com/RebekahZoe/FreezerApplication");
		this.driver.get(Constants.ip);
		indexPage.clickFreezers();
		assertEquals(driver.getCurrentUrl(),Constants.ip+"/Freezer.html");
		
		FreezerPage freezerPage = PageFactory.initElements(driver, FreezerPage.class);
		freezerPage.clickFreezerApp();
		assertEquals(driver.getCurrentUrl(),Constants.ip+"/index.html");
		this.driver.get(Constants.ip+"/Freezer.html");
		freezerPage.clickHome();
		assertEquals(driver.getCurrentUrl(),"/index.html");
		this.driver.get(Constants.ip+"/Freezer.html");
		freezerPage.clickGitHub();
		assertEquals(driver.getCurrentUrl(),"https://github.com/RebekahZoe/FreezerApplication");
		this.driver.get(Constants.ip+"Freezer.html");
		freezerPage.clickFreezers();
		assertEquals(driver.getCurrentUrl(),Constants.ip+"/Freezer.html");
		
		IndividualFreezerPage individualFreezerPage = PageFactory.initElements(driver, IndividualFreezerPage.class);
		individualFreezerPage.clickFreezerApp();
		assertEquals(driver.getCurrentUrl(),Constants.ip+"/index.html");
		this.driver.get(Constants.ip+"/IndividualFreezer.html");
		individualFreezerPage.clickHome();
		assertEquals(driver.getCurrentUrl(),"/index.html");
		this.driver.get(Constants.ip+"/IndividualFreezer.html");
		individualFreezerPage.clickGitHub();
		assertEquals(driver.getCurrentUrl(),"https://github.com/RebekahZoe/FreezerApplication");
		this.driver.get(Constants.ip+"/IndividualFreezer.html");
		individualFreezerPage.clickFreezers();
		assertEquals(driver.getCurrentUrl(),Constants.ip+"/Freezer.html");
		
	}
	
	@After
	public void tearDown() {
		this.driver.close();
	}
	
}
