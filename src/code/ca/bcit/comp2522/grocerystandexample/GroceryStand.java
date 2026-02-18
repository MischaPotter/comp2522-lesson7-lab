package ca.bcit.comp2522.grocerystandexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Models a GroceryStand, which holds items.
 *
 * @author Mischa Potter
 * @author Aika Manalo
 * @version 1.0
 */
class GroceryStand<T>
{
    private static int numGroceryStand;

    private final List<T> inventory;

    /**
     * Constructs a GroceryStand, which populates itself with inventory '
     * based off a List of items to go in the GroceryStand.
     *
     * @param items the list of items to be put into the GroceryStand
     */
    GroceryStand(final List<T> items)
    {
        numGroceryStand++;
        inventory = new ArrayList<>();

        for (final T item : items)
        {
            inventory.add(item);
        }
    }

    /**
     * Example of an inner static nested class.
     */
    static class GroceryStandInfo
    {
        /**
         * Displays the number of total GroceryStand
         */
        public void displayInfo()
        {
            System.out.println("Number of total GroceryStands: " + numGroceryStand);
        }
    }

    /**
     * Example of an inner non-static nested class.
     */
    public class Main
    {
        /**
         * Drives the program.
         *
         * @param args command line arguments (unused)
         */
        public static void main(String[] args)
        {
            final List<Product> items;
            items = new ArrayList<>();

            items.add(new Product("Carrots", 1));
            items.add(new Product("Apples", 2));
            items.add(new Product("Oranges", 3));
            items.add(new Product("Cookies", 4));
            items.add(new Product("Fish", 5));

            // sort
            Collections.sort(items, new Comparator<Product>()
            {
                @Override
                public int compare(final Product a,
                                   final Product b)
                {
                    return a.getProductName().compareTo(b.getProductName());
                }
            });

            GroceryStand<Product> stand;
            stand = new GroceryStand<>(items);

            GroceryStand.GroceryStandInfo info = new GroceryStandInfo();
            info.displayInfo();

        }
    }
}
