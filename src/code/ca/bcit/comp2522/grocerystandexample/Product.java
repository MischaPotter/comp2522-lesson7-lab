package ca.bcit.comp2522.grocerystandexample;

/**
 * Models a Product, which has a name, id, and price in CAD.
 *
 * @author Mischa Potter
 * @author Aika Manalo
 * @version 1.0
 */
class Product
    implements Comparable<Product>
{
    private final String productName;
    private final int    productId;

    /**
     * Constructs a Product with a product name and id.
     *
     * @param productName the name of the Product, e.g. carrots
     * @param productId   the Product's id. This can be different for different stores
     */
    Product(final String productName,
            final int productId)
    {
        validateProductName(productName);

        this.productName = productName;
        this.productId   = productId;
    }

    /**
     * Gets (accesses) the product name.
     *
     * @return the product name
     */
    public String getProductName()
    {
        return productName;
    }

    /**
     * Gets (accesses) the product id.
     *
     * @return the product id
     */
    public int getProductId()
    {
        return productId;
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
}
