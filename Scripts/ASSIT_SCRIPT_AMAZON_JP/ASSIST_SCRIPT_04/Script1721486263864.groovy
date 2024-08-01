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

/*
 *  Open a browser, navigate to Amazon Japan, search for 'nintendo switch', double click on a specific element, and then close the browser.
 *
 *  1. Open a browser with no specific URL.
 *  2. Navigate to https://www.amazon.co.jp/
 *  3. Set the text 'nintendo switch' in the search field.
 *  4. Close the browser.
 *
 */
// Open a browser with no specific URL
WebUI.openBrowser('')

// Navigate to https://www.amazon.co.jp/
WebUI.navigateToUrl('https://www.amazon.co.jp/')

// Set the text 'nintendo switch' in the search field
WebUI.setText(findTestObject('Page_Amazon Japan/input_Search'), 'nintendo switch')

// Close the browser
WebUI.closeBrowser()