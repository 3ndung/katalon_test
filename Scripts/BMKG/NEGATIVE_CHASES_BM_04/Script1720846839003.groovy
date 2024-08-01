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

// Mocking a response with extra unexpected parameters
def responseContent = '''
<forecast>
  <area id="501397" latitude="5.54491" longitude="95.34312" coordinate="95.34312 5.54491" type="land" region="" level="1" description="Banda Aceh" domain="Aceh" tags="">
    <parameter id="t" description="Temperature" type="hourly">
      <timerange type="hourly" h="12" datetime="202407131200">
        <value unit="C">30</value>
        <value unit="F">86</value>
      </timerange>
    </parameter>
    <parameter id="unexpected" description="Unexpected Parameter" type="hourly">
      <timerange type="hourly" h="12" datetime="202407131200">
        <value unit="X">999</value>
      </timerange>
    </parameter>
  </area>
</forecast>
'''

// Parse the XML response
def xmlResponse = new XmlSlurper().parseText(responseContent)

// Extract unexpected parameter
def unexpectedParameters = xmlResponse.forecast.area.parameter.findAll { it.@id == 'unexpected' }

// Validate unexpected parameter values
assert unexpectedParameters.size() == 0 : "Unexpected parameters should not be present but they are."
