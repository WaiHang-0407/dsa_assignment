package dao;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import adt.ListInterface;
import entity.Doctor;

public class DoctorDAO {
    public static void saveDoctorToFile(String filename){
        try (BufferedWriter doctorWriter = new BufferedWriter(new FileWriter(filename, true))){
            ListInterface<Doctor> doctor = Doctor.getDoctors();
            for (int i = 0; i < doctor.size(); i++){
                Doctor d = doctor.get(i);
                String line = d.getDoctorID() + "," + d.getName() + "," + d.getSpecialist() + "," + d.getEmail() + "," + d.getPassword() + "," + d.getPhoneNo();
                doctorWriter.write(line);
                doctorWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error file: " + e.getMessage());
        }
    }

    public static void initializeIdCounterFromFile(String filename) {
        int maxID = 1000; // starting value
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].startsWith("D")) {
                    try {
                        int num = Integer.parseInt(parts[0].substring(1));
                        if (num > maxID) {
                            maxID = num;
                        }
                    } catch (NumberFormatException ignored) {}
                }
            }
        } catch (IOException e) {
            // file might not exist yet, so ignore
        }
        
    }
}
