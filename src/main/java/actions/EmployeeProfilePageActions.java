package actions;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import locators.EmployeeProfilePageLocators;
import locators.ImportEmployeeDataPageLocators;
import locators.LogInPageLocators;
import utility.BaseClass;
import utility.ConfigFileReader;
import utility.GenericMethods;

public class EmployeeProfilePageActions extends BaseClass{

	int count = 0;
	int maxRetryCountToSearchEmployee = 10;
	ConfigFileReader configFileReader = new ConfigFileReader(); 
	LogInPageLocators loginpageLocators = new LogInPageLocators();
	ImportEmployeeDataPageLocators importEmployeeData = new ImportEmployeeDataPageLocators();
	EmployeeProfilePageLocators employeeProfilePageLocators = new EmployeeProfilePageLocators();
	//ImportEmployeeDataPageActions importEmployeeDataPageActions = new ImportEmployeeDataPageActions();
	String fileNameToValidate=null;
	
	public void validateEmployeeProfileDataforBasicImport() throws InterruptedException {
		if(ImportEmployeeDataPageActions.validateImportedFileErrorFlag==true) {
			Assert.assertTrue(false, "Error present in previous steps...Exiting test execution");
		}
		
		String [] arr = ImportEmployeeDataPageActions.fileName.split("\\\\");
		fileNameToValidate = arr[7].toString();
		System.out.println("New File Name is  " +fileNameToValidate);
		BufferedReader br=null;
		File src = new File(System.getProperty("user.dir")+"\\employeedataNew\\"+ fileNameToValidate);
		

//		CSVReader c = new CSVReader(new FileReader(src));
//		c.skip(1);
		Map<String, String> mp = new HashMap<String, String>();
		List<String> headers = new ArrayList<String>(); 
		List<String> empData = new ArrayList<String>(); 
		List<Integer> emptyEmpDataCount = new ArrayList<Integer>();
		List<String> finalHeaderList = new ArrayList<String>();
		String line= null;
		String[] cols = null;
//		String key=null;
		int lineCount=1;
		int rowCount = 0;
		
		
	    //Reading the ComparisonReport file
	  	  String filePath = "C:\\Users\\debasishdey\\Desktop\\workspace\\SAP_Automation\\testReports\\ComparisonReport.xlsx";
	  	  FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	  	    Workbook wb=null;
			try {
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	  Sheet sheet = wb.getSheet("BasicUserInfoImportTemplate");	  	  
	  	  Row row = null;
	  	  row=sheet.getRow(0);
	  	  int cellCount = row.getLastCellNum();
	  	  
	  	  
	  	  
	  	  int rowCount2=sheet.getLastRowNum();
	  	  System.out.println("Row Count for new Run "+rowCount2);
	  	  if(rowCount2>0) {
	  		  for(int m =1;m<=rowCount2;m++) {
	  			sheet.removeRow(sheet.getRow(m));
	  		  }
	  		  
	  	  }
		
		try {
		br = new BufferedReader(new FileReader(src));
			while (( line = br.readLine()) != null) {  //Reading the csv line by line by line
			    cols = line.split(",");				   //Splitting each line by comma separator
//		    for(String s: cols) {
//		    	//ls.add(s);
//		    }
			    int i;
			    
			    if(lineCount==2) {						//Retrieving all the headers
			    	  for(i=0;i<cols.length;i++) {
					    	//ls.clear();
			    			 headers.add(cols[i]);
					    	//System.out.println(ls + "Iteration "+i);		    	  
					    	//break;
			    		  	
							}
					    
			    }
			    
   
			    if(lineCount>=3) {						//Retrieving employee data starting from 3rd line in csv file
			    	finalHeaderList.clear();
			    	mp.clear();
			    	  for(i=0;i<cols.length;i++) {
					    	//ls.clear();
			    		  if(!cols[i].isEmpty()) {
			    			  emptyEmpDataCount.add(i);
			    			  empData.add(cols[i]);
			    		  }

							}
				
			  		for(int j=0;j<emptyEmpDataCount.size();j++) {
						int count = emptyEmpDataCount.get(j);
						finalHeaderList.add(headers.get(count));
				}
			  		
			  	    for(int m=0;m<finalHeaderList.size();m++) {
			  	    	mp.put(finalHeaderList.get(m).toString(), empData.get(m).toString());
			  	    }
			  	    
			  	    
			  	    
			  	    //Reteiving Data from UI:
			  	    
			  	    System.out.println(">>> Retreive UI data ");
			  	    
			  	    loginpageLocators.searchBox.click();
			  	    //loginpageLocators.searchBox.sendKeys(mp.get("First Name").concat(" ").concat(mp.get("Last Name")));
			  	    loginpageLocators.searchBox.sendKeys(mp.get("Person Id"));
					
					Thread.sleep(3000);
					String empSearchListText = driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText();
					System.out.println("Search list " +empSearchListText);
					
					try {
					while(!empSearchListText.contains(mp.get("Username"))) {
						Thread.sleep(4000);
						//System.out.println(">>>>>>>>>>>> inside while");
						driver.navigate().refresh();
				//		loginpageLocators.searchBox.clear();
						loginpageLocators.searchBox.click();
						
//						if(count==2) {
//							loginpageLocators.searchBox.clear();
//							loginpageLocators.searchBox.sendKeys("Alex Hales");
//							Thread.sleep(4000);
//							System.out.println(">>>>>>> found emp inside new 1 " +driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText());
//							if(driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText().contains("Mgr24")) {
//								System.out.println(">>>>>>> found emp inside new" +driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText());
//								break;
//							}
//						}
//						
						
						//loginpageLocators.searchBox.sendKeys(mp.get("First Name").concat(" ").concat(mp.get("Last Name")));
						loginpageLocators.searchBox.sendKeys(mp.get("Person Id"));
						Thread.sleep(4000);
						//size = driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul/li")).size();
						//System.out.println(">>>>>>> found emp " +driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText());
						if(driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText().contains(mp.get("Username"))) {
							//System.out.println(">>>>>>> found emp inside " +driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText());
							break;
						}
						count++;
						if(count==maxRetryCountToSearchEmployee) {
							System.out.println(">>>>>>> Maximum retry reached. Employee not found ");
							
							break;
						}

					}
					
					//String emp = driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul/li")).get(0).getText();
					
					if(driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText().contains(mp.get("Username"))) {
						GenericMethods.actionClassForClickOnElement(driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul/li")).get(0));
					}
					}
					
					catch(Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(10000);
					String [] fullNameList = null;
					
					//try {
						//GenericMethods.explicitWaitByExpectedConditionVisibility(employeeProfilePageLocators.fullName.get(0));
						String name = employeeProfilePageLocators.fullName.get(0).getAttribute("innerHTML");
						System.out.println(" new name is " +name);
						fullNameList = employeeProfilePageLocators.fullName.get(0).getText().split("\\s+");
					//	System.out.println("   test    " +fullNameList[0].toString()   +   fullNameList[1].toString());
					//}
					//catch(StaleElementReferenceException e) {
						fullNameList = employeeProfilePageLocators.fullName.get(0).getText().split("\\s+");
					//}
					
			  	    String fullNameFromUI = fullNameList[0].toString().concat(" ").concat(fullNameList[1].toString());
			  	    //String fullNameFromUI = "test";
			  	    System.out.println(">>>>>>>> For employee " + mp.get("First Name").concat(" ").concat(mp.get("Last Name")));
			  	    
			  	    System.out.println(fullNameFromUI  + " ---> "+mp.get("First Name").concat(" ").concat(mp.get("Last Name")));
			  	    String userNameFromUI = employeeProfilePageLocators.userName.getText().replace("(", "").replace(")", "");
			  	    System.out.println(userNameFromUI + " ---> "+mp.get("Username"));
			  	    String titleFromUI = employeeProfilePageLocators.title.getText();
			  	    System.out.println(titleFromUI + " ---> "+mp.get("Title"));
			  	    String[] departmentAndDivision = employeeProfilePageLocators.departmentAndDivision.getText().split(",");
			  	    System.out.println(departmentAndDivision[0].toString() + "  "+mp.get("Department"));
			  	    String divisionFromUI = departmentAndDivision[1].toString();
			  	    System.out.println(divisionFromUI.trim() + " ---> "+mp.get("Division"));
			  	    
			  	    String[] locationList = employeeProfilePageLocators.location.getText().split("\\s+");
			  	    String locationFromUI = locationList[0].toString();
			  	    System.out.println(locationFromUI + " ---> "+mp.get("Location"));
			  	
			  	    String personIdFromUI = employeeProfilePageLocators.personId.getText();
			  	    System.out.println(personIdFromUI + "---> " +mp.get("Person Id"));
			  	   
//			  	    System.out.println(divisionFromUI + "  "+mp.get("Division"));
//			  	    System.out.println(locationFromUI + "  "+mp.get("Location"));
			  	    
			  	    
			  	    //Writting data in excel
			  	 List<String> listOfUIData = new ArrayList<String>();
			  	 List<String> listOfCSVData = new ArrayList<String>();
			  	 List<String> listOfHeaders = new ArrayList<String>();
			  	 
			  	listOfUIData.add(fullNameFromUI);      
			  	listOfUIData.add(userNameFromUI);      
			  	listOfUIData.add(titleFromUI);        
			  	listOfUIData.add(departmentAndDivision[0].toString()); 
			  	listOfUIData.add(divisionFromUI.trim()); 
			  	listOfUIData.add(locationFromUI);         
			  	listOfUIData.add(personIdFromUI);     

			  	listOfCSVData.add(mp.get("First Name").concat(" ").concat(mp.get("Last Name")));
			  	listOfCSVData.add(mp.get("Username"));
			  	listOfCSVData.add(mp.get("Title"));
			  	listOfCSVData.add(mp.get("Department"));
			  	listOfCSVData.add(mp.get("Division"));
			  	listOfCSVData.add(mp.get("Location"));
			  	listOfCSVData.add(mp.get("Person Id"));
			  	
			  	listOfHeaders.add("Employee Name");
			  	listOfHeaders.add("Username");
			  	listOfHeaders.add("Title");
			  	listOfHeaders.add("Department");
			  	listOfHeaders.add("Division");
			  	listOfHeaders.add("Location");
			  	listOfHeaders.add("Person Id");
			  	
			  	
			  	

			  	
			  	//Writing Comparison Report
			  	
			  	//  System.out.println("total Columns " +cellCount); 
			  	   
			  	    for(int a=1;a<=listOfUIData.size();a++) {
			  	    	 row = sheet.createRow(rowCount+1);
			  	    	 
			  	    	 for(int b=0 ; b<cellCount;b++) {
			  	    		//int cellToSetValue = 0;
			  	    		Cell cell=row.createCell(b);
					  	    	if(b==0) { 		
					  	    		cell.setCellValue(mp.get("First Name").concat(" ").concat(mp.get("Last Name")));
					  	    	}
					  	    	else if(b==1) {
					  	    		cell.setCellValue(listOfHeaders.get(a-1));
					  	    	}
					  	    	else if(b==2) {
					  	    		cell.setCellValue(listOfUIData.get(a-1));
					  	    	}
					  	    	else if(b==3) {
					  	    		cell.setCellValue(listOfCSVData.get(a-1));
					  	    	}
					  	    	
					  	    	//cellToSetValue++;
					  	    }
			  	    	rowCount++;
			  	    }
			  	  fis.close();
			          FileOutputStream out = new FileOutputStream(new File(filePath));
			          wb.write(out);
			          out.close();
			          System.out.println("Updated Successfully");			  	    
			  	    
			    }
			    
			    rowCount=sheet.getLastRowNum();			  
			    lineCount++;
			}
			
		} 
	catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		
	}
	

	
	public void validateEmployeeProfileDataforBiographicalInfo() throws InterruptedException {
		if(ImportEmployeeDataPageActions.validateImportedFileErrorFlag==true) {
			Assert.assertTrue(false, "Error present in previous steps...Exiting test execution");
		}
		String [] arr = ImportEmployeeDataPageActions.fileName.split("\\\\");
		fileNameToValidate = arr[7].toString();
		System.out.println("New File Name is " +fileNameToValidate);
		
		BufferedReader br=null;
		File src = new File(System.getProperty("user.dir")+"\\employeedataNew\\"+ fileNameToValidate);
		
//		CSVReader c = new CSVReader(new FileReader(src));
//		c.skip(1);
		Map<String, String> mp = new HashMap<String, String>();
		List<String> headers = new ArrayList<String>(); 
		List<String> empData = new ArrayList<String>(); 
		List<Integer> emptyEmpDataCount = new ArrayList<Integer>();
		List<String> finalHeaderList = new ArrayList<String>();
		String line= null;
		String[] cols = null;
//		String key=null;
		int lineCount=1;
		int rowCount = 0;
		
		
	    //Reading the ComparisonReport file
	  	  String filePath = "C:\\Users\\debasishdey\\Desktop\\workspace\\SAP_Automation\\testReports\\ComparisonReport.xlsx";
	  	  FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	  	    Workbook wb=null;
			try {
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	  Sheet sheet = wb.getSheet("BoigraphicalInfoTemplate");	  	  
	  	  Row row = null;
	  	  row=sheet.getRow(0);
	  	  int cellCount = row.getLastCellNum();
	  	  
	  	  
	  	  
	  	  int rowCount2=sheet.getLastRowNum();
	  	  System.out.println("Row Count for new Run "+rowCount2);
	  	  if(rowCount2>0) {
	  		  for(int m =1;m<=rowCount2;m++) {
	  			sheet.removeRow(sheet.getRow(m));
	  		  }
	  		  
	  	  }
		
		try {
		br = new BufferedReader(new FileReader(src));
			while (( line = br.readLine()) != null) {  //Reading the csv line by line by line
			    cols = line.split(",");				   //Splitting each line by comma separator
//		    for(String s: cols) {
//		    	//ls.add(s);
//		    }
			    int i;
			    
			    if(lineCount==2) {						//Retrieving all the headers
			    	  for(i=0;i<cols.length;i++) {
					    	//ls.clear();
			    			 headers.add(cols[i]);
					    	//System.out.println(ls + "Iteration "+i);		    	  
					    	//break;
			    		  	
							}
					    
			    }
			    

			  	  

			  	  
			    
			    if(lineCount>=3) {						//Retrieving employee data starting from 3rd line in csv file
			    	finalHeaderList.clear();
			    	mp.clear();
			    	  for(i=0;i<cols.length;i++) {
					    	//ls.clear();
			    		  if(!cols[i].isEmpty()) {
			    			  emptyEmpDataCount.add(i);
			    			  empData.add(cols[i]);
			    		  }

							}
				
			  		for(int j=0;j<emptyEmpDataCount.size();j++) {
						int count = emptyEmpDataCount.get(j);
						finalHeaderList.add(headers.get(count));
				}
			  		
			  	    for(int m=0;m<finalHeaderList.size();m++) {
			  	    	mp.put(finalHeaderList.get(m).toString(), empData.get(m).toString());
			  	    }
			  	    
			  	    
			  	    
			  	    //Reteiving Data from UI:
			  	    
			  	    System.out.println(">>> Retreive UI data ");
			  	    
			  	    Thread.sleep(3000);
			  	    loginpageLocators.searchBox.click();
			  	    loginpageLocators.searchBox.sendKeys(mp.get("Person ID"));
					
					Thread.sleep(3000);
					String empSearchListText = driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText();
					System.out.println("Search list " +empSearchListText);
					
					try {
										
						GenericMethods.actionClassForClickOnElement(driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul/li")).get(0));
					}
					
					catch(Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(10000);
			  	
			  	    String personIdFromUI = employeeProfilePageLocators.personId.getText();
			  	    System.out.println(personIdFromUI + "---> " +mp.get("Person ID"));
			  	    
			  	    String dateOfBirthFromUI = employeeProfilePageLocators.dateOfBirth.getText();
			  	    System.out.println(dateOfBirthFromUI + "---> " +mp.get("Date of Birth"));
			  	    
			  	    String countryOfBirthFromUI = employeeProfilePageLocators.countryOfBirth.getText();
			  	    System.out.println(countryOfBirthFromUI + "---> " +mp.get("Country of Birth"));
			  	   
			  	    
			  	    
			  	    //Writting data in excel
			  	 List<String> listOfUIData = new ArrayList<String>();
			  	 List<String> listOfCSVData = new ArrayList<String>();
			  	 List<String> listOfHeaders = new ArrayList<String>();
			  	        
			  	listOfUIData.add(personIdFromUI);  
			  	listOfUIData.add(dateOfBirthFromUI); 
			  	listOfUIData.add(countryOfBirthFromUI); 


			  	listOfCSVData.add(mp.get("Person ID"));
			  	listOfCSVData.add(mp.get("Date of Birth"));
			  	listOfCSVData.add(mp.get("Country of Birth"));
			  	
			  	listOfHeaders.add("Person ID");
			  	listOfHeaders.add("Date of Birth");
			  	listOfHeaders.add("Country of Birth");

			  	
			  	//Writing Comparison Report
			  	
			  	//  System.out.println("total Columns " +cellCount); 
			  	   
			  	    for(int a=1;a<=listOfUIData.size();a++) {
			  	    	 row = sheet.createRow(rowCount+1);
			  	    	 
			  	    	 for(int b=0 ; b<cellCount;b++) {
			  	    		//int cellToSetValue = 0;
			  	    		Cell cell=row.createCell(b);
					  	    	if(b==0) { 		
					  	    		cell.setCellValue(mp.get("Person ID"));
					  	    	}
					  	    	else if(b==1) {
					  	    		cell.setCellValue(listOfHeaders.get(a-1));
					  	    	}
					  	    	else if(b==2) {
					  	    		cell.setCellValue(listOfUIData.get(a-1));
					  	    	}
					  	    	else if(b==3) {
					  	    		cell.setCellValue(listOfCSVData.get(a-1));
					  	    	}
					  	    	
					  	    	//cellToSetValue++;
					  	    }
			  	    	rowCount++;
			  	    }
			  	  fis.close();
			          FileOutputStream out = new FileOutputStream(new File(filePath));
			          wb.write(out);
			          out.close();
			          System.out.println("Updated Successfully");			  	    
			  	    
			    }
			    
			    rowCount=sheet.getLastRowNum();			  
			    lineCount++;
			}
			
		} 
	catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
	}
	
	
	
	
	
///////////////////////////////////Employment INfo//////////////////////////////////////////	
	
	
	public void validateEmployeeProfileDataforEmployementInfo() throws InterruptedException {
		if(ImportEmployeeDataPageActions.validateImportedFileErrorFlag==true) {
			Assert.assertTrue(false, "Error present in previous steps...Exiting test execution");
		}
		String [] arr = ImportEmployeeDataPageActions.fileName.split("\\\\");
		fileNameToValidate = arr[7].toString();
		System.out.println("New File Name is " +fileNameToValidate);
		
		BufferedReader br=null;
		File src = new File(System.getProperty("user.dir")+"\\employeedataNew\\"+ fileNameToValidate);
		
//		CSVReader c = new CSVReader(new FileReader(src));
//		c.skip(1);
		Map<String, String> mp = new HashMap<String, String>();
		List<String> headers = new ArrayList<String>(); 
		List<String> empData = new ArrayList<String>(); 
		List<Integer> emptyEmpDataCount = new ArrayList<Integer>();
		List<String> finalHeaderList = new ArrayList<String>();
		String line= null;
		String[] cols = null;
//		String key=null;
		int lineCount=1;
		int rowCount = 0;
		
		
	    //Reading the ComparisonReport file
	  	  String filePath = "C:\\Users\\debasishdey\\Desktop\\workspace\\SAP_Automation\\testReports\\ComparisonReport.xlsx";
	  	  FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	  	    Workbook wb=null;
			try {
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	  Sheet sheet = wb.getSheet("EmploymentInfoTemplate");	  	  
	  	  Row row = null;
	  	  row=sheet.getRow(0);
	  	  int cellCount = row.getLastCellNum();
	  	  
	  	  
	  	  
	  	  int rowCount2=sheet.getLastRowNum();
	  	  System.out.println("Row Count for new Run "+rowCount2);
	  	  if(rowCount2>0) {
	  		  for(int m =1;m<=rowCount2;m++) {
	  			sheet.removeRow(sheet.getRow(m));
	  		  }
	  		  
	  	  }
		
		try {
		br = new BufferedReader(new FileReader(src));
			while (( line = br.readLine()) != null) {  //Reading the csv line by line by line
			    cols = line.split(",");				   //Splitting each line by comma separator
//		    for(String s: cols) {
//		    	//ls.add(s);
//		    }
			    int i;
			    
			    if(lineCount==2) {						//Retrieving all the headers
			    	  for(i=0;i<cols.length;i++) {
					    	//ls.clear();
			    			 headers.add(cols[i]);
					    	//System.out.println(ls + "Iteration "+i);		    	  
					    	//break;
			    		  	
							}
					    
			    }
			    

			    if(lineCount>=3) {						//Retrieving employee data starting from 3rd line in csv file
			    	finalHeaderList.clear();
			    	mp.clear();
			    	  for(i=0;i<cols.length;i++) {
					    	//ls.clear();
			    		  if(!cols[i].isEmpty()) {
			    			  emptyEmpDataCount.add(i);
			    			  empData.add(cols[i]);
			    		  }

							}
				
			  		for(int j=0;j<emptyEmpDataCount.size();j++) {
						int count = emptyEmpDataCount.get(j);
						finalHeaderList.add(headers.get(count));
				}
			  		
			  	    for(int m=0;m<finalHeaderList.size();m++) {
			  	    	mp.put(finalHeaderList.get(m).toString(), empData.get(m).toString());
			  	    }
			  	    
			  	    
			  	    
			  	    //Reteiving Data from UI:
			  	    
			  	    System.out.println(">>> Retreive UI data ");
			  	    
			  	    
			  	    Thread.sleep(3000);
			  	    loginpageLocators.searchBox.click();
			  	    loginpageLocators.searchBox.sendKeys(mp.get("User ID"));
					
					Thread.sleep(3000);
					String empSearchListText = driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText();
					System.out.println("Search list " +empSearchListText);
					
					try {
										
						GenericMethods.actionClassForClickOnElement(driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul/li")).get(0));
					}
					
					catch(Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(15000);
					
					System.out.println(">>>>>>Show More button list size " +employeeProfilePageLocators.showMoreBttnEmpDetails.size());
					//GenericMethods.actionClassForClickOnElement(employeeProfilePageLocators.showMoreBttn.get(8));
					//GenericMethods.actionClassForClickOnElement(employeeProfilePageLocators.showMoreBttn.get(9));
					//GenericMethods.actionClassForClickOnElement(employeeProfilePageLocators.showMoreBttn.get(11));
				  	  //employeeProfilePageLocators.showMoreBttn.get(8).click();
				  	  //employeeProfilePageLocators.showMoreBttn.get(9).click();
				  	  //employeeProfilePageLocators.showMoreBttn.get(11).click();
					GenericMethods.javaScriptExecutorScrollingIntoToViewWithElement(employeeProfilePageLocators.employmentDetailsSection);
					
					//employeeProfilePageLocators.employmentDetailsDrpDwnMenu.click();
					
			  	    String userIDFromUI = employeeProfilePageLocators.personId.getText();
			  	    System.out.println(userIDFromUI + "---> " +mp.get("User ID"));
			  	    
			  	    String firstDateWorkedFromUI = employeeProfilePageLocators.firstDateWorked.getText();
			  	    System.out.println(firstDateWorkedFromUI + "---> " +mp.get("First Date Worked"));
			  	    
			  	    String recruitDateFromUI = employeeProfilePageLocators.recruitDate.getText();
			  	    System.out.println(recruitDateFromUI + "---> " +mp.get("Recruit Date"));
			  	    
			  	    String benefitsEligibilityStartDateFromUI = employeeProfilePageLocators.benefitsEligibilityStartDate.getText();
			  	    System.out.println(benefitsEligibilityStartDateFromUI + "---> " +mp.get("Benefits Eligibility Start Date"));
			  	    
			  	    GenericMethods.actionClassForClickOnElement(employeeProfilePageLocators.showMoreBttnEmpDetails.get(0));
			  	    
			  	    String contingentWorkerFromUI = employeeProfilePageLocators.contingentWorker.getText();
			  	    System.out.println(contingentWorkerFromUI + "---> " +mp.get("Contingent Worker"));
			  	    
			  	    String eligibleForStockFromUI = employeeProfilePageLocators.eligibleForStock.getText();
			  	    System.out.println(eligibleForStockFromUI + "---> " +mp.get("Eligible for Stock"));
			  	    
			  	    String employeesFirstEmploymentFromUI = employeeProfilePageLocators.employeesFirstEmployment.getText();
			  	    System.out.println(employeesFirstEmploymentFromUI + "---> " +mp.get("Employee's First Employment"));
			  	    
			  	    String originalStartDateFromUI = employeeProfilePageLocators.originalStartDate.getText();
			  	    System.out.println(originalStartDateFromUI + "---> " +mp.get("Original Start Date"));
			  	    
			  	    String professionalServiceDateFromUI = employeeProfilePageLocators.professionalServiceDate.getText();
			  	    System.out.println(professionalServiceDateFromUI + "---> " +mp.get("Professional Service Date"));
			  	    
			  	    String seniorityStartDateFromUI = employeeProfilePageLocators.seniorityStartDate.getText();
			  	    System.out.println(seniorityStartDateFromUI + "---> " +mp.get("Seniority Start Date"));
			  	    
			  	    String serviceDateFromUI = employeeProfilePageLocators.serviceDate.getText();
			  	    System.out.println(serviceDateFromUI + "---> " +mp.get("Service Date"));
			  	   
			  	    
			  	    
			  	    //Writting data in excel
			  	 List<String> listOfUIData = new ArrayList<String>();
			  	 List<String> listOfCSVData = new ArrayList<String>();
			  	 List<String> listOfHeaders = new ArrayList<String>();
			  	        
			  	listOfUIData.add(userIDFromUI);  
			  	listOfUIData.add(firstDateWorkedFromUI); 
			  	listOfUIData.add(recruitDateFromUI); 
			  	listOfUIData.add(benefitsEligibilityStartDateFromUI); 
			  	listOfUIData.add(contingentWorkerFromUI); 
			  	listOfUIData.add(eligibleForStockFromUI); 
			  	listOfUIData.add(employeesFirstEmploymentFromUI); 
			  	listOfUIData.add(originalStartDateFromUI); 
			  	listOfUIData.add(professionalServiceDateFromUI); 
			  	listOfUIData.add(seniorityStartDateFromUI); 
			  	listOfUIData.add(serviceDateFromUI); 
			  	


			  	listOfCSVData.add(mp.get("User ID"));
			  	listOfCSVData.add(mp.get("First Date Worked"));
			  	listOfCSVData.add(mp.get("Recruit Date"));
			  	listOfCSVData.add(mp.get("Benefits Eligibility Start Date"));
			  	listOfCSVData.add(mp.get("Contingent Worker"));
			  	listOfCSVData.add(mp.get("Eligible for Stock"));
			  	listOfCSVData.add(mp.get("Employee's First Employment"));
			  	listOfCSVData.add(mp.get("Original Start Date"));
			  	listOfCSVData.add(mp.get("Professional Service Date"));
			  	listOfCSVData.add(mp.get("Seniority Start Date"));
			  	listOfCSVData.add(mp.get("Service Date"));
			
			  	
			  	listOfHeaders.add("User ID");
			  	listOfHeaders.add("First Date Worked");
			  	listOfHeaders.add("Recruit Date");
			  	listOfHeaders.add("Benefits Eligibility Start Date");
			  	listOfHeaders.add("Contingent Worker");
			  	listOfHeaders.add("Eligible for Stock");
			  	listOfHeaders.add("Employees First Employment");
			  	listOfHeaders.add("Original Start Date");
			  	listOfHeaders.add("Professional Service Date");
			  	listOfHeaders.add("Seniority Start Date");
			  	listOfHeaders.add("Service Date");

			  	
			  	//Writing Comparison Report
			  	
			  	//  System.out.println("total Columns " +cellCount); 
			  	   
			  	    for(int a=1;a<=listOfUIData.size();a++) {
			  	    	 row = sheet.createRow(rowCount+1);
			  	    	 
			  	    	 for(int b=0 ; b<cellCount;b++) {
			  	    		//int cellToSetValue = 0;
			  	    		Cell cell=row.createCell(b);
					  	    	if(b==0) { 		
					  	    		cell.setCellValue(mp.get("User ID"));
					  	    	}
					  	    	else if(b==1) {
					  	    		cell.setCellValue(listOfHeaders.get(a-1));
					  	    	}
					  	    	else if(b==2) {
					  	    		cell.setCellValue(listOfUIData.get(a-1));
					  	    	}
					  	    	else if(b==3) {
					  	    		cell.setCellValue(listOfCSVData.get(a-1));
					  	    	}
					  	    	
					  	    	//cellToSetValue++;
					  	    }
			  	    	rowCount++;
			  	    }
			  	  fis.close();
			          FileOutputStream out = new FileOutputStream(new File(filePath));
			          wb.write(out);
			          out.close();
			          System.out.println("Updated Successfully");			  	    
			  	    
			    }
			    
			    rowCount=sheet.getLastRowNum();			  
			    lineCount++;
			}
			
		} 
	catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
	}	
	
	
	///////////////////////////////////JOb History////////////////////////
	
	public void validateEmployeeProfileDataforJobHistory() throws InterruptedException {
		if(ImportEmployeeDataPageActions.validateImportedFileErrorFlag==true) {
			Assert.assertTrue(false, "Error present in previous steps...Exiting test execution");
		}
		String [] arr = ImportEmployeeDataPageActions.fileName.split("\\\\");
		fileNameToValidate = arr[7].toString();
		System.out.println("New File Name is " +fileNameToValidate);
		
		BufferedReader br=null;
		File src = new File(System.getProperty("user.dir")+"\\employeedataNew\\"+ fileNameToValidate);
		
//		CSVReader c = new CSVReader(new FileReader(src));
//		c.skip(1);
		Map<String, String> mp = new HashMap<String, String>();
		List<String> headers = new ArrayList<String>(); 
		List<String> empData = new ArrayList<String>(); 
		List<Integer> emptyEmpDataCount = new ArrayList<Integer>();
		List<String> finalHeaderList = new ArrayList<String>();
		String line= null;
		String[] cols = null;
//		String key=null;
		int lineCount=1;
		int rowCount = 0;
		
		
	    //Reading the ComparisonReport file
	  	  String filePath = "C:\\Users\\debasishdey\\Desktop\\workspace\\SAP_Automation\\testReports\\ComparisonReport.xlsx";
	  	  FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	  	    Workbook wb=null;
			try {
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	  Sheet sheet = wb.getSheet("JobHstoryInfoTemplate");	  	  
	  	  Row row = null;
	  	  row=sheet.getRow(0);
	  	  int cellCount = row.getLastCellNum();
	  	  
	  	  
	  	  
	  	  int rowCount2=sheet.getLastRowNum();
	  	  System.out.println("Row Count for new Run "+rowCount2);
	  	  if(rowCount2>0) {
	  		  for(int m =1;m<=rowCount2;m++) {
	  			sheet.removeRow(sheet.getRow(m));
	  		  }
	  		  
	  	  }
		
		try {
		br = new BufferedReader(new FileReader(src));
			while (( line = br.readLine()) != null) {  //Reading the csv line by line by line
			    cols = line.split(",");				   //Splitting each line by comma separator
//		    for(String s: cols) {
//		    	//ls.add(s);
//		    }
			    int i;
			    
			    if(lineCount==2) {						//Retrieving all the headers
			    	  for(i=0;i<cols.length;i++) {
					    	//ls.clear();
			    			 headers.add(cols[i]);
					    	//System.out.println(ls + "Iteration "+i);		    	  
					    	//break;
			    		  	
							}
					    
			    }
			    

			    if(lineCount>=3) {						//Retrieving employee data starting from 3rd line in csv file
			    	finalHeaderList.clear();
			    	mp.clear();
			    	  for(i=0;i<cols.length;i++) {
					    	//ls.clear();
			    		  if(!cols[i].isEmpty()) {
			    			  emptyEmpDataCount.add(i);
			    			  empData.add(cols[i]);
			    		  }

							}
				
			  		for(int j=0;j<emptyEmpDataCount.size();j++) {
						int count = emptyEmpDataCount.get(j);
						finalHeaderList.add(headers.get(count));
				}
			  		
			  	    for(int m=0;m<finalHeaderList.size();m++) {
			  	    	mp.put(finalHeaderList.get(m).toString(), empData.get(m).toString());
			  	    }
			  	    
			  	    
			  	    
			  	    //Reteiving Data from UI:
			  	    
			  	    System.out.println(">>> Retreive UI data ");
			  	    

			  	    Thread.sleep(3000);
			  	    loginpageLocators.searchBox.click();
			  	    loginpageLocators.searchBox.sendKeys(mp.get("User ID"));
					
					Thread.sleep(3000);
					String empSearchListText = driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText();
					System.out.println("Search list " +empSearchListText);
					
					try {
										
						GenericMethods.actionClassForClickOnElement(driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul/li")).get(0));
					}
					
					catch(Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(10000);
			  	
			  	    String userIDFromUI = employeeProfilePageLocators.personId.getText();
			  	    System.out.println(userIDFromUI + "---> " +mp.get("User ID"));
			  	    
			  	    GenericMethods.javaScriptExecutorScrollingIntoToViewWithElement(employeeProfilePageLocators.organizationalInfoSection);
			  	    GenericMethods.actionClassForClickOnElement(employeeProfilePageLocators.showMoreBttnOrganizationalInfoSection.get(0));
			  	    
			  	    String companyFromUI = employeeProfilePageLocators.company.getText();
			  	    System.out.println(companyFromUI + "---> " +mp.get("Company"));
			  	    
			  	    GenericMethods.javaScriptExecutorScrollingIntoToViewWithElement(employeeProfilePageLocators.jobInfoSection);
			  	    GenericMethods.actionClassForClickOnElement(employeeProfilePageLocators.showMoreBttnJobInfoSection.get(0));
			  	    
			  	    String jobClassificationFromUI = employeeProfilePageLocators.JobClassification.getText();
			  	    System.out.println(jobClassificationFromUI + "---> " +mp.get("Job Classification"));
			  	    
			  	    String jobTitleFromUI = employeeProfilePageLocators.JobTitle.getText();
			  	    System.out.println(jobTitleFromUI + "---> " +mp.get("Job Title"));
			  	    
			  	    String locationFromUI = employeeProfilePageLocators.Location.getText();
			  	    System.out.println(locationFromUI + "---> " +mp.get("Location"));
			  	    
			  	    String positionFromUI = employeeProfilePageLocators.Position.getText();
			  	    System.out.println(positionFromUI + "---> " +mp.get("Position"));
			  	    
			  	    String costCentreFromUI = employeeProfilePageLocators.CostCentre.getText();
			  	    System.out.println(costCentreFromUI + "---> " +mp.get("Cost Centre"));
			  	    
			  	    String employeeClassFromUI = employeeProfilePageLocators.EmployeeClass.getText();
			  	    System.out.println(employeeClassFromUI + "---> " +mp.get("Employee Class"));
			  	    
			  	    String FTEFromUI = employeeProfilePageLocators.FTE.getText();
			  	    System.out.println(FTEFromUI + "---> " +mp.get("FTE"));
			  	    
			  	    String LOBFromUI = employeeProfilePageLocators.LineofBusinessCentre.getText();
			  	    System.out.println(LOBFromUI + "---> " +mp.get("Line of Business - Centre"));
			  	    
			  	    String regularOrTemporaryFromUI = employeeProfilePageLocators.RegularTemporary.getText();
			  	    System.out.println(regularOrTemporaryFromUI + "---> " +mp.get("Regular/Temporary"));
			  	   
			  	    
			  	    
			  	    //Writting data in excel
			  	 List<String> listOfUIData = new ArrayList<String>();
			  	 List<String> listOfCSVData = new ArrayList<String>();
			  	 List<String> listOfHeaders = new ArrayList<String>();
			  	        
			  	listOfUIData.add(userIDFromUI);  
			  	listOfUIData.add(companyFromUI); 
			  	listOfUIData.add(jobClassificationFromUI); 
			  	listOfUIData.add(jobTitleFromUI); 
			  	listOfUIData.add(locationFromUI); 
			  	listOfUIData.add(positionFromUI); 
			  	listOfUIData.add(costCentreFromUI); 
			  	listOfUIData.add(employeeClassFromUI); 
			  	listOfUIData.add(FTEFromUI); 
			  	listOfUIData.add(LOBFromUI); 
			  	listOfUIData.add(regularOrTemporaryFromUI); 
			  	


			  	listOfCSVData.add(mp.get("User ID"));
			  	listOfCSVData.add(mp.get("Company"));
			  	listOfCSVData.add(mp.get("Job Classification"));
			  	listOfCSVData.add(mp.get("Job Title"));
			  	listOfCSVData.add(mp.get("Location"));
			  	listOfCSVData.add(mp.get("Position"));
			  	listOfCSVData.add(mp.get("Cost Centre"));
			  	listOfCSVData.add(mp.get("Employee Class"));
			  	listOfCSVData.add(mp.get("FTE"));
			  	listOfCSVData.add(mp.get("Line of Business - Centre"));
			  	listOfCSVData.add(mp.get("Regular/Temporary"));
			
			  	
			  	listOfHeaders.add("User ID");
			  	listOfHeaders.add("Company");
			  	listOfHeaders.add("Job Classification");
			  	listOfHeaders.add("Job Title");
			  	listOfHeaders.add("Location");
			  	listOfHeaders.add("Position");
			  	listOfHeaders.add("Cost Centre");
			  	listOfHeaders.add("Employee Class");
			  	listOfHeaders.add("FTE");
			  	listOfHeaders.add("Line of Business - Centre");
			  	listOfHeaders.add("Regular/Temporary");

			  	
			  	//Writing Comparison Report
			  	
			  	//  System.out.println("total Columns " +cellCount); 
			  	   
			  	    for(int a=1;a<=listOfUIData.size();a++) {
			  	    	 row = sheet.createRow(rowCount+1);
			  	    	 
			  	    	 for(int b=0 ; b<cellCount;b++) {
			  	    		//int cellToSetValue = 0;
			  	    		Cell cell=row.createCell(b);
					  	    	if(b==0) { 		
					  	    		cell.setCellValue(mp.get("User ID"));
					  	    	}
					  	    	else if(b==1) {
					  	    		cell.setCellValue(listOfHeaders.get(a-1));
					  	    	}
					  	    	else if(b==2) {
					  	    		cell.setCellValue(listOfUIData.get(a-1));
					  	    	}
					  	    	else if(b==3) {
					  	    		cell.setCellValue(listOfCSVData.get(a-1));
					  	    	}
					  	    	
					  	    	//cellToSetValue++;
					  	    }
			  	    	rowCount++;
			  	    }
			  	  fis.close();
			          FileOutputStream out = new FileOutputStream(new File(filePath));
			          wb.write(out);
			          out.close();
			          System.out.println("Updated Successfully");			  	    
			  	    
			    }
			    
			    rowCount=sheet.getLastRowNum();			  
			    lineCount++;
			}
			
		} 
	catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
	}	
	
	
	///////Personal Info/////////////////////////
	
	public void validateEmployeeProfileDataforPersonalInfo() throws InterruptedException {
		if(ImportEmployeeDataPageActions.validateImportedFileErrorFlag==true) {
			Assert.assertTrue(false, "Error present in previous steps...Exiting test execution");
		}
		String [] arr = ImportEmployeeDataPageActions.fileName.split("\\\\");
		fileNameToValidate = arr[7].toString();
		System.out.println("New File Name is " +fileNameToValidate);
		
		BufferedReader br=null;
		File src = new File(System.getProperty("user.dir")+"\\employeedataNew\\"+ fileNameToValidate);
		
//		CSVReader c = new CSVReader(new FileReader(src));
//		c.skip(1);
		Map<String, String> mp = new HashMap<String, String>();
		List<String> headers = new ArrayList<String>(); 
		List<String> empData = new ArrayList<String>(); 
		List<Integer> emptyEmpDataCount = new ArrayList<Integer>();
		List<String> finalHeaderList = new ArrayList<String>();
		String line= null;
		String[] cols = null;
//		String key=null;
		int lineCount=1;
		int rowCount = 0;
		
		
	    //Reading the ComparisonReport file
	  	  String filePath = "C:\\Users\\debasishdey\\Desktop\\workspace\\SAP_Automation\\testReports\\ComparisonReport.xlsx";
	  	  FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	  	    Workbook wb=null;
			try {
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	  Sheet sheet = wb.getSheet("PersonalInfoTemplate");	  	  
	  	  Row row = null;
	  	  row=sheet.getRow(0);
	  	  int cellCount = row.getLastCellNum();
	  	  
	  	  
	  	  
	  	  int rowCount2=sheet.getLastRowNum();
	  	  System.out.println("Row Count for new Run "+rowCount2);
	  	  if(rowCount2>0) {
	  		  for(int m =1;m<=rowCount2;m++) {
	  			sheet.removeRow(sheet.getRow(m));
	  		  }
	  		  
	  	  }
		
		try {
		br = new BufferedReader(new FileReader(src));
			while (( line = br.readLine()) != null) {  //Reading the csv line by line by line
			    cols = line.split(",");				   //Splitting each line by comma separator
//		    for(String s: cols) {
//		    	//ls.add(s);
//		    }
			    int i;
			    
			    if(lineCount==2) {						//Retrieving all the headers
			    	  for(i=0;i<cols.length;i++) {
					    	//ls.clear();
			    			 headers.add(cols[i]);
					    	//System.out.println(ls + "Iteration "+i);		    	  
					    	//break;
			    		  	
							}
					    
			    }
			    

			    if(lineCount>=3) {						//Retrieving employee data starting from 3rd line in csv file
			    	finalHeaderList.clear();
			    	mp.clear();
			    	  for(i=0;i<cols.length;i++) {
					    	//ls.clear();
			    		  if(!cols[i].isEmpty()) {
			    			  emptyEmpDataCount.add(i);
			    			  empData.add(cols[i]);
			    		  }

							}
				
			  		for(int j=0;j<emptyEmpDataCount.size();j++) {
						int count = emptyEmpDataCount.get(j);
						finalHeaderList.add(headers.get(count));
				}
			  		
			  	    for(int m=0;m<finalHeaderList.size();m++) {
			  	    	mp.put(finalHeaderList.get(m).toString(), empData.get(m).toString());
			  	    }
			  	    
			  	    
			  	    
			  	    //Reteiving Data from UI:
			  	    
			  	    System.out.println(">>> Retreive UI data ");
			  	    

			  	    Thread.sleep(3000);
			  	    loginpageLocators.searchBox.click();
			  	    loginpageLocators.searchBox.sendKeys(mp.get("Person ID External"));
					
					Thread.sleep(3000);
					String empSearchListText = driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0).getText();
					System.out.println("Search list " +empSearchListText);
					
					try {
										
						GenericMethods.actionClassForClickOnElement(driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul/li")).get(0));
					}
					
					catch(Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(10000);
			  	
					
					
			  	    String personIDFromUI = employeeProfilePageLocators.personId.getText();
			  	    System.out.println(personIDFromUI + "---> " +mp.get("Person ID External"));
			  	    
			  	    GenericMethods.javaScriptExecutorScrollingIntoToViewWithElement(employeeProfilePageLocators.personalInfoSection);
			  	    employeeProfilePageLocators.GenderShowBttn.click();
			  	    
			  	    String firstNameFromUI = employeeProfilePageLocators.FirstName.getText();
			  	    System.out.println(firstNameFromUI + "---> " +mp.get("Company"));
			  	    
			  	    String middleNmaeFromUI = employeeProfilePageLocators.MiddleName.getText();
			  	    System.out.println(middleNmaeFromUI + "---> " +mp.get("Job Classification"));
			  	    
			  	    String LastNameFromUI = employeeProfilePageLocators.LastName.getText();
			  	    System.out.println(LastNameFromUI + "---> " +mp.get("Job Title"));
			  	    
			  	    String salutationFromUI = employeeProfilePageLocators.Salutation.getText();
			  	    System.out.println(salutationFromUI + "---> " +mp.get("Location"));
			  	    
			  	    String prefferedNameFromUI = employeeProfilePageLocators.PreferredName.getText();
			  	    System.out.println(prefferedNameFromUI + "---> " +mp.get("Position"));
			  	    
			  	    String genderFromUI = employeeProfilePageLocators.Gender.getText();
			  	    System.out.println(genderFromUI + "---> " +mp.get("Cost Centre"));
			  	    
			  	    String maritalStatusFromUI = employeeProfilePageLocators.MaritalStatus.getText();
			  	    System.out.println(maritalStatusFromUI + "---> " +mp.get("Employee Class"));
			  	    
			  	    String nationalityFromUI = employeeProfilePageLocators.Nationality.getText();
			  	    System.out.println(nationalityFromUI + "---> " +mp.get("FTE"));
			  	    
			  	    String nativePrefferedLanguageFromUI = employeeProfilePageLocators.NativePreferredLanguage.getText();
			  	    System.out.println(nativePrefferedLanguageFromUI + "---> " +mp.get("Line of Business - Centre"));
			  	    
			  	    String attachmentFromUI = employeeProfilePageLocators.Attachment.getText();
			  	    System.out.println(attachmentFromUI + "---> " +mp.get("Regular/Temporary"));
			  	   
			  	    
			  	    
			  	    //Writting data in excel
			  	 List<String> listOfUIData = new ArrayList<String>();
			  	 List<String> listOfCSVData = new ArrayList<String>();
			  	 List<String> listOfHeaders = new ArrayList<String>();
			  	        
			  	listOfUIData.add(personIDFromUI);  
			  	listOfUIData.add(firstNameFromUI); 
			  	//listOfUIData.add(middleNmaeFromUI); 
			  	listOfUIData.add(LastNameFromUI); 
			  	listOfUIData.add(salutationFromUI); 
			  	listOfUIData.add(prefferedNameFromUI); 
			  	listOfUIData.add(genderFromUI); 
			  	listOfUIData.add(maritalStatusFromUI); 
			  	listOfUIData.add(nationalityFromUI); 
			  	listOfUIData.add(nativePrefferedLanguageFromUI); 
			  	//listOfUIData.add(attachmentFromUI); 
			  	


			  	listOfCSVData.add(mp.get("Person ID External"));
			  	listOfCSVData.add(mp.get("First Name"));
			  	listOfCSVData.add(mp.get("Last Name"));
			  	listOfCSVData.add(mp.get("Salutation"));
			  	listOfCSVData.add(mp.get("Preferred Name"));
			  	listOfCSVData.add(mp.get("Gender"));
			  	listOfCSVData.add(mp.get("Marital Status"));
			  	listOfCSVData.add(mp.get("Nationality"));
			  	listOfCSVData.add(mp.get("Native Preferred Language"));

			
			  	
			  	listOfHeaders.add("Person ID");
			  	listOfHeaders.add("First Name");
			  	listOfHeaders.add("Last Name");
			  	listOfHeaders.add("Salutation");
			  	listOfHeaders.add("Preferred Name");
			  	listOfHeaders.add("Gender");
			  	listOfHeaders.add("Marital Status");
			  	listOfHeaders.add("Nationality");
			  	listOfHeaders.add("Native Preferred Language");


			  	
			  	//Writing Comparison Report
			  	
			  	//  System.out.println("total Columns " +cellCount); 
			  	   
			  	    for(int a=1;a<=listOfUIData.size();a++) {
			  	    	 row = sheet.createRow(rowCount+1);
			  	    	 
			  	    	 for(int b=0 ; b<cellCount;b++) {
			  	    		//int cellToSetValue = 0;
			  	    		Cell cell=row.createCell(b);
					  	    	if(b==0) { 		
					  	    		cell.setCellValue(mp.get("Person ID External"));
					  	    	}
					  	    	else if(b==1) {
					  	    		cell.setCellValue(listOfHeaders.get(a-1));
					  	    	}
					  	    	else if(b==2) {
					  	    		cell.setCellValue(listOfUIData.get(a-1));
					  	    	}
					  	    	else if(b==3) {
					  	    		cell.setCellValue(listOfCSVData.get(a-1));
					  	    	}
					  	    	
					  	    	//cellToSetValue++;
					  	    }
			  	    	rowCount++;
			  	    }
			  	  fis.close();
			          FileOutputStream out = new FileOutputStream(new File(filePath));
			          wb.write(out);
			          out.close();
			          System.out.println("Updated Successfully");			  	    
			  	    
			    }
			    
			    rowCount=sheet.getLastRowNum();			  
			    lineCount++;
			}
			
		} 
	catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
	}
}
