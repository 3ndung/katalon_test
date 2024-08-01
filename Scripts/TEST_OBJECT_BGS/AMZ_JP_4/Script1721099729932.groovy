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

WebUI.setText(findTestObject('Object Repository/AMZ_JP_X/AMZ_JP_X1/Page_Amazon.co.jp  Books, Apparel, Electron_6e447f/input_Search Amazon.co.jp_field-keywords'), 
    'nintendo')

WebUI.click(findTestObject('Object Repository/AMZ_JP_X/AMZ_JP_X1/Page_Amazon.co.jp  Books, Apparel, Electron_6e447f/input_Search Amazon.co.jp_nav-search-submit-button'))

WebUI.click(findTestObject('Object Repository/AMZ_JP_X/AMZ_JP_X1/Page_Amazon.co.jp  nintendo/img_Results_s-image'))

WebUI.switchToWindowTitle('Amazon.co.jp: ニンテンドープリペイド番号 9000円|オンラインコード版 : Video Games')

WebUI.click(findTestObject('Object Repository/AMZ_JP_X/AMZ_JP_X1/Page_Amazon.co.jp  9000  Video Games/button_1) 500'))

WebUI.click(findTestObject('Object Repository/AMZ_JP_X/AMZ_JP_X1/Page_Amazon.co.jp  9000  Video Games/button_2) 1,000'))

WebUI.click(findTestObject('Object Repository/AMZ_JP_X/AMZ_JP_X1/Page_Amazon.co.jp  9000  Video Games/button_3) 2,000'))

WebUI.click(findTestObject('Object Repository/AMZ_JP_X/AMZ_JP_X1/Page_Amazon.co.jp  9000  Video Games/button_4) 3,000'))

WebUI.click(findTestObject('Object Repository/AMZ_JP_X/AMZ_JP_X1/Page_Amazon.co.jp  9000  Video Games/button_6) 9,000'))

WebUI.click(findTestObject('Object Repository/AMZ_JP_X/AMZ_JP_X1/Page_Amazon.co.jp  9000  Video Games/button_5) 5,000'))

WebUI.click(findTestObject('Object Repository/AMZ_JP_X/AMZ_JP_X1/Page_Amazon.co.jp  9000  Video Games/img__a-dynamic-image p13n-sc-dynamic-image _885a43'))

WebUI.closeBrowser()

