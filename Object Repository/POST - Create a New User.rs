<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST - Create a New User</name>
   <tag></tag>
   <elementGuidId>72d3bc82-6386-4111-bdd3-e5f4b1ae1556</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot; {\n    \&quot;id\&quot;:${GlobalVariable.randomId},\n    \&quot;first_name\&quot;:\&quot;${firstName}\&quot;,\n    \&quot;last_name\&quot;:\&quot;${lastName}\&quot;,\n    \&quot;username\&quot;:\&quot;${GlobalVariable.randomUsername}\&quot;,\n    \&quot;job_position\&quot;:\&quot;${jobPosition}\&quot;,\n    \&quot;job_level\&quot;:\&quot;${jobLevel}\&quot;,\n    \&quot;salary\&quot;:${jobSalary},\n    \&quot;work_duration\&quot;:${workDuration}\n  }&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>apikey</name>
      <type>Main</type>
      <value>${GlobalVariable.ApiKey}</value>
      <webElementGuid>025e7ea1-9d51-4054-ae76-83d37e1d489f</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.Token}</value>
      <webElementGuid>89ddbf0d-9cef-4fb4-ac39-d79c54821808</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>ccdf0d21-dbcf-4bb9-b596-fe03f3945cc7</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Prefer</name>
      <type>Main</type>
      <value>return=representation</value>
      <webElementGuid>29443ed3-d473-4dd8-b9eb-c4728f2e4117</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.3.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.BaseUrl}/users</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'Manusia'</defaultValue>
      <description></description>
      <id>657f3f19-f1db-4881-bc2d-c9630cfe563a</id>
      <masked>false</masked>
      <name>firstName</name>
   </variables>
   <variables>
      <defaultValue>'Super'</defaultValue>
      <description></description>
      <id>9a05c329-2868-4891-bfd0-20ff977d41e8</id>
      <masked>false</masked>
      <name>lastName</name>
   </variables>
   <variables>
      <defaultValue>'QA Engineer'</defaultValue>
      <description></description>
      <id>55979274-cfc6-42fc-b0bf-3f2151e32322</id>
      <masked>false</masked>
      <name>jobPosition</name>
   </variables>
   <variables>
      <defaultValue>'Manager'</defaultValue>
      <description></description>
      <id>aa7bb299-6bdd-40af-9ab4-450435c2882a</id>
      <masked>false</masked>
      <name>jobLevel</name>
   </variables>
   <variables>
      <defaultValue>'999999999999'</defaultValue>
      <description></description>
      <id>aa2f85b6-cc38-4f5b-9943-dd170d00ebb7</id>
      <masked>false</masked>
      <name>jobSalary</name>
   </variables>
   <variables>
      <defaultValue>'30'</defaultValue>
      <description></description>
      <id>4faa76c0-6382-458a-916e-02a26c19e674</id>
      <masked>false</masked>
      <name>workDuration</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()


WS.verifyResponseStatusCode(response, 201)

assertThat(response.getStatusCode()).isEqualTo(201)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
