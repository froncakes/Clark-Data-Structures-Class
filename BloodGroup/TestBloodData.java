public class TestBloodData {
    public static void main(String[] args) {
        BloodData a = new BloodData();
        System.out.println(a.toString());
        BloodData b = new BloodData(BloodType.AB,"-");
        System.out.println(b.toString());
    }
}
