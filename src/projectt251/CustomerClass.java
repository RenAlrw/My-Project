package projectt251;

/**
 *
 * @author maryam
 */
public class CustomerClass {
  private String phoneNo ;
  private String name ;
  private String email;
  private  String address;

    /**
     *
     * @param phoneNo of customer 
     * @param name of customer 
     * @param email of customer 
     * @param address of customer 
     */
    public CustomerClass(String phoneNo, String name, String email, String address) {
        this.phoneNo = phoneNo;
        this.name = name;
        this.email = email;
        this.address = address;
    }
  
 
  CustomerClass(){
      
  }

    /**
     *
     * @return String
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     *
     * @param phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     *
     * @return String
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
     * @return String
     */
    public String getEmail() {
        return email;
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
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
  
     /**
     * This method is used to verify the Phone Number  
     * @param number wants to verified 
     * @return boolean of check statues 
     */
    public boolean checkPhoneNumber(String number) {
      int count=0;
         for (int i = 0; i < number.length(); i++) {
              char a = number.charAt(i);
              if(Character.isLetter(a))
               count++;
         }
         if(number.length()==10 && count==0 &&  number.charAt(0)=='0' && number.charAt(1)=='5')
             return true; 
        else
           return false;    
}}