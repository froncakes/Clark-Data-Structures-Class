import java.util.Arrays;
import java.util.Scanner;
public class ArrayLab {
    public static void main(String[] args) {
        double[] nums = new double[20];
        Scanner s = new Scanner(System.in);
        for (int i =0; i < nums.length; i++){
            nums[i] = s.nextDouble();
            System.out.println(Arrays.toString(nums));
        }
    }
}