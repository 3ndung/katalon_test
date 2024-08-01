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


/* Write a Katalon Studio test case to perform the following steps.
 * 1. Open browser to the URL https://www.airbnb.com/
 * 2. Click Experiences
 * 3. Fill in Search Distination with Tokyo
 * 4. Add Date from 1 ~ 30 August 2024
 * 5. Click Search
 * 6. Close the browser
 * */
// Open browser to the URL https://www.airbnb.com/
WebUI.openBrowser('https://www.airbnb.com/')

// Click Experiences
WebUI.click(findTestObject('Object Repository/Experiences_Button'))

// Fill in Search Destination with Tokyo
WebUI.setText(findTestObject('Object Repository/Search_Destination_Input'), 'Tokyo')

// Add Date from 1 ~ 30 August 2024
WebUI.setText(findTestObject('Object Repository/Date_Input'), '1 August 2024')
WebUI.setText(findTestObject('Object Repository/Date_Input'), '30 August 2024')

// Click Search
WebUI.click(findTestObject('Object Repository/Search_Button'))

// Close the browser
WebUI.closeBrowser()
