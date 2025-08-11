package dao;

import java.io.BufferedWriter;
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
}
