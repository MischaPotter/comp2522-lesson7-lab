package ca.bcit.comp2522.itembasket;

/**
 * JigsawPuzzle, child of Toy, is a jigsaw puzzle with a name, product id, price
 * in CAD, age range, and number of pieces.
 *
 * @author Mischa Potter
 * @author Aika Manalo
 * @author Mayvee Tan
 * @author Grace Yang
 * @version 1.0
 */
public final class JigsawPuzzle extends Toy
{
    // constant
    private static final int MIN_NUM_PUZZLE_PIECES = 0;

    // instance variable
    private final int totalNumPieces;

    /**
     * Constructs a JigsawPuzzle that has a name, id, price, age range, and number of pieces.
     *
     * @param jigsawPuzzleName the name of this JigsawPuzzle
     * @param jigsawPuzzleId   the product ID of this JigsawPuzzle
     * @param priceCAD         the price in CAD of this JigsawPuzzle
     * @param ageRange         the age range (e.g. 12-99) of this JigsawPuzzle
     * @param totalNumPieces   the number of pieces of this JigsawPuzzle
     */
    public JigsawPuzzle(final String jigsawPuzzleName,
                        final int jigsawPuzzleId,
                        final double priceCAD,
                        final int[] ageRange,
                        final int totalNumPieces)
    {
        super(jigsawPuzzleName, jigsawPuzzleId, priceCAD, ageRange);

        validateNumPieces(totalNumPieces);
        this.totalNumPieces = totalNumPieces;
    }

    /**
     * Gets the number of pieces for this JigsawPuzzle.
     *
     * @return the number of pieces
     */
    public int getNumPieces()
    {
        return totalNumPieces;
    }

    /**
     * Returns a formatted String describing the JigsawPuzzle.
     *
     * @return a String detailing the JigsawPuzzle
     */
    @Override
    public String toString()
    {
        final StringBuilder builder;
        builder = new StringBuilder();

        builder.append(super.toString());
        builder.append("Total Num Pieces: ");
        builder.append(totalNumPieces);
        builder.append("\n");

        return builder.toString();
    }

    /*
     * Validates the number of pieces in the puzzle.
     *
     * @param totalNumPieces the number of pieces in the puzzle to be validated
     */
    private static void validateNumPieces(final int totalNumPieces)
    {
        if (totalNumPieces < MIN_NUM_PUZZLE_PIECES)
        {
            throw new IllegalArgumentException("Invalid number of pieces: " + totalNumPieces);
        }
    }
}
