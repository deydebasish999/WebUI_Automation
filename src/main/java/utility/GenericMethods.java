package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods extends BaseClass{
	
	static WebDriverWait wait;
	static int timeToWait =20;
	
	
	public  static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
	}
	
	public static void explicitWaitByExpectedConditionVisibility(WebElement element) {
		//wait = new WebDriverWait(driver, 15);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(element));
		//wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public static void javaScriptExecutorScrollingIntoToViewWithElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void actionClassForClickOnElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).click().build().perform();
	}
	
	public static void actionClassForSendingText(WebElement element,String text) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).sendKeys(text).build().perform();
	}
	
	public static void typeUsingRobot(WebElement element) throws AWTException {
		
		
		int xaxis = element.getLocation().x;
		 
		int yaxis=element.getLocation().y;
		 
		int width = element.getSize().width;
		int height= element.getSize().height;
		 
		Robot r=new Robot();
		r.mouseMove(xaxis+width/2, yaxis+height/2+70);
		r.mousePress(KeyEvent.BUTTON1_MASK);//click function
		r.mouseRelease(KeyEvent.BUTTON1_MASK);
		 
		//typing text in text box one by one
		r.keyPress(KeyEvent.VK_N);
		r.keyPress(KeyEvent.VK_C);
		r.keyPress(KeyEvent.VK_T);
		r.keyPress(KeyEvent.VK_R);
		r.keyPress(KeyEvent.VK_A);
		
		r.keyRelease(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_A);		 

	}
	
	public static void fileUpload(WebElement uploadBttn, String pathOfFile) throws AWTException, InterruptedException {
		actionClassForClickOnElement(uploadBttn);
		Thread.sleep(2000);
		Robot rb = new Robot();
		StringSelection str = new StringSelection(pathOfFile);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 
	     // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public static void dismisstAlert() {
		driver.switchTo().alert().dismiss();;
	}
	
	public static void getAlertText() {
		driver.switchTo().alert().getText();
	}
	
	public static void setAlertText(String alertText) {
		driver.switchTo().alert().sendKeys(alertText);
	}
}
