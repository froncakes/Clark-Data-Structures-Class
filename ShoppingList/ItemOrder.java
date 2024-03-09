public class ItemOrder {
    // an Item is a String for name and an int for price
    private Item item;
    private int quantity = 1;
    private int totalCost = 0;
    // discount for buy 2, get 1 free
    private boolean disc2for1 = false;
    // discount for 50 percentage off (since the prices are ints its just dividing by 2)
    private boolean disc50off = false;
    public ItemOrder(String itemName, int itemPrice, int orderQuantity){
        item = new Item(itemName, itemPrice);
        quantity = orderQuantity;
        calculatePrice();
    }
    private void calculatePrice(){
        for (int i = 0; i < quantity; i++){
            // if the 2 for 1 deal is on and the quantity is 3 then the price will not be added to the total
            if (!disc2for1 && !((i+1)%3==0)){
                totalCost += item.getPrice();
            }
        }
    }
    public void set2For1Deal(boolean discount){
        disc2for1 = discount;
        calculatePrice();
    }
    public int getTotal(){
        return totalCost;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculatePrice();
    }
    public int getQuantity() {
        return quantity;
    }
    public void setItem(Item item) {
        this.item = item;
        calculatePrice();
    }
    public Item getItem() {
        return item;
    }
}
