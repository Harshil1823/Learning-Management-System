import java.util.ArrayList;

/**
 * @author JavaDoc
 * Represents grade for course.
 */
public class CourseGrade {

    private Course course;
    private String userID;
    private double totalGrade;
    private ArrayList<ModuleGrade> moduleGrades;

    /**
     * Constructor to initialize CourseGrade.
     * @param course Type Course of course.
     * @param userID Type String of userID.
     */
    public CourseGrade(Course course,double totGrade, String userID) {
        this.course = course;
        this.userID = userID;
        this.totalGrade = getTotalGrade();
        if (moduleGrades == null)
            moduleGrades = new ArrayList<ModuleGrade>();
    }

    /**
     * Returns course.
     * @return Type Course of course.
     */
    public Course getCourse() {
        return this.course;
    }

    /**
     * Returns user id.
     * @return String of user id.
     */
    public String getUserID() {
        return this.userID;
    }

    /**
     * Calculates total grade and returns it.
     * @return double of course grade.
     */
    public double getTotalGrade() {
        double total = 0;
        for(int i = 0; i < moduleGrades.size(); i++)
            total += moduleGrades.get(i).getTotalGrade();
        total = total / moduleGrades.size();
        return total;
    }

    /**
     * Returns module grades.
     * @return Type ArrayList<ModuleGrade> of module grades.
     */
    public ArrayList<ModuleGrade> getModuleGrades() {
        return this.moduleGrades;
    }

    /**
     * Adds modulegrade to list.
     * @param moduleGrade Type ModuleGrade to add.
     */
    public void addModuleGrade(ModuleGrade moduleGrade) {
        moduleGrades.add(moduleGrade);
    }

}
