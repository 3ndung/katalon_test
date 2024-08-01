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

WebUI.navigateToUrl('https://www.traveloka.com/en-id')

WebUI.click(findTestObject('Object Repository/TRAPEL/Page_Traveloka - Southeast Asias Leading Tr_13aaf0/input_From_css-11aywtz r-cwxd7f r-13awgt0 r_549de5'))

WebUI.setText(findTestObject('Object Repository/TRAPEL/Page_Traveloka - Southeast Asias Leading Tr_13aaf0/input_To_css-11aywtz r-cwxd7f r-13awgt0 r-t_6f93ff'), 
    dest)

WebUI.click(findTestObject('Object Repository/TRAPEL/Page_Traveloka - Southeast Asias Leading Tr_13aaf0/input_To_css-11aywtz r-cwxd7f r-13awgt0 r-t_6f93ff'))

WebUI.click(findTestObject('Object Repository/TRAPEL/Page_Traveloka - Southeast Asias Leading Tr_13aaf0/svg'))

WebUI.closeBrowser()

