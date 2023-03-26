import java.util.ArrayList;

/**
 * @author JavaDoc
 * Handles CourseList operations.
 */
public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    /**
     * Constructor to initialize course list.
     */
    private CourseList() {
        courseList = new CourseList();
    }

    /**
     * Returns instance of course list.
     * @return Either new instance or previous instance of course list.
     */
    public CourseList getInstance() {
        if (courseList == null)
            return new CourseList();
        return courseList;
    }

    /**
     * Add course to course list.
     * @param course Type Course to add.
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    public void editCourse() {
        //not sure what this means.
    }

    /**
     * Delete course from list.
     * @param course Type Course to delete.
     */
    public void deleteCourse(Course course) {
        courses.remove(course);
    }

    /**
     * Save course list to datawriter.
     */
    public void save() {
        DataWriter writer = new DataWriter();
        writer.saveCourses(courses);
    }

}
