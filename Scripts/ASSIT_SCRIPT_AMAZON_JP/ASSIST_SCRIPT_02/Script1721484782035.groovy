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
 
1 Open the browser: Start by opening a web browser.
2 Go to amazon.co.jp
3 input_search "Nintendo Swithc"
4 close browswe

 * */
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Open the browser
WebUI.openBrowser('')

// Go to Amazon Japan
WebUI.navigateToUrl('https://www.amazon.co.jp')

// Wait for the search bar to be present (you might need to adjust the timeout)
WebUI.waitForElementPresent(findTestObject('Page_amazon.co.jp/input_search'), 10)

// Input "Nintendo Switch" into the search bar
WebUI.setText(findTestObject('Page_amazon.co.jp/input_search'), 'Nintendo Switch')

// Close the browser
WebUI.closeBrowser()