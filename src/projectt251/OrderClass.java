
package projectt251;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static projectt251.ApplicationClass.ProductsArray;
import static projectt251.ApplicationClass.findeProdectes;

/**
 *
 * @author maryam
 */
public class OrderClass {
    static int receiptNo =100;
    private ArrayList<String>  cart =new ArrayList<String>();
    private ArrayList<Integer> qunatity=new ArrayList<Integer>();
    private int totalPrice;
    private String orderDate ;
    private CustomerClass newCustomer=new CustomerClass();
    private  double tax ;
   
    /**
     * This method is used to confirm the Order 
     * @param name of customer 
     * @param addres of customer 
     * @param email of customer 
     * @param PhoneNo of customer 
     * @return boolean of confirm status 
     */
    public  boolean confirmOrder(String name,String addres,String  email,String  PhoneNo){
        if(newCustomer.checkPhoneNumber(PhoneNo)){
          newCustomer.setAddress(addres);
          newCustomer.setEmail(email);
          newCustomer.setName(name);
          newCustomer.setPhoneNo(PhoneNo);
          orderDate=java.time.LocalDate.now()+" ";
         
          return true;}
        
          else
            return false;}
   
    /**
     * This method is used to check Availability of Product
     * @param id of Product want to check 
     * @param quantety of Product want to check
     * @return boolean of check status
     */
    public static boolean checkAvailbility(String id ,int quantety){
        for (int i = 0; i < ProductsArray.size(); i++) {
            if(ProductsArray.get(i).getId().equals(id))
                if(ProductsArray.get(i).getQuantity()>=quantety){
                   return true;}
                else
                   return false;   
        }
 
        return false;
        
     }

    /**
     * This method is used to Calculate total price of products That the customer order it
     * @return int Total price
     */
    public  int TotalPrice(){
        for (int i = 0; i < cart.size(); i++) {
            ProductsClass Product=findeProdectes(cart.get(i));
            if(Product.getOffers() == ','){
            totalPrice+=Product.getPrice()*qunatity.get(i);
            }else{
            switch(Product.getOffers()){
                    case 'A':
                     totalPrice+=Product.getPrice()*(qunatity.get(i)/2);
                     break;
                    case 'B':
                     totalPrice+=Product.getPrice()*((qunatity.get(i)/3*2));
                     break;
                            }
            }      
        }
        return totalPrice;
        
    }

    /**
     * This method is used to Calculate Tax of products That the customer order it
     * @return double Tax
     */
    public  double calculateTax(){
       
      tax=(totalPrice*0.15);
    
       return tax;
    }

    /**
     * This method is used to add Product to customer cart  
     * @param id of Product want to add to cart 
     * @param qunatity of Product want to add to cart 
     */
    public  void addProduct(String id,int qunatity){
        int counter = 0;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(id) ) {
                this.qunatity.set(i, this.qunatity.get(i) + qunatity);
                counter = 1;
            }
        }
        if (counter == 0) {
            cart.add(id);
            this.qunatity.add(qunatity);
        }
    }
                
    /**
     * This method is used to delete Product from customer cart  
     * @param id of Product want to delete from cart 
     */
    public  void deleteProduct(String id){                
        ProductsClass deleteProduct= findeProdectes(id);
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(id)) {
              deleteProduct.setQuantity(deleteProduct.getQuantity()+qunatity.get(i));
              deleteProduct.setSoldProducts(deleteProduct.getQuantity()-qunatity.get(i));
              cart.remove(i);
              qunatity.remove(i);
                if(deleteProduct.getOffers()!=','){
                    deleteProduct.setOffers(',');
                }  
              }
            
        }
        }
    
    /**
     *
     * @return int
     */
    public int getReceiptNo() {
        return receiptNo;
    }

    /**
     *
     * @param receiptNo
     */
    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    /**
     *
     * @return ArrayList<String> 
     */
    public ArrayList<String> getCart() {
        return cart;
    }

    /**
     *
     * @param cart
     */
    public void setCart(ArrayList<String> cart) {
        this.cart = cart;
    }

    /**
     *
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getQunatity() {
        return qunatity;
    }

    /**
     *
     * @param qunatity
     */
    public void setQunatity(ArrayList<Integer> qunatity) {
        this.qunatity = qunatity;
    }

    /**
     *
     * @return int
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     *
     * @param totalPrice
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     *
     * @return String 
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     *
     * @param orderDate
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     *
     * @return CustomerClass
     */
    public CustomerClass getNewCustomer() {
        return newCustomer;
    }

    /**
     *
     * @param newCustomer
     */
    public void setNewCustomer(CustomerClass newCustomer) {
        this.newCustomer = newCustomer;
    }

    /**
     *
     * @return double
     */
    public double getTax() {
        return tax;
    }

    /**
     *
     * @param tax
     */
    public void setTax(double tax) {
        this.tax = tax;
    }
    
    
}
