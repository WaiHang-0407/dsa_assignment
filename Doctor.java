public class Doctor implements AbstractFunction {
    private String doctorID;
    private String name;
    private String specialist;
    private String email;
    private String password;
    private int phoneNo;
    private static int idCount = 1001;

    public Doctor(String name, String specialist, String email, String password, int phoneNo) {
        this.doctorID = "D" + idCount++;
        this.name = name;
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

    public void setPhoneNo(int phoneNo){
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

    public int getPhoneNo(){
        return this.phoneNo;
    }

    public static void defaultDoctor(){
        Doctor doctor1 = new Doctor("WaiHang", "Cardiologist", "waihang@gmail.com", "waihang123", 987654321);
        Doctor doctor2 = new Doctor("Dek", "Oncologist", "dek@gmail.com", "dek123", 123456789);
        Doctor doctor3 = new Doctor("Wheylong", "Dermatologist", "wheylong@gmail.com", "wheylong123", 912345678);
    }

    public void saveToArray(){
        
    }
}
