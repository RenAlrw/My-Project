
package projectt251;

import java.io.IOException;
import java.util.ArrayList;
import static projectt251.ApplicationClass.*;

/**
 *
 * @author maryam
 */
public class ManagerClass extends StaffClass{
  
    /**
     *
     */
    public ManagerClass(){
     }

    /**
     *
     * @param id of the Manager 
     * @param pass of the Manager
     */
    public ManagerClass(String id, String pass) {
        super(id, pass);
    }

    /**
     * This method is used to add new PF to PFArray and call updatePfFile() method 
     * @param newPF new PF want to add 
     * @return boolean to confirm the addition 
     * @throws IOException
     */
    public static boolean modifyPFADD(ProductiveFamiliesClass newPF) throws IOException {
       PFArray.add(newPF);
       updatePfFile();
       return true;
     }

    /**
     *  This method is used to delete  PF from PFArray and call updatePfFile() method 
     * @param id of PF want to delete 
     * @return boolean to confirm the delete 
     * @throws IOException
     */
    public static boolean modifyPFDelet(String id) throws IOException{
        for (int i = 0; i < PFArray.size(); i++) {
            if (PFArray.get(i).getId().equals(id.trim())) {
                PFArray.remove(i);
                 updatePfFile();
                 return true;
                
            }
        }
        return false;
    }

    /**
     * This method is used to generate Report about Products 
     * @return StringBuffer This returns Report  
     */
    public static StringBuffer  generatReport(){
     StringBuffer report=new StringBuffer();
         for (int i = 0; i < ProductsArray.size(); i++) {
           report.append(ProductsArray.get(i).toString());
           report.append("\n\n");
         }
    
     
     return report;
     }
     
    /**
     * This method is used to delete Products from ProductsArray and call updateProdectsFile() method
     * @param id of new Product want to Delete
     * @return boolean to confirm the Delete
     * @throws IOException
     */
    public static boolean modifyMenuDelet(String id ) throws IOException{
        for (int i = 0; i < ProductsArray.size(); i++) {
            if (ProductsArray.get(i).getId().equals(id.trim())) {
                ProductsArray.remove(i);
                updateProdectsFile();
                return true;
            }
        }
        return false;
}
    
    /**
     * This method is used to add new Products to ProductsArray and call updateProdectsFile() method 
     * @param newProducts new Products want to added 
     * @return boolean to confirm the addition
     * @throws IOException
     */
    public static boolean modifyMenuADD(ProductsClass newProducts) throws IOException{
    ProductsArray.add(newProducts);
    updateProdectsFile();
        return true;    
        
   
}

    /**
     * This method is used to check of exist of PF in the PFArray 
     * @param id of PF want to verified 
     * @return boolean check status 
     */
    public static boolean checkExitPF(String id){
        for (int i = 0; i < PFArray.size(); i++) {
            if (PFArray.get(i).getId().equals(id.trim())) {
                return true;
            }
        }

        return false;  
    
    
    }

    /**
     * This method is used to check of exist of Products in the ProductsArray 
     * @param id of Products want to verified 
     * @return boolean check status 
     */
    public boolean checkExitProdect( String id) {
        for (int i = 0; i < ProductsArray.size(); i++) {
            if (ProductsArray.get(i).getId().equals(id.trim())) {
               
                return true;
            }
        }

        return false;  
    }    
}
