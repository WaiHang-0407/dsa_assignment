package boundary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import adt.ArrayList;
import adt.ListInterface;

public class doctorBoundary {
    public static void doctorMainBanner(){
        System.out.println("=================================");
        System.out.println("        Doctor Main Page");
        System.out.println("=================================");
        System.out.println("[1] Profile");
        System.out.println("[2] Schedule");
        System.out.println("[3] Availability");
        System.out.println("[0] Back");
    }

    public static void doctorProfileBanner() {
        System.out.println("=================================");
        System.out.println("        Doctor Profile");
        System.out.println("=================================");
        System.out.println("[1] View Doctor");
        System.out.println("[2] Edit Doctor Profile");
        System.out.println("[3] Add Doctor");
        System.out.println("[4] Remove Doctor");
        System.out.println("[0] Back");
    }

    public static void displayDoctor(){
        try (BufferedReader doctorReader = new BufferedReader(new FileReader("doctor.txt"))) {
            String line;

            int idWidth = "Doctor ID".length();
            int nameWidth = "Name".length();
            int specialistWidth = "Specialist".length();
            int emailWidth = "Email".length();
            int passwordWidth = "Password".length();
            int phoneNoWidth = "Phone No".length();

            ListInterface<String[]> rows = new ArrayList<>();
            while ((line = doctorReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    rows.add(parts);

                    if (parts[0].length() > idWidth) idWidth = parts[0].length();
                    if (parts[1].length() > nameWidth) nameWidth = parts[1].length();
                    if (parts[2].length() > specialistWidth) specialistWidth = parts[2].length();
                    if (parts[3].length() > emailWidth) emailWidth = parts[3].length();
                    if (parts[4].length() > passwordWidth) passwordWidth = parts[4].length();
                    if (parts[5].length() > phoneNoWidth) phoneNoWidth = parts[5].length();
                }
            }

            String format = "| %-" + idWidth + "s | %-" + nameWidth + "s | %-" + specialistWidth + "s | %-" +
                    emailWidth + "s | %-" + passwordWidth + "s | %-" + phoneNoWidth + "s |\n";

            System.out.printf(format, "Doctor ID", "Name", "Specialist", "Email", "Password", "Phone No");

            int totalWidth = idWidth + nameWidth + specialistWidth + emailWidth + passwordWidth + phoneNoWidth + 19;
            System.out.println("-".repeat(totalWidth));

            for (String[] parts : rows) {
                System.out.printf(format, parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void addDoctorBanner() {
        System.out.println("=================================");
        System.out.println("        Add Doctor");
        System.out.println("=================================");
    }

    
}
