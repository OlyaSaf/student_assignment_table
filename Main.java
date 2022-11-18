package firstAssessment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// new class
public class Main {
        private static ArrayList<Student> students = new ArrayList<Student>();

        public static void main(String[] args) {
                readFile("Students.txt");
        }

        public static boolean readFile(String fileName) {
                try {

                        File file = new File(fileName);

                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                                String[] words = scanner.nextLine().split(",");

                                Student student = new Student(Integer.parseInt(words[0]), words[1], words[2],
                                                new AssignmentMarks("Mathematics",
                                                                Integer.parseInt(words[3]),
                                                                Integer.parseInt(words[4]),
                                                                Integer.parseInt(words[5])),
                                                new AssignmentMarks("English",
                                                                Integer.parseInt(words[6]),
                                                                Integer.parseInt(words[7]),
                                                                Integer.parseInt(words[8])));

                                students.add(student);

                        }
                        scanner.close();
                        return true;
                } catch (FileNotFoundException e) {
                        System.out.println("Failed to read file");
                        return false;
                }
        }

        private static void addNewStudent(int id, String firstName, String lastName, int mathMark1, int mathMark2,
                        int mathMark3, int englishMark1, int englishMark2, int englishMark3) {
                students.add(new Student(id, firstName, lastName,
                                new AssignmentMarks("Mathematics", mathMark1, mathMark2, mathMark3),
                                new AssignmentMarks("English", englishMark1, englishMark2, englishMark3)));

        }

        private static void displayReportByMarks() {
                for (Student student : students) {
                        writeReportLine(student);
                }
        }

        private static void writeReportHeader() {
                System.out.println("Id   Name        Maths   A1   A2   A3   Grade   English   A1   A2   A3   Grade");
        }

        private static void writeReportLine(Student student) {
                System.out.print(student.id);
                System.out.print(student.getFullName());
                System.out.print(student.mathMarks.assignment1);
                System.out.print(student.mathMarks.assignment2);
                System.out.print(student.mathMarks.assignment3);
                System.out.print(student.mathMarks.getAverageMark());
                System.out.print(student.englishMarks.assignment1);
                System.out.print(student.englishMarks.assignment2);
                System.out.print(student.englishMarks.assignment3);
                System.out.println(student.englishMarks.getAverageMark());
        }

        private static void writeReportSeparaterLine() {
                System.out.println("-------------------------------------------------------------------------------");
        }

}
