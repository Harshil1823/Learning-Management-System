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

    /**
     * Returns course by title. If not found returns null.
     * @param title Course title to search for.
     * @return Course with same title. Otherwise null.
     */
    public Course getCourseByTitle(String title){
        for(Course course: courses)
            if(title.equalsIgnoreCase(course.getTitle()))
                return course;
        return null;
            
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
        DataWriter.saveCourses(courses);
    }

    /**
     * Displays courses in list.
     */
    public void viewCourses(){
        for(Course course: courses)
            System.out.println(course.getTitle());
    }
}
