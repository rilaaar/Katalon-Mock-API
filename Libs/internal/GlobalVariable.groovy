package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object ApiKey
     
    /**
     * <p></p>
     */
    public static Object Token
     
    /**
     * <p></p>
     */
    public static Object BaseUrl
     
    /**
     * <p></p>
     */
    public static Object randomId
     
    /**
     * <p></p>
     */
    public static Object randomUsername
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            ApiKey = selectedVariables['ApiKey']
            Token = selectedVariables['Token']
            BaseUrl = selectedVariables['BaseUrl']
            randomId = selectedVariables['randomId']
            randomUsername = selectedVariables['randomUsername']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
