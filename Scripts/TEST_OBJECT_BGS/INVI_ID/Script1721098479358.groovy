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

WebUI.navigateToUrl('https://www.invincible.id/')

WebUI.click(findTestObject('Object Repository/INVI_ID/Page_INVINCIBLE Indonesia  INVINCIBLE Indonesia/span_Search_show-search-link__icon'))

WebUI.click(findTestObject('Object Repository/INVI_ID/Page_INVINCIBLE Indonesia  INVINCIBLE Indonesia/pop-up_Close        Join Us                _3b2f88'))

WebUI.setText(findTestObject('Object Repository/INVI_ID/Page_INVINCIBLE Indonesia  INVINCIBLE Indonesia/input_Cart_q'), 
    'nike')

WebUI.doubleClick(findTestObject('Object Repository/INVI_ID/Page_Search 214 results found for nike  INV_8102d5/div_We found 214 results'))

WebUI.doubleClick(findTestObject('Object Repository/INVI_ID/Page_Search 214 results found for nike  INV_8102d5/input_Search_q'))

WebUI.doubleClick(findTestObject('Object Repository/INVI_ID/Page_Search 214 results found for nike  INV_8102d5/input_Search_q'))

WebUI.setText(findTestObject('Object Repository/INVI_ID/Page_Search 214 results found for nike  INV_8102d5/input_Search_q'), 
    'stussy')

WebUI.doubleClick(findTestObject('Object Repository/INVI_ID/Page_Search 95 results found for stussy  IN_380e1e/input_Search_q'))

WebUI.setText(findTestObject('Object Repository/INVI_ID/Page_Search 95 results found for stussy  IN_380e1e/input_Search_q'), 
    'adidas')

WebUI.doubleClick(findTestObject('Object Repository/INVI_ID/Page_Search 23 results found for adidas  IN_c9ce64/div_We found 23 results'))

WebUI.closeBrowser()

