package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLeadAssignment1 extends BaseclassAssignment1 {

	@Test
	public void createLead() {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Tech");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Abi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Balu");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Abi");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Creating the Lead");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abinaya@yahoo.com");
		WebElement statedropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state = new Select(statedropdown);
		state.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
		
	}

}
