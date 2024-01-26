/*
Frankie Nolan
1/18/2024-1/25/2024
CSCI 121 Sec 02.

Money Convertor Class
Converts money formatted as a double "0.00" and converts it to coins and added pennies
Added the ability to exchange coins for different coins as well as go again so the program doesn't end and thus doesn't need to be reset
*/
import java.util.Scanner;
public class HW1MoneyConverter {
    static Scanner scan = new Scanner(System.in);
    static boolean quarterConvert = false;
    static boolean dimeConvert = false;
    static boolean nickelConvert = false;
    static boolean pennyConvert = false;
    static int quarters = 0;
    static int dimes = 0;
    static int nickels = 0;
    static int pennies = 0;
    public static void main(String[] args) {
        System.out.println("input a dollar amount like *N.NN* such as 3.75 and get the amount of coins it is back");
        CoinCalculation(scan.nextDouble());
    }
    public static void CoinCalculation(double MONEY){
        /* separate variables MONEY acts as a constant of the double given by the user,
        while money acts as a way to easily divide the money into quarters dimes nickels and pennies
         */
        int money = (int)(MONEY*100);
        if (quarterConvert == false) {
            quarters += money/25;
            money %= 25;
        }
        if (dimeConvert == false) {
            dimes += money/10;
            money %= 10;
        }
        if (nickelConvert == false) {
            nickels += money/5;
            money %= 5;
        }
        if (pennyConvert == false) {
            pennies += money;
        }
        System.out.print("Your balance of coins is ");
        // if statements in order to have them only appear if necessary
        if (quarters > 0) {
            System.out.print(quarters + " quarters ");
        }
        if (dimes > 0) {
            System.out.print(dimes + " dimes ");
        }
        if (nickels > 0 & !nickelConvert) {
            System.out.print(nickels + " nickels ");
        }
        if (pennies > 0 & !pennyConvert) {
            System.out.print(pennies + " pennies");
        }
        /*
        Exchanging for coins will call back to CoinCalculation() with the value of the coins that want to be exchanged.
        These coins will then be exchanged into other coins that make up the most optimal way of storing (higher value coins),
        without being able to store as the coin type originally stored.

        Ex. You put in Y to exchange coins prompt, you then type 1 for quarters, select 3 for the amount which is a value of $0.75
        that money will then be converted into 7 dimes and 1 nickel instead of quarters.
         */
        quarterConvert = false;
        dimeConvert = false;
        nickelConvert = false;
        pennyConvert = false;
        System.out.println();
        System.out.println("Would you like to exchange coins? type Y/N for Yes/No");
        if (scan.next().charAt(0) == 'Y') {
            System.out.println("What coin would u like to exchange? type 1 for quarters, 2 for dimes, 3 for nickels, or 4 for pennies");
            int tempCoin = scan.nextInt();
            if (tempCoin == 1){
                System.out.println("how many quarters? you have " + quarters + " quarters");
                int i = scan.nextInt();
                if (i <= quarters) {
                    quarters -= i;
                    quarterConvert = true;
                    CoinCalculation(.25 * i);
                }
            } else if (tempCoin == 2) {
                System.out.println("how many dimes? you have " + dimes + " dimes");
                int i = scan.nextInt();
                if (i <= dimes) {
                    dimes -= i;
                    dimeConvert = true;
                    CoinCalculation(.10 * i);
                }
            } else if (tempCoin == 3) {
                System.out.println("how many nickels? you have " + nickels + " nickles");
                int i = scan.nextInt();
                if (i <= nickels) {
                    nickels -= i;
                    nickelConvert = true;
                    CoinCalculation(.05 * i);
                }
            } else if (tempCoin == 4) {
                System.out.println("how many pennies? you have " + pennies + " pennies");
                int i = scan.nextInt();
                if (i <= pennies & i % 5==0) {
                    pennies -= i;
                    pennyConvert = true;
                    CoinCalculation(.01 * i);
                }
            }
        }
        // calls function and asks the user if they would like to check another amount on Y, repeats the process, on N, process stops
        System.out.println("would you like to check another amount? type Y/N for Yes/No");
        if (scan.next().charAt(0) == 'Y'){
            System.out.println("input a dollar amount like *N.NN* such as 3.75 and get the amount of coins it is back");
            pennies = 0;
            nickels = 0;
            dimes = 0;
            quarters = 0;
            CoinCalculation(scan.nextDouble());
        }
    }
}