import java.util.ArrayList;

public class CourseList {
    private CourseList courseList;
    private ArrayList<Course> courses;

    private CourseList() {

    }

    public CourseList getInstance() {
        if (this.courseList == null)
            return new CourseList();
        return this.courseList;
    }

    public void addCourse() {

    }

    public void editCourse() {

    }

    public void deleteCourse() {

    }

    public void save() {

    }

}
