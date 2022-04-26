package week5.day1;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DuplicateLeadAssignment1 extends BaseclassAssignment1 {

	@Test
	public void duplicateLead() throws InterruptedException {
		driver.findElement(By.linkText("Leads")).click();
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
