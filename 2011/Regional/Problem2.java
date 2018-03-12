import java.io.*;
import java.util.Scanner;

public class Problem2 {
    public static void main(String [] args) throws IOException{
        File temp = new File("DATA21.txt");
        Scanner file = new Scanner(temp);

        for(int i=0;i<5;i++){
            String text1a = file.nextLine();
            String text1b = file.nextLine();
            String text1c = file.nextLine();

            //System.out.println(letterFromSum(101));
            createSum(text1a,text1b,text1c);
            System.out.println();
        }
        reader.close();

    }

    public static void createSum(String line1, String line2, String line3){
        int sum=0;
        for(int i=0;i<line1.length();i+=2){
            sum = 0;
            if(line1.charAt(i) == 'x') sum+=1;
            if(line1.charAt(i+1) == 'x') sum+=10;
            if(line2.charAt(i) == 'x') sum+=100;
            if(line2.charAt(i+1) == 'x') sum+=1000;
            if(line3.charAt(i) == 'x') sum+=10000;
            if(line3.charAt(i+1) == 'x') sum+=100000;
            System.out.print(letterFromSum(sum));
            //System.out.print(line1.charAt(i));
        }
    }

    public static char letterFromSum(int sum){
        char letter = '*';
        switch(sum){
            case 0: letter = ' '; break;
            case 1: letter = 'a'; break;
            case 101: letter = 'b'; break;
            case 11: letter = 'c'; break;
            case 1011: letter = 'd'; break;
            case 1001: letter = 'e'; break;
            case 111: letter = 'f'; break;
            case 1111: letter = 'g'; break;
            case 1101: letter = 'h'; break;
            case 110: letter = 'i'; break;
            case 1110: letter = 'j'; break;
            case 10001: letter = 'k'; break;
            case 10101: letter = 'l'; break;
            case 10011: letter = 'm'; break;
            case 11011: letter = 'n'; break;
            case 11001: letter = 'o'; break;
            case 10111: letter = 'p'; break;
            case 11111: letter = 'q'; break;
            case 11101: letter = 'r'; break;
            case 10110: letter = 's'; break;
            case 11110: letter = 't'; break;
            case 110001: letter = 'u'; break;
            case 110101: letter = 'v'; break;
            case 101110: letter = 'w'; break;
            case 110011: letter = 'x'; break;
            case 111011: letter = 'y'; break;
            case 111001: letter = 'z'; break;
        }
        return letter;
    }
}
