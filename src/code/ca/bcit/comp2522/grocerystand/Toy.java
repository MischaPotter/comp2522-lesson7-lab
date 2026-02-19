package ca.bcit.comp2522.grocerystand;

import java.util.Arrays;

/**
 * Toy, child of Product, is a toy with a name, product ID, price in CAD, and age range.
 *
 * @author Mischa Potter
 * @author Aika Manalo
 * @author Mayvee Tan
 * @author Grace Yang
 * @version 1.0
 */
public abstract class Toy extends Product
{
    // constant
    private static final int MAX_AGE_RANGE_ARR_ELEMENTS = 2;

    // instance variable
    private final int[] ageRange;

    /**
     * Constructs a Toy with the name, product ID, price, and age range.
     *
     * @param toyName  the name of this Toy
     * @param toyId    the toy ID of this Toy
     * @param priceCAD the price of this Toy
     * @param ageRange the age range for this Toy
     */
    Toy(final String toyName,
        final int toyId,
        final double priceCAD,
        final int[] ageRange)
    {
        super(toyName, toyId, priceCAD);

        validateAgeRange(ageRange);

        this.ageRange = ageRange;
    }

    /**
     * Returns the age range in a formatted string.
     *
     * @return the age range for this Toy
     */
    public String getAgeRange()
    {
        final StringBuilder builder;
        builder = new StringBuilder();

        builder.append("Age range: ");
        builder.append(ageRange[0]);
        builder.append(" - ");
        builder.append(ageRange[1]);
        builder.append("\n");

        return builder.toString();
    }

    /**
     * Returns a formatted String describing this Toy.
     *
     * @return a formatted String
     */
    @Override
    public String toString()
    {
        final StringBuilder builder;
        builder = new StringBuilder();

        builder.append(super.toString());
        builder.append(getAgeRange());

        return builder.toString();
    }
    
    /*
     * Validates the age range.
     *
     * @param ageRange the age range to be validated
     */
    private static void validateAgeRange(final int[] ageRange)
    {
        if (ageRange.length != MAX_AGE_RANGE_ARR_ELEMENTS ||
            ageRange[0] > ageRange[1])
        {
            throw new IllegalArgumentException("Invalid age range: " + Arrays.toString(ageRange));
        }
    }
}
