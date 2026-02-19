package ca.bcit.comp2522.grocerystand;

/**
 * ActionFigure, child of Toy, is an action figure with a character name, product id, price in CAD, age range,
 * franchise.
 *
 * @author Mischa Potter
 * @author Aika Manalo
 * @author Mayvee Tan
 * @author Grace Yang
 * @version 1.0
 */
public class ActionFigure extends Toy
{
    // instance variable
    private final String franchise;

    /**
     * Creates an ActionFigure with a name, ID, price in CAD, the intended age range, and the franchise the character
     * is from.
     *
     * @param characterName        the name of the character
     * @param actionFigureID       the ID of the toy
     * @param actionFigurePriceCAD the price of the action in CAD
     * @param ageRange             the intended age range
     * @param franchise            the franchise the character is from
     */
    public ActionFigure(final String characterName,
                        final int actionFigureID,
                        final double actionFigurePriceCAD,
                        final int[] ageRange,
                        final String franchise)
    {
        super(characterName, actionFigureID, actionFigurePriceCAD, ageRange);
        validateFranchise(franchise);

        this.franchise = franchise;

    }

    /**
     * Gets (accesses) the franchise of the ActionFigure.
     *
     * @return the franchise the ActionFigure character is from
     */
    protected String getFranchise()
    {
        return franchise;
    }

    /**
     * Returns a formatted String describing the ActionFigure.
     *
     * @return a String describing the ActionFigure
     */
    @Override
    public String toString()
    {
        final StringBuilder builder;
        builder = new StringBuilder();

        builder.append(super.toString());
        builder.append("Franchise: ");
        builder.append(franchise);
        builder.append("\n");

        return builder.toString();
    }

    /*
     * Validates the franchise to be not null or not empty.
     *
     * @param franchise the franchise being validated
     */
    private static void validateFranchise(final String franchise)
    {
        if (franchise == null || franchise.isEmpty())
        {
            throw new IllegalArgumentException("Invalid franchise: " + franchise);
        }
    }
}
