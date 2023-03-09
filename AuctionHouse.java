import java.util.ArrayList;
import java.util.List;

public class AuctionHouse{
    private String Auction_name; //name of auction house
    private List<Item> sold; //The list of items sold in auction house

    /**
     * The constructor for the AuctionHouse class
     * @param Auction_name being the name of the auction house
     *  The 'sold' is the array list which has items that are sold in an auction house
     */
     public AuctionHouse(String Auction_name) {
         this.Auction_name = Auction_name;
         this.sold = new ArrayList<>();
     }

    public String getAuction_name() {
        return Auction_name;
    }

    public void setAuction_name(String auction_name) {
        Auction_name = auction_name;
    }

    public void setSold(ArrayList<Item> sold) {
        this.sold = sold;
    }
    public void addItem(Item i){
        sold.add(i);
    }
    public List<Item> getSold() {
        return sold;
    }

    //The Item with the highest ever price sold at the auction house.
    public ArrayList<Item> high_price(double price) {
        ArrayList<Item> high = new ArrayList<>();
        for (Item i : sold) {
            if (i.getPrice() >= price) {
                high.add(i);
            }
        }
        return high;
    }

    //The average item price recorded by the auction house in a given year.

    /**
     * This method will find the highest average item price recorded in the auction house in a given year where
     * @param year - is to compare which items that are sold in the year given
     * @return the total price of the items divide by the number of items
     */
    public double average_price(int year) {
        if (sold.isEmpty()){
            return 0;
        }
        int count = 0;      //used to count how many items sold in the same year
        double total = 0;
        for (Item i : sold) {
            if (i.getYear() == year) {
                count++;
                total += i.getPrice();
            }
        }
        return total/count;
    }

    //A list of all items sold by the auction house with a price greater than a given amount of money.
    public ArrayList<Item> All_price(double price) {
        ArrayList<Item> tmp = new ArrayList<>();
        for (Item i : sold) {
            if (i.getPrice() > price) {
                tmp.add(i);
            }
        }
        return tmp;
    }

    @Override
    public String toString() {
        return "AuctionHouse{" +
                "Auction_name='" + Auction_name + '\'' +
                ", sold=" + sold +
                '}';
    }
}