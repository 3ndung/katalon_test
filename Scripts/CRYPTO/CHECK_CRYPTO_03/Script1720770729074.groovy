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
import groovy.json.JsonSlurper // Importing JsonSlurper

// Initialize an empty array
def ARR = []

try {
	// Send the GET request to the specified URL
	def response = WS.sendRequest(findTestObject('POST_GUS'))

	// Verify that the response status code is 200
	WS.verifyResponseStatusCode(response, 200)

	// Parse the response to JSON
	def jsonResponse = new JsonSlurper().parseText(response.getResponseText())

	// Extract the USD code and rate_float and save them into the array
	if (jsonResponse.bpi.x) {
		ARR << jsonResponse.bpi.x.code
		ARR << jsonResponse.bpi.x.rate_float
	} else {
		println('Does not Exist ya Cynnnnn :D ')
	}

	// Print the array to verify the values
	println("Array contents: " + ARR)
} catch (Exception e) {
	println('An error occurred: ' + e.message)
}