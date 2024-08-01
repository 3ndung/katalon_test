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

WebUI.setText(findTestObject('Object Repository/AMZ_JP_X/Page_Amazon.co.jp  Books, Apparel, Electron_6e447f/input_Search Amazon.co.jp_field-keywords'), 
    product)

WebUI.click(findTestObject('Object Repository/AMZ_JP_X/Page_Amazon.co.jp  Books, Apparel, Electron_6e447f/input_Search Amazon.co.jp_nav-search-submit-button'))

WebUI.click(findTestObject('Object Repository/AMZ_JP_X/Page_Amazon.co.jp  nintendo/input_Indonesia_a-button-input'))

WebUI.doubleClick(findTestObject('Object Repository/AMZ_JP_X/Page_Amazon.co.jp  nintendo/span_nintendo'))

WebUI.verifyElementText(findTestObject('Object Repository/AMZ_JP_X/Page_Amazon.co.jp  nintendo/span_nintendo'), '"nintendo"')

WebUI.closeBrowser()

