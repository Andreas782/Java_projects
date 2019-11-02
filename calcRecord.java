/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.*;
import java.io.*;

/**
 * @author Andreas & Ethan
 */

public class calcRecord {
    File file_data = new File("marks_file.txt");
    ArrayList<String> studentRecords = new ArrayList<>();
    
    public void calcRecord() throws IOException
    {
        readFile();
        double average;
        String studentCode;
        String markString;
        int mark;
        int total = 0;
        int count = 0;
        
        for (int i = 0; i<studentRecords.size(); i++)
        {
            String value = studentRecords.get(i);
            studentCode = value.substring(0,6);
            markString = value.substring(6+1,value.length());
            mark = Integer.parseInt(markString);
            total += mark;
            count++;
        }
        average = total/count;
        System.out.println(average);
    }
    public void readFile() throws IOException {
        String record;
        try (Scanner scan = new Scanner(file_data).useDelimiter(",")) {
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
     
}
