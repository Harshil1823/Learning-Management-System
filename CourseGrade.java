import java.util.ArrayList;

public class CourseGrade {

    private Course course;
    private String userID;
    private double totalGrade;
    private double finalGrade;
    private double quizGrade;
    private ArrayList<Double> moduleGrades;

    public CourseGrade(Course course, String userID, double finalGrade, double quizGrade) {
        this.course = course;
        this.userID = userID;
        this.totalGrade = (this.finalGrade * .80) + (this.quizGrade * .20);
        this.moduleGrades = new ArrayList<Double>();
    }

    public double getTotalGrade() {
        return this.totalGrade;
    }

    public Course getCourse() {
        return this.course;
    }

    public String getUserID() {
        return this.userID;
    }

    public ArrayList<Double> getModuleGrades() {
        return this.moduleGrades;
    }

    public void addModuleGrade(double grade) {
        if (grade >= 0)
            moduleGrades.add(grade);
    }
}
