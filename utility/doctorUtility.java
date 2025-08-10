package utility;
import java.util.Scanner;

public class doctorUtility {
    public static int checkInt(Scanner intScanner, int min, int max){
        int input;
        System.out.print(": ");
        do {
            while (!intScanner.hasNextInt()){
                System.out.println("Invalid choice. Please enter a number between " + min + "-" + max + ": ");
                intScanner.next();
            }

            input = intScanner.nextInt();
            intScanner.nextLine();

            if (input < min || input > max){
                System.out.println("Invalid choice. Please enter a number between " + min + "-" + max + ": ");
            }
        } while (input < min || input > max);

        return input;
    }

    
}
