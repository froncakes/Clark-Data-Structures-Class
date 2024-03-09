public class Item {
    private String name = new String();
    private int price = 0;
    public Item(String name, int price){
        this.price = price;
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
