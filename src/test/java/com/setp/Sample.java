package com.setp;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sample {
	public static WebDriver driver;

	@Given("User should launch browsers")
	public void user_should_launch_browsers() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\raju\\Downloads\\eclipse-jee-oxygen-3a-win32-x86_64\\eclipse\\samatha\\Sele1\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/telecom/");

	}

	@Given("user click add customer links")
	public void user_click_add_customer_links() {
		driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();

	}

	@When("user provide valid detailss")
	public void user_provide_valid_detailss(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("when:1");
		List<Map<String, String>> twodmap = dataTable.asMaps(String.class, String.class);
		System.out.println(twodmap);
		driver.findElement(By.id("rental1")).sendKeys(twodmap.get(0).get("MonthlyRental"));
		driver.findElement(By.id("local_minutes")).sendKeys(twodmap.get(1).get("FreeLocalMinutes"));
		driver.findElement(By.id("inter_minutes")).sendKeys(twodmap.get(1).get("InternationalFreeMinutes"));
		driver.findElement(By.id("sms_pack")).sendKeys(twodmap.get(0).get("FreeSMSPack"));
		driver.findElement(By.id("minutes_charges")).sendKeys(twodmap.get(0).get("LocalPerMinutesCharges"));
		driver.findElement(By.id("inter_charges")).sendKeys(twodmap.get(1).get("InternationalPerMinutesCharges"));
		driver.findElement(By.id("sms_charges")).sendKeys(twodmap.get(0).get("SMSPerCharges"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Then("To verify the customer id is displayeds")
	public void to_verify_the_customer_id_is_displayeds() {
		Assert.assertTrue(
				driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).isDisplayed());

	}

}
