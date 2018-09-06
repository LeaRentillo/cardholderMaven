package CardholderMavenProject;

public class settings {

	public static final int registrationTest = 1;
	public static final int loginTest = 2;
	public static final int accountTest = 3;
/*	public static final int orderCardTest = 4;
	public static final int loadByCardTest = 6;*/
	public static final int loadByBankTransfertest = 4;
	public static final int profileTest = 5;
	public static final int statementTest = 6;
	public static final int suspendedTest = 7;
	public static final int unloadTest = 8;
	public static final int orderCardNonEUTest = 9;
	public static final int orderCardEUTest = 10;
	public static final int loadByCardEUTest = 11;
	public static final int loadByCardNonEUTest = 12;
	public static final int pinTest = 13;
	public static final int viewImageTest = 14;
	   
	   //testing setup
	   
	   public boolean skipTest(String testCase) {
		   boolean runTestCase;
		   switch (testCase) {
           case "registrationTest": runTestCase = false;
        	   	break;
           case "loginTest": runTestCase = false;
   	   			break;
           case "accountTest": runTestCase = false;
   	   			break;         
           case "loadByBankTransfertest": runTestCase = false;
   	   			break;          
           case "pinTest": runTestCase = false;
   	   			break;
           case "profileTest": runTestCase = false;
   	   			break;
           case "statementTest": runTestCase = false;
   	   			break;
           case "suspendedTest": runTestCase = false;
   	   			break;
           case "unloadTest": runTestCase = false;
   	   			break;
           case "viewImageTest": runTestCase = false;
   	   			break;
           case "orderCardNonEUTest": runTestCase = false;
	   			break;
           case "orderCardEUTest": runTestCase = false;
	   			break;
           case "loadByCardEUTest": runTestCase = false;
	   			break;
           case "loadByCardNonEUTest": runTestCase = true;
	   			break;
           default:  runTestCase = true;
                    break;
		   }
		   
		   return runTestCase;
		   
	   }
}