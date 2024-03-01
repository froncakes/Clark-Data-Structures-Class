/* Wedding Classes for CSCI 121
 * Frankie Nolan
 * 2/29/2024
 *
 * added a way to look at all the different details of the Wedding class aswell as a way to add guests to the Wedding
 * added constructors to Person and Couple aswell.
 */

import java.time.LocalDate;
import java.util.Scanner;
public class TestWedding {
    static Wedding ceremony;
    public static void main(String[] args) {
        // scanning all the information needed to make the wedding class
        Scanner s = new Scanner(System.in);
        System.out.println("What is the bride's full name?");
        Person bride = getName();
        System.out.println("What is the groom's full name?");
        Person groom = getName();
        System.out.println("What year is the wedding in?");
        int y = s.nextInt();
        System.out.println("What month of the year is the wedding in? 1-12");
        int m = s.nextInt();
        System.out.println("what day of the month is the wedding in?");
        int d = s.nextInt();
        LocalDate day = LocalDate.of(y,m,d);
        System.out.println("where is the wedding taking place?");
        String location = s.next();
        Couple couple = new Couple(bride,groom);
        ceremony = new Wedding(couple, day, location);
        // Allows the user to use any methods such as adding guests, getting guests, and the gets for all properties of the wedding.
        displayDetails();

    }
    private static void displayDetails(){
        Scanner s = new Scanner(System.in);
        System.out.println("What would you like to do? 1 to add guests, 2 to get the name of a guest via number, 3 to get bride's name");
        System.out.println("4 to get groom's name, 5 to get the location, 6 to get Wedding Date, 7 to exit");
        int n = s.nextInt();
        if (n==1){
            System.out.println("Write the full name of the guest you'd like to add");
            ceremony.addGuests(getName());
        }
        else if (n==2){
            System.out.println("Input the number of the guest you'd like to see");
            System.out.println(ceremony.getGuest(s.nextInt()));
        }
        else if (n==3){
            System.out.println(ceremony.getBrideName());
        }
        else if (n==4){
            System.out.println(ceremony.getGroomName());
        }
        else if (n==5){
            System.out.println(ceremony.getLocation());
        }
        else if (n==6){
            System.out.println(ceremony.getWeddingDate().toString());
        }
        if (n>0 && n<7){
            displayDetails();
        }
    }
    // getName() scans the next line and splits the name up by two by detecting a space in between, and makes a person
    // and then returns that person.
    private static Person getName(){
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        String[] a = name.split(" ", 2);
        return new Person(a[0],a[1]);
    }
}
