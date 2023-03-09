import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ReportingIO {

    public static void main(String[] args) {
        /**
         * Testing code to test the functions for the functions from the menu
         * Made 2 auction houses which both have items and are added to the array list of auction houses
         * known as Houses_list
         */
        AuctionHouse H = new AuctionHouse("Chicken");
        AuctionHouse N = new AuctionHouse("The Game");

        Reporting Houses_list = new Reporting(); //initiates list for a list of Auction Houses
        Houses_list.addAuctionHouse(H);
        Houses_list.addAuctionHouse(N);

        Item T1 = new Item(123, "Call", 123.12, 2001, "furniture");
        Item T2 = new Item(123, "Um", 312.34, 2001, "painting");
        Item T3 = new Item(123, "HA", 400.00, 2003, "sculpture");
        H.addItem(T1);
        H.addItem(T2);
        H.addItem(T3);

        Item T4 = new Item(123,"Jimmy", 200.00, 2003,"sculpture");
        Item T5 = new Item(123, "Mumbo", 420.69, 2020, "painting");
        Item T6 = new Item(123, "Bimbo", 200.20, 2003, "furniture");
        N.addItem(T4);
        N.addItem(T5);
        N.addItem(T6);

/**
 * The main menu of the user interface with methods placed outside the main method. And a hidden option just to test
 * what is stored in the Houses_list.
 */
        boolean run = true;
        Scanner x = new Scanner(System.in);
        while (run) {
            System.out.println("Main menu\n input the following integers to access the following features:");
            System.out.println("1. enter Auction House data" +
                    "\n2. enter Item data" +
                    "\n3. Report statistics" +
                    "\n4. exit");
            System.out.println("input number:");
            try {
                int option = x.nextInt();

                switch (option) {
                    case 1:
                        enterauctionhouse();
                        break;
                    case 2:
                        enteritemdata();
                        break;
                    case 3:
                        Report_statistics();
                        break;
                    case 4:
                        System.out.println("Exiting the program...");
                        run = false;
                        break;
                    case 5:
                        System.out.println(Houses_list); //testing what is in the Reporting class array list
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Something went wrong. Please try again" +
                        "\n------------------------------------------");
            } finally {
                x.nextLine();
            }
        }
    }

    /**
     * Asks the user to input a name for the Auction House.
     * @return The name of the auction house that the user has inputted which will be added to the array list.
     */
    static AuctionHouse enterauctionhouse() {
        Scanner Name = new Scanner(System.in);
        AuctionHouse auctionHouse;
            System.out.println("Type the name of the Auction House:");
            String name = Name.nextLine();
            auctionHouse = new AuctionHouse(name);
            Reporting.addAuctionHouse(auctionHouse);
            System.out.println("Auction house data has been entered");
            return auctionHouse;
    }

    /**
     * Method for the user to enter data for an item which should then be put into the Auction House.
     * This would then show the data that the user has inputted and then ask the name of the auction house
     * then putting it into an existing auction house
     */
     static Item enteritemdata() {
        Scanner item = new Scanner(System.in);

        System.out.println("input buyer's name");
        String name = item.nextLine();
        System.out.println("input the type of the item: \nFurniture, Painting or Sculpture:");
        String typing = item.nextLine();
        System.out.println("input item lot number");
        int lot = item.nextInt();
        System.out.println("input the price of item");
        double price = item.nextDouble();
        System.out.println("input the year the item was sold");
        int year = item.nextInt();
        Item T0 = new Item(lot, name, price, year, typing);
        System.out.println(T0);
        enterauctionhouse().addItem(T0);
        return new Item(lot, name, price, year, typing);
    }

    /**
     * This report_statistics method has more options which will then use the methods that are in the other classes
     */
    static void Report_statistics() {
        Scanner sc = new Scanner(System.in);
        boolean stat = true;
            System.out.println("choose the following options:");
            System.out.println("1. Auction house with the largest average price for a given year" +
                    "\n2. highest price item ever reported" +
                    "\n3. items sold with a price higher than a given amount");
        while(stat) {
            try {
                int option2 = sc.nextInt();
                switch (option2) {
                    case 1:
                        System.out.println("Enter the year of the largest average price");
                        int year = sc.nextInt();
                        AuctionHouse Auctionname = Reporting.getLargestAvg(year);
                        System.out.println("The auction house with the largest price item in " + year + " is:" + Auctionname);
                        stat = false;
                        break;
                    case 2:
                        Item highest_price = Reporting.getLargestPriceItem();
                        System.out.println("The highest price ever recorded is: " + highest_price);
                        stat = false;
                        break;
                    case 3:
                        System.out.println("Enter a price to find items sold higher than the price:");
                        double price = sc.nextDouble();
                        ArrayList<Item> price_higher_than = Reporting.getgreaterSold(price);
                        System.out.println("The items sold higher than £" + price + " is " + price_higher_than);
                        stat = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input an integer");
            } finally{
                sc.nextLine();
            }
        }
    }
}
