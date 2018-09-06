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
           case "registrationTest": runTestCase = true;
        	   	break;
           case "loginTest": runTestCase = true;
   	   			break;
           case "accountTest": runTestCase = true;
   	   			break;         
           case "loadByBankTransfertest": runTestCase = true;
   	   			break;          
           case "pinTest": runTestCase = true;
   	   			break;
           case "profileTest": runTestCase = true;
   	   			break;
           case "statementTest": runTestCase = true;
   	   			break;
           case "suspendedTest": runTestCase = true;
   	   			break;
           case "unloadTest": runTestCase = true;
   	   			break;
           case "viewImageTest": runTestCase = true;
   	   			break;
           case "orderCardNonEUTest": runTestCase = true;
	   			break;
           case "orderCardEUTest": runTestCase = true;
	   			break;
           case "loadByCardEUTest": runTestCase = true;
	   			break;
           case "loadByCardNonEUTest": runTestCase = true;
	   			break;
           default:  runTestCase = true;
                    break;
		   }
		   
		   return runTestCase;
		   
	   }
}