public class DeliveryPizza extends Pizza {
    String deliveryAddress = new String();
    // a is the array of toppings, b is the number of toppings used, c is the address
    public DeliveryPizza(String[] a,int b,String c){
        // does the same as the pizza constructor but sets delivery address to a location and sets the delivery fee on the price
        super(a,b);
        deliveryAddress = c;
        if (getPrice() > 18){
            setPrice(getPrice()+3);
        }else {
            setPrice(getPrice()+5);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " delivered to "+ deliveryAddress;
    }
}
