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

// Function to get nationality information for a given name
def getNationality(String name) {
	// Send the GET request to the specified URL using the object repository
	def response = WS.sendRequest(findTestObject('Object Repository/TEBAK_NAME', [('name') : name]))

	// Verify that the response status code is 200
	WS.verifyResponseStatusCode(response, 200)

	// Parse the response to JSON
	def jsonResponse = new JsonSlurper().parseText(response.getResponseText())

	// Return the JSON response
	return jsonResponse
}

// Array of names
def NAME = ['BAGUS', 'BAYU', 'EFRAN', 'CINDY']

// Iterate through each name in the array
NAME.each { name ->
	// Skip processing if the name is 'CINDY'
	if (name == 'CINDY') {
		println("Skipping ${name}...")
		return
	}
	
	// Call the function and get the nationality information for each name
	def nationalityInfo = getNationality(name)

	// Print the nationality information for each name
	println("Nationality information for ${name}: ${nationalityInfo}")
}
