import java.util.*;
import java.io.*;
public class Problem3{
    public static List<Integer> codedNumbers = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
        File temp = new File("DATA31.txt");
        Scanner file = new Scanner(temp);
        String codeKey = file.nextLine();

        encoded(codeKey);
        for(int i=0;i<5;i++){
            String codeMessage = file.nextLine();
            decode(codeMessage);
        }

        file.close();
	}

    public static void encoded(String code){
        for(int i=0;i<code.length();i++){
            switch(code.charAt(i)){
                case 'A': codedNumbers.add(1); break;
                case 'B': codedNumbers.add(2); break;
                case 'C': codedNumbers.add(3); break;
                case 'D': codedNumbers.add(4); break;
                case 'E': codedNumbers.add(5); break;
                case 'F': codedNumbers.add(6); break;
                case 'G': codedNumbers.add(7); break;
                case 'H': codedNumbers.add(8); break;
                case 'I': codedNumbers.add(9); break;
                case 'J': codedNumbers.add(10); break;
                case 'K': codedNumbers.add(11); break;
                case 'L': codedNumbers.add(12); break;
                case 'M': codedNumbers.add(13); break;
                case 'N': codedNumbers.add(14); break;
                case 'O': codedNumbers.add(15); break;
                case 'P': codedNumbers.add(16); break;
                case 'Q': codedNumbers.add(17); break;
                case 'R': codedNumbers.add(18); break;
                case 'S': codedNumbers.add(19); break;
                case 'T': codedNumbers.add(20); break;
                case 'U': codedNumbers.add(21); break;
                case 'V': codedNumbers.add(22); break;
                case 'W': codedNumbers.add(23); break;
                case 'X': codedNumbers.add(24); break;
                case 'Y': codedNumbers.add(25); break;
                case 'Z': codedNumbers.add(26); break;
            }
        }
    }

	//Decodes an encrypted string
    public static void decode(String encrypted){
        String tempEncrypted = encrypted;
        String finalEncrypted = encrypted;

        for(int i=encrypted.length()-1;i>-1;i--) //Loops through each digit backwards
		{
            tempEncrypted = finalEncrypted; //creates a backup of the encrypted message

			//Gets corresponding code for each digit
            int corrCode = codedNumbers.get(i % codedNumbers.size());

			//The position of the character that will be switched
            int secondCharSwitch = (corrCode + i) % encrypted.length();

			//Switches the second character (i=position of original character)
            finalEncrypted = tempEncrypted.substring(0,secondCharSwitch)+
            tempEncrypted.substring(i,i+1)+
            tempEncrypted.substring(secondCharSwitch+1, tempEncrypted.length());

			//Switches the first character
            finalEncrypted = finalEncrypted.substring(0,i)+
            tempEncrypted.substring(secondCharSwitch,secondCharSwitch+1)+
            finalEncrypted.substring(i+1, finalEncrypted.length());
        }
        System.out.println(finalEncrypted);
    }

	//Not needed, identical to decode() but iterates i++ instead of i--
    public static void encode(String encrypted){
        String tempEncrypted = encrypted;
        String finalEncrypted = encrypted;
        for(int i=0;i<encrypted.length();i++){
            tempEncrypted = finalEncrypted;
            int corrCode = codedNumbers.get(i % codedNumbers.size());
            int secondCharSwitch = (corrCode + i) % encrypted.length();
            finalEncrypted = tempEncrypted.substring(0,secondCharSwitch)+
            tempEncrypted.substring(i,i+1)+
            tempEncrypted.substring(secondCharSwitch+1, tempEncrypted.length());
            finalEncrypted = finalEncrypted.substring(0,i)+
            tempEncrypted.substring(secondCharSwitch,secondCharSwitch+1)+
            finalEncrypted.substring(i+1, finalEncrypted.length());
        }
        System.out.println(finalEncrypted);
    }
}
