package ca.bcit.comp2522.itembasket;

import java.util.ArrayList;
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
public class Basket<T extends Product>
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
     *
     * @author Mischa Potter
     * @author Aika Manalo
     * @author Mayvee Tan
     * @author Grace Yang
     * @version 1.0
     */
    public static class DiscountCode
    {
        // constants
        private static final double DIVIDE_FOR_PERCENTAGE   = 100.0;
        private static final double MAX_DISCOUNT_PERCENTAGE = 100.0;

        // instance variable
        private final String promoCode;
        private final double discountedPercentage;

        /**
         * Constructs a new DiscountCode with the promo code and how much gets discounted.
         *
         * @param promoCode            the String
         * @param discountedPercentage the percent it's discounted
         */
        public DiscountCode(final String promoCode,
                            final double discountedPercentage)
        {
            validatePromoCode(promoCode);
            validateDiscountedPercentage(discountedPercentage);

            this.promoCode            = promoCode;
            this.discountedPercentage = discountedPercentage;
        }

        /**
         * Applies the discount from this DiscountCode to the original price.
         *
         * @param originalPrice the original price before the discount is applied
         * @return the price after the discount as been applied
         */
        public double applyDiscount(final double originalPrice)
        {
            final double discount;
            final double discountedPrice;

            discount        = originalPrice * (discountedPercentage / DIVIDE_FOR_PERCENTAGE);
            discountedPrice = originalPrice - discount;

            return discountedPrice;
        }

        /*
         * Validates the promoCode to not be null or empty.
         *
         * @param promoCode the promo code being validated
         */
        private static void validatePromoCode(final String promoCode)
        {
            if (promoCode == null || promoCode.isEmpty())
            {
                throw new IllegalArgumentException("Invalid promo code: " + promoCode);
            }
        }

        /*
         * Validates the discountedPercentage to be less than MAX_DISCOUNT_PERCENTAGE.
         *
         * @param discountedPercentage the discount percentage being validated
         */
        private static void validateDiscountedPercentage(final double discountedPercentage)
        {
            if (discountedPercentage > MAX_DISCOUNT_PERCENTAGE)
            {
                throw new IllegalArgumentException("Invalid discount percentage: " + discountedPercentage);
            }
        }
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
         * Calculates the total price of all the inventory in CAD.
         *
         * @return the sum of all the items in inventory
         */
        public double calculateTotalPriceCAD()
        {
            double total;
            total = 0.0;

            for (final T item : inventory)
            {
                total += item.getPriceCAD();
            }
            return total;
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

            builder.append("Total Price: $");
            builder.append(calculateTotalPriceCAD());
            builder.append("\n");

            System.out.println(builder);
        }
    }

    /**
     * Prints the receipt for this basket without a coupon.
     */
    public void checkout()
    {
        final Receipt receipt;
        receipt = new Receipt();
    }

    /**
     * Prints the receipt for this basket with a coupon.
     *
     * @param discountCode the promo code
     */
    public void checkout(final DiscountCode discountCode)
    {
        final Receipt receipt;
        final double totalPriceCAD;

        receipt       = new Receipt();
        totalPriceCAD = discountCode.applyDiscount(receipt.calculateTotalPriceCAD());

        System.out.println("Total price after discount: $" + totalPriceCAD);
    }
}
