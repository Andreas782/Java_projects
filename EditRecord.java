/*
*/
package assignment2;

import java.io.*;
import java.util.*;

/*
 * @author Andreas
*/

public class EditRecord {
    File file = new File("marks_file.txt");
    ArrayList<String> recordArray = new ArrayList<>() ;
    
    public void ReadFile() throws IOException {
        String record;
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                record = scan.nextLine();
                recordArray.add(record);
            }
            scan.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
    }
    
    public void EditRecord() throws IOException {
        ReadFile();
        Scanner userInput = new Scanner(System.in);
        String bCode;
        String newBcode;
        int mark;
        String option;
        String newRecord;

            System.out.println("Please enter the students B code: ");
            bCode = userInput.nextLine();

                for (int i = 0; i < recordArray.size(); i++) {
                    String value = recordArray.get(i);
                    
                    if (value.contains(bCode)) {
                        
                        System.out.println("Valid Bcode record in the file." +
                                "\n" + "Do you want to modify this record? (Y/N)" );
                    
                        option = userInput.nextLine().toUpperCase();
                        
                        if (option.equals("Y")) {
                            System.out.println("Enter the new Bcode: ");
                            newBcode = userInput.nextLine();
                            System.out.println("Enter the new mark: ");
                            mark = userInput.nextInt();
                            newRecord = newBcode + "," + mark;
                            recordArray.set(recordArray.indexOf(value),newRecord);
                        }
                    }
                }
        PrintFile();
    }
    
    public void PrintFile() throws FileNotFoundException{
        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < recordArray.size(); i++){
                String value = recordArray.get(i);
                writer.println(value);
            }
            writer.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
    }
}
