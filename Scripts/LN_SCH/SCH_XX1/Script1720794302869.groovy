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
import groovy.json.JsonOutput

def url = 'https://107d-sgapp.teleows.com/ws/rest/107d/wfm_pos_lead/wfm/reschedule/get_allocation'
def headers = [
	'Authorization': 'Basic MTA3ZHxlQ05rbmhmaFVLTUJjOEZxYWlZYTo+RG5BUkM/WUg6ZVU1anteJE9CT2NkV0wvbEQtQypLQUFBQXYoTH1gNlQtVkdLWmgvUFM8XmFEbEt0Ujk+I18k',
	'Content-Type': 'application/json'
]

// Dynamic parameters
def startDate = '2024-06-09' // Replace with your start date
def endDate = '2024-07-20' // Replace with your end date
def homepassId = '04103080' // Replace with your homepass ID

def data = [
	"start_date": startDate,
	"end_date": endDate,
	"homepass_id": homepassId,
	"vendor_name": "LINKNET",
	"city_code": "",
	"wo_type": "onboarding"
]

def response = WS.sendRequest(findTestObject('Object Repository/YourWebServiceObject', [
	('url') : url,
	('headers') : headers,
	('body') : JsonOutput.toJson(data)
]))

if (response.getStatusCode() == 200) {
	println('Request was successful')
	def responseJson = new JsonSlurper().parseText(response.getResponseText())
	println('Response: ' + JsonOutput.prettyPrint(JsonOutput.toJson(responseJson)))

	// Save the pretty-printed JSON to a file
	new File('RPS.json').withWriter('UTF-8') { writer ->
		writer.write(JsonOutput.prettyPrint(JsonOutput.toJson(responseJson)))
	}
} else {
	println('Request failed with status code: ' + response.getStatusCode())
}