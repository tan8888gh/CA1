/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tanveenca1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author tanve
 */
public class TanveenCA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\tanve\\Desktop\\students.txt");
            Scanner myReader = new Scanner(file);

            /*Line Number will be used to check the current line in the students.txt file 
              and to check if the line contains the valid data according to assignment rules*/
            int lineNumber = 1;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("Currenly on Line number " + lineNumber + " Data: " + data);
                String[] names = data.split(" ");
                
                if (lineNumber == 1) {
                    System.out.println("Student Name");
                    String firstName = names[0];
                    char[] firstNameArr = firstName.toCharArray();
                    for (int i = 0; i < firstNameArr.length; i++) {
                        if (!Character.isLetter(firstNameArr[i])) {
                            throw new IllegalArgumentException("Not valid first name");
                        }
                    }
                    System.out.println("FirstName: " + firstName);

                    String lastName = names[1];
                    char[] lastNameArr = lastName.toCharArray();
                    for (int i = 0; i < lastNameArr.length; i++) {
                        if (!Character.isLetter(lastNameArr[i])) {
                            throw new IllegalArgumentException("Not valid last name");
                        }
                    }
                    System.out.println("Last Name: " + lastName);
                }
                lineNumber++;
                if (lineNumber > 3) {
                    lineNumber = 1;
                }
            }
            myReader.close();
        } catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}
