package utility;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import adt.ArrayList;
import adt.ListInterface;
import dao.DoctorDAO;
import entity.Doctor;

public class doctorUtility {
    public static int checkInt(Scanner scanner, int min, int max) {
        int input = 0;
        boolean valid = false;

        do {
            System.out.print(": ");
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.print("Input cannot be empty. Please enter a number between " + min + "-" + max);
                continue;
            }

            try {
                input = Integer.parseInt(line);
                if (input < min || input > max) {
                    System.out.print("Invalid choice. Please enter a number between " + min + "-" + max);
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid choice. Please enter a number between " + min + "-" + max);
            }
        } while (!valid);

        return input;
}

    public static String checkString(Scanner stringScanner){
        String input;
        System.out.print(": ");
    
        do {
            input = stringScanner.nextLine();
            if (input.isEmpty()){
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());

        return input;
    }

    public static void clear(){
        for (int i = 0; i < 3; i++) {
            System.out.print("\n");
        }
    }

    public static void pressAnyKeyToContinue(Scanner continueScanner) {
        System.out.println("\nPress Enter to go back...");
        continueScanner.nextLine();
    }

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    public static boolean isValidPhoneNo(String phone) {
        if (phone == null) {
            return false;
        }
        String regex = "^(\\+?60|0)[1-9]\\d{1,2}[- ]?\\d{6,7}$";
        return phone.matches(regex);
    }

    public static void addDoctorFunction(Scanner addScanner) {
        String doctorName;
        String doctorSpecialist;
        String doctorEmail;
        String doctorPassword;
        String doctorPhoneNo;

        ListInterface<Doctor> doctors = Doctor.getDoctors();

        System.out.print("Name");
        doctorName = doctorUtility.checkString(addScanner);

        System.out.print("Specialist");
        doctorSpecialist = doctorUtility.checkString(addScanner);

        do {
            System.out.print("Email");
            doctorEmail = doctorUtility.checkString(addScanner);
            if (!doctorUtility.isValidEmail(doctorEmail)) {
                System.out.println("Invalid email format. Please enter again.");
            }
        } while (!doctorUtility.isValidEmail(doctorEmail));

        System.out.print("Password");
        doctorPassword = doctorUtility.checkString(addScanner);
        
        do {
            System.out.print("Phone No.");
            doctorPhoneNo = doctorUtility.checkString(addScanner);
            if (!doctorUtility.isValidPhoneNo(doctorPhoneNo)){
                System.out.println("Invalid phone no. format. Please enter again.");
            }
        } while (!doctorUtility.isValidPhoneNo(doctorPhoneNo));

        Doctor newDoctor = new Doctor(doctorName, doctorSpecialist, doctorEmail, doctorPassword, doctorPhoneNo);
        doctors.add(newDoctor);
        DoctorDAO.saveDoctorToFile("doctor.txt", newDoctor);

        System.out.println("New Doctor Added Successfully!");
        clear();
    }
}
