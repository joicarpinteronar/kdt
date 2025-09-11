package com.operation;

import org.openqa.selenium.WebDriver;




public class KeywordExecutor {
	
	TestMethods tests = new TestMethods(); //Creating object of a TestMethod class	
	
	/**
	 * This method will execute the test methods according to the keyword provided
	 * @param keywordData
	 * @param identificadorData
	 * @param locatorData
	 * @param inputData
	 */
	String stepExecuionResult; 
	public String execute(WebDriver driver, String keywordData,  String identificadorData ,String locatorData, String inputData) throws InterruptedException{
		switch (keywordData) {
		case"OpenBrowser":
			stepExecuionResult = tests.abrirNavegador(inputData);
			break;
		case "OpenWebsite":
			stepExecuionResult = tests.openUrl(driver, inputData);
			break;
		case "Clear":
			stepExecuionResult = tests.clear(driver, identificadorData, locatorData);
			break;
		case "ScrollToElement":
			stepExecuionResult = tests.scrollToElement(identificadorData, locatorData);
			break;
		case "WaitForElement":
			stepExecuionResult = tests.WaitForElement(identificadorData, locatorData, inputData);
			break;
		case "EnterText":
			stepExecuionResult = tests.enterText(driver, identificadorData,locatorData, inputData);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			break;

		case "Click":
			stepExecuionResult = tests.click(driver, identificadorData, locatorData);
			
			break;
		case "VerifyText":
			stepExecuionResult = tests.verifyText(driver, identificadorData, locatorData, inputData);			
			break;
		default:
			System.out.println("Invalid Keyword");
			stepExecuionResult = "Invalid Keyword";
			break;
		}
		return stepExecuionResult;

	}
	

}
