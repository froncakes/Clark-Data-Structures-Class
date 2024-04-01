public class Patient {
    private int ID;
    private int age;
    private BloodData bloodInfo;
    // default constructor sets ID and age to 0, and BloodData to the default constructor of O+
    public Patient(){
        ID = 0;
        age = 0;
        bloodInfo = new BloodData();
    }
    // constructor with all values
    public Patient(int ID, int age, BloodData bloodInfo){
        this.ID = ID;
        this.age = age;
        this.bloodInfo = bloodInfo;
    }
    // setters and getters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BloodData getBloodInfo() {
        return bloodInfo;
    }

    public void setBloodInfo(BloodData bloodInfo) {
        this.bloodInfo = bloodInfo;
    }

    @Override
    public String toString() {
        return "Patient" +
                " ID Number: " + ID +
                ", Age: " + age +
                ", Blood Type: " + bloodInfo.toString();
    }
}
