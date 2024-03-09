import java.util.ArrayList;
public class ShoppingCart {
    private ArrayList<ItemOrder> list = new ArrayList<ItemOrder>();
    private ArrayList<String> items = new ArrayList<String>();
    private int total = 0;
    // adds order to list and then adds to items in cart
    public void addOrder(ItemOrder order){
        list.add(order);
        int quantity = order.getQuantity();
        for (int i = 0; i < quantity; i++){
            items.add(order.getItem().getName());
        }
    }
    // finds the string at given integer to remove all the items from the cart and then removes the order from the list
    public void removeOrder(int a){
        a--;
        String b = list.get(a).getItem().getName();
        for (int i = 0; i < items.size(); i++){
            try {
                while (items.get(i) == b) {
                    items.remove(i);
                }
            } catch (IndexOutOfBoundsException e){

            }
        }
        list.remove(a);
    }
    // shows all the item names in cart accounting for quantity
    public void showCart(){
        System.out.println("cart contains "+items.toString());
    }
    public void getTotal(){
        total = 0;
        for(int i = 0; i <list.size(); i++){
            total += list.get(i).getTotal();
        }
        System.out.println("cart is a total of $"+total);
    }
    // searches the array list for an item with a name that is the same as the one inputted, outputs its number in the order,
    // returns -1 if it cannot be found.
    public int searchOrder(String name){
        for(int i = 0; i <list.size(); i++){
            if (list.get(i).getItem().getName() == name){
                return i+1;
            }
        }
        return -1;
    }
    public ItemOrder getOrder(int a){
        return list.get(a-1);
    }
}
