import java.util.LinkedList;
import java.io.*;

public class testing_code {
    public static void main(String[] args) {
        AuctionHouse House = new AuctionHouse("CALLING");
        Item item1 = new Item(123, "Callum", 123.12, 2003, "Furniture");
        Item item2 = new Item(123, "Callum", 200.01, 2003, "Painting");
        Item item3 = new Item(123, "Callum", 321.21, 2003, "Sculpture");
        House.addItem(item1);
        House.addItem(item2);
        House.addItem(item3);
        System.out.println("The auction house called 'CALLING' " + House);

        AuctionHouse Auction = new AuctionHouse("My");
        Item item4 = new Item(123, "A", 120.20, 2003, "Furniture");
        Item item5 = new Item(123, "B", 90.00, 2003, "Furniture");
        Item item6 = new Item(123, "C", 200.12, 2003, "Furniture");
        Auction.addItem(item4);
        Auction.addItem(item5);
        Auction.addItem(item6);
        System.out.println("The auction house called 'My' " + Auction);

        Reporting List = new Reporting();
        List.addAuctionHouse(Auction);
        List.addAuctionHouse(House);

        System.out.println("The list of Auction Houses and item in it " + List);

    }
}