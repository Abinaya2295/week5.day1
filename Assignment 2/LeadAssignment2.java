package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LeadAssignment2 extends BaseclassAssignment2 {
	
	//Used invocation count to run multiple times
	@Test(invocationCount = 2)
	public void createLead() {
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
	
	//Using priority attribute to run this at first
	@Test(priority = -1)
	public void editLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Tech1");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Abi1");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Balu1");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Abi1");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Creating the Lead");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abinaya@yahoo.com");
		WebElement statedropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state = new Select(statedropdown);
		state.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Editing the Leads");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title);		
	}
	
	//Using enabled attribute to ignore one TC
	@Test(enabled = false)
	public void deleteLead() throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("9");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		String firstLeadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println(firstLeadId);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstLeadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		boolean displayed = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		if(displayed)
		{
			System.out.println("Delection completed successfully");
			
		}
		else
		{
			System.out.println("Delection not completed successfully");
		}
		Thread.sleep(3000);
	}
	
	//used DependsOnMethod attribute and invocationCount attribute
	@Test(dependsOnMethods = "createLead", invocationCount = 2)
	public void duplicateLead() throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("abinaya@yahoo.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();		
		System.out.println(name);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Duplicate Lead"))
		{
			System.out.println("Title contains duplicate leads");
		}else
		{
			System.out.println("Title doesn't contain duplicated Lead");
		}
		driver.findElement(By.name("submitButton")).click();
		String duplicatename = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(duplicatename);
		if(duplicatename.equals(name))
		{
			System.out.println("Duplicated lead name is same as captured name");
		}else
		{
			System.out.println("Duplicated lead name is not same as captured name");
		}
		Thread.sleep(1000);		
	}
}
