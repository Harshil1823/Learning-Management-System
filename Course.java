import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author JavaDoc
 *         Represents a course in the LMS.
 */
public class Course {
    private String author;
    private String title;
    private String description;
    private String userID;
    private String courseID;
    private Difficulty difficulty;
    private static Scanner keyboard = new Scanner(System.in);
    private boolean completed;
    private ArrayList<Module> modules;
    private ArrayList<Review> reviews;
    private ArrayList<CourseGrade> courseGrades;
    private ArrayList<Comment> courseComments;

    /**
     * Constructor to initialize a Course.
     * 
     * @param author       String author of course.
     * @param title        String title of course.
     * @param description  String of course description.
     * @param userID       String of user ID.
     * @param courseID     String of course ID.
     * @param difficulty   String of difficulty.
     * @param modules      ArrayList<Module> of modules.
     * @param reviews      ArrayList<Review> of reviews.
     * @param courseGrades ArrayList<CourseGrade> of grades.
     */
    public Course(String author, String title, String description, String userID, String courseID, String difficulty,
            ArrayList<Module> modules, ArrayList<Review> reviews, ArrayList<CourseGrade> courseGrades) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.userID = userID;
        this.courseID = courseID;
        this.completed = false;
        setDifficulty(difficulty);
        this.modules = modules != null ? modules : new ArrayList<Module>();
        this.reviews = reviews != null ? reviews : new ArrayList<Review>();
        this.courseGrades = courseGrades != null ? courseGrades : new ArrayList<CourseGrade>();
        this.courseComments = new ArrayList<Comment>();
    }

    /**
     * Returns author of the course.
     * 
     * @return String of author name.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns title of course.
     * 
     * @return String of title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns course description.
     * 
     * @return String of description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns difficulty of course.
     * 
     * @return String of difficulty.
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /**
     * Returns reviews of course.
     * 
     * @return ArrayList<Review> of reviews.
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    /**
     * Returns course grades.
     * 
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
     * 
     * @return String of course ID.
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Returns user id.
     * 
     * @return String of user id.
     */
    public String getUser_ID() {
        return this.userID;
    }

    /**
     * Returns modules of course.
     * 
     * @return ArrayList<Module> of modules.
     */
    public ArrayList<Module> getModules() {
        return this.modules;
    }

    /**
     * Sets course ID.
     * 
     * @param courseId String of course id.
     */
    public void setCourseID(String courseId) {
        this.courseID = courseId;
    }

    /**
     * Sets to enum difficulty of course.
     * 
     * @param difficulty String of difficulty.
     */
    public void setDifficulty(String difficulty) {
        if (difficulty.equalsIgnoreCase("Beginner"))
            this.difficulty = Difficulty.Beginner;
        else if (difficulty.equalsIgnoreCase("Intermediate"))
            this.difficulty = Difficulty.Intermediate;
        else if (difficulty.equalsIgnoreCase("Expert"))
            this.difficulty = Difficulty.Expert;
        else
            this.difficulty = null;
    }

    /**
     * Adds module to list.
     * 
     * @param Module Module to add.
     */
    public void addModule(Module module) {
        modules.add(module);
    }

    /**
     * Adds review to list.
     * 
     * @param review Review to add.
     */
    public void addReview(Review review) {
        reviews.add(review);
    }

    /**
     * Adds course grade to list.
     * 
     * @param grade CourseGrade to add.
     */
    public void addCourseGrade(CourseGrade grade) {
        courseGrades.add(grade);
    }

    /**
     * Adds comment to course comments.
     * 
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

    // taking a course
    public void takeCourse() {
        System.out.println();
        System.out.println("Welcome to this " + title + " course!");

        System.out.println("Please read course description: ");
        System.out.println(description);

        System.out.println("Please choose a uncompleted module to take. (Enter number)");
        for (int i = 1; i <= modules.size(); i++) {
            System.out.print(i + ". ");
            System.out.print(modules.get(i - 1).getTitle());
            if ((modules.get(i - 1).getCompleted()))
                System.out.println(" (Completed) ");
            else
                System.out.println();
        }
        int choice = keyboard.nextInt();
        keyboard.nextLine();

        if (modules.get(choice - 1).getCompleted()) {
            System.out.println("Module already completed.");
            return;
        }

        System.out.println("Great choice, here is the module description!");
        System.out.println(modules.get(choice - 1).getDescription());

        // goes through topics and shows title and description.
        int i = 1;
        while (true) {
            System.out.println("Here is topic " + i + " and the description!");
            System.out.println(modules.get(choice - 1).getTopics().get(i - 1).getTitle());
            System.out.println(modules.get(choice - 1).getTopics().get(i - 1).getDescription());

            if (modules.get(choice - 1).getTopics().get(i) != null) {
                System.out.println("Press c to continue to next topic, otherwise press q to quit.");
                String decision = keyboard.next();

                if (decision.equalsIgnoreCase("q")) {
                    break;
                }
            } else {
                break;
            }
            i++;
        }

        System.out.println("Now that you have looked at the material, would you like to take the module quiz?");
        System.out.println("Enter yes or no");
        String take_quiz = keyboard.next();

        if (take_quiz.equalsIgnoreCase("yes")) {
            // implement taking quiz and harshil rocket after
            // implement a completed for course if all modules are compelted
        } else {
            System.out.println("Okay come back when your ready!");
        }
    }

    public void displayDetails() {
        System.out.println();
        System.out.println("Course Details:");
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Modules:");

        if (modules.size() == 0) {
            System.out.println("- No modules.");
        } else {
            for (Module module : modules) {
                module.displayDetails();
            }
        }

        System.out.println("Reviews:");
        if (this.reviews.size() == 0) {
            System.out.println("No reviews.");
        } else {
            for (Review review : reviews) {
                System.out.println("- " + "Rating: " + review.getRating() + " Review: " + review.getText());
            }
        }

        System.out.println("Course Grades:");

        if (courseGrades.size() == 0) {
            System.out.println("No course grades.");
        } else {
            for (CourseGrade grade : courseGrades) {
                System.out.println("- " + grade.getTotalGrade());
            }
        }

        System.out.println("Course Comments:");
        if (courseComments.size() == 0) {
            System.out.println("No comments.");
        } else {
            for (Comment comment : courseComments) {
                System.out.println("- " + comment.getText());
            }
        }
    }

}
