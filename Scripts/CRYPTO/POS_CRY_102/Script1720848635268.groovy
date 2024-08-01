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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

def historicalDataEndpoint = 'GET_Historical_Data'
def expectedStatusCode = 200
def dateFormatPattern = /\d{4}-\d{2}-\d{2}/

try {
	// Send request to historical data endpoint
	def response = WS.sendRequest(findTestObject(historicalDataEndpoint))
	
	// Verify the response status code
	WS.verifyResponseStatusCode(response, expectedStatusCode)
	
	// Parse the JSON response
	def jsonResponse = new JsonSlurper().parseText(response.getResponseText())
	
	// Validate date format and positive values for historical data
	jsonResponse.bpi.each { date, value ->
		assert date ==~ dateFormatPattern
		assert value > 0
	}
	
} catch (Exception e) {
	println('An error occurred: ' + e.message)
}
