import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean badInput = true;
        char choice = ' ';
        Scanner inputText = new Scanner(System.in);
        ReadFile read = new ReadFile();

        // Reading from file
        System.out.print("Enter file name:");

        if (read.tryRead(inputText.next()) == 1){
            System.out.println("File was read...");
        }else{
            System.exit(100);
        }

        // Choices from menu with try/catch
        while (badInput) {
            try {
                System.out.println("Make a choice:");
                System.out.println("h - Customers with Voice");
                System.out.println("i - Customers with Internet");
                System.out.println("f - Customers without money");
                System.out.println("m - SMS campaign");
                choice = inputText.next().charAt(0);
                if (choice == 'h' || choice == 'i' || choice == 'f' || choice == 'm'){
                    badInput = false;
                    System.out.println();
                    System.out.format("%-18s\t| %-18s\t| %-18s\t%n","NAME","NUMBER","BALANCE");
                    System.out.println("======================================================");
                    read.printPerson(choice);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Allowed are h - i - f - m - x");
                inputText.next();
            }
        }
    }
}
