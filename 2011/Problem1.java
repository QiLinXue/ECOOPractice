import java.io.*;
import java.util.Scanner;

public class Problem1 {
    public static void main(String [] args) throws IOException{
        File temp = new File("DATA11.txt");
        Scanner file = new Scanner(temp);

        String text1 = file.nextLine();
        String text2 = file.nextLine();
        String text3 = file.nextLine();
        String text4 = file.nextLine();
        String text5 = file.nextLine();

        printWord(text1);
        Scanner reader = new Scanner(System.in);
        System.out.println("Next?");
        int n = reader.nextInt();
        printWord(text2);
        System.out.println("Next?");
        n = reader.nextInt();
        printWord(text3);
        System.out.println("Next?");
        n = reader.nextInt();
        printWord(text4);
        System.out.println("Next?");
        n = reader.nextInt();
        printWord(text5);
        reader.close();




    }

    public static void printWord(String text){
        System.out.println('*'+text+'*');
        for(int i=0;i<text.length();i++){
            System.out.print(text.charAt(text.length()-i-1));
            for(int j=0;j<text.length();j++){
                System.out.print('*');
            }
            System.out.print(text.charAt(i));
            System.out.println();
        }
        System.out.println('*'+text+'*');
    }
}
