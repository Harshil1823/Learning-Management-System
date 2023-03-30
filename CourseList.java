import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.time.LocalDate;
import java.io.*;

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
    CourseList() {
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
     * checks if it's in bounds and userCan
     * choose a couse
     * 
     * @param index
     * @return
     */
    public Course getCourse(int index) {
        if (index >= 0 && index < courses.size()) {
            return courses.get(index);
        }
        return null;
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
        for (int i = 1; i <= courses.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(courses.get(i - 1).getTitle());
        }
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
    /*
     * public boolean enrollInCourse(User user) {
     * viewCourses();
     * System.out.println("Please enter course title to enroll in.");
     * String title = keyboard.nextLine();
     * 
     * Course course = getCourseByTitle(title);
     * if (course == null) {
     * System.out.println("Course not found.");
     * return false;
     * }
     * if (user.getCourses().contains(course)) {
     * System.out.println("You are already enrolled in this course.");
     * return false;
     * }
     * user.addCourse(course);
     * System.out.println("You have successfully enrolled in " + course.getTitle() +
     * ".");
     * return true;
     * }
     */

    /**
     * Can do things such as creating module,
     * topics, quiz, and tests
     * @param user (author is the user in this case and has the ability to create a course)
     * @return - returns the course that Author just created
     */
    public Course createCourse(User user) {

        System.out.println("Please enter the title of the course.");
        String title = keyboard.next();
        keyboard.nextLine();

        System.out.println("Please enter the description of the course.");
        String description = keyboard.nextLine();

        System.out.println("Please enter the difficulty of the course.");
        String difficulty = keyboard.next();
        keyboard.nextLine();

        boolean moduleLoop = true;
        ArrayList<Module> modules = new ArrayList<>();
        ArrayList<Topic> topics;
        ArrayList<Question> question_arr;
        Module module;
        while (moduleLoop) {
            moduleLoop = false;
            System.out.println("Would you like to create a module. \"Y\" to create module. Otherwise, \"N\"");
            String choice = keyboard.next();
            keyboard.nextLine();
            topics = new ArrayList<>();
            question_arr = new ArrayList<>();
            String module_title = "";
            String module_description = "";

            // if creating module
            if (choice.equalsIgnoreCase("y")) {

                System.out.println("Please enter the title of module.");
                module_title = keyboard.nextLine();

                System.out.println("Please enter the description of module.");
                module_description = keyboard.nextLine();

                System.out.println("How many topic(s) will be in this module?");
                int topic_count = keyboard.nextInt();
                keyboard.nextLine();

                // topic creation
                for (int i = 1; i <= topic_count; i++) {
                    System.out.println("Please enter the topic title for topic " + i + ".");
                    String topic_title = keyboard.nextLine();

                    System.out.println("Please enter the topic description for topic " + i + ".");
                    String topic_description = keyboard.nextLine();

                    Topic topic = new Topic(topic_title, topic_description);
                    topics.add(topic);
                }

                moduleLoop = true;

                System.out.println("How many questions would you like to add to module?");
                int questions = keyboard.nextInt();
                keyboard.nextLine();

                String questionText = "";
                int correct = 0;
                ArrayList<String> choice_arr;

                for (int i = 1; i <= questions; i++) {
                    choice_arr = new ArrayList<>();
                    // question creation
                    System.out.println("Please enter a question " + i + " for module.");
                    questionText = keyboard.nextLine();

                    System.out.println("How many choices do you want for this question?");
                    int choices = keyboard.nextInt();
                    keyboard.nextLine();

                    for (int j = 1; j <= choices; j++) {
                        System.out.println("Please enter choice " + j);
                        choice_arr.add(keyboard.nextLine());
                    }

                    System.out.println("Which number choice is correct choice?");
                    correct = keyboard.nextInt();
                    keyboard.nextLine();

                    Question question = new Question(questionText, choice_arr, correct - 1);
                    question_arr.add(question);

                }

                module = new Module(module_title, module_description, topics, question_arr,
                        new ArrayList<Comment>(), new ModuleGrade());
                modules.add(module);
            }

        }
        ArrayList<Review> reviews = new ArrayList<>();
        // module creation!!!

        // created course
        Course course = new Course(user.getFirstName() + " " + user.getLastName(), title, description, user.getUserID(),
                UUID.randomUUID().toString(), difficulty, modules, reviews);
        user.getCreatedCourses().add(course);
        return course;
    }
    /**
     * lets the author go back to the course they created 
     * and then asks them what would you like you edit, add, and remove
     * @param user - Author can edit the course that they created
     */
    public void editCourse(User user) {
        if (user.getCreatedCourses().size() == 0) {
            System.out.println("You haven't created any courses to edit.");
            return;
        }
        System.out.println("Which course would you like to edit? (Enter number)");

        for (int i = 1; i <= user.getCreatedCourses().size(); i++) {
            System.out.print(i + ". ");
            System.out.println(user.getCreatedCourses().get(i - 1).getTitle());
        }

        int choice = keyboard.nextInt();
        keyboard.nextLine();
        Course edit_course = user.getCreatedCourses().get(choice - 1);

        System.out.println("How would you like to edit this course? (Enter number)");
        System.out.println("1. Edit module");
        System.out.println("2. Remove module");
        System.out.println("3. Add module");

        Module edit_module;
        choice = keyboard.nextInt();

        // MODULE EDITING CHOICE
        if (choice == 1) {
            System.out.println("Which module would you like to choose from?");

            for (int i = 1; i <= edit_course.getModules().size(); i++) {
                System.out.print(i + ". ");
                System.out.println(edit_course.getModules().get(i - 1).getTitle());
            }

            choice = keyboard.nextInt();
            keyboard.nextLine();

            // module to edit
            edit_module = edit_course.getModules().get(choice - 1);

            System.out.println("How would you like to edit this module?");
            System.out.println("1. Add question");
            System.out.println("2. Add topic");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            String questionText = "";
            int correct = 0;
            ArrayList<String> choice_arr = new ArrayList<>();

            // add question
            if (choice == 1) {
                // question creation
                System.out.println("Please enter a question for module.");
                questionText = keyboard.nextLine();

                System.out.println("How many choices do you want for this question?");
                int choices = keyboard.nextInt();
                keyboard.nextLine();

                for (int j = 1; j <= choices; j++) {
                    System.out.println("Please enter choice " + j);
                    choice_arr.add(keyboard.nextLine());
                }

                System.out.println("Which number choice is correct choice?");
                correct = keyboard.nextInt();
                keyboard.nextLine();

                Question question = new Question(questionText, choice_arr, correct - 1);
                edit_module.addQuestion(question);

                System.out.println("Question added!");

            }

            else if (choice == 2) {
                // topic creation
                ArrayList<Topic> topics = new ArrayList<>();
                System.out.println("Please enter the topic title for topic.");
                String topic_title = keyboard.nextLine();

                System.out.println("Please enter the topic description for topic.");
                String topic_description = keyboard.nextLine();

                Topic topic = new Topic(topic_title, topic_description);
                topics.add(topic);
            } else {
                System.out.println("Invalid choice.");
                return;
            }
        }
        // module remove
        else if (choice == 2) {
            System.out.println("Which module would you like remove? (Enter number)");

            for (int i = 1; i <= edit_course.getModules().size(); i++) {
                System.out.print(i + ". ");
                System.out.println(edit_course.getModules().get(i - 1).getTitle());
            }

            int module_choice = keyboard.nextInt();
            keyboard.nextLine();

            edit_course.getModules().remove(module_choice - 1);
            System.out.println("Module removed");
        }
        // module adding
        else if (choice == 3) {

            System.out.println("Please enter the title of module.");
            String module_title = keyboard.nextLine();

            System.out.println("Please enter the description of module.");
            String module_description = keyboard.nextLine();

            System.out.println("How many topic(s) will be in this module?");
            int topic_count = keyboard.nextInt();
            keyboard.nextLine();

            ArrayList<Topic> topics = new ArrayList<>();
            // topic creation
            for (int i = 1; i <= topic_count; i++) {
                System.out.println("Please enter the topic title for topic " + i + ".");
                String topic_title = keyboard.nextLine();

                System.out.println("Please enter the topic description for topic " + i + ".");
                String topic_description = keyboard.nextLine();

                Topic topic = new Topic(topic_title, topic_description);
                topics.add(topic);
            }

            System.out.println("How many questions would you like to add to module?");
            int questions = keyboard.nextInt();
            keyboard.nextLine();

            String questionText = "";
            int correct = 0;
            ArrayList<String> choice_arr = new ArrayList<>();
            ArrayList<Question> question_arr = new ArrayList<>();
            for (int i = 1; i <= questions; i++) {
                // question creation
                System.out.println("Please enter a question " + i + " for module.");
                questionText = keyboard.nextLine();

                System.out.println("How many choices do you want for this question?");
                int choices = keyboard.nextInt();
                keyboard.nextLine();

                for (int j = 1; j <= choices; j++) {
                    System.out.println("Please enter choice " + j);
                    choice_arr.add(keyboard.nextLine());
                }

                System.out.println("Which number choice is correct choice?");
                correct = keyboard.nextInt();
                keyboard.nextLine();

                Question question = new Question(questionText, choice_arr, correct - 1);
                question_arr.add(question);

            }

            Module module = new Module(module_title, module_description, topics, question_arr,
                    new ArrayList<Comment>(), new ModuleGrade());
            edit_course.getModules().add(module);
        } else {
            System.out.println("Invalid choice");
            return;
        }
    }
    /**
     * 
     * @param user (student) checks if they are enrolled in any course
     * and if so then it prints out which courses they are enrolled in 
     * if not then it prints you aren't enrolled in any courses
     */
    public void displayEnrolledCourses(User user) {
        if (user.getCourses().size() <= 0) {
            System.out.println("You aren't enrolled in any courses");
            return;
        } else {
            for (int i = 1; i <= user.getCourses().size(); i++) {
                System.out.print(i + ". ");
                System.out.print(user.getCourses().get(i - 1).getTitle());
                if (user.getCourses().get(i - 1).getCompletion()) {
                    System.out.println(" (Completed) ");
                } else {
                    System.out.println(" (Enrolled) ");
                }
            }
        }

        System.out.println();
        System.out.println("Would you like to print a certificate of completion for a course? ");
        System.out.println("Enter yes or no");

        String choice = keyboard.next();
        keyboard.nextLine();
        System.out.println();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Please enter course number to print.");
            int number = keyboard.nextInt();
            if (user.getCourses().get(number - 1).getCompletion()) {
                printCertificate(user, user.getCourses().get(number - 1));
            } else {
                System.out.println("You haven't completed this course.");
            }
        }
    }
    /**
     * student can comment on moudles and 
     * courses
     * @param user (student can comment on a course)
     */
    public void courseComment(User user) {
        System.out.println("Would you like to leave a module or course comment?");
        System.out.println("Enter module or course");
        String choice = keyboard.next();
        keyboard.nextLine();

        if (choice.equalsIgnoreCase("course")) {
            viewCourses();
            System.out.println("Choose course to comment on. (Enter number)");

            int pick = keyboard.nextInt();
            keyboard.nextLine();

            System.out.println("Please enter your comment.");
            String reply = keyboard.nextLine();
            Comment comment = new Comment(user.getFirstName() + " " + user.getLastName(), reply);
            courses.get(pick - 1).addComment(comment);
            System.out.println("Comment added");
        } else if (choice.equalsIgnoreCase("module")) {
            viewCourses();
            System.out.println("Choose course to view modules on. (Enter number)");
            int pick = keyboard.nextInt();
            keyboard.nextLine();

            System.out.println("Choose module to comment on. (Enter number");
            for (int i = 1; i <= courses.get(pick - 1).getModules().size(); i++) {
                System.out.print(i + ". ");
                System.out.println(courses.get(pick - 1).getModules().get(i - 1).getTitle());
            }

            int module_comment = keyboard.nextInt();
            keyboard.nextLine();

            System.out.println("Please enter your comment.");
            String reply = keyboard.nextLine();
            Comment comment = new Comment(user.getFirstName() + " " + user.getLastName(), reply);
            courses.get(pick - 1).getModules().get(module_comment - 1).addComment(comment);
            System.out.println("Comment added");

        }
    }
    /**
     * @param user (student) can review a course
     * asks what would you like to give from  1 - 10
     * and asks user behind the rating they gave
     */
    public void courseReview(User user) {
        System.out.println("Which course would you like to leave a review on?");
        viewCourses();

        int choice = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Please enter rating 1 - 10 of course.");
        String rating = keyboard.next();
        keyboard.nextLine();

        System.out.println("Please enter the reason behind this rating.");
        String text = keyboard.nextLine();

        Review review = new Review(user.getUserID(), text, rating, LocalDate.now().toString());

        courses.get(choice - 1).addReview(review);
        System.out.println("Review added");
    }
    /**
     * Prints Title, descirpiton, course details
     * reviews, and comments about the course
     */
    public void getCourseDetails() {
        System.out.println();
        System.out.println("Which course would you like to learn details about?");
        viewCourses();
        int choice = keyboard.nextInt();
        keyboard.nextLine();

        courses.get(choice - 1).displayDetails();

    }
    /**
     * prints certificate signed by the author that user has completed the course
     * @param user - student
     * @param course - passes in the course that they are taking
     */
    public void printCertificate(User user, Course course) {
        if (!course.getCompletion())
            return;
        try {
            FileWriter fileWriter = new FileWriter("certificate.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Write certificate text to file
            printWriter.println("Certificate of Completion");
            printWriter.println("-------------------------");
            printWriter.println("");
            printWriter.printf("This is to certify that " + user.getFirstName() + " " + user.getLastName()
                    + " has completed the course named " + course.getTitle());

            // Close the file
            printWriter.close();
            System.out.println("Certificate printed to certificate.txt");
        } catch (IOException e) {
            System.out.println("Error: could not print certificate to file");
            e.printStackTrace();
        }
    }
    /**
     * enrolls the user in which course they would like to take
     * @param user
     * @throws InterruptedException
     */
    public void takeCourse(User user) throws InterruptedException {
        System.out.println("Which course would you like to take?");
        viewCourses();

        int choice = keyboard.nextInt();
        user.getCourses().add(courses.get(choice - 1)); // enroll user in course
        courses.get(choice - 1).takeCourse();
    }
    /**
     * Prints the course material and modules to a file
     */
    public void printCourseToFile() {
        System.out.println("Please choose a course to print material from. (Enter number) ");
        viewCourses();
        int number = keyboard.nextInt();
        keyboard.nextLine();
        for (int i = 1; i <= courses.get(number - 1).getModules().size(); i++) {
            System.out.print(i + ". ");
            System.out.println(courses.get(number - 1).getModules().get(i - 1).getTitle());
        }
        System.out.println();
        System.out.println("Please choose a module to print material from. (Enter number) ");
        int module_choice = keyboard.nextInt();
        keyboard.nextLine();
        courses.get(number - 1).getModules().get(module_choice - 1).printModuleToFile();

    }
    /**
     * 
     * @param user - has to be student
     * asks user to reply on a comment
     * and then stores the comment
     */
    public void courseReply(User user) {
        System.out.println("Which course do you want to leave a reply to comment on?");
        viewCourses();

        int choice = keyboard.nextInt();
        keyboard.nextLine();

        ArrayList<Module> modules = courses.get(choice - 1).getModules();
        System.out.println("Which module comments do you want to look at?");
        for (int i = 1; i <= modules.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(modules.get(i - 1).getTitle());
        }

        int module = keyboard.nextInt();
        keyboard.nextLine();

        Module mod = modules.get(module - 1);
        System.out.println("Which comment do you want to reply too?");
        for (int i = 1; i <= mod.getComments().size(); i++) {
            System.out.print(i + ". ");
            System.out.println(mod.getComments().get(i - 1).getText());
        }

        int reply = keyboard.nextInt();
        keyboard.nextLine();

        Comment comment = mod.getComments().get(reply - 1);

        comment.reply();
    }
}
