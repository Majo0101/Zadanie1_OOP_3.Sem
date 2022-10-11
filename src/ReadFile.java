import java.io.*;
import java.util.Scanner;

public class ReadFile {

    private int countLines;
    private Person[] person;

    // Read file twice - Function -  1. Count all rows for dynamic array , 2. Read the data line by line
    public int tryRead(String name){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(name));
            while (reader.readLine() != null) countLines++;
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return 2;
        } catch (IOException e) {
            System.out.println("Error");
            return 2;
        }

        person = new Person[countLines];
        countLines = 0;

        try {
            File myReader = new File(name);
            Scanner myScanner = new Scanner(myReader);

            while (myScanner.hasNextLine()) {
                lineToPerson(myScanner.nextLine(), countLines++);
            }
            myScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return 2;
        }
        return 1;
    }


    // Function - Line data parse to the values for Person objects in the Person array
    private void lineToPerson(String lineData, int lineNumber){

        String name = "";
        String number = "";
        String balance = "";
        boolean callService = false;
        boolean internetService = false;
        boolean payMethod = false;
        int counter = 0;

        person[lineNumber] = new Person();

        for (int i = 0; i < lineData.length(); i++){

            if (lineData.charAt(i) == ','){
                counter++;
                continue;
            }

            switch (counter){
                case 0:
                    name += lineData.charAt(i);
                    break;

                case 1:
                    number += lineData.charAt(i);
                    break;

                case 2:
                    if (lineData.charAt(i) == 'h' || lineData.charAt(i) == 'H')callService = true;
                    // Jump to the end - first character is important
                    while (lineData.charAt(i + 1) != ',') i++;
                    break;

                case 3:
                    if (lineData.charAt(i) == 'i' || lineData.charAt(i) == 'I')internetService = true;
                    while (lineData.charAt(i + 1) != ',') i++;
                    break;

                case 4:
                    if (lineData.charAt(i) == 'p' || lineData.charAt(i) == 'P') payMethod = true;
                    while (lineData.charAt(i + 1) != ',') i++;
                    break;

                case 5:
                    balance += lineData.charAt(i);
                    break;
            }
        }

        person[lineNumber].setName(name);
        person[lineNumber].setNumber(number);
        person[lineNumber].setService(callService, internetService);
        person[lineNumber].setPayment(payMethod);
        person[lineNumber].setBalance(Integer.parseInt(balance));
    }


    // Tunnel from main to the Person objects - one by one
    public void printPerson(char c){

        for (Person value : person) {
            value.printIf(c);
        }
    }
}
