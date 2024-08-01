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

import groovy.json.JsonSlurper

// ARR to store all films
List<String> ARR = []
List<String> TVShows = []
List<String> VideoGames = []
List<String> ParkAttractions = []
List<String> Allies = []
List<String> Enemies = []

String sourceUrl
String imageUrl
String createdAt
String updatedAt
String url

// Send the GET request to the specified URL
def response = WS.sendRequest(findTestObject('DISNEY'))

// Verify that the response status code is 200
WS.verifyResponseStatusCode(response, 200)

// Parse the response to JSON
def jsonResponse = new JsonSlurper().parseText(response.getResponseText())

// Test case 1: Get all films parameter
def films = jsonResponse.data.films

// Test case 2: Save all films parameter into the ARR list
ARR.addAll(films)

// Test case 3: Get all TV shows
def tvShows = jsonResponse.data.tvShows
TVShows.addAll(tvShows)

// Test case 4: Get all video games
def videoGames = jsonResponse.data.videoGames
VideoGames.addAll(videoGames)

// Test case 5: Get all park attractions
def parkAttractions = jsonResponse.data.parkAttractions
ParkAttractions.addAll(parkAttractions)

// Test case 6: Get all allies
def allies = jsonResponse.data.allies
Allies.addAll(allies)

// Test case 7: Get all enemies
def enemies = jsonResponse.data.enemies
Enemies.addAll(enemies)

// Additional variables
sourceUrl = jsonResponse.data.sourceUrl
imageUrl = jsonResponse.data.imageUrl
createdAt = jsonResponse.data.createdAt
updatedAt = jsonResponse.data.updatedAt
url = jsonResponse.data.url

// Printing all films for verification
println "All films: $ARR"

// Iterate over ARR and print each film if its length is greater than 3
for (String film : ARR) {
	if (film.length() > 3) {
		println film
	}
}

// Printing additional variables
println "TV Shows: $TVShows"
println "Video Games: $VideoGames"
println "Park Attractions: $ParkAttractions"
println "Allies: $Allies"
println "Enemies: $Enemies"
println "Source URL: $sourceUrl"
println "Image URL: $imageUrl"
println "Created At: $createdAt"
println "Updated At: $updatedAt"
println "URL: $url"
