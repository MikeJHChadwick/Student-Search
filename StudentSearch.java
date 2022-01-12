/**
 * This program demostrates a BinarySearchTree populated with Student objects 
 * @author Michael Chadwick
 * @version 5/13/2020 Final Student Search
 */

import java.io.IOException;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentSearch
{
    private static BinarySearchTree students;

    /**
     * Creates the initial BinarySearchTree and populates it with firve Student objects
     * Then creates and loops a simple GUI prompting the user for input for how they wish
     * to interact with the tree
     * @throw Exception - if passed from a subordinate method
     * @throw IOException - if pased from a subordinate method
     */
    public static void main() throws Exception, IOException
    {
        Scanner in = new Scanner(System.in);
        students = new BinarySearchTree();
        boolean run = true;
        try
        {
            students.add(new Student(5407, "Mike Chadwick", "CIS"));
            students.add(new Student(2281, "Samia Cushing", "BIO"));
            students.add(new Student(8123, "Kyle Shah", "OAC"));
            students.add(new Student(9009, "Salamatu Dumbuya", "GEN"));
            students.add(new Student(0164, "Demetrius Moss", "CIS"));
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        while(run)
        {
            String.format("%8s %-20s %s\n", "ID", "Name", "Major");
            students.print();
            System.out.println("Choose from the options below: ");
            System.out.println("\n1 - add a student\n2 - display a student\n3 - remove a student\n4 - list by major\n5 - exit program\n");
            String choice = in.nextLine();
            try
            {
                /**
                 * After printing the initial menu and tree, we ask what action the user wishes
                 */
                switch(choice)
                {
                    /**
                     * Case 1: The user can add a new student into the tree as long as they
                     * enter in the corresponding data correctly and the ID doesn't already
                     * exist
                     */
                    case "1":
                    Student newStud;
                    while(true)
                    {
                        System.out.println("Add a student - enter student ID: "); 
                        int num = in.nextInt();
                        in.nextLine();
                        newStud = new Student(num);
                        if(students.find(newStud) != null)
                        {
                            System.out.print('\u000C');
                            students.print();
                            System.out.println("This ID already exists.");
                            continue;
                        }
                        break;
                    }
                    while(true)
                    {
                        System.out.println("Enter in the student's name: ");
                        try
                        {
                            newStud.setName(in.nextLine());
                        }
                        catch(Exception ex)
                        {
                            System.out.print('\u000C');
                            students.print();
                            System.out.println(ex.getMessage());
                            continue;
                        }
                        break;
                    }
                    while(true)
                    {
                        System.out.println("Enter in a major: ");
                        try
                        {
                            newStud.setMajor(in.nextLine());
                        }
                        catch(Exception ex)
                        {
                            System.out.print('\u000C');
                            students.print();
                            System.out.println(ex.getMessage());

                            continue;
                        }
                        break;
                    }
                    students.add(newStud);
                    System.out.print('\u000C');
                    break;

                    /**
                     *Case 2: The user can display a student's information from the tree by entering 
                     *a valid ID number
                     */
                    case "2":
                    while(true)
                    {
                        System.out.println("Display a student: ");
                        System.out.println("Enter in a student ID: ");
                        int num = in.nextInt();
                        in.nextLine();
                        Student studFind = new Student(num);
                        studFind = (Student) students.find(studFind); // find returns comparable generic object
                        if( studFind == null)
                        {
                            System.out.print('\u000C');
                            students.print();
                            System.out.println("This ID doesn't exists.");
                            continue;
                        }
                        System.out.print('\u000C');
                        System.out.println(studFind.toString());
                        System.out.println("-------------------");
                        break;
                    }                    
                    break;
                    
                    /**
                     * Case 3: Allows the user to remove a student with the respective
                     * ID number as long as it's a valid number a student in the tree has
                     */
                    case "3":                   
                    while(true)
                    {
                        System.out.println("Enter the student's ID: "); 
                        int num = in.nextInt();
                        in.nextLine();
                        newStud = new Student(num);
                        newStud = (Student) students.find(newStud);
                        if(newStud == null)
                        {
                            System.out.print('\u000C');
                            students.print();
                            System.out.println("This ID doesn't exist.");
                            continue;
                        }
                        students.remove(newStud);
                        System.out.print('\u000C');
                        break;
                    }
                    System.out.print('\u000C');
                    break;
                    
                    /**
                     * Case 4: List all students with the corresponding major as long
                     * as the user enters it correctly and a student in the tree actually
                     * has the major
                     */
                    case "4":
                    while(true)
                    {
                        System.out.println("List students by major: ");
                        String major = new String();
                        major = in.nextLine();                    
                        System.out.print('\u000C');
                        if(major.length() == 3)
                            major = major.toUpperCase();
                        else
                        {
                            System.out.print('\u000C');
                            students.print();
                            System.out.println("The major must be three characters long.\n");
                            continue;
                        }  
                        ArrayList<Object> studList = students.getList();
                        int count = 0;
                        for(int i = 0; i < studList.size(); i ++)
                        {   
                            newStud = ((Student) studList.get(i));
                            if(newStud.getMajor().equals(major))
                            {
                                System.out.println(newStud.toString());
                                count++;
                            }                        
                        }
                        if(count == 0)
                        {
                            students.print();
                            System.out.println("There isn't a student with that major.");
                            continue;
                        }
                        System.out.println("-------------------");
                        break;
                    }
                    break;
                    
                    /**
                     * Case 5: flushes the console then prints the current tree followed
                     * by a prompt stating the termination of the program
                     */
                    case "5": 
                    System.out.print('\u000C');
                    System.out.printf(String.format("%8s %-20s %s\n", "ID", "Name", "Major"));
                    students.print();
                    System.out.println("Program Terminated");
                    run = false;
                    break;
                    
                    /**
                     * Default: If user inputs invalid data, the program flushes the
                     * console and displays an error message
                     */
                    default:
                    System.out.print('\u000C');
                    System.out.println("Invalid input.\n");
                    break;
                }
            }
            catch(Exception ex)
            {
                System.out.print('\u000C');
                System.out.println(ex.getMessage());
            }
        }
    }
}   
