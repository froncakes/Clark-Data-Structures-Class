import java.util.Scanner;
public class BadSubscriptCaught {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] names = {"Luke", "James", "Anna", "Cole", "Peter", "Daniel", "Corey", "Nancy", "Tim", "George"};
        try{
            System.out.println(names[s.nextInt()-1]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("out of scope of names[] "+e);
        }
    }
}