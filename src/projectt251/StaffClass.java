
package projectt251;

import java.util.ArrayList;
import static projectt251.ApplicationClass.ManagerArray;
import static projectt251.ApplicationClass.PFArray;

/**
 *
 * @author maryam
 */
public class StaffClass {
    private String id ;
    private String pass ;

    /**
     *
     */
    public StaffClass() {
    }

    /**
     *
     * @param id
     * @param pass
     */
    public StaffClass(String id, String pass) {
        this.id = id;
        this.pass = pass;
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
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
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
     * @return
     */
    public String getPass() {
        return pass;
    }
    
    /**
     * This method is used to verify the Pass and ID of Staff
     * @param id of the Staff that they wants to verify it 
     * @param pass of the Staff that they wants to verify it
     * @return
     */
    public static boolean  login(String id,String pass){
         if ((id.charAt(0) + "" + id.charAt(1)).equals("18")) {
             for (int i = 0; i < ManagerArray.size(); i++) {
                 if (ManagerArray.get(i).getId().equals(id) && ManagerArray.get(i).getPass().equals(pass)) {
                     return true;
                 }
             }
             return false;
         } else if ((id.charAt(0) + "" + id.charAt(1)).equals("19")) {
             for (int i = 0; i < PFArray.size(); i++) {
                 if (PFArray.get(i).getId().equals(id) && PFArray.get(i).getPass().equals(pass)) {
                     return true;
                 }
             }
             return false;
         } else {
             return false;
         }
         
    
     }

    
     
}
