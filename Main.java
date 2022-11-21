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
        mainMenu();
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

    private static void removeStudent(int id) {
        for (Student student : students) {
            if (student.id == id) {
                students.remove(student);
                return;
            }
        }
    }

    private static void displayReportByMarks() {
        writeReportHeader();
        writeReportSeparaterLine();
        for (Student student : students) {
            writeReportLineByMark(student);
        }
    }

    private static void displayReportByGrade() {
        writeReportHeader();
        writeReportSeparaterLine();
        for (Student student : students) {
            writeReportLineByGrade(student);
        }
    }

    private static void writeReportHeader() {
        System.out.println("Id   Name               Maths   A1   A2   A3   Grade   English   A1   A2   A3   Grade");
    }

    private static void writeReportLineByMark(Student student) {
        System.out.print(GetStringOfLength(Integer.toString(student.id), 4));
        System.out.print(GetStringOfLength(student.firstName + " " + student.lastName, 28));
        System.out.print(GetStringOfLength(Integer.toString(student.mathMarks.assignment1), 5));
        System.out.print(GetStringOfLength(Integer.toString(student.mathMarks.assignment2), 5));
        System.out.print(GetStringOfLength(Integer.toString(student.mathMarks.assignment3), 6));
        System.out.print(GetStringOfLength(Integer.toString(student.mathMarks.getAverageMark()), 17));
        System.out.print(GetStringOfLength(Integer.toString(student.englishMarks.assignment1), 5));
        System.out.print(GetStringOfLength(Integer.toString(student.englishMarks.assignment2), 5));
        System.out.print(GetStringOfLength(Integer.toString(student.englishMarks.assignment3), 6));
        System.out.println(student.englishMarks.getAverageMark());
    }

    private static void writeReportLineByGrade(Student student) {
        System.out.print(GetStringOfLength(Integer.toString(student.id), 4));
        System.out.print(GetStringOfLength(student.firstName + " " + student.lastName, 28));
        System.out.print(GetStringOfLength(student.mathMarks.getGrade(1), 5));
        System.out.print(GetStringOfLength(student.mathMarks.getGrade(2), 5));
        System.out.print(GetStringOfLength(student.mathMarks.getGrade(3), 6));
        System.out.print(GetStringOfLength(student.mathMarks.getAverageGrade(), 17));
        System.out.print(GetStringOfLength(student.englishMarks.getGrade(1), 5));
        System.out.print(GetStringOfLength(student.englishMarks.getGrade(2), 5));
        System.out.print(GetStringOfLength(student.englishMarks.getGrade(3), 6));
        System.out.println(student.englishMarks.getAverageGrade());
    }

    private static void writeReportSeparaterLine() {
        System.out.println("------------------------------------------------------------------------------------------");
    }

    private static String GetStringOfLength(String input, int desiredLen) {
        String result = input;
        for (int i = 0; i < desiredLen - input.length(); ++i) {
            result += " ";
        }
        return result;
    }

    private static void displayMenu() {

        System.out.println("\n"
        + "1) Display individual student marks.\n"
        + "2) Display a table of all the student marks, including the marks for both courses as well as the average mark for each course.\n"
        + "3) Display individual student grades.\n"
        + "4) Display a table of all student grades, including the marks for both courses as well as the average grade for each course.\n"
        + "5) Add new student (this should ask the user to input a student information including course marks).\n"
        + "6) Remove student(this should ask the user to input a student ID and subsequently remove the student from the Data Structure).\n"
        + "7) Exit the program (the program should confirm with the user before exiting)");

    }

    private static int selectMenuOption() {
        System.out.print("Enter your choice: ");
        return readInt();
    }

    private static void mainMenu() {
        displayMenu();
        int option = selectMenuOption();
        executeAction(option);
    }
    private static void executeAction (int option) {
        switch (option) {
            case 1:
                displayIndividualStudentByMark();
                break;
            case 2:
                displayReportByMarks();
                break;
            case 3:
                displayIndividualStudentByGrade();
                break;
            case 4:
                displayReportByGrade();
                break;
            case 5:
                System.out.println("Please, enter student information below ");
                displayAddStudent();

                break;
            case 6:
                System.out.println("Please, enter student id to remove this student from the system");
                displayRemoveStudent();
                break;
            case 7:
                Scanner exitMenu = new Scanner(System.in); // confirm app exit
                System.out.println("Are you sure you want to exit?     1. Yes    2. No  ");
                int selectedOption = readInt(); //Reads user input
                if (selectedOption == 1){
                    return;
                }
        }

        mainMenu();
    }

    private static void displayRemoveStudent() {
        System.out.print("Enter student id: ");
        int studentId = readInt();
        removeStudent(studentId);
    }

    private static void displayIndividualStudentByGrade() {
        System.out.print("Enter student id: ");
        int studentId = readInt();
        for (Student student : students) {
            if (student.id == studentId)
            {
                writeReportHeader();
                writeReportSeparaterLine();
                writeReportLineByGrade(student);
                return;
            }
        }
    }


    private static void displayIndividualStudentByMark() {
        System.out.print("Enter student id: ");
        int studentId = readInt();

        for (Student student : students) {
            if (student.id == studentId)
            {
                writeReportHeader();
                writeReportSeparaterLine();
                writeReportLineByMark(student);
                return;
            }
        }
    }

    private static void displayAddStudent() {
        System.out.print("Enter student id: ");
        int id = readInt();
        System.out.print("Enter student first name: ");
        String firstName = readWord();
        System.out.print("Enter student last name: ");
        String lastName = readWord();
        System.out.print("Enter math mark 1: ");
        int math1 = readInt();
        System.out.print("Enter math mark 2: ");
        int math2 = readInt();
        System.out.print("Enter math mark 3: ");
        int math3 = readInt();
        System.out.print("Enter english mark 1: ");
        int english1 = readInt();
        System.out.print("Enter english mark 2: ");
        int english2 = readInt();
        System.out.print("Enter english mark 3: ");
        int english3 = readInt();

        addNewStudent(id, firstName, lastName, math1, math2, math3, english1, english2, english3);
    }

    private static int readInt() {
        Scanner myInput = new Scanner( System.in );
        return myInput.nextInt();
    }

    private static String readWord() {
        Scanner myInput = new Scanner( System.in );
        return myInput.next();
    }
}

