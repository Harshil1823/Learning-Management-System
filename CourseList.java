import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author JavaDoc
 *         Handles CourseList operations.
 */
public class CourseList {
    private static Scanner keyboard = new Scanner(System.in);
    private static CourseList courseList;
    private ArrayList<Course> courses = new ArrayList<>();

    /**
     * Constructor to initialize course list.
     */
    private CourseList() {
    }

    /**
     * Returns instance of course list.
     * 
     * @return Either new instance or previous instance of course list.
     */
    public static CourseList getInstance() {
        if (courseList == null)
            return new CourseList();
        return courseList;
    }

    /**
     * Add course to course list.
     * 
     * @param course Type Course to add.
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Returns course by title. If not found returns null.
     * 
     * @param title Course title to search for.
     * @return Course with same title. Otherwise null.
     */
    public Course getCourseByTitle(String title) {
        for (Course course : courses)
            if (title.equalsIgnoreCase(course.getTitle()))
                return course;
        return null;

    }

    /**
     * Delete course from list.
     * 
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
    public void viewCourses() {
        for (Course course : courses)
            System.out.println(course.getTitle());
    }

    /**
     * Enrolls the user in course using the title of the course
     * if the user is already enrolled then it checks for it
     * if course isn't valid then it says course not found
     * 
     * @param user  - takes the user object
     * @param title - takes the title of the course and checks if it's in course
     *              list
     * @return - true if the user is enrolled and false if not
     */
    public boolean enrollInCourse(User user, String title) {
        Course course = getCourseByTitle(title);
        if (course == null) {
            System.out.println("Course not found.");
            return false;
        }
        if (user.getCourses().contains(course)) {
            // System.out.println("You are already enrolled in this course.");
            return false;
        }
        user.addCourse(course);
        // System.out.println("You have successfully enrolled in " + course.getTitle() +
        // ".");
        return true;
    }

    public void createCourse(User user) {

        System.out.println("Please enter the title of the course.");
        String title = keyboard.next();

        System.out.println("Please enter the description of the course.");
        String description = keyboard.nextLine();
        keyboard.nextLine();

        System.out.println("Please enter the difficulty of the course.");
        String difficulty = keyboard.next();

        boolean moduleLoop = true;
        ArrayList<Module> modules = new ArrayList<>();
        ArrayList<Topic> topics;
        Module module;
        while (moduleLoop) {
            moduleLoop = false;
            System.out.println("Would you like to create a module. \"Y\" to create module. Otherwise, \"N\"");
            String choice = keyboard.next();
            keyboard.nextLine();
            topics = new ArrayList<>();

            // if creating module
            if (choice.equalsIgnoreCase("y")) {

                System.out.println("Please enter the title of module.");
                String module_title = keyboard.nextLine();
                keyboard.nextLine();

                System.out.println("Please enter the description of module.");
                String module_description = keyboard.nextLine();
                keyboard.nextLine();

                System.out.println("How many topic(s) will be in this module?");
                int topic_count = keyboard.nextInt();
                keyboard.nextLine();

                // topic creation
                for (int i = 0; i < topic_count; i++) {
                    System.out.println("Please enter the topic title for topic " + i + ".");
                    String topic_title = keyboard.nextLine();
                    keyboard.nextLine();

                    System.out.println("Please enter the topic description for topic " + i + ".");
                    String topic_description = keyboard.nextLine();
                    keyboard.nextLine();

                    Topic topic = new Topic(topic_title, topic_description);
                    topics.add(topic);
                }

                moduleLoop = true;
                module = new Module(module_title, module_description, topics, new ArrayList<Question>(),
                        new ArrayList<Comment>(), new ArrayList<ModuleGrade>());
                modules.add(module);
            }

        }
        ArrayList<Review> reviews = new ArrayList<>();
        ArrayList<CourseGrade> courseGrades = new ArrayList<>();
        // module creation!!!


        // created course
        Course course = new Course(user.getFirstName() + " " + user.getLastName(), title, description, user.getUserID(),
                UUID.randomUUID().toString(), difficulty, modules, reviews, courseGrades);
        courseList.addCourse(course);
    }
}
