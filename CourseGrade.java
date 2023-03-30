import java.util.ArrayList;

/**
 * @author JavaDoc
 * Represents grade for course.
 */
public class CourseGrade {

    private Course course;
    private String userID;
    private double totalGrade;
    private ArrayList<Module> modules;

    /**
     * Constructor to initialize CourseGrade.
     * @param course Type Course of course.
     * @param userID Type String of userID.
     */
    public CourseGrade(Course course, double totalGrade, String userID) {
        this.course = course;
        this.userID = userID;
        this.totalGrade = getTotalGrade();
        this.modules = course.getModules();
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
        for(int i = 0; i < modules.size(); i++)
            total += modules.get(i).getModuleGrade();
        total = total / modules.size();
        return total;
    }

    /**
     * Returns module grades.
     * @return Type ArrayList<ModuleGrade> of module grades.
     */
    public ArrayList<Module> getModules() {
        return this.modules;
    }


}
