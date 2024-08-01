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

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp  Books, Apparel, Electron_6e447f/input_Indonesia_a-button-input'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp  Books, Apparel, Electron_6e447f/a_Amazon Points Check your balance'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp Amazon Stores Amazon  More/a_Best Sellers'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp Best Sellers The most pop_7c929d/a_Amazon Devices  Accessories'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp Best Sellers The most pop_1dde50/a_Amazon Device Accessories'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp Best Sellers The most pop_921ede/a_Audio'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp Best Sellers The most pop_4aff84/a_Clocks'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp Best Sellers The most pop_e41aca/a_Memory Cards'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp Best Sellers The most pop_85e5d9/a_Power Supplies  Chargers'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp Best Sellers The most pop_90a54a/a_Reading Lights'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp Best Sellers The most pop_bcdf0e/a_Remote Controls'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp Best Sellers The most pop_6d1935/div_Alexa Pro (2022)  Fire TV'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon.co.jp Alexa Pro (2022)  Fire TV/a_Todays Deals'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon Prime Day 2024/button_Amazon'))

WebUI.click(findTestObject('Object Repository/AMZ_JP/Page_Amazon Prime Day 2024/div_Fire HD 10  - 10HD  32GB  (2023)_a-sect_2e1b59'))

WebUI.closeBrowser()

