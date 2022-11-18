package firstAssessment;

// new class
public class Student {
    // class variables
    public int id;
    public String firstName;
    public String lastName;
    public AssignmentMarks mathMarks;
    public AssignmentMarks englishMarks;

    // class constructor
    public Student(int id, String firstName, String lastName, AssignmentMarks mathMarks, AssignmentMarks englishMarks) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mathMarks = mathMarks;
        this.englishMarks = englishMarks;
    }

    // reurns full name of the student
    public String getFullName() {
        return ("The student's full name: " + this.firstName + " " + this.lastName);
    }
}
