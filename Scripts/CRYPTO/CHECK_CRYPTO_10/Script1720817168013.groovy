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

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

// Define additional variables
def endpoint = 'POST_GUS'
def expectedStatusCode = 200
def jsonResponseField = 'bpi.x'
def defaultCode = 'Code not available'
def defaultRate = 0.0
def responseTimeThreshold = 2000
def historicalDataEndpoint = 'GET_Historical_Data'
def invalidEndpoint = 'POST_Invalid_Endpoint'
def maxDescriptionLength = 50
def dateFormatPattern = /\d{4}-\d{2}-\d{2}/

def ARR = []

try {
	// Send request to the specified endpoint
	def response = WS.sendRequest(findTestObject(endpoint))
	
	// Verify the response status code
	WS.verifyResponseStatusCode(response, expectedStatusCode)
	
	// Verify response time is below the threshold
	WS.verifyResponseTime(response, responseTimeThreshold)
	
	// Parse the JSON response
	def jsonResponse = new JsonSlurper().parseText(response.getResponseText())

	// Extract and validate the fields
	if (jsonResponse.bpi.x) {
		def code = jsonResponse.bpi.x.code ?: defaultCode
		def rateFloat = jsonResponse.bpi.x.rate_float ?: defaultRate
		
		assert code.length() <= maxDescriptionLength
		ARR << code
		ARR << rateFloat
	} else {
		println('Does not Exist ya Cynnnnn :D ')
	}

	// Print the array contents
	println("Array contents: " + ARR)

	// Additional test cases
	
	// Check historical data retrieval
	def historicalResponse = WS.sendRequest(findTestObject(historicalDataEndpoint))
	WS.verifyResponseStatusCode(historicalResponse, expectedStatusCode)
	def historicalJsonResponse = new JsonSlurper().parseText(historicalResponse.getResponseText())

	if (historicalJsonResponse.bpi) {
		historicalJsonResponse.bpi.each { date, value ->
			assert date ==~ dateFormatPattern // Validate date format
			assert value > 0 // Ensure value is positive
		}
	} else {
		println('No historical data available')
	}

	// Test invalid endpoint error handling
	try {
		def invalidResponse = WS.sendRequest(findTestObject(invalidEndpoint))
		WS.verifyResponseStatusCode(invalidResponse, 404)
		println("Invalid endpoint test passed")
	} catch (Exception e) {
		println('An error occurred while testing invalid endpoint: ' + e.message)
	}
	
} catch (Exception e) {
	println('An error occurred: ' + e.message)
}
