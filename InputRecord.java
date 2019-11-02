/*

 */
package assignment2;

import java.io.*;
import java.util.*;

/**
 *
 * @author B00686845
 */

public class InputRecord {
        File file = new File("Marks_File.txt");
        char comma = ',';
        
     public void InputRecord() throws IOException{
        
        ArrayList<String> recordArray = new ArrayList<>() ;
        Scanner userInput = new Scanner(System.in);
        
        String bCode;
        int mark = 0;
        String record;
        String newRecord;
        
        try{
            
            System.out.println("Please enter the students B code: ");
            bCode = userInput.nextLine();
            
            Scanner scan = new Scanner(file).useDelimiter(",");
            
            while (scan.hasNextLine()) {
                record = scan.nextLine();
                recordArray.add(record);
                }
 
            for (int i = 0; i < recordArray.size(); i++) {
                    String value = recordArray.get(i);
                    if (value.contains(bCode)) {
                        System.out.println("Bcode already appears in the file."
                                + "Please enter a valid Bcode: ");
                        bCode = userInput.nextLine();
                    }
                    else{
                        System.out.println("Valid B code used that is not in the file" +
                        "\n" + "Please enter a mark for that student: " );
                        mark = userInput.nextInt();
                        if (mark<100 && mark>0) {
                            System.out.println("Valid mark entered file updated!"); 
                        }
                    }
            }
                    
            newRecord = bCode + "," + mark;
            System.out.println(newRecord);
            scan.close();
            
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pr = new PrintWriter(bw);
            pr.println(newRecord);
            pr.close();
        }
        
            catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
            }
    }
}
