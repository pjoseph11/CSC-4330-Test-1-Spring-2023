import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question8 {
   public static void main(String[] args) {
   try {
         Scanner scanner = new Scanner(new File("sampleEmails.txt"));

			while (scanner.hasNextLine()) {
				String word = scanner.nextLine();
            int index = word.indexOf('@');
            System.out.println("Email: " + word);
            if (index > 0) {
               String localPart = word.substring(0, index);
               String domainName = word.substring(index + 1);
               System.out.println("Local Part: " + localString(localPart));
               System.out.println("Domain Part: " + domainString(domainName));
               if (localString(localPart) && domainString(domainName) == true){
                  System.out.println("Valid Email.");
               } else {
                  System.out.println("Not Valid Email.");

               }
            }


			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}   
   }
   
   public static boolean localString(String local){
      String status;
	   String strID = "^[^.](?!.*[.][.])[-A-Za-z0-9_%$'!&*=?^`{}|~.\\/#&+]*[^\\.]$";
		Pattern patID = Pattern.compile(strID);
	   Matcher matcherID = patID.matcher(local);
	   boolean matchFoundID = matcherID.find(); 
	   if(matchFoundID) {
         return true;
	   } else{
         return false;
      }
   }
   public static boolean domainString(String domain){
      String status;
	   String strID2 = "^[^-.@](?!.*[.][.])[A-za-z0-9-.]*[^\\-.@]$";
		Pattern patID2 = Pattern.compile(strID2);
	   Matcher matcherID2 = patID2.matcher(domain);
	   boolean matchFoundID2 = matcherID2.find(); 
	   if(matchFoundID2) {
         return true;
	   } else{
         return false;
      }
   }  
}
