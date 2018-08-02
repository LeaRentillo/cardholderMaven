package CardholderMavenProject;

public class settings {
	   public static final int loginTest = 1;
	   public static final int accountTest = 2;
	   public static final int loadByCardTest = 3;
	   public static final int loadByBankTransfertest = 4;
	   public static final int orderCardTest = 5;
	   public static final int pinTest = 6;
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
           case "accountTest": runTestCase = false;
   	   			break;
           case "loadByCardTest": runTestCase = false;
   	   			break;
           case "loadByBankTransfertest": runTestCase = false;
   	   			break;
           case "orderCardTest": runTestCase = false;
   	   			break;
           case "pinTest": runTestCase = false;
   	   			break;
           case "profileTest": runTestCase = false;
   	   			break;
           case "statementTest": runTestCase = false;
   	   			break;
           case "suspendedTest": runTestCase = false;
   	   			break;
           case "unloadTest": runTestCase = true;
   	   			break;
           case "viewImageTest": runTestCase = false;
   	   			break;
           default:  runTestCase = true;
                    break;
		   }
		   
		   return runTestCase;
		   
	   }
}
