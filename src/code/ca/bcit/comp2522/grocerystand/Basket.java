package ca.bcit.comp2522.grocerystand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Models a Basket, which holds items and tracks how many Baskets are created.
 *
 * @author Mischa Potter
 * @author Aika Manalo
 * @author Mayvee Tan
 * @author Grace Yang
 * @version 1.0
 */
public class Basket<T>
{
    // instance variables
    private static int     numBaskets;
    private final  List<T> inventory;

    /**
     * Constructs a Basket, which populates itself with inventory
     * based off a List of items to go in the Basket.
     *
     * @param items the list of items to be put into the Basket
     */
    public Basket(final List<T> items)
    {
        numBaskets++;
        inventory = new ArrayList<>();

        for (final T item : items)
        {
            inventory.add(item);
        }
    }

    /**
     * Example of an inner static nested class.
     */
    public static class BasketInfo
    {
        /**
         * Displays the number of total Baskets.
         */
        public void displayInfo()
        {
            System.out.println("Number of total baskets: " + numBaskets);
        }
    }

    /**
     * Prints the receipt for this basket.
     */
    public void checkout()
    {
        final Receipt receipt;
        receipt = new Receipt();
    }

    /**
     * Receipt is an inner class that generates a receipt for this specific basket.
     * Non-static because it needs access to this basket's inventory.
     *
     * @author Mischa Potter
     * @author Aika Manalo
     * @author Mayvee Tan
     * @author Grace Yang
     * @version 1.0
     */
    public class Receipt
    {
        /**
         * Creates a Checkout object that prints the receipt for your basket.
         */
        public Receipt()
        {
            printReceipt();
        }

        /**
         * Prints the receipt for the items in the basket.
         */
        public void printReceipt()
        {
            final StringBuilder builder;
            builder = new StringBuilder();

            builder.append("Number of items: ");
            builder.append(inventory.size());
            builder.append("\n");

            for (final T item : inventory)
            {
                builder.append(item.toString());
            }

            System.out.println(builder);
        }
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args)
    {
        final List<Product> items;
        final int[] ageRangeFiveToTwelve;

        items                = new ArrayList<>();
        ageRangeFiveToTwelve = new int[2];

        ageRangeFiveToTwelve[0] = 5;
        ageRangeFiveToTwelve[1] = 12;

        items.add(new JigsawPuzzle("Cat Jigsaw Puzzle", 1, 19.99, ageRangeFiveToTwelve, 1000));
        items.add(new JigsawPuzzle("Horse Jigsaw Puzzle", 2, 39.99, ageRangeFiveToTwelve, 3000));
        items.add(new ActionFigure("Batman", 3, 9.99, ageRangeFiveToTwelve, "DC"));
        items.add(new ActionFigure("Poison Ivy", 4, 8.89, ageRangeFiveToTwelve, "DC"));

        // anonymous method
        Collections.sort(items, new Comparator<Product>()
        {
            /**
             * Compares two Products.
             *
             * @param a the first object to be compared
             * @param b the second object to be compared
             * @return a negative number if Product a is less than Product b and a positive number if Product a is
             * greater than Product B
             */
            @Override
            public int compare(final Product a,
                               final Product b)
            {
                return a.getProductName().compareTo(b.getProductName());
            }
        });

        Basket<Product> shoppingBasket;
        BasketInfo info = new BasketInfo();

        shoppingBasket = new Basket<>(items);
        info.displayInfo();

        shoppingBasket.checkout();

    }
}
