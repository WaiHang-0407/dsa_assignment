package control;
import java.util.Scanner;

import utility.doctorUtility;
import boundary.doctorBoundary;

public class Main {
    public static void doctorMain(Scanner doctorScanner){
        int doctorChoice;

        doctorBoundary.doctorMainBanner();
        System.out.print("Choice");
        doctorChoice = doctorUtility.checkInt(doctorScanner, 1, 3);

        switch (doctorChoice) {
            case 1:
                doctorProfile();
                break;
            case 2:
                schedule();
            case 3:
                availability();
            case 4:
                return;
            default:
                break;
        }
    }

    public static void doctorProfile(){
        doctorBoundary.displayDoctor();
    }

    public static void schedule(){

    }

    public static void availability(){

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        doctorMain(scanner);
    }
}
