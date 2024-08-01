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
import groovy.xml.XmlSlurper
import java.nio.file.Files
import java.nio.file.Paths

// Send request and get the response
def response = WS.sendRequest(findTestObject('BMKG'))
def responseContent = response.getResponseText()

// Parse the XML response
def xmlResponse = new XmlSlurper().parseText(responseContent)

// Get all area id information
def areaIds = xmlResponse.forecast.area*.@id*.toString()
println("Area IDs: " + areaIds)

// Validate Area IDs
def targetAreaId = '501397'
if (areaIds.contains(targetAreaId)) {
	println("Area ID '${targetAreaId}' is present in the response.")
} else {
	println("Area ID '${targetAreaId}' is NOT present in the response.")
	println("Area IDs in response: " + areaIds)
}

// Assert that '501397' is present
assert areaIds.contains(targetAreaId)

// Convert areaIds list to a string with each ID on a new line
def areaIdsString = areaIds.join("\n")

// Define the file path
def filePath = 'areaIds.txt'

// Write the area IDs to a text file
Files.write(Paths.get(filePath), areaIdsString.getBytes())

println("Area IDs have been saved to ${filePath}")
