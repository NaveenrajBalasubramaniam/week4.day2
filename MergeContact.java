package week4.day2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		WebElement username=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement login=driver.findElement(By.className("decorativeSubmit"));
		username.sendKeys("demosalesmanager");
		password.sendKeys("crmsfa");
		login.click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']")).click();
		//driver.findElement(By.xpath("//*[@id='ext-gen604']")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[2]/div/form/table/tbody/tr[1]/td[2]/a/img"))).click().build().perform();
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String winow : windows) {
			driver.switchTo().window(winow);
			System.out.println(driver.getTitle());
			if(driver.getTitle().contains("Find Contacts")) {
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Actions act1 = new Actions(driver);
				//act1.moveToElement(driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]/div/a"))).click().build().perform();
				act1.moveToElement(driver.findElement(By.xpath("//div[1]/table/tbody/tr[1]/td[1]/div/a"))).click().build().perform();
			}

		}
		driver.switchTo().window(parent);
		Actions act2 = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[2]/div/form/table/tbody/tr[2]/td[2]/a/img"))).click().build().perform();
		windows = driver.getWindowHandles();
		for (String winow : windows) {
			driver.switchTo().window(winow);
			System.out.println(driver.getTitle());
			if(driver.getTitle().contains("Find Contacts")) {
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Actions act1 = new Actions(driver);
				act1.moveToElement(driver.findElement(By.xpath("//div[3]/table/tbody/tr[1]/td[1]/div/a"))).click().build().perform();
			}

		}
		driver.switchTo().window(parent);
		driver.findElement(By.linkText("Merge")).click();
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());
	}

}
