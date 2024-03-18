// Pizza class contains an array of toppings, the price of the pizza, and the description
public class Pizza {
    private String[] toppings = new String[10];
    private int price = 14;
    private String description = new String("a ");
    // a is the array of toppings, b is the number of toppings used
    public Pizza(String[] a,int b){
        toppings = a;
        // adds a topping to the description for how many toppings added, aswell as adding 2 dollars per topping
        for (int i = 0; i < b; i++) {
            if (toppings[i] != null){
                price += 2;
                // removes comma if its the last one
                if (i == b-1){
                    description = description + a[i] + " ";
                }else{
                    description = description + a[i] + ", ";
                }
            }
        }
    }
    public String toString(){
        String a = description + "pizza which costs $" +price;
        return a;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
