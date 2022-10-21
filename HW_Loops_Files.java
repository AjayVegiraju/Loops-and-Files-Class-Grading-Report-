package com.company;
import java.io.*;
import java.util.*;

public class HW_Loops_Files {

    public static void main(String[] args){
        int courseNumber;            // Number of the course
        Scanner inputFile = null;    // File containing data (p. 297        //     in Savitch discusses null)

        // ... code assigning inputFile in a try/catch statement
        try {
            inputFile = new Scanner(new FileInputStream("courseData.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File you are trying to reach has not been found");
        }

        // following block is to read weights of each grade type in
        String globalWeights = inputFile.nextLine();
        Scanner globalWeight = new Scanner(globalWeights);
        final double programsWeight = globalWeight.nextDouble();
        final double midtermWeight = globalWeight.nextDouble();
        final double finalWeight = globalWeight.nextDouble();


    //following for loop is for outputting
    //class number, Headings and class average and repeating the while loop
    //until it reaches a non-integer or blank line
    //(until there are no more classes)
        for (;inputFile.hasNextInt() && inputFile.hasNextLine();)
        {
            courseNumber= inputFile.nextInt();
            System.out.println("Grade Data For Class "+courseNumber+"\n");
            System.out.println(" ID   Programs  Midterm  Final " +
                    " Weighted Average  Programs grade\n" +
                    " --   --------  -------  -----  " +
                    "----------------  --------------");
        inputFile.nextLine();//there is a blank line somewhere in the txt file
                            //and this is to account for that

        int studentCount=0;//to keep track of student count for class average
        double total = 0;/*to keep track of total weighted
                           average for class average*/


    /*following while loop is to read and output all class data for each class
    one at a time*/
            while (inputFile.hasNextLine())
            {
                String line = inputFile.nextLine();


        //following if statement is to break when the while loop reaches a 0

                if(!line.equals("0")){
                    String passFail;
                    Scanner classData = new Scanner(line);
                    int studentNumber = classData.nextInt();
                    int programScore= classData.nextInt();
                    int midtermScore= classData.nextInt();
                    int finalScore = classData.nextInt();
                    if(programScore>=70){
                        passFail="Pass";
                    }else{
                        passFail="Fail";
                    }

                    double weightedAverage=(programsWeight*programScore) +
                        (midtermWeight*midtermScore) +
                            (finalWeight*finalScore);

                    total= weightedAverage+total;

                    System.out.print(studentNumber+"     "+
                            programScore+"       "
                            +midtermScore+"      "+finalScore+"         ");
                    System.out.printf("%2.2f",weightedAverage);
                    System.out.print("        "+passFail);

                    studentCount++;
                }else{

                    break;
                }
                System.out.println();



            }

            //following calculation and output is the class average
            double classAverage = total/studentCount;
            System.out.printf("Class Average:  %2.2f\n\n",classAverage);
           // testAvg(total,studentCount);

        }
        inputFile.close();
    }

    //method to see the total of weightedAvg and StudentCount
    //it is called at the very end of the for loop
    public static void testAvg(double total, int studentCount){
        System.out.println(total);
        System.out.println(studentCount);
    }

}



