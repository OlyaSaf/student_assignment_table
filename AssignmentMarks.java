package firstAssessment;

//new class contains course name and assignment marks
public class AssignmentMarks {
    String courseName;
    int assignment1, assignment2, assignment3;

    String[] grades = { "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D" };
    int[] gradeMarks = { 95, 90, 85, 80, 75, 70, 60, 50, 41, 0 };

    // class constructor
    public AssignmentMarks(String name, int mark1, int mark2, int mark3) {

        courseName = name;
        assignment1 = mark1;
        assignment2 = mark2;
        assignment3 = mark3;
    }

    // sets marks to the assignments
    public void setMark(int assignmentNumber, int mark) {
        if (mark < 0 || mark > 100) {
            System.out.println("Error!");
            return;
        }
        if (assignmentNumber < 1 || assignmentNumber > 3) {
            System.out.println("Error!");
            return;
        }
        if (assignmentNumber == 1) {
            assignment1 = mark;
        } else if (assignmentNumber == 2) {
            assignment2 = mark;
        } else if (assignmentNumber == 3) {
            assignment3 = mark;
        }
    }

    // returns mark
    public int getMark(int assignmentNumber) {

        if (assignmentNumber < 1 || assignmentNumber > 3) {
            System.out.println("Error!");
            return -1;
        }
        if (assignmentNumber == 1) {
            return assignment1;
        } else if (assignmentNumber == 2) {
            return assignment2;
        }
        return assignment3;
    }

    // calculates and returns average mark
    public int getAverageMark() {
        int averageMark = (assignment1 + assignment2 + assignment3) / 3;
        return averageMark;
    }

    // returns grade
    public String getGrade(int assignmentNumber) {

        int mark = getMark(assignmentNumber);
        return markToGrade(mark);
    }

    // reterns average grade
    public String getAverageGrade(int assignmentNumber) {
        int averageMark = getAverageMark();
        return markToGrade(averageMark);

    }

    private String markToGrade(int mark) {

        for (int i = 0; i < gradeMarks.length; i++) {
            if (gradeMarks[i] < mark)
                return grades[i];
        }

        return grades[grades.length - 1];
    }

    public void setCourseName(String name) {
        courseName = name;
    }

    public String getCourseName() {
        return courseName;
    }

}
