import java.io.*;
import java.util.Scanner;

public class Problem1 {
    public static void main(String [] args) throws IOException{
        File temp = new File("DATA11.txt");
        Scanner file = new Scanner(temp);

        //I was lazy and just copied and pasted it. Please use an actual for loop.
        String text1 = file.nextLine();
        String text2 = file.nextLine();
        String text3 = file.nextLine();
        String text4 = file.nextLine();
        String text5 = file.nextLine();

        printWord(text1);
        Scanner reader = new Scanner(System.in);

        System.out.println("Type '0' to continue");
        int n = reader.nextInt();
        printWord(text2);

        System.out.println("Type '0' to continue");
        n = reader.nextInt();
        printWord(text3);

        System.out.println("Type '0' to continue");
        n = reader.nextInt();
        printWord(text4);

        System.out.println("Type '0' to continue");
        n = reader.nextInt();
        printWord(text5);

        file.close();
    }

    public static void printWord(String text){
        System.out.println('*'+text+'*'); //First Line

        for(int i=0;i<text.length();i++) //Number of columns
		{
            System.out.print(text.charAt(text.length()-i-1)); //First Letter
            for(int j=0;j<text.length();j++){
                System.out.print('*'); //Prints the buffers
            }
            System.out.print(text.charAt(i)); //Last Letter
            System.out.println(); //Makes New Line
        }
        System.out.println('*'+text+'*'); //Last Line
    }
}
