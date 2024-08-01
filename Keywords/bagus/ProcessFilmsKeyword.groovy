package bagus

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import groovy.json.JsonSlurper


public class ProcessFilmsKeyword {
    @Keyword
    def static void saveAndPrintFilms(List<String> films) {
        List<String> ARR = []
        ARR.addAll(films)
        println "All films: $ARR"
        
        // Iterate over ARR and print each film if its length is greater than 3
        ARR.each { film ->
            if (film.size() > 3) {
                println film
            }
        }
    }

    @Keyword
    def static void verifyAndPrintTVShows(response) {
        def jsonResponse = new JsonSlurper().parseText(response.getResponseText())
        if (jsonResponse.data.tvShows) {
            List<String> TVShows = jsonResponse.data.tvShows
            println "TV Shows: $TVShows"
        } else {
            println "No TV Shows found."
        }
    }
}
