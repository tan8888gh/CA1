/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tanveenca1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author tanve
 */
public class TanveenCA1 {

    private static List<Student> studentsList;
    //GitHub Link: https://github.com/tan8888gh/CA1.git
    public static void main(String[] args) {
        studentsList = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\tanve\\Desktop\\students.txt");
            Scanner myReader = new Scanner(file);

            /*Line Number will be used to check the current line in the students.txt file 
              and to check if the line contains the valid data according to assignment rules*/
            int lineNumber = 1;
            int currentStudentIndex = 0;
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                System.out.println("Currently on Line number " + lineNumber + " Data: " + data);
                String[] names = data.split(" ");

                //Checks if the line number is 1 and if it is 1 it saves the first and last names in the new student
                if (lineNumber == 1) {
                    Student student = new Student();

                    System.out.println("Student Name");
                    String firstName = names[0];
                    //this logic is validating input by using java built in methods
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

                    student.setFirstName(firstName);
                    student.setLastName(lastName);

                    studentsList.add(student);
                }

                int numberOfClasses;
                //Checks if the line number is 2 and if it is 2 it gets the current student object and set number of classes in it
                if (lineNumber == 2) {
                    //this logic is comparing ASCII code with characters from string
                    if (data.charAt(0) >= '1' && data.charAt(0) <= '8') {
                        numberOfClasses = Character.getNumericValue(data.charAt(0));
                    } else {
                        throw new IllegalArgumentException("Number of classes is not valid");
                    }
                    System.out.println("Number of classes: " + numberOfClasses);
                    studentsList.get(currentStudentIndex).setNumberOfClasses(numberOfClasses);
                }

                //Checks if the line number is 3 and if it is 3 it gets the current student object and set student id in it
                if (lineNumber == 3) {
                    if (data.length() < 6) {
                        throw new IllegalArgumentException("Invalid data, Student id length less than 6 characters");
                    }
                    if (!Character.isDigit(data.charAt(0)) || !Character.isDigit(data.charAt(1))) {
                        throw new IllegalArgumentException("Invalid data Student id has first two characters other than numbers");
                    }
                    //characters validation using java built in method Character.isLetter()
                    if (!Character.isLetter(data.charAt(2))
                            || !Character.isLetter(data.charAt(3))
                            || !Character.isLetter(data.charAt(4))) {
                        throw new IllegalArgumentException("Invalid data, Student id has 3,4 or 5 character being not a letter");
                    }
                    char[] dataCharArray = data.toCharArray();
                    for (int i = 5; i < dataCharArray.length; i++) {
                        if (!Character.isDigit(dataCharArray[i])) {
                            throw new IllegalArgumentException("Invalid data, Student id has a character other than number after 5th character");
                        }
                    }
                    System.out.println("Student Id" + data);
                    studentsList.get(currentStudentIndex).setStudentId(data);
                }

                lineNumber++;
                //this logic is used to reset the line number so our program creates a new student every time
                //we process 3 lines
                if (lineNumber > 3) {
                    currentStudentIndex++;
                    lineNumber = 1;
                }
            }
            myReader.close();
        } catch (IllegalArgumentException exc) { //this prints the exception to show useful message to the user
            System.out.println(exc.getMessage());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        
        //File Writing Part
        try {
            File file = new File("C:\\Users\\tanve\\Desktop\\status.txt");

            if (file.createNewFile()) {
                System.out.println("New file created");
            }
            FileWriter fileWriter = new FileWriter(file);
            //Iterating through each student in the list and printing the output in required format
            for (Student student : studentsList) {
                fileWriter.write(student.getStudentId() + "-" + student.getLastName() + "\n");
                switch (student.getNumberOfClasses()) {
                    case 1:
                        fileWriter.append("Very Light" + "\n");
                        break;
                    case 2: 
                        fileWriter.append("Light" + "\n");
                        break;
                    case 3: 
                    case 4:
                    case 5:
                        fileWriter.append("Part Time" + "\n");
                        break;
                    default: 
                        fileWriter.append("Full Time" + "\n");
                        break;
                }
            }
            fileWriter.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}
