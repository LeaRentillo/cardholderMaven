package CardholderMavenProject;

public class settings {
	   public static final int loginTest = 1;
	   public static final int accountTest = 2;
	   public static final int orderCardTest = 3;
	   public static final int pinTest = 4;
	   public static final int loadByCardTest = 5;
	   public static final int loadByBankTransfertest = 6;
	   public static final int profileTest = 7;
	   public static final int statementTest = 8;
	   public static final int suspendedTest = 9;
	   public static final int unloadTest = 10;
	   public static final int viewImageTest = 11;
	   
	   //testing setup
	   
	   public boolean skipTest(String testCase) {
		   boolean runTestCase = true;
		   switch (testCase) {
           case "loginTest": runTestCase = true;
        	   	break;
           case "accountTest": runTestCase = true;
   	   			break;
           case "loadByCardTest": runTestCase = true;
   	   			break;
           case "loadByBankTransfertest": runTestCase = true;
   	   			break;
           case "orderCardTest": runTestCase = true;
   	   			break;
           case "pinTest": runTestCase = false;
   	   			break;
           case "profileTest": runTestCase = true;
   	   			break;
           case "statementTest": runTestCase = true;
   	   			break;
           case "suspendedTest": runTestCase = true;
   	   			break;
           case "unloadTest": runTestCase = false;
   	   			break;
           case "viewImageTest": runTestCase = true;
   	   			break;
           default:  runTestCase = true;
                    break;
		   }
		   
		   return runTestCase;
		   
	   }
}
