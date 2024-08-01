import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

// Define the number of times you want to fetch the facts
int numberOfTimes = 5

// Loop to send the request and print the fact
for (int i = 0; i < numberOfTimes; i++) {
    // Send the GET request to the specified URL
    def response = WS.sendRequest(findTestObject('CAT1'))

    // Verify that the response status code is 200
    WS.verifyResponseStatusCode(response, 200)

    // Parse the response to JSON
    def jsonResponse = new JsonSlurper().parseText(response.getResponseText())

    // Print the fact from the response
    println("Fact ${i + 1}: " + jsonResponse.fact)
	println(jsonResponse.fact)
}

