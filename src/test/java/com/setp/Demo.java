package com.setp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Demo {
	static WebDriver driver;
	@Given("User should launch browser")
	public void user_should_launch_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\raju\\Downloads\\eclipse-jee-oxygen-3a-win32-x86_64\\eclipse\\samatha\\Sele1\\driver\\chromedriver.exe");
		   driver= new ChromeDriver();
		driver.get("http://www.demo.guru99.com/telecom/");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


	   	}

	@Given("user click add customer link")
	public void user_click_add_customer_link() {
		driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	   	}

	@When("user provide valid details")
	public void user_provide_valid_details(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("when:1");
		List<List<String>> twodlist = dataTable.asLists(String.class);
		System.out.println(twodlist);
		driver.findElement(By.id("rental1")).sendKeys(twodlist.get(0).get(0));
		driver.findElement(By.id("local_minutes")).sendKeys(twodlist.get(0).get(1));
		driver.findElement(By.id("inter_minutes")).sendKeys(twodlist.get(0).get(2));
		driver.findElement(By.id("sms_pack")).sendKeys(twodlist.get(0).get(3));
		driver.findElement(By.id("minutes_charges")).sendKeys(twodlist.get(0).get(4));
		driver.findElement(By.id("inter_charges")).sendKeys(twodlist.get(0).get(5));
		driver.findElement(By.id("sms_charges")).sendKeys(twodlist.get(0).get(6));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	   	}

	@Then("To verify the customer id is displayed")
	public void to_verify_the_customer_id_is_displayed() {
		Assert.assertTrue(
				driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).isDisplayed());

	   	}


}
