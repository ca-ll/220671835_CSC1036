public class Item {
    private int item_number;
    private String buyer_name;
    private double price;
    private int year;
    private String type;

    /**
     * The constructure to store and retrieve the information about the items that have been sold
     * @param item_number - the item number
     * @param buyer_name - the name of the buyer
     * @param price - the price of the item
     * @param year - the year that the item was sold
     * @param type - the type of item it is being either furniture, painting or sculpture
     */
    Item(int item_number, String buyer_name, double price, int year, String type){
        this.item_number = item_number;
        this.buyer_name = buyer_name;
        this.price = price;
        this.year = year;
        this.type = type;
    }

    /**
     * Get Setter methods for each variable that was listed, so that other classes can access the data
     */
    public int getItem_number(){
        return item_number;
    }
    public void setItem_number(){
        this.item_number = item_number;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_number=" + item_number +
                ", buyer_name='" + buyer_name + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", type='" + type + '\'' +
                '}';
    }
}
