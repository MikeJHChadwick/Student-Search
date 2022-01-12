/**
 * Thic class creates objects of the Student type
 *
 * @author Michael Chadwick
 * @version 5/13/2020 Final Student Search
 */

import java.lang.Exception;
import java.lang.String;

public class Student implements Comparable<Student>
{
    private int studId;
    private String studName;
    private String studMajor;
    
    /**
     * Constructs a Student object with default values
     */
    public Student()
    {
        studId = 0;
        studName = " ";
        studMajor = " ";
    }
    
    /**
     * Constructor for objects of class Student
     * @param studId - the student ID to be used in the search
     */
    public Student(int studId)
    {
        this.studId = studId;
        this.studName = " ";
        this.studMajor = " ";
    }
    
    /**
     * Constructor for Student object with parameter values
     * @param studId - the student's ID
     * @param studName - the student's name
     * @param studMajor - the student's major
     * @throw Exception - passed on from Student set methods
     */
    public Student(int studId, String studName, String studMajor) throws Exception
    {
        setId(studId);
        setName(studName);
        setMajor(studMajor);
    } 
    
    /**
     * Gets the cards type
     * @return studId - returns the student's ID number
     */
    public int getId()
    {
        return this.studId;
    }
    
    /**
     * Sets the student's ID number
     * @pram studId - sets the student's ID number
     * @throw Exception - chekcs that the Student object if it alreadys has a number
     * and that it's greater than zero
     */
    public void setId(int studId) throws Exception
    {
        if(studId > 0)
            if(this.studId == 0)
                this.studId = studId;
            else
                throw new Exception("The student ID already exists.\n");
        else
            throw new Exception("Student's ID must be greater than zero.\n");
    }
    
    /**
     * Gets the student's name
     * @return studName - returns the student's name
     */
    public String getName()
    {
        return this.studName;
    }
    
    /**
     * Sets the student's Name
     * @param studName - sets the student's name
     * @throw Exception = if the name is blank
     */
    public void setName(String studName) throws Exception
    {
        if(studName == null)
            throw new Exception("A name must be provided.\n");
        studName = studName.trim();
        if(studName.length() > 0)
            this.studName = studName;
        else
            throw new Exception("A name must be provided.\n");
    }
    
    /**
     * Gets the student's major
     * @return getMajor - returns the student's major
     */
    public String getMajor()
    {
        return this.studMajor;
    }
    
    /**
     * Sets the student's major
     * @param studMajor - sets the student's major
     * @throw Exception - if it does'nt meet the minimum length
     */
    public void setMajor(String studMajor) throws Exception
    {
        studMajor = studMajor.trim();
        if(studMajor.length() == 3)
            this.studMajor = studMajor.toUpperCase();
        else
            throw new Exception("The major must be three characters long.\n");
    }
    
    /**
     * Overrides the standard compareTo method offered by Object to get the proper output 
     * for our subclass Student object
     * Compares two Student objects for proper sequencing in our BinarySearchTree
     * @param otherObject - which is a Student object to compare with the host Student object
     * @return - a integer representing the difference between the two objects
     */
    @Override
    public int compareTo(Student otherStudent)
    {
        return studId - otherStudent.studId;
    }
    
    /**
     * Overrides the standard toString method offered by Object to get the proper output 
     * for our subclass Student object
     * @return String - returns all the variable's associated to a student formatted to readability
     */
    @Override
    public String toString()
    {
        return String.format("%8d %-20s %s\n", studId, studName, studMajor); 
    }
}
