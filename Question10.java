import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question10 {
   public static void main(String[] args) {
   try {
         Scanner scanner = new Scanner(new File("sampleInt.txt"));

			while (scanner.hasNextLine()) {
				String intTerm = scanner.nextLine();
            System.out.println(intTerm);
            if (isHex(intTerm) == true){
            System.out.println("Valid Integer Literal");
            }
            else if (isOct(intTerm) == true){
            System.out.println("Valid Integer Literal");
            }
            else if (isDec(intTerm) == true){
            System.out.println("Valid Integer Literal");
            }
            else {
            System.out.println("Not Integer Literal");
            } 
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}   
   }
   
   public static boolean isDec(String intTerm){
      String status;
	   String strID = "^[1-9][0-9]*(u|l)?$";
		Pattern patID = Pattern.compile(strID);
	   Matcher matcherID = patID.matcher(intTerm);
	   boolean matchFoundID = matcherID.find(); 
	   if(matchFoundID) {
         return true;
	   } else{
         return false;
      }
   }
   public static boolean isOct(String intTerm){
      String status;
	   String strID2 = "^0[0-7]*(u|l)?$";
		Pattern patID2 = Pattern.compile(strID2);
	   Matcher matcherID2 = patID2.matcher(intTerm);
	   boolean matchFoundID2 = matcherID2.find(); 
	   if(matchFoundID2) {
         return true;
	   } else{
         return false;
      }
   }
   public static boolean isHex(String intTerm){
      String status;
	   String strID3 = "^(0x|0X)[0-9A-Fa-f]*(I64|Ui64)?$";
		Pattern patID3 = Pattern.compile(strID3);
	   Matcher matcherID3 = patID3.matcher(intTerm);
	   boolean matchFoundID3 = matcherID3.find(); 
	   if(matchFoundID3) {
         return true;
	   } else{
         return false;
      }
   }
}
