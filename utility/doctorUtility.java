package utility;
import java.util.Scanner;
import java.util.regex.Pattern;

import adt.ListInterface;
import dao.DoctorDAO;
import entity.Doctor;
import boundary.doctorBoundary;

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
        doctorName = checkString(addScanner);

        System.out.print("Specialist");
        doctorSpecialist = checkString(addScanner);

        do {
            System.out.print("Email");
            doctorEmail = checkString(addScanner);
            if (!doctorUtility.isValidEmail(doctorEmail)) {
                System.out.println("Invalid email format. Please enter again.");
            }
        } while (!doctorUtility.isValidEmail(doctorEmail));

        System.out.print("Password");
        doctorPassword = checkString(addScanner);
        
        do {
            System.out.print("Phone No.");
            doctorPhoneNo = checkString(addScanner);
            if (!doctorUtility.isValidPhoneNo(doctorPhoneNo)){
                System.out.println("Invalid phone no. format. Please enter again.");
            }
        } while (!doctorUtility.isValidPhoneNo(doctorPhoneNo));

        DoctorDAO.initializeIDCounterFromFile("doctor.txt");
        Doctor newDoctor = new Doctor(doctorName, doctorSpecialist, doctorEmail, doctorPassword, doctorPhoneNo);
        doctors.add(newDoctor);
        DoctorDAO.saveDoctorToFile("doctor.txt", newDoctor);

        System.out.println("New Doctor Added Successfully!");
        clear();
    }

    public static void removeDoctorFunction(Scanner removeScanner){
        String doctorID;
        boolean removed = false;
        ListInterface<Doctor> doctors = Doctor.getDoctors();

        if (doctors.isEmpty()){
            System.out.println("Doctor is Empty.");
            clear();
            return;
        }

        do {
            System.out.print("Enter doctor ID");
            doctorID = doctorUtility.checkString(removeScanner);
            doctorID = doctorID.toUpperCase().trim();
            
            removed = false;

            for (int i = 0; i < doctors.size(); i++){
                Doctor d = doctors.get(i);

                if (d != null && d.getDoctorID().toUpperCase().trim().equals(doctorID)){
                    d.setDoctorID("");
                    d.setName("");
                    d.setSpecialist("");
                    d.setEmail("");
                    d.setPassword("");
                    d.setPhoneNo("");
                    DoctorDAO.saveDoctorToFile("doctor.txt");
                    System.out.println("Doctor " + doctorID + " removed successfully!");
                    removed = true;
                    break;
                }
            }

            if (removed == false){
                System.out.println("Doctor " + doctorID + " not found.");
            }
            else {
                clear();
                break;
            }
        } while (true);
    }

    public static void editDoctorFunction(Scanner editScanner){
        int editChoice;
        String id;

        ListInterface<Doctor> doctors = Doctor.getDoctors();

        do {
            System.out.print("Select Doctor ID");
            id = checkString(editScanner).toUpperCase().trim();

            boolean found = false;

            for (int i = 0; i < doctors.size(); i++){
                Doctor d = doctors.get(i);

                // check empty not done
                if (d.getDoctorID().trim().equals("")){
                    System.out.println("Doctor " + id + " not found.");
                    return;
                }

                if (d != null && d.getDoctorID().toUpperCase().trim().equals(id)){
                    found = true;

                    doctorBoundary.editChoiceBanner();
                    System.out.print("Edit Choice");
                    editChoice = checkInt(editScanner, 0, 5);

                    switch (editChoice){
                        case 1:
                            d.setName(editName(editScanner));
                            break;
                        case 2:
                            d.setSpecialist(editSpecialist(editScanner));
                            break;
                        case 3:
                            d.setEmail(editEmail(editScanner));
                            break;
                        case 4:
                            d.setPassword(editPassword(editScanner));
                            break;
                        case 5:
                            d.setPhoneNo(editPhoneNo(editScanner));
                            break;
                    }
                    DoctorDAO.saveDoctorToFile("doctor.txt");
                    System.out.println("Doctor Information Updated.");
                    break;
                }
            }

            if (found == false){
                System.out.println("Doctor " + id + " not found.");
            }
            else {
                clear();
                break;
            }
        } while (true);
    }

    public static String editName(Scanner nameScanner){
        System.out.print("Enter new name");
        return checkString(nameScanner);
    }

    public static String editSpecialist(Scanner specialistScanner){
        System.out.print("Enter new specialist");
        return checkString(specialistScanner);
    }

    public static String editEmail(Scanner emailScanner){
        System.out.print("Enter new email");
        return checkString(emailScanner);
    }

    public static String editPassword(Scanner passwordScanner){
        System.out.print("Enter new password");
        return checkString(passwordScanner);
    }

    public static String editPhoneNo(Scanner phoneNoScanner){
        System.out.print("Enter new phone no.");
        return checkString(phoneNoScanner);
    }
}
