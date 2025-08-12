package entity;

import adt.ArrayList;
import adt.ListInterface;

public class Doctor {
    private String doctorID;
    private String name;
    private String specialist;
    private String email;
    private String password;
    private String phoneNo;
    private static int idCount = 1001;

    private static ListInterface<Doctor> doctors = new ArrayList<>();

    public Doctor(String name, String specialist, String email, String password, String phoneNo) {
        this.doctorID = "D" + idCount++;
        this.name = name;
        this.specialist = specialist;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
    }

    public void setDoctorID(String doctorID){
        this.doctorID = doctorID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSpecialist(String specialist){
        this.specialist = specialist;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }

    public String getDoctorID(){
        return this.doctorID;
    }

    public String getName(){
        return this.name;
    }

    public String getSpecialist(){
        return this.specialist;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public String getPhoneNo(){
        return this.phoneNo;
    }

    public static ListInterface<Doctor> getDoctors() {
        return doctors;
    }

    public static void setIDCounter(int value){
        idCount = value;
    }
}
