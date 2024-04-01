// enum containing the blood types
enum BloodType {
    O, A, B, AB
}

public class BloodData {
    private BloodType bloodType;
    private String rhFactor;
    private String donorInfo;
    private String receiverInfo;
    // blood types are A, B, O, and AB. RH factors are + and -
    BloodData(BloodType bloodType, String rhFactor) {
        this.bloodType = bloodType;
        this.rhFactor = rhFactor;
        // sets the donor information based off the blood type and RH factor
        if (rhFactor == "-"){
            donorInfo = "AB+, AB-";
            if (bloodType != bloodType.AB){
                // A-
                if (bloodType == bloodType.A){
                    donorInfo += ", A+, A-";
                    receiverInfo = "O-, A-";
                }
                // B-
                if (bloodType == bloodType.B){
                    donorInfo += ", B+, B-";
                    receiverInfo = "O-, B-";
                }
                // O-
                if (bloodType == bloodType.O){
                    donorInfo += ", A+, A-, B+, B-, O+, O-";
                    receiverInfo = "O-";
                }
            }// AB-
            else{receiverInfo = "AB-, A-, B-, O-";}
        }else{
            donorInfo = "AB+";
            if (bloodType != bloodType.AB) {
                // A+
                if (bloodType == bloodType.A) {
                    donorInfo += ", A+";
                    receiverInfo = "O-, O+, A-, A+";
                }
                // B+
                if (bloodType == bloodType.B) {
                    donorInfo += ", B+";
                    receiverInfo = "O-, O+, B-, B+";
                }
                // O+
                if (bloodType == bloodType.O) {
                    donorInfo += ", A+, B+, O+";
                    receiverInfo = "O-, O+";
                }
            }//AB+
            else{receiverInfo = "AB-, AB+, A-, A+, B-, B+, O-, O+";}
        }
        // end
    }
    // default constructor sets to O and +
    BloodData() {
        this.bloodType = BloodType.O;
        this.rhFactor = "+";
        donorInfo = "AB+, A+, B+, O+";
        receiverInfo = "O+, O-";
    }
    // getters and setters for blood type and rh factor
    public BloodType getBloodType() {
        return bloodType;
    }
    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
    public String getRhFactor() {
        return rhFactor;
    }
    public void setRhFactor(String rhFactor) {
        this.rhFactor = rhFactor;
    }

    @Override
    public String toString() {
        return bloodType + rhFactor + " Donor Information: "+ donorInfo +", Receiver Information: "+receiverInfo;
    }
}