package projectt251;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author maryam
 */
public class ApplicationClass {

    /**
     *
     */
    public static  ArrayList<ProductiveFamiliesClass> PFArray = new ArrayList<ProductiveFamiliesClass>();

    /**
     *
     */
    public static  ArrayList<ManagerClass> ManagerArray = new ArrayList<ManagerClass>();

    /**
     *
     */
    public static  ArrayList<ProductsClass> ProductsArray = new ArrayList<ProductsClass>();

    /**
     *
     */
    public static  ArrayList< Character > Offers  = new ArrayList<Character>();
    /**
     * This method is used to search for Specific PF in PFArray by id 
     * @param id of the PF that they wants to search for 
     * @return  ProductiveFamiliesClass This returns search result 
     */
    public static ProductiveFamiliesClass findePF(String id){
        for (int i = 0; i < PFArray.size(); i++) {
            if (PFArray.get(i).getId().equals(id.trim())) {
                return PFArray.get(i);
            }
        }return null;
}
  
    /**
     * This method is used to search for Specific PF in PFArray by name 
     * @param PFname of the PF that they wants to search for 
     * @return ProductiveFamiliesClass This returns search result
     */
    public static ProductiveFamiliesClass findePFByname(String PFname){
     for (int i = 0; i < PFArray.size(); i++) {
            if ((PFArray.get(i).getFirstName()+" "+PFArray.get(i).getLastName()).equals(PFname)) {
                return PFArray.get(i);
              
            }
        } 
     
     return null;
     
     }
  
    /**
     * This method is used to get offers from the Offers Array and put it into StringBuffer to display later to customer
     * @return StringBuffer This returns offers 
     */
    public static StringBuffer browseOffers() {
        StringBuffer offers=new StringBuffer();
        for (int i = 0; i < Offers.size(); i++) {
            if(Offers.get(i)=='A')
               offers.append("A: \n Buy one and get one free\n");
               
            else if(Offers.get(i)=='B')
                 offers.append("B: \n Buy two and get one free\n");
        }
       
        return  offers;      
    }

    /**
     * This method is used to get Products from the Products Array and put it into StringBuffer to display later to customer
     * @param id of the PF that they wants to get their Products 
     * @return StringBuffer This returns Products menu
     */
    public static StringBuffer displayMenu(String id ) {
        ProductiveFamiliesClass PF=findePF(id);
        StringBuffer menu= new StringBuffer();
        ArrayList<ProductsClass>  Products= PF.getProducts();
        
        for (int j = 0; j < Products.size(); j++) {
                    System.out.println(Products.get(j).toString2()); 
                    menu.append(Products.get(j).toString2());
                    menu.append("\n\n");
                    System.out.println(menu.toString());
                }
       return menu;
    }

    /**
     * This method is used to search for Specific Products in ProductsArray by id 
     * @param id of the Products that they wants to search for 
     * @return  ProductsClass This returns search result
     */
    public static  ProductsClass findeProdectes(String id){
       for (int i = 0; i < ProductsArray.size(); i++) {
         if(ProductsArray.get(i).getId().equals(id))
               return ProductsArray.get(i);
       }   
        return null;
    }

    /**
     * This method is used update PF File 
     * @throws IOException 
     */
    public static void updatePfFile() throws IOException{
     BufferedWriter w = new BufferedWriter(new FileWriter("PF.txt"));
         for (int i = 0; i < PFArray.size(); i++) {
            w.append(PFArray.get(i).toString()+"\n"); 
        }
        
    w.close();
    
    
    
    }     

    /**
     * This method is used update Products File
     * @throws IOException
     */
    public static void updateProdectsFile() throws IOException{
        BufferedWriter w = new BufferedWriter(new FileWriter("Prodect.txt"));
         for (int i = 0; i < ProductsArray.size(); i++) {
            w.append(ProductsArray.get(i).toString3()+"\n"); 
        }
        
    w.close();
    
    } 

    /**
     * This method is used read from Products, Manager and PF Files and fill ProductsArray, ManagerArray and PFArray   
     * @throws FileNotFoundException
     */
    public static void readFile( ) throws FileNotFoundException{
        File ManagerFile = new File("Manager.txt");
        Scanner input = new Scanner(ManagerFile);
        File PfFile = new File("PF.txt");
        Scanner input2 = new Scanner(PfFile);
        File ProductsFile = new File("Prodect.txt");
        Scanner input3 = new Scanner(ProductsFile);
        File OffersFile = new File("Offers.txt");
        Scanner input4 = new Scanner(OffersFile);

        String[] inputInfManager = new String[2];
        String[] inputInfPF = new String[8];
        String[] inputInfProdects = new String[8];
        

        String commend = "";

        if (ManagerFile.exists()) {
            while (input.hasNext()) {
                commend = input.nextLine();
                inputInfManager = commend.split(" ");
                ManagerClass newManager = new ManagerClass(inputInfManager[0], inputInfManager[1]);
                ManagerArray.add(newManager);
            }
        }

        if (PfFile.exists()) {
            while (input2.hasNext()) {
                commend = input2.nextLine();
                inputInfPF = commend.split(" ");
                ProductiveFamiliesClass newPF = new ProductiveFamiliesClass(inputInfPF[0],inputInfPF[1],inputInfPF[2], inputInfPF[3], inputInfPF[4], inputInfPF[5], inputInfPF[6], inputInfPF[7]);
                PFArray.add(newPF);
            }
        }

        if (ProductsFile.exists()) {
            while (input3.hasNext()) {
                commend = input3.nextLine();
                inputInfProdects = commend.split(" ");
                ProductsClass newProducts = new ProductsClass(inputInfProdects[0], inputInfProdects[1], inputInfProdects[2],
                        inputInfProdects[3], Integer.valueOf(inputInfProdects[4]),
                        Integer.valueOf(inputInfProdects[5]),Integer.valueOf(inputInfProdects[6]) ,inputInfProdects[7]);
                ProductsArray.add(newProducts);
            }
        }
        
        if (OffersFile.exists()){
            while (input4.hasNext()) {
                commend = input4.nextLine();
                switch (commend.trim()) {
                    case "Buy one and get one free":
                        Offers.add('A');
                        break;
                    case "Buy two and get one free":
                        Offers.add('B');
                        break;

                }
            }} 
        

   }

    /**
     * This is the main method which makes use readFile method 
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
 
      
       readFile();
       //PRINT TO CHECK 
//       for(int i = 0; i < ManagerArray.size(); i++) {   
//          System.out.print(ManagerArray.get(i).toString());
//           System.out.println(" ");
//}  
//       for(int i = 0; i < PFArray.size(); i++) {   
//          System.out.print(PFArray.get(i).toString());
//           System.out.println(" ");
//}  
//       for(int i = 0; i < ProductsArray.size(); i++) {   
//          System.out.print(ProductsArray.get(i).toString());
//           System.out.println(" ");
//}  

//         for (int i = 0; i < Offers.size(); i++) {
//             System.out.println(Offers.get(i));
//        }



        Main1 m=new Main1();
        m.setVisible(true);
        
    }
}
