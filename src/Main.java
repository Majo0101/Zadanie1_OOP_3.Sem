import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean badInput = true;
        String choice = "";
        Scanner inputText = new Scanner(System.in);
        ReadFile read = new ReadFile();

        if (args.length == 0){
            System.out.println("Missing arguments: filename_choice");
            return;
        }

        if (read.tryRead(args[0]) == 1){
            System.out.println("File was read...");
        }else{
            System.exit(100);
        }

        // Choices from menu with try/catch
        if (args.length <= 1){
            System.out.println();
            System.out.println("Missing argument:");
            System.out.println("h - Customers with Voice");
            System.out.println("i - Customers with Internet");
            System.out.println("f - Customers without money");
            System.out.println("m - SMS campaign");

//            choice = inputText.next();
//            break here;

        }else{
            choice = args[1];

//            here:{ } Missing GOTO statement from C++ :D

            if (choice.equals("h") || choice.equals("i") || choice.equals("f") || choice.equals("m")){
                System.out.println();
                System.out.println("===========================================================");
                System.out.format("| %-18s\t| %-18s\t| %-8s|%n","NAME","NUMBER","BALANCE");
                System.out.println("===========================================================");
                read.printPerson(choice.charAt(0));
                System.out.println("===========================================================");
            }else{
                System.out.println("Bad choice");
            }
        }
    }
}
