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
 * 
 */

public class menu {
    
    public static void main(String[] args) throws IOException{
        menu asign = new menu();
        asign.menu();   
    }
    
    public static void div_line()
    {
        // This is used to generate lines that help seperate the text
        System.out.println("----------------------------------------------");
    }
    
    private void menu() throws IOException{
        
        int userChoice;
        Scanner menuChoice = new Scanner(System.in);
        
        ReadFile first = new ReadFile();
        addRecords second = new addRecords();
        EditRecord third = new EditRecord();
        calcRecord fifth = new calcRecord();
        

        System.out.println("1: Load and display records from the file");
        System.out.println("2: Add records to the file");
        System.out.println("3: Edit records in the file");
        System.out.println("4: Delete records from the file");
        System.out.println("5: Display highest, lowest, average of the records");
        System.out.println("6: Close program");
        div_line();
        System.out.println("Please make a selection (1-6): ");
        
        userChoice = menuChoice.nextInt();
    
        if (userChoice !=7){
            switch(userChoice){//Switch statement used as there is 6 options much more efficient than nested if statements

                case 1:
                        first.ReadFile();
                        menu();
                        break;
                case 2:
                        second.addRecords();
                        menu();
                        break;
                case 3: 
                        third.EditRecord();
                        menu();
                        break;
                case 4:
                        //fourth.DeleteRecord();
                        break;
                case 5: 
                        fifth.calcRecord();
                        break;
                case 6:
                        System.out.println("Exiting Program..... Goodbye!");
                        break;
                default:
                    System.out.println("Please choose an option between 1-6");
                    break;

            }//End of switch statement
        }
    }
}//End of Menu method
