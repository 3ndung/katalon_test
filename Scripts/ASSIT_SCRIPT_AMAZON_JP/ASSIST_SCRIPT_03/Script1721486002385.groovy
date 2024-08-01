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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.amazon.co.jp/')

WebUI.setText(findTestObject('Object Repository/ASSIST_SCRIPT/Page_Amazon.co.jp  Books, Apparel, Electron_6e447f/input_Search Amazon.co.jp_field-keywords'), 
    'nintendo switch')

WebUI.doubleClick(findTestObject('Object Repository/ASSIST_SCRIPT/Page_Amazon.co.jp  nintendo switch/span_1-48 of over 1,000 results for'))

WebUI.closeBrowser()

/*
*  Open a browser, navigate to Amazon Japan, search for 'nintendo switch', double click on a specific element, and then close the browser.
*
*  1. Open a browser with no specific URL.
*  2. Navigate to the Amazon Japan website.
*  3. Set the text 'nintendo switch' in the search field.
*  4. Double click on a specific element related to the search results.
*  5. Close the browser.
*
*/
