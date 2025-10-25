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

CustomKeywords.'defaultPackage.RandomData.setRandomUserData'()
println("Random ID yang digunakan: " + GlobalVariable.randomId)

// 1. Create User
def createResponse = WS.sendRequest(findTestObject('POST - Create a New User'))

def userId = WS.getElementPropertyValue(createResponse, 'id')
println(createResponse.getResponseBodyContent())

// 2. Read User
def readResponse = WS.sendRequestAndVerify(findTestObject('GET - Single User', [('UserId') : GlobalVariable.randomId]))

WS.verifyElementPropertyValue(readResponse, 'first_name', '[Manusia]')
println(readResponse.getResponseBodyContent())

// 3. Update User
def updateResponse = WS.sendRequest(findTestObject('PATCH - Update a User', [('UserId') : GlobalVariable.randomId]))
println(updateResponse.getResponseBodyContent())

// 4. Read again to verify update
def verifyUpdate = WS.sendRequestAndVerify(findTestObject('GET - Single User', [('UserId') : GlobalVariable.randomId]))

WS.verifyElementPropertyValue(verifyUpdate, 'job_level', '[Senior Manager]')
println(verifyUpdate.getResponseBodyContent())

// 5. Delete User
def deleteResponse = WS.sendRequest(findTestObject('DELETE - Delete a User', [('UserId') : GlobalVariable.randomId]))
println(deleteResponse.getResponseBodyContent())

// 6. Read deleted user
def checkDeleted = WS.sendRequest(findTestObject('GET - Single User', [('UserId') : GlobalVariable.randomId]))

WS.verifyResponseStatusCode(checkDeleted, 200)
println(checkDeleted.getResponseBodyContent())

