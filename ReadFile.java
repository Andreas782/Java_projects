/*
 * 
 */
package assignment2;
import java.io.*;
import java.util.*;

/**
 * @author Andreas&Ethan
 */

public class ReadFile {
    
    public void ReadFile(){
        Scanner scan = null;
        
        try{// try catch used to help if the file cannot be found
            File file_data = new File("marks_file.txt");
            scan = new Scanner(file_data); 
            
        }//End of try
        
        catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("in" + System.getProperty("user.dir"));
            System.exit(1);
        }//End of catch  
        
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
        scan.close();//closing the file we are reading
        
    }//End of ReadFile method
}//End of class
