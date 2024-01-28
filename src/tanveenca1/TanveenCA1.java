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
        // TODO code application logic here
        try {
            File file = new File("C:\\Users\\tanve\\Desktop\\students.txt");
            Scanner myReader = new Scanner(file);

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

                int numberOfClasses = 0;

                if (lineNumber == 2) {
                    if (data.charAt(0) > '1' && data.charAt(0) <= '8') {
                        numberOfClasses = Character.getNumericValue(data.charAt(0));
                    } else {
                        throw new IllegalArgumentException("Number of classes is not valid");
                    }
                    System.out.println("Number of classes: " + numberOfClasses);
                }

                lineNumber++;
                if (lineNumber > 3) {
                    lineNumber = 1;
                }
//                System.out.println(lastName);
            }
            myReader.close();
        } catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        try {
            File file = new File("C:\\Users\\tanve\\Desktop\\status.txt");

            if (file.createNewFile()) {
                System.out.println("New file created");
            } else {
                System.out.println("already exists");
            }
            
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Testing");
            fileWriter.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

}