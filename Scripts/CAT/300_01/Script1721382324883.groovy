import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.internal.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

// Method to handle self-healing of locators
def handleBrokenLocator(def testObject, Closure action) {
	int maxRetries = 3
	int retryCount = 0
	boolean successful = false
	
	while (retryCount < maxRetries && !successful) {
		try {
			action.call()
			successful = true
		} catch (StepFailedException e) {
			retryCount++
			if (retryCount >= maxRetries) {
				throw e
			}
			// Optional: Add logging for each retry
			println("Retrying due to locator failure. Attempt ${retryCount}")
			// Re-fetching the test object might help if locators are dynamically changing
			testObject = WebUiCommonHelper.findWebElement(testObject, FailureHandling.OPTIONAL)
		}
	}
}

// Test case for fetching cat facts
int numberOfTimes = 5
String logFilePath = 'cat_facts_log.txt'
Path logFile = Paths.get(logFilePath)

if (!Files.exists(logFile)) {
	Files.createFile(logFile)
}

// Ensure the log file is empty at the start
Files.write(logFile, ''.getBytes(), StandardOpenOption.TRUNCATE_EXISTING)

for (int i = 0; i < numberOfTimes; i++) {
	handleBrokenLocator(findTestObject('CAT1')) {
		def response = WS.sendRequest(findTestObject('CAT1'))
		WS.verifyResponseStatusCode(response, 200)
		
		def jsonResponse = new JsonSlurper().parseText(response.getResponseText())
		String fact = jsonResponse.fact

		println("Fact ${i + 1}: " + fact)

		// Log fact to file
		Files.write(logFile, ("Fact ${i + 1}: " + fact + "\n").getBytes(), StandardOpenOption.APPEND)
	}
}
