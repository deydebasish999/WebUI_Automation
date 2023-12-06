package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowTest extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		//*[@component-id='userPrefProvider']//parent::*//*[@component-id='vdqiezh']
		//BaseClass.setUp();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://devkrisncdhhs.service-now.com/side_door.do");
		driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys("tuhinmitra@kpmg.com");
		driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("Manju@2021");	
		driver.findElement(By.xpath("//*[@id='sysverb_login']")).click();
		Thread.sleep(30000);
//		WebElement l = driver.findElement(By.xpath("//*[@app-id='a84adaf4c700201072b211d4d8c260b7']"));
		WebElement ele = driver.findElement(By.xpath("//*[@app-id='a84adaf4c700201072b211d4d8c260b7']")).
				getShadowRoot().findElement(By.cssSelector("*[component-id*='-root']")).
				getShadowRoot().findElement(By.cssSelector("*[component-id*='-snCanvasAppshellLayout]")).
				getShadowRoot().findElement(By.cssSelector("*[@component-id*='-polarisLayout']"));
	System.out.println(ele.isDisplayed());
	}

}
