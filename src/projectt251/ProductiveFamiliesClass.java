
package projectt251;

import java.util.ArrayList;
import static projectt251.ApplicationClass.*;

/**
 *
 * @author maryam
 */
public class ProductiveFamiliesClass extends StaffClass{
  private String firstName;
  private String lastName;
  private String email;
  private String address;
  private String birthDate;
  private String sex;

    /**
     * 
     * @param id of ProductiveFamilie
     * @param firstName of ProductiveFamilie
     * @param lastName of ProductiveFamilie
     * @param pass of ProductiveFamilie
     * @param email of ProductiveFamilie
     * @param address of ProductiveFamilie
     * @param birthDate of ProductiveFamilie
     * @param sex of ProductiveFamilie
     */
    public ProductiveFamiliesClass(String id,String firstName,String lastName, String pass,String email, String address, String birthDate, String sex) {
        super(id, pass);
        this.firstName=firstName;
        this.lastName=lastName;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    /**
     * 
     */
    public ProductiveFamiliesClass() {
    }
  
    /**
     * This method is used to get all the information of Products of PF and put it into StringBuffer and display later to PF as Query
     * @return This return Query 
     */ 
    public  StringBuffer displayQuery(){
     StringBuffer Query =new StringBuffer();
     ArrayList<ProductsClass> PFProductsArray =getProducts(); 
       for (int i = 0; i < PFProductsArray.size(); i++) {
           Query.append(PFProductsArray.get(i).getName()+"\t"+PFProductsArray.get(i).getId()+"\t"+(PFProductsArray.get(i).getQuantity()-PFProductsArray.get(i).getSoldProducts())+"\t\t\t"+PFProductsArray.get(i).getSoldProducts());
           Query.append("\n\n\n");
         }
    
     return Query;
    }
    
    /**
     * This method is used to get all the Products of PF 
     * @return This return Products 
     */
    public  ArrayList<ProductsClass> getProducts(){
      ArrayList<ProductsClass> PFProductsArray = new ArrayList<ProductsClass>();
        for (int i = 0; i < ProductsArray.size(); i++) {
            if(ProductsArray.get(i).getPFid().equals(super.getId()))
               PFProductsArray.add(ProductsArray.get(i));
        }
    
    return PFProductsArray;
    }
    
    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     *
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @return
     */
    public String getSex() {
        return sex;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.getId()+" "+ firstName + " " + lastName + " " +super.getPass()+" " + email + " " + address + " " + birthDate + " " + sex ;
    }

   

}
