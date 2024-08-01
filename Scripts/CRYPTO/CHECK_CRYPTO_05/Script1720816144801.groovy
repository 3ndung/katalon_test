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

def ARR = []

try {
	def response = WS.sendRequest(findTestObject('POST_GUS'))
	WS.verifyResponseStatusCode(response, 200)
	
	def jsonResponse = new JsonSlurper().parseText(response.getResponseText())

	def expectedSchema = [
		'time': [ 'updated': String, 'updatedISO': String, 'updateduk': String ],
		'disclaimer': String,
		'chartName': String,
		'bpi': [ 'USD': [ 'code': String, 'rate': String, 'description': String, 'rate_float': Number ] ]
	]

	def isValidSchema = { json, schema ->
		schema.every { k, v ->
			if (v instanceof Class) {
				json[k] in v
			} else {
				isValidSchema(json[k], v)
			}
		}
	}
	
	assert isValidSchema(jsonResponse, expectedSchema)

	if (jsonResponse.bpi.USD) {
		ARR << jsonResponse.bpi.USD.code
		ARR << jsonResponse.bpi.USD.rate_float
	} else {
		println('Does not Exist ya Cynnnnn :D ')
	}

	println("Array contents: " + ARR)
} catch (Exception e) {
	println('An error occurred: ' + e.message)
}
