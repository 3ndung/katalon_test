import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil

// Send the POST request
def response = WS.sendRequest(findTestObject('LNX'))

// Verify the response status code
if (response.getStatusCode() == 201) {  // 201 is the expected LNXstatus code for a successful POST request
    KeywordUtil.markPassed('Request was successful')
    def jsonResponse = new JsonSlurper().parseText(response.getResponseText())
    KeywordUtil.logInfo('Response: ' + JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponse)))

    // Save the response to a JSON file
    def jsonFile = new File('response.json')
    jsonFile.write(JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponse)))

} else {
    KeywordUtil.markFailed('Request failed with status code: ' + response.getStatusCode())
}
