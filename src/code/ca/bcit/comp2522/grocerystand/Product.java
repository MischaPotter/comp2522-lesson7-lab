package ca.bcit.comp2522.grocerystand;

/**
 * Models a Product, which has a name, id, and price in CAD.
 *
 * @author Mischa Potter
 * @author Aika Manalo
 * @author Mayvee Tan
 * @author Grace Yang
 * @version 1.0
 */
public abstract class Product
    implements Comparable<Product>
{
    // instance variables
    private final String productName;
    private final int    productId;
    private final double priceCAD;

    /**
     * Represents a Product with a product name and id.
     *
     * @param productName the name of the Product, e.g. carrots
     * @param productId   the Product's id. This can be different for different stores
     */
    public Product(final String productName,
                   final int productId,
                   final double priceCAD)
    {
        validateProductName(productName);

        this.productName = productName;
        this.productId   = productId;
        this.priceCAD    = priceCAD;
    }

    /**
     * Gets (accesses) the product name.
     *
     * @return the product name
     */
    protected String getProductName()
    {
        return productName;
    }

    /**
     * Gets (accesses) the product id.
     *
     * @return the product id
     */
    protected int getProductId()
    {
        return productId;
    }

    /**
     * Gets (accesses) the price in CAD.
     *
     * @return the price in CAD
     */
    protected double getPriceCAD()
    {
        return priceCAD;
    }

    /**
     * Returns a formatted String describing the Product.
     *
     * @return a String detailing the Product.
     */
    @Override
    public String toString()
    {
        final StringBuilder builder;
        builder = new StringBuilder();

        builder.append("Name: ");
        builder.append(productName);
        builder.append("\nProduct ID: ");
        builder.append(productId);
        builder.append("\nProduct Price (CAD): ");
        builder.append(priceCAD);
        builder.append("\n");

        return builder.toString();
    }

    /**
     * Compares two Products.
     *
     * @param o the object to be compared.
     * @return a positive int if this Product is greater than the other Product, a negative int if this Product is less
     * than the other Product, and 0 if the Products are the same.
     */
    @Override
    public int compareTo(final Product o)
    {
        return productId - o.productId;
    }

    /*
     * Validates the product name.
     *
     * @param productName the product name to be validated
     */
    private static void validateProductName(final String productName)
    {
        if (productName == null || productName.isEmpty())
        {
            throw new IllegalArgumentException("Invalid product name: " + productName);
        }
    }
}


