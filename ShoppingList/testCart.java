/*
* Frankie Nolan
* 3/9/2024
* shoppingList assignment, can show cart and has a 2 for 1 discount.
 */
public class testCart {
    static ShoppingCart cart = new ShoppingCart();
    public static void main(String[] args) {
        /*
        * use to add orders, remove orders, search orders, set for a 2 for 1 discount, get the total cost, and show cart.
        * examples of all below
         */

        // create a new ItemOrder(String, int, int)
        cart.addOrder(new ItemOrder("Cheese", 6, 3));
        cart.addOrder(new ItemOrder("Ketchup", 4, 3));
        // discount get order from cart and then setDiscount(boolean) or set2For1Deal(boolean)
        cart.getOrder(2).set2For1Deal(true);
        // print out the search order searchOrder(String);
        System.out.println(cart.searchOrder("Ketchup"));
        // getTotal();
        cart.getTotal();
        // showCart();
        cart.showCart();
        // removaOrder(int)
        cart.removeOrder(1);
    }
}
