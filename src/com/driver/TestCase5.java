package com.driver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.operation.KeywordExecutor;
import com.operation.TestMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.GenerateReport;
import com.utility.ReadExcel;

public class TestCase5 extends TestMethods {
	/**
	 * Main Driver method that will drive the execution
	 * 
	 * @param args
	 */
	
	String testSuiteFile = System.getProperty("user.dir") + "/TestSuites/FirstTestSuite.xls";
	KeywordExecutor executor = new KeywordExecutor();
	String testSheetName = this.getClass().getSimpleName();
	ExtentTest test;
	String stepExecutionResult[];
	
	@BeforeClass()
	public void beforeTestMethod(){
		 test = GenerateReport.reporter.startTest(testSheetName+"_TestCase");
	}
	
	@Test(dataProvider = "driverMethodData")
	public void driverMethod(String keyword, String identificador,String locator, String inputData, String purpose) throws Exception {
		stepExecutionResult = executor.execute(driver, keyword, identificador ,locator, inputData).split("::");
		Shutterbug.shootPage(driver).withName("Validar Inicio_TestCase_5").save();
		System.out.println(stepExecutionResult[0] +" - "+ stepExecutionResult[1]);
		if(stepExecutionResult[0].toUpperCase().contains("PASS"))
		{ 
			test.log(LogStatus.PASS, keyword +" - "+ purpose, stepExecutionResult[1]);
			Shutterbug.shootPage(driver).withName("Test_Satisfactorio_Test_5").save();
		}
		else if(stepExecutionResult[0].toUpperCase().contains("FAIL")){
			test.log(LogStatus.FAIL, keyword+" - "+ purpose, stepExecutionResult[1]);
			Shutterbug.shootPage(driver).withName("Test_Fallido_Test_5").save();
		}
		
	}
	
	@DataProvider
	public Object[][] driverMethodData() {
		Object testData[][] = ReadExcel.ExcelReader(testSuiteFile, testSheetName);
		for (Object[] objects : testData) {
			for (Object object : objects) {
				System.out.println(object);
			}
		}
		return testData;
	}
	
	@AfterClass
	public void closeTestAndDriver(){
		GenerateReport.reporter.endTest(test);
		GenerateReport.reporter.flush();
		driver.quit();
		
	}
}
