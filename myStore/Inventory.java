
package myStore;

import java.util.ArrayList;

/**
 * class tracks the state of the product in inventory of the store.
 */
public class Inventory implements ProductStockContainer {
    /**
     * ArrayList to track the products.
     */
    private final ArrayList<Product> productCatalog = new ArrayList<>();

    /**
     * ArrayList to track the amount of stocks.
     */
    private final ArrayList<Integer> stocks = new ArrayList<>();

    /**
     * Initialize the inventory.
     */
    public Inventory() {
        init();
    }

    /**
     * Set the contents of the inventory to some default values upon object
     * creation.
     */
    private void init() {
        Product p1 = new Product("apple", 0, 0.50);
        Product p2 = new Product("mango", 1, 0.50);
        Product p3 = new Product("melon", 2, 1.00);
        Product p4 = new Product("pear", 3, 0.50);
        Product p5 = new Product("watermelon", 4, 2.50);
        Product p6 = new Product("broccoli", 5, 0.50);
        Product p7 = new Product("cabbage", 6, 0.20);
        Product p8 = new Product("carrot", 7, 0.20);
        Product p9 = new Product("lettuce", 8, 0.50);
        Product p10 = new Product("pakchoy", 9, 0.50);
        productCatalog.add(p1);
        stocks.add(100);
        productCatalog.add(p2);
        stocks.add(100);
        productCatalog.add(p3);
        stocks.add(100);
        productCatalog.add(p4);
        stocks.add(100);
        productCatalog.add(p5);
        stocks.add(100);
        productCatalog.add(p6);
        stocks.add(100);
        productCatalog.add(p7);
        stocks.add(100);
        productCatalog.add(p8);
        stocks.add(100);
        productCatalog.add(p9);
        stocks.add(100);
        productCatalog.add(p10);
        stocks.add(100);
    }

    /**
     * Get information on a product given a Product ID.
     *
     * @param id int : value for the ID number of the product
     * @return Product : the product object
     */
    public Product getProductInfo(int id) {
        int index = 0;
        boolean productExist = false;
        for (int i = 0; i < this.productCatalog.size(); i++) {
            if (this.productCatalog.get(i).getId() == id) {
                index = i;
                productExist = true;
            }
        }
        if (productExist) {
            return this.productCatalog.get(index);
        } else {
            // INVENTORY > ERROR > product does not exist in inventory.
            return null;
        }
    }

    /**
     * Get ArrayList which tracks the information for the Product objects.
     *
     * @return ArrayList<Product> : object that track the Product objects
     */
    public ArrayList<Product> getProductCatalog() {
        return this.productCatalog;
    }

    /**
     * Get amount of stock for a given Product.
     *
     * @param product Product : the product
     * @return int : the quantity of the product in stock
     */
    @Override
    public int getProductQuantity(Product product) {
        int quantity = 0;
        for (int i = 0; i < this.productCatalog.size(); i++) {
            if (this.productCatalog.get(i).getId() == product.getId()) {
                quantity = this.stocks.get(i);
                break;
            }
        }
        return quantity;
    }

    /**
     * Add specified amount of stock for a given Product object to the inventory.
     *
     * @param product  Product : object to be added to stock
     * @param quantity int : value for a specified amount of stock to be added
     */
    @Override
    public void addProductQuantity(Product product, int quantity) {
        int newQuantity;
        boolean productExist = false;
        if (quantity >= 0) {
            if (this.productCatalog.size() != 0) {
                for (int i = 0; i < this.productCatalog.size(); i++) {
                    if (this.productCatalog.get(i).getId() == (product.getId())) {
                        newQuantity = this.stocks.get(i);
                        newQuantity += quantity;
                        this.stocks.set(i, newQuantity);
                        productExist = true;
                        break;
                    }
                }
            }
            if (!productExist) {
                this.productCatalog.add(product);
                this.stocks.add(quantity);
            }
        }
    }

    /**
     * Remove specified amount of stock for a given Product ID from the inventory.
     *
     * @param product  Product : object to be removed from stock
     * @param quantity int : value for a specified amount of stock to be removed
     */
    @Override
    public void removeProductQuantity(Product product, int quantity) {
        int newQuantity = 0;
        int index = 0;
        boolean productExist = false;
        if (quantity >= 0) {
            for (int i = 0; i < this.productCatalog.size(); i++) {
                if (this.productCatalog.get(i).getId() == product.getId()) {
                    newQuantity = this.stocks.get(i);
                    if (quantity >= newQuantity) {
                        newQuantity = 0;
                    }
                    newQuantity -= quantity;
                    index = i;
                    productExist = true;
                    break;
                }
            }
            if (productExist) {
                this.stocks.set(index, newQuantity);
            }
        }
    }

    /**
     * Get number of product item in the inventory.
     *
     * @return int : number of products
     */
    @Override
    public int getNumOfProducts() {
        return getProductCatalog().size();
    }
}
