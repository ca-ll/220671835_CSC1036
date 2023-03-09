import java.util.ArrayList;
import java.util.*;

public class Reporting {
    private static List<AuctionHouse> auctionHouses;
    public Reporting() {
        auctionHouses = new ArrayList<>();
    }

    public static List<AuctionHouse> getAuctionHouses() {
        return auctionHouses;
    }
    public static void setAuctionHouses(List<AuctionHouse> auctionHouses) {
        Reporting.auctionHouses = auctionHouses;
    }
    public static void addAuctionHouse(AuctionHouse a){
        auctionHouses.add(a);
    }

    //getting the largest price item in the auction house
    public static Item getLargestPriceItem() {
        Item largestPriceItem = null;
        double largestPrice = 0.0;
        for (AuctionHouse a : auctionHouses) {
            for (Item item : a.getSold()) {
                if (item.getPrice() > largestPrice) {
                    largestPrice = item.getPrice();
                    largestPriceItem = item;
                }
            }
        }
        return largestPriceItem;
    }
    //The AuctionHouse with the largest average price for a given year
    public static AuctionHouse getLargestAvg(int year) {
        AuctionHouse largestAvg = null;
        double largestAvgPrice = 0.0;
        for(AuctionHouse a: auctionHouses){
            double avgPrice = a.average_price(year);
            if(avgPrice>largestAvgPrice){
                largestAvgPrice = avgPrice;
                largestAvg = a;
            }
        }
        return largestAvg;
    }
    //A list of all Items sold with price greater than a given amount of money

    public static ArrayList<Item> getgreaterSold(double price){
        ArrayList<Item> money = new ArrayList<>();
        for(AuctionHouse a: auctionHouses){
        for(Item i : a.getSold()) {
            if(i.getPrice() > price){
                money.add(i);
            }
        }
        }
        return money;
    }
    @Override
    public String toString() {
        return "Reporting{}" + auctionHouses;
    }
}