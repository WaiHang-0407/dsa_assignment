import java.util.Scanner;

public class Main implements AbstractFunction{
    public void saveToArray(){

    }

    public static void doctorMain(Scanner doctorScanner){
        int doctorChoice;

        System.out.println("[1] Profile");
        System.out.println("[2] Schedule");
        System.out.println("[3] Availability");
        System.out.println("[0] Back");

        System.out.print("Choice");
        doctorChoice = Utility.checkInt(doctorScanner, 1, 3);

        switch (doctorChoice) {
            case 1:
                doctorProfile();
                break;
            case 2:
                schedule();
            case 3:
                availability();
            default:
                break;
        }
    }

    public static void doctorProfile(){

    }

    public static void schedule(){

    }

    public static void availability(){

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        defaultDoctor();
        doctorMain(scanner);
    }
}
