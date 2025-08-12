package control;
import java.util.Scanner;

import utility.doctorUtility;
import boundary.doctorBoundary;
import dao.DoctorDAO;

public class Main {
    public static void doctorMain(Scanner doctorScanner){
        int doctorChoice;

        doctorBoundary.doctorMainBanner();
        System.out.print("Choice");
        doctorChoice = doctorUtility.checkInt(doctorScanner, 0, 3);
        doctorUtility.clear();

        switch (doctorChoice) {
            case 0:
                return;
            case 1:
                doctorProfile(doctorScanner);
                break;
            case 2:
                schedule();
                break;
            case 3:
                availability();
        }
    }

    public static void doctorProfile(Scanner profileScanner){
        int profileChoice;

        doctorBoundary.doctorProfileBanner();

        System.out.print("Choice");
        profileChoice = doctorUtility.checkInt(profileScanner, 0, 4);
        doctorUtility.clear();

        switch (profileChoice){
            case 0:
                doctorMain(profileScanner);
                break;
            case 1:
                viewDoctor(profileScanner);
                break;
            case 2:
                editProfile(profileScanner);
                break;
            case 3:
                addDoctor(profileScanner);
                break;
            case 4:
                removeDoctor(profileScanner);
                break;
        }
    }

    public static void viewDoctor(Scanner viewScanner){
        doctorBoundary.displayDoctor();
        doctorUtility.pressAnyKeyToContinue(viewScanner);
        doctorUtility.clear();
        doctorProfile(viewScanner);
    }

    public static void editProfile(Scanner editScanner){

    }

    public static void addDoctor(Scanner addScanner){
        doctorBoundary.addDoctorBanner();
        doctorUtility.addDoctorFunction(addScanner);
        doctorMain(addScanner);

    }

    public static void removeDoctor(Scanner removeScanner){

    }

    public static void schedule(){

    }

    public static void availability(){

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        DoctorDAO.readDoctorFile("doctor.txt");

        DoctorDAO.initializeIDCounterFromFile("doctor.txt");
        
        doctorMain(scanner);
    }
}
