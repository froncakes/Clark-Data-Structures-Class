/*
 * Frankie Nolan
 * 4/1/2024
 * Blood Group Individual
 * Added donor information and receiver information to the Blood Data
 */
import java.util.Scanner;
public class TestPatient {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Patient A
        Patient a = new Patient();
        System.out.println(a.toString());

        // Patient B
        System.out.println("What is the patients ID number?");
        int id = s.nextInt();
        System.out.println("What is the patients age?");
        int age = s.nextInt();
        System.out.println("What is the patients blood type? (O, A, B, or AB)");
        // User inputs a String and then that is turned into a BloodType, default BloodType of O
        BloodType bloodType = BloodType.O;
        String type = s.next();
        if (type.equals("O")) {
            bloodType = BloodType.O;
        } else if (type.equals("A")) {
            bloodType = BloodType.A;
        } else if (type.equals("B")) {
            bloodType = BloodType.B;
        } else if (type.equals("AB")) {
            bloodType = BloodType.AB;
        }else{
            System.out.println("invalid blood type");
        }
        System.out.println("Is the patients blood type positive or negative? (put in either + or -)");
        String rhFactor = s.next();
        Patient b = new Patient(id, age, new BloodData(bloodType, rhFactor));
        System.out.println(b.toString());

        // Patient C
        System.out.println("What is the patients ID number?");
        id = s.nextInt();
        System.out.println("What is the patients age?");
        age = s.nextInt();
        Patient c = new Patient(id, age, new BloodData());
        System.out.println(c.toString());
    }
}
