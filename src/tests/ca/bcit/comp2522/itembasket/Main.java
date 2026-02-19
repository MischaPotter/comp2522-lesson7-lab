package ca.bcit.comp2522.itembasket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Contains the main method that tests the item basket.
 *
 * @author Mischa Potter
 * @author Aika Manalo
 * @author Mayvee Tan
 * @author Grace Yang
 * @version 1.0
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
             * @return a negative number if Product a is less than Product b lexicographically, and a positive number if
             * Product a is greater than Product b alphabetically
             */
            @Override
            public int compare(final Product a,
                               final Product b)
            {
                return a.getProductName().compareTo(b.getProductName());
            }
        });

        final Basket<Product> shoppingBasket;
        final Basket.DiscountCode saleCode;

        shoppingBasket = new Basket<>(items);
        saleCode       = new Basket.DiscountCode("25OFF", 25.0);

        shoppingBasket.checkout();
        shoppingBasket.checkout(saleCode);

    }
}
