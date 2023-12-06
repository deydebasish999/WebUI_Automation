package actions;

import java.awt.AWTException;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.testng.Assert;
import locators.ImportEmployeeDataPageLocators;
import utility.BaseClass;
import utility.ConfigFileReader;
import utility.GenericMethods;

public class ImportEmployeeDataPageActions extends BaseClass{

	int maxRetryCount = 5;
	ConfigFileReader configFileReader = new ConfigFileReader(); 
	ImportEmployeeDataPageLocators importEmployeeData = new ImportEmployeeDataPageLocators();
	String filePath = System.getProperty("user.dir")+ "//testReports//FileValidationLog.txt";
	FileWriter fw = null;
	public static Boolean validateImportedFileErrorFlag=false;
	public static String fileName=null;
	
	public void searchEntitye(String entityName) throws InterruptedException {
		if(validateImportedFileErrorFlag==true) {
			Assert.assertFalse(true, "Error present in previous steps...Exiting test execution");
		}
		importEmployeeData.entitySearchDrpDownButton.click();
		for(int i=0;i<importEmployeeData.entitySearchBoxList.size(); i++) {
			if(importEmployeeData.entitySearchBoxList.get(i).getText().equalsIgnoreCase(entityName)) {
				importEmployeeData.entitySearchBoxList.get(i).click();
			}			

		}
	}
	
	public void searchEntityForImporting(String entityName) throws InterruptedException {
		if(validateImportedFileErrorFlag==true) {
			Assert.assertFalse(true, "Error present in previous steps...Exiting test execution");
		}
		importEmployeeData.entitySearchDrpDownButton.click();
		for(int i=0;i<importEmployeeData.entitySearchBoxList.size(); i++) {
			if(importEmployeeData.entitySearchBoxList.get(i).getText().equalsIgnoreCase(entityName)) {
				importEmployeeData.entitySearchBoxList.get(i).click();
			}
			

		}
	}
	
//	public void chooseFileToUpload(String fileName) throws InterruptedException, IOException, AWTException {
//		Thread.sleep(1000);
//		GenericMethods.fileUpload(importEmployeeData.broweseBttn, System.getProperty("user.dir") + "\\employee-data\\" +fileName + ".csv");
//
//	
//	}
	
	public void chooseFileToUpload(final String partialfileName) throws InterruptedException, IOException, AWTException {
		
		if(validateImportedFileErrorFlag==true) {
			Assert.assertFalse(true, "Error present in previous steps...Exiting test execution");
		}
		Thread.sleep(2000);
		File workingDirectory = new File(System.getProperty("user.dir") + "\\employeeDataNew\\");
		File[] listOfFiles = workingDirectory.listFiles(new java.io.FilenameFilter(){
		    public boolean accept(File rootDir, String name){
		        //return name.startsWith(partialfileName);
		        return name.contains(partialfileName);
		    }
		});
		fileName = listOfFiles[0].toString();
		System.out.println("////////////File name is " +fileName);
		if(fileName.contains(partialfileName)) {
			GenericMethods.fileUpload(importEmployeeData.broweseBttn, fileName);
		}

	
	}
	
	public void chooseFileToUploadForImporting(final String partialfileName) throws InterruptedException, IOException, AWTException {
		
		if(validateImportedFileErrorFlag==true) {
			Assert.assertFalse(true, "Error present in previous steps...Exiting test execution");
		}
		Thread.sleep(2000);
		File workingDirectory = new File(System.getProperty("user.dir") + "\\employeeDataNew\\");
		File[] listOfFiles = workingDirectory.listFiles(new java.io.FilenameFilter(){
		    public boolean accept(File rootDir, String name){
		        return name.startsWith(partialfileName);
		    }
		});
		fileName = listOfFiles[0].toString();
		//System.out.println("File name is " +fileName);
		if(fileName.contains(partialfileName)) {
			GenericMethods.fileUpload(importEmployeeData.broweseBttn, fileName);
		}

	
	}
	
	
	
	public void clearValidationLogFile() {
		try {
			fw = new FileWriter(new File(filePath),false);
			PrintWriter pw = new PrintWriter(fw, false);
			pw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void validateImportedFile(String fileName) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		importEmployeeData.validateImportfileBttn.click();
		//&& !importEmployeeData.validationMessage.getText().contains(" [[Warning!], This record was not saved")
		
		if((importEmployeeData.validationMessage.getText().contains("Validation Successful.") || importEmployeeData.validationMessage.getText().contains("No error is found in the file.")) && !importEmployeeData.validationMessage.getText().contains(" [[Warning!], This record was not saved") ) {
			System.out.println(">>>>>>>>>> Validation of file " +fileName+ " successful >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("");
			try {
				fw = new FileWriter(new File(filePath),true);
				fw.append(">>>>>>>>>> Validation of file " +fileName+ " successful >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				fw.append("\n");
				fw.append("\n");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			};

			
		}
		else {
			System.out.println(">>>>>>>>>>>>>>>>>>>> Errors present in "+fileName+ ". Validation Unsuccessful for below Errors >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(importEmployeeData.validationMessage.getText());
			System.out.println("");
			try {
				fw = new FileWriter(new File(filePath),true);
				fw.append(">>>>>>>>>>>>>>>>>>>> Errors present in "+fileName+ ". Validation Unsuccessful for below Errors >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				fw.append(importEmployeeData.validationMessage.getText());
				fw.append("\n");
				fw.append("\n");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			};
			validateImportedFileErrorFlag=true;
			Assert.assertTrue(false,">>>>>>>>>>>>>>>>>>>>>>>>>>>> Validation unsusscessful for 1 or more files >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
		}
	}		

	
	
	
	public void clickOnImportFile() throws InterruptedException {
		if(validateImportedFileErrorFlag==true) {
			Assert.assertFalse(true, "Error present in previous steps...Exiting test execution");
		}
		importEmployeeData.importBttn.click();
		Thread.sleep(3000);
	}
	
	public void importSuccessfulMessage(String fileName) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(validateImportedFileErrorFlag==true) {
			Assert.assertFalse(true, "Error present in previous steps...Exiting test execution");
		}  
		
		if(importEmployeeData.validationMessage.getText().contains("Number of failed records:0") || importEmployeeData.validationMessage.getText().contains("The Import was successfully completed") || importEmployeeData.validationMessage.getText().contains("Your file has been uploaded to the server successfully")) {
			System.out.println(">>>>>>>>>> Import of file " +fileName+ " successful >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("");
				
		}
		else {
			System.out.println(">>>>>>>>>>>>>>>>>>>> Errors present in "+fileName+ ". Import Unsuccessful for below Errors >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(importEmployeeData.validationMessage.getText());
			System.out.println("");
			
		}
	}		
	
	
}
