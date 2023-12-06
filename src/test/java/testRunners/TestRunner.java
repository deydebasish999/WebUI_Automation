package testRunners;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import actions.ImportEmployeeDataPageActions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utility.BaseClass;
import utility.CropImage;


@SuppressWarnings("unused")
@CucumberOptions(
		features = "src/test/resources/featureFiles",
		glue = "stepDefinitions",
		tags= "@CreditMemoReq",   //modify to run specific scenarios 
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber.json",
				"de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
		dryRun = false,
		monochrome = true
     )


public class TestRunner extends AbstractTestNGCucumberTests{
ImportEmployeeDataPageActions importEmployeeDataActions =  new ImportEmployeeDataPageActions();
	
	@BeforeSuite
	public void initialization() {
		BaseClass.setUp();
		importEmployeeDataActions.clearValidationLogFile();
	}
	
	
	@AfterSuite
	public void tearDown() throws Exception {
		File reportOutputDirectory = new File("target/cucumber");
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add("target/cucumber.json");
		//String buildNumber = "1";
		String projectName = "SAP_Automation_Demo";
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
		BaseClass.tearDownReport();
//		BaseClass.setUp();
//		BaseClass.driver.get(System.getProperty("user.dir")+"\\target\\cucumber\\cucumber-html-reports\\overview-features.html");
//		JavascriptExecutor js = (JavascriptExecutor)BaseClass.driver;
//		js.executeScript("arguments[0].setAttribute('style','display: none;');",BaseClass.driver.findElement(By.xpath("//*[@id='navigation']")));
//		js.executeScript("arguments[0].setAttribute('style','display: none;');",BaseClass.driver.findElement(By.xpath("//*[@class='fa fa-chevron-left']")));
//		js.executeScript("arguments[0].setAttribute('style','display: none;');",BaseClass.driver.findElement(By.xpath("//*[@class='fa fa-chevron-right']")));
//		js.executeScript("arguments[0].setAttribute('style','display: none;');",BaseClass.driver.findElement(By.xpath("//*[@class='carousel-indicators']")));
//
//		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(BaseClass.driver);
//		Thread.sleep(3000);
//		ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir")+"\\screenshots\\screen.png"));
//		File imageFile = new File(System.getProperty("user.dir")+"\\screenshots\\screen.png");
//	    File destFile = new File(System.getProperty("user.dir")+"\\screenshots\\image-crop.png");
//	    CropImage.resize(imageFile, destFile, 800, 600);
//		BaseClass.tearDownReport();
	}
}
