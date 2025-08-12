package dao;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import adt.ListInterface;
import entity.Doctor;

public class DoctorDAO {
    public static void saveDoctorToFile(String filename, Doctor newDoctor){
        try (BufferedWriter doctorWriter = new BufferedWriter(new FileWriter(filename, true))){
            String line = newDoctor.getDoctorID() + "," + newDoctor.getName() + "," + newDoctor.getSpecialist() + "," + newDoctor.getEmail() + "," + newDoctor.getPassword() + "," + newDoctor.getPhoneNo();
            doctorWriter.write(line);
            doctorWriter.newLine();
        } catch (IOException e) {
            System.err.println("Error file: " + e.getMessage());
        }
    }

    public static void readDoctorFile(String filename){
        ListInterface<Doctor> doctors = Doctor.getDoctors();
        int maxID = 0;
        
        try(BufferedReader doctorReader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = doctorReader.readLine()) != null){
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String doctorID = parts[0];
                    String doctorName = parts[1];
                    String doctorSpecialist = parts[2];
                    String doctorEmail = parts[3];
                    String doctorPassword = parts[4];
                    String doctorPhoneNo = parts[5];

                    Doctor doctor = new Doctor(doctorName, doctorSpecialist, doctorEmail, doctorPassword, doctorPhoneNo);
                    doctors.add(doctor);

                    try {
                        int num = Integer.parseInt(doctorID.substring(1)); // e.g., D1001 → 1001
                        if (num > maxID) {
                            maxID = num;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid doctor ID format in file: " + doctorID);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading doctor file: " + e.getMessage());
        }
    }

    public static void initializeIDCounterFromFile(String filename) {
        int maxID = 1000;
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
            System.out.println("Error reading file: " + e.getMessage());
        }
        Doctor.setIDCounter(maxID + 1);
    }
}
