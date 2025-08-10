package boundary;

import adt.ArrayList;
import adt.ListInterface;
import entity.Doctor;

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

    public static void displayDoctor(){
        int idWidth = " ID".length();
        int nameWidth = "Name".length();
        int specialistWidth = "Specialist".length();
        int emailWidth = "Email".length();
        int passwordWidth = "Password".length();
        int phoneNoWidth = "Phone No.".length();

        Doctor doctor1 = new Doctor("WaiHang", "Cardiologist", "waihang@gmail.com", "waihang123", 987654321);
        Doctor doctor2 = new Doctor("Dek", "Oncologist", "dek@gmail.com", "dek123", 123456789);
        Doctor doctor3 = new Doctor("Wheylong", "Dermatologist", "wheylong@gmail.com", "wheylong123", 912345678);

        ListInterface<Doctor> doctors = new ArrayList<>();

        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);

        for (int i = 0; i < doctors.size(); i++){
            Doctor d = doctors.get(i);
            if (d.getDoctorID().length() > idWidth){
                idWidth = d.getDoctorID().length();
            }

            if (d.getName().length() > nameWidth){
                nameWidth = d.getName().length();
            }

            if (d.getSpecialist() != null && d.getSpecialist().length() > specialistWidth){
                specialistWidth = d.getSpecialist().length();
            }

            if (d.getEmail().length() > emailWidth){
                emailWidth = d.getEmail().length();
            }

            if (d.getPassword().length() > passwordWidth){
                passwordWidth = d.getPassword().length();
            }

            String phoneNoString = String.valueOf(d.getPhoneNo());
            if (phoneNoString.length() > phoneNoWidth){
                phoneNoWidth = phoneNoString.length();
            }
        }
        
        String format = "| %-" + (idWidth + 7) + "s| %-" + (nameWidth + 7) + "s| %-" + (specialistWidth + 7) + "s| %-" + (emailWidth + 7) + "s| %-" +  (passwordWidth + 7) + "s| %-" + (phoneNoWidth + 7) + "s|\n";

        for (int i = 0; i < idWidth + nameWidth + specialistWidth + emailWidth + passwordWidth + phoneNoWidth + 55; i++){
            System.out.print("-");
        }

        System.out.println("");

        System.out.printf(format, "Doctor ID", "Name", "Specialist", "Email", "Password", "Phone No.");
        for (int i = 0; i < idWidth + nameWidth + specialistWidth + emailWidth + passwordWidth + phoneNoWidth + 55; i++){
            System.out.print("-");
        }
        System.out.println("");

        for (int i = 0; i < doctors.size(); i++){
            Doctor d = doctors.get(i);
            System.out.printf(format, d.getDoctorID(), d.getName(), d.getSpecialist(), d.getEmail(), d.getPassword(), d.getPhoneNo());
            System.out.println("");
        }
    }
}
