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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Start Test Cloud Tunnel (this should already be running from the terminal commands)
WebUI.comment("Ensure Test Cloud Tunnel is running before executing this script")

// Open Browser
WebUI.openBrowser('')

// Navigate to Google
WebUI.navigateToUrl('https://www.google.com')

// Wait for the page to load
WebUI.waitForPageLoad(10)

// Find the search box and enter the keyword "Katalon"
WebUI.setText(findTestObject('Page_Google/input_search_box'), 'Katalon')

// Click the Google Search button
WebUI.click(findTestObject('Page_Google/button_search'))

// Wait for the results page to load
WebUI.waitForPageLoad(10)

// Verify the search results contain "Katalon"
boolean isPresent = WebUI.verifyTextPresent('Katalon', false)

if (isPresent) {
	WebUI.comment("Search results contain 'Katalon'")
} else {
	WebUI.comment("Search results do not contain 'Katalon'")
}

// Close Browser
WebUI.closeBrowser()
