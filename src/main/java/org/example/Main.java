package org.example;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int nStudents = sc.nextInt();
        sc.nextLine();
        ArrayList<String> topStudents = new ArrayList<>();
        int[] gradeCounts = {0,0,0,0,0};
        double topGrade = 0.0;
        double totalScore = 0.0;


        for (int i = 0; i < nStudents; i++){
            System.out.print("Enter name of student " + (i+1) + ": ");
            String name = sc.nextLine();
            System.out.print("Enter score for " + name + ": ");
            int score = sc.nextInt();
            sc.nextLine();

            totalScore+=score;

            if (score > topGrade){
                topGrade = score;
                topStudents.add(name + " (" + score + ") ");
            }
            else if (score == topGrade) {
                topStudents.add(name + " (" + score + ") ");
            }

            char grade = ScoreToGrade(score);
            System.out.println(name + " got grade: " + grade);
            System.out.println();

            switch(grade){
                case 'A': gradeCounts[0]++; break;
                case 'B': gradeCounts[1]++; break;
                case 'C': gradeCounts[2]++; break;
                case 'D': gradeCounts[3]++; break;
                case 'F': gradeCounts[4]++; break;
            }
        }

        System.out.println("----- Class Summary -----");
        System.out.printf("Average Score: %.2f\n", (totalScore/nStudents));
        System.out.println("Grade Counts: A:" + gradeCounts[0] + " B:" + gradeCounts[1] + " C:" + gradeCounts[2] + " D:" + gradeCounts[3] + " F:" + gradeCounts[4]);
        System.out.print("Top Student(s): ");
        for (String top: topStudents) System.out.print(top + " ");
    }

    public static char ScoreToGrade (int score){
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        else return 'F';
    }
}
