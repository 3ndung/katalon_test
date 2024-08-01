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

ARR = []

	// Send the GET request to the specified URL
def response = WS.sendRequest(findTestObject('CARI_SEKOLAH'))

	// Verify that the response status code is 200
WS.verifyResponseStatusCode(response, 200)

	// Parse the response to JSON
//def jsonResponse = new JsonSlurper().parseText(response.getResponseText())

	// Print the fact from the response
	
	//println("Fact ${i + 1}: " + jsonResponse.fact)
//println("ini --> "+jsonResponse)

// Parse the JSON response
def jsonArray = new JsonSlurper().parseText(response.getResponseText())

// Initialize lists to store names and web pages
def names = []
def webPages = []

// Iterate through each object in the JSON array
jsonArray.each { entry ->
	// Extract name and web_pages
	def name = entry.name
	def webPage = entry.web_pages[0] // Assuming there's only one web page per entry

	// Add name and web_page to lists
	names.add(name)
	webPages.add(webPage)
}

// Print names and web_pages

println("Names: ${names}")
println("Web Pages: ${webPages}")

