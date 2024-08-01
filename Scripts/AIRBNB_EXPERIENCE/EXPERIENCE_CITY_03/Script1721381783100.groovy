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

// Open the browser
WebUI.openBrowser('')

// Navigate to the Airbnb website
WebUI.navigateToUrl('https://www.airbnb.com/')

// Define a method to handle broken locators with a fallback strategy
def clickElement(TestObject primaryLocator, TestObject fallbackLocator) {
	try {
		WebUI.click(primaryLocator)
	} catch (Exception e) {
		WebUI.click(fallbackLocator)
	}
}

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Open the browser and navigate to the Airbnb website
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.airbnb.com/')

// Check if the 'Experiences' button is present and clickable
boolean isExperiencesButtonPresent = WebUI.waitForElementVisible(findTestObject('Object Repository/AIRBNB_EXP_02/Page_Airbnb  Vacation rentals, cabins, beac_308838/span_Experiences'), 10)
assert isExperiencesButtonPresent : 'Experiences button is not present'

// Check if the search input field is present and editable
boolean isSearchInputPresent = WebUI.waitForElementVisible(findTestObject('Object Repository/AIRBNB_EXP_02/Page_Airbnb  Vacation rentals, cabins, beac_308838/input_Where_query'), 10)
assert isSearchInputPresent : 'Search input field is not present'

// Check if the date picker is present and clickable
boolean isDatePickerPresent = WebUI.waitForElementVisible(findTestObject('Object Repository/AIRBNB_EXP_02/Page_Airbnb  Vacation rentals, cabins, beac_308838/div_Add dates'), 10)
assert isDatePickerPresent : 'Date picker is not present'

// Check if the guest selector is present and clickable
boolean isGuestsSelectorPresent = WebUI.waitForElementVisible(findTestObject('Object Repository/AIRBNB_EXP_02/Page_Airbnb  Vacation rentals, cabins, beac_308838/span_Add guests_t1dqvypu atm_9s_1ulexfb atm_023ad9'), 10)
assert isGuestsSelectorPresent : 'Guests selector is not present'

// Check if the experiences count is present
boolean isExperiencesCountPresent = WebUI.waitForElementVisible(findTestObject('Object Repository/AIRBNB_EXP_02/Page_Things to Do in Tokyo  5-Star Authenti_352301/span_267 experiences'), 10)
assert isExperiencesCountPresent : 'Experiences count is not present'

// Close the browser
WebUI.closeBrowser()

