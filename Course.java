import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

/**
 * @author JavaDoc
 * Represents a course in the LMS.
 */
public class Course {
    private String author;
    private String title;
    private String description;
    private String userID;
    private String courseID;
    private Difficulty difficulty;
    private ArrayList<Module> modules;
    private ArrayList<Review> reviews;
    private ArrayList<CourseGrade> courseGrades;
    private ArrayList<Comment> courseComments;

    /**
     * Constructor to initialize a Course.
     * @param author String author of course.
     * @param title String title of course.
     * @param description String of course description.
     * @param userID String of user ID.
     * @param courseID String of course ID.
     * @param difficulty String of difficulty.
     * @param modules ArrayList<Module> of modules.
     * @param reviews ArrayList<Review> of reviews.
     * @param courseGrades ArrayList<CourseGrade> of grades.
     */
    public Course(String author, String title, String description, String userID, String courseID, String difficulty,
            ArrayList<Module> modules, ArrayList<Review> reviews, ArrayList<CourseGrade> courseGrades) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.userID = userID;
        this.courseID = courseID;
        setDifficulty(difficulty);
        this.modules = modules != null ? modules : new ArrayList<Module>();
        this.reviews = reviews != null ? reviews : new ArrayList<Review>();
        this.courseGrades = courseGrades != null ? courseGrades : new ArrayList<CourseGrade>();
        // this.courseComments = courseComments != null ? courseComments : new
        // ArrayList<Comment>(); treated under review
    }

    /**
     * Returns author of the course.
     * @return String of author name.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns title of course.
     * @return String of title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns course description.
     * @return String of description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns difficulty of course.
     * @return String of difficulty.
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /**
     * Returns reviews of course.
     * @return ArrayList<Review> of reviews.
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    /**
     * Returns course grades.
     * @return ArrayList<CourseGrade> of grades.
     */
    public ArrayList<CourseGrade> getCourseGrades() {
        return courseGrades;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Comment> getCourseComments() {
        return courseComments;
    }

    /**
     * Returns course ID.
     * @return String of course ID.
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Returns user id.
     * @return String of user id.
     */
    public String getUser_ID() {
        return this.userID;
    }

    /**
     * Returns modules of course.
     * @return ArrayList<Module>  of modules.
     */
    public ArrayList<Module> getModules() {
        return this.modules;
    }

    /**
     * Sets course ID.
     * @param courseId String of course id.
     */
    public void setCourseID(String courseId) {
        this.courseID = courseId;
    }

    /**
     * Sets to enum difficulty of course.
     * @param difficulty String of difficulty.
     */
    public void setDifficulty(String difficulty){
        if(difficulty.equalsIgnoreCase("Beginner"))
            this.difficulty = Difficulty.Beginner;
        else if(difficulty.equalsIgnoreCase("Intermediate"))
            this.difficulty = Difficulty.Intermediate;
        else if(difficulty.equalsIgnoreCase("Expert"))
            this.difficulty = Difficulty.Expert;
        else  
            this.difficulty = null;
    }

    /**
     * Adds module to list.
     * @param Module Module to add.
     */
    public void addModule(Module module) {
        modules.add(module);
    }
    /**
     * Adds review to list.
     * @param review Review to add.
     */
    public void addReview(Review review) {
        reviews.add(review);
    }

    /**
     * Adds course grade to list.
     * @param grade CourseGrade to add.
     */
    public void addCourseGrade(CourseGrade grade) {
        courseGrades.add(grade);
    }

    /**
     * Adds comment to course comments.
     * @param comment Comment to add.
     */
    public void addComment(Comment comment) {
        courseComments.add(comment);
    }

    /**
     * Displays course modules.
     */
    public void viewModules() {
        for (Module module : modules) 
            System.out.println(module.toString());
    }

    /**
     * Displays course reviews.
     */
    public void viewReviews() {
        for (Review review : reviews) 
            System.out.println(review.toString());
    }

    /**
     * Displays course grades.
     */
    public void viewGrades() {
        for (CourseGrade grade : courseGrades) {
            System.out.println(grade.toString());
        }
    }

    /**
     * Returns string of course attributes.
     * @return String of various course attributes. 
     */
    @Override
    public String toString() {
        return "Course [courseId=" + courseID + ", title=" + title + ", description=" + description + ", modules="
                + modules + ", reviews=" + reviews + ", courseGrades=" + courseGrades + ", difficulty=" + difficulty
                + ", courseComments=" + courseComments + "]";
    }
}
