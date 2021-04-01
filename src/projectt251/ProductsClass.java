package projectt251;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 *
 * @author maryam
 */
public class ProductsClass {

    private String id;
    private String PFid;
    private String name;
    private String expireDate;
    private String calories;
    private int price;
    private int quantity;
    private int soldProducts;
    private char offers;
    
    /**
     *
     */
    public ProductsClass() {
    }

    /**
     *
     * @param id of Product 
     * @param name of Product
     * @param expireDate of Product
     * @param calories of Product
     * @param price of Product
     * @param quantity of Product
     * @param soldProducts of Product
     * @param PFid of Product
     */
    public ProductsClass(String  id, String name, String expireDate, String calories, int price, int quantity,int soldProducts,String PFid) {
        this.id = id;
        this.name = name;
        this.expireDate = expireDate;
        this.calories = calories;
        this.price = price;
        this.quantity = quantity;
        this.PFid=PFid;
        this.soldProducts=soldProducts;
        this.offers=',';
    }
    
    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     *
     * @param expireDate
     */
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    /**
     *
     * @return
     */
    public String getCalories() {
        return calories;
    }

    /**
     *
     * @param calories
     */
    public void setCalories(String calories) {
        this.calories = calories;
    }

    /**
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public int getSoldProducts() {
        return soldProducts;
    }

    /**
     *
     * @param soldProducts
     */
    public void setSoldProducts(int soldProducts) {
        this.soldProducts = soldProducts;
    }

    /**
     *
     * @return
     */
    public String getPFid() {
        return PFid;
    }

    /**
     *
     * @param PFid
     */
    public void setPFid(String PFid) {
        this.PFid = PFid;
    }

    /**
     *
     * @return
     */
    public char getOffers() {
        return offers;
    }

    /**
     *
     * @param offers
     */
    public void setOffers(char offers) {
        this.offers = offers;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return   PFid+"\t\t"+id + "\t" + name + "\t\t" + expireDate +  "\t\t" + price + "\t\t" + quantity + "\t\t" + soldProducts ;
    }

    /**
     *
     * @return String
     */
    public String toString2() {
        return   id + "\t" + name + "\t" + expireDate + "\t" + calories + "\t" + price  ;
    }

    /**
     *
     * @return String
     */
    public String toString3() {
        return   id + " " + name + " " + expireDate + " " + calories + " " + price + " " + quantity +" "+soldProducts+" "+PFid ;
    }

}
