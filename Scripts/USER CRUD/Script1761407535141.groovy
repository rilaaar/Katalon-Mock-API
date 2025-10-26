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
import groovy.json.JsonBuilder

CustomKeywords.'defaultPackage.RandomData.setRandomUserData'()
println("Random ID yang digunakan: " + GlobalVariable.randomId)

// 1. Create User
def createResponse = WS.sendRequest(findTestObject('POST - Create a New User'))

def userId = WS.getElementPropertyValue(createResponse, 'id')

def responseBody0 = createResponse.getResponseBodyContent()
println("Raw Response Body:")
println(responseBody0)

def json0 = new JsonSlurper().parseText(responseBody0)
if (json0 instanceof Map && json0.containsKey("data")) {
	println("Data user:")
	println(new JsonBuilder(json0.data).toPrettyString())
}
else if (json0 instanceof List) {
	println("Response array:")
	println(new JsonBuilder(json0).toPrettyString())
}
else {
	println(" Response bukan array 'data':")
	println(new JsonBuilder(json0).toPrettyString())
}

// 2. Read User
def readResponse = WS.sendRequestAndVerify(findTestObject('GET - Single User', [('UserId') : GlobalVariable.randomId]))

WS.verifyElementPropertyValue(readResponse, 'first_name', '[Manusia]')

def responseBody1 = readResponse.getResponseBodyContent()
println("Raw Response Body:")
println(responseBody1)

def json1 = new JsonSlurper().parseText(responseBody1)
if (json1 instanceof Map && json1.containsKey("data")) {
	println("Data user:")
	println(new JsonBuilder(json1.data).toPrettyString())
}
else if (json1 instanceof List) {
	println("Response array:")
	println(new JsonBuilder(json1).toPrettyString())
}
else {
	println(" Response bukan array 'data':")
	println(new JsonBuilder(json1).toPrettyString())
}

// 3. Update User
def updateResponse = WS.sendRequest(findTestObject('PATCH - Update a User', [('UserId') : GlobalVariable.randomId]))

def responseBody2 = updateResponse.getResponseBodyContent()
println("Raw Response Body:")
println(responseBody2)

def json2 = new JsonSlurper().parseText(responseBody2)
if (json2 instanceof Map && json2.containsKey("data")) {
	println("Data user:")
	println(new JsonBuilder(json2.data).toPrettyString())
}
else if (json2 instanceof List) {
	println("Response array:")
	println(new JsonBuilder(json2).toPrettyString())
}
else {
	println(" Response bukan array 'data':")
	println(new JsonBuilder(json2).toPrettyString())
}

// 4. Read again to verify update
def verifyUpdate = WS.sendRequestAndVerify(findTestObject('GET - Single User', [('UserId') : GlobalVariable.randomId]))

WS.verifyElementPropertyValue(verifyUpdate, 'job_level', '[Senior Manager]')

def responseBody3 = verifyUpdate.getResponseBodyContent()
println("Raw Response Body:")
println(responseBody3)

def json3 = new JsonSlurper().parseText(responseBody3)
if (json3 instanceof Map && json3.containsKey("data")) {
	println("Data user:")
	println(new JsonBuilder(json3.data).toPrettyString())
}
else if (json3 instanceof List) {
	println("Response array:")
	println(new JsonBuilder(json3).toPrettyString())
}
else {
	println(" Response bukan array 'data':")
	println(new JsonBuilder(json3).toPrettyString())
}

// 5. Delete User
def deleteResponse = WS.sendRequest(findTestObject('DELETE - Delete a User', [('UserId') : GlobalVariable.randomId]))
println(deleteResponse.getResponseBodyContent())

// 6. Read deleted user
def checkDeleted = WS.sendRequest(findTestObject('GET - Single User', [('UserId') : GlobalVariable.randomId]))

WS.verifyResponseStatusCode(checkDeleted, 200)
println(checkDeleted.getResponseBodyContent())

