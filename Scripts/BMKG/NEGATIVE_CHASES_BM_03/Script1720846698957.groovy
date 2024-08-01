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

// Mocking a response with incorrect temperature values
def responseContent = '''
<forecast>
  <area id="501397" latitude="5.54491" longitude="95.34312" coordinate="95.34312 5.54491" type="land" region="" level="1" description="Banda Aceh" domain="Aceh" tags="">
    <parameter id="t" description="Temperature" type="hourly">
      <timerange type="hourly" h="12" datetime="202407131200">
        <value unit="C">28</value>
        <value unit="F">82.4</value>
      </timerange>
    </parameter>
  </area>
</forecast>
'''

// Parse the XML response
def xmlResponse = new XmlSlurper().parseText(responseContent)

// Extract temperature parameter
def temperatureParameters = xmlResponse.forecast.area.parameter.findAll { it.@id == 't' }

// Validate temperature parameter values
def targetDateTime = '202407131200'
def targetTempC = '30'
def targetTempF = '86'

boolean temperatureMatched = false

temperatureParameters.each { param ->
	def timerange = param.timerange.find { it.@datetime == targetDateTime }
	if (timerange != null) {
		def tempC = timerange.value.find { it.@unit == 'C' }?.text()
		def tempF = timerange.value.find { it.@unit == 'F' }?.text()
		
		if (tempC == targetTempC && tempF == targetTempF) {
			temperatureMatched = true
		}
	}
}

assert !temperatureMatched : "Temperature values should not match but they did."
