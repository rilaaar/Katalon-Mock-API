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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.json.JSONObject as JSONObject
import org.json.JSONTokener as JSONTokener
import org.everit.json.schema.Schema as Schema
import org.everit.json.schema.loader.SchemaLoader as SchemaLoader
import org.json.JSONArray as JSONArray
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder


println("Random ID yang digunakan: " + GlobalVariable.randomId)

def response = WS.sendRequestAndVerify(findTestObject('PATCH - Update a User', [('UserId') : GlobalVariable.randomId]))

def responseBody = response.getResponseBodyContent()
println("Raw Response Body:")
println(responseBody)

def json = new JsonSlurper().parseText(responseBody)
if (json instanceof Map && json.containsKey("data")) {
	println("Data user:")
	println(new JsonBuilder(json.data).toPrettyString())
}
else if (json instanceof List) {
	println("Response array:")
	println(new JsonBuilder(json).toPrettyString())
}
else {
	println(" Response bukan array 'data':")
	println(new JsonBuilder(json).toPrettyString())
}

def schemaPath = RunConfiguration.getProjectDir() + '/Include/schemas/update_a_user.json'
def schemaFile = new File(schemaPath)
def schemaJson = new JSONObject(new JSONTokener(new FileInputStream(schemaFile)))
def responseJson = new JSONArray(response.getResponseBodyContent())

SchemaLoader.load(schemaJson).validate(responseJson)