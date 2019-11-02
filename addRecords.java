/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.io.*;
import java.util.*;
/**
 *
 * @author Andreas&Ethan
 */
public class addRecords
{
    File file_data = new File ("marks_file.txt");
    ArrayList<String> studentRecords = new ArrayList<>() ;

public void ReadFile() throws IOException {
        String record;
        try (Scanner scan = new Scanner(file_data)) {
            while (scan.hasNextLine()) {
                record = scan.nextLine();
                studentRecords.add(record);
            }
            scan.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
    }
    
    public void addRecords() throws IOException {
        ReadFile();
        Scanner userInput = new Scanner(System.in);
        String studentCode;
        int mark;
        String newRecord;

        System.out.println("Please enter a students B code you wish to add: ");
        studentCode = userInput.nextLine();

            for (String curVal: studentRecords) {
                

                if (curVal.contains(studentCode)) 
                {
                    System.out.println("Student code already exists in the file" +
                            "\n" + "Please enter a valid B code: " );
                    studentCode = userInput.nextLine().toUpperCase();

                    System.out.println("Enter the new mark: ");
                    mark = userInput.nextInt();
                    newRecord = studentCode + "," + mark;
                    studentRecords.add(newRecord);
                }
                else
                {
                    System.out.println("Pleaes enter the mark for the new record: ");
                    mark = userInput.nextInt();
                    if (mark<=100 && mark>=0) 
                    {
                        System.out.println("Valid mark entered file updated!");
                        newRecord = studentCode + "," + mark;
                        studentRecords.add(newRecord);
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid mark entered please try again: ");
                        mark = userInput.nextInt();
                        newRecord = studentCode + "," + mark;
                        studentRecords.add(newRecord);
                    }
                }
                }
            PrintFile();
    }
        
  
    public void PrintFile() throws FileNotFoundException{
        try (PrintWriter writer = new PrintWriter(file_data)) {
            for (int i = 0; i < studentRecords.size(); i++){
                String value = studentRecords.get(i);
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
