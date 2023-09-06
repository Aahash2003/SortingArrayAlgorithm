package Q2;

import java.util.Collections;
import java.util.Vector;

public class StudentGrade implements Comparable<StudentGrade>{
    public static void main(String[]args){
        header(2,2,"Aahash Srikumar", 251225561,"Print the sorted and unsorted arrays using vector");
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny",
                "Draco", "Dean", "Fred"};// filling the array
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood",
                "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26)};// randomizing the values for the array

        Vector<StudentGrade> sg = new Vector<>();

        for(int i = 0; i< fnArray.length; i++) {// inputting the three type objects into the student grade variable
            sg.add(new StudentGrade(fnArray[i], lnArray[i], grd[i]));
        }
        System.out.println("The Unsorted Array ................");
        System.out.printf("%s\b\n",sg.toString());
        Collections.sort(sg, StudentGrade::compareTo);//comparing the grades
        System.out.println("Sorted by Grades......................");
        System.out.println(sg.toString()+"\b");
        StudentGrade [] a = new StudentGrade[fnArray.length];// making a new array
        sg.copyInto(a);//copying the new array
insertionSort(a,1);//calling the method
        System.out.println("Sorted by First Names .............");
       printArray(a);//calling print array
       insertionSort(a,2);//choosing between the first and last name using the val parameter
        System.out.println("Sorted by Last Names .............");
       printArray(a);
       footer("Aahash", 2,2);
    }//instantiating the variables
    private String firstName;
    private String lastName;
    private int grade;
    public StudentGrade(){

    }
    public StudentGrade(String fN, String lN, int g){
        firstName= fN;
        lastName=lN;
        grade = g;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public int getGrade() {
        return grade;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(StudentGrade b) {//comparing the grades
      int rv =0;
      if(this.grade>b.grade)
          rv =1;
      else if (this.grade<b.grade)
          rv =-1;
      else
          rv =0;
      return rv;
    }

    @Override
    public String toString() {
        return String.format("\b\b%12s %8s   :   %4d\n\b\b",firstName,lastName,grade);

    }
    public static void printArray(StudentGrade [] a){//printing the array out using tostring
        for(int i =0; i<a.length; i++){
            System.out.printf("%s",a[i].toString());
        }
        System.out.println();
    }
    public static <T extends Comparable<? super T>> void insertionSort(StudentGrade[] a, int val) {
        int n = a.length;
        if(val == 1) {//if parameter equals 1 first name comparison if equal to 2 last name comparison
            for (int i = 1; i < n; i++) {//comparing the first name is descending order
                int key = i;
                while (key > 0 && (a[key - 1].getFirstName().compareTo(a[key].getFirstName()) > 0)) {
                    StudentGrade temp = a[key];
                    a[key] = a[key - 1];
                    a[key - 1] = temp;
                    key--;
                }
            }
        }
            else{
            for (int i = 1; i < n; i++) {
                int key = i;
                while (key > 0 && (a[key - 1].getLastName().compareTo(a[key].getLastName()) > 0)) {
                    StudentGrade temp = a[key];
                    a[key] = a[key - 1];
                    a[key - 1] = temp;
                    key--;
                }
            }
            }
        }

    public static void header(int number, int question, String name, int SD, String explanation) {
        System.out.println("===================================================================");
        System.out.printf(" Lab Exercise %d,Q%d \n Prepared By: %s \n Student Number: %d \n Goal of this Exercise: %s\n", number,question, name, SD, explanation);
        System.out.println("===================================================================");
    }

    public static void footer(String name, int lab, int q) {
        System.out.println("===================================================================");
        System.out.printf("Completion of Lab Assignment %d, %d is successful!\nSigning Off - %s\n", lab,q, name);
        System.out.println("===================================================================");
    }
}
