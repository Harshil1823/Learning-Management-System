import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * @author JavaDoc
 *         Represents a course module.
 */
public class Module {
    private String title;
    private String description;
    private boolean completed;
    private ArrayList<Topic> topics;
    private ArrayList<Question> questions;
    private ArrayList<Comment> comments;
    private ModuleGrade moduleGrade;

    private static Scanner keyboard = new Scanner(System.in);

    /**
     * Constructor to initalize a module.
     * 
     * @param title        String of module title.
     * @param description  String of module description.
     * @param topics       ArrayList<Topic> of topics that module contains.
     * @param questions    ArrayList<Question> of questions that module contains.
     * @param comments     ArrayList<Comment> of comments about module.
     * @param moduleGrades ArrayList<ModuleGrade> containing grades of different
     *                     modules.
     */
    public Module(String title, String description, ArrayList<Topic> topics, ArrayList<Question> questions,
            ArrayList<Comment> comments, ModuleGrade moduleGrade) {
        this.title = title;
        this.description = description;
        this.topics = topics;
        this.questions = questions;
        this.comments = comments;
        this.moduleGrade = moduleGrade;
    }

    /**
     * Returns title of module.
     * 
     * @return String of module title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns description of module.
     * 
     * @return String of module description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Returns whether all questions in this instance of the quiz have been completed.
     * @return true if all questions have been completed, false otherwise
     */
    public boolean getCompleted() {
        completed = true;

        for (Question question : questions) {
            if (!question.getCompleted())
                completed = false;
        }
        return completed;
    }
    /**
     * sets completed to whatever boolean value
     * you pass in
     * @param t
     */
    public void setCompleted(boolean t) {
        completed = t;
    }

    /**
     * Returns module topics.
     * 
     * @return ArrayList<Topic> of module topics.
     */
    public ArrayList<Topic> getTopics() {
        return topics;
    }

    /**
     * Returns module questions.
     * 
     * @return ArrayList<Question> of module questions.
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * Returns module comments.
     * 
     * @return ArrayList<Comment> of module comments.
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Returns module grades.
     * 
     * @return ArrayList<ModuleGrade> of module grades.
     */
    public double getModuleGrade() {
        return moduleGrade.getFinalGrade();
    }

    /**
     * Sets module title.
     * 
     * @param title String of module title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets module description.
     * 
     * @param description String of module description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets module topics.
     * 
     * @param topics ArrayList<Topic> of module topics.
     */
    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    /**
     * Sets module questions.
     * 
     * @param questions ArrayList<Question> of module questions.
     */
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    /**
     * Sets module comments.
     * 
     * @param comments ArrayList<Comment> of module coments.
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Sets module grades.
     * 
     * @param moduleGrades ArrayList<ModuleGrade> of module grades.
     */
    public void setModuleGrades(ModuleGrade moduleGrades) {
        this.moduleGrade = moduleGrades;
    }

    /**
     * Adds comment to comment list.
     * 
     * @param comment Type Comment.
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * Adds topic to topic list.
     * 
     * @param topic Type Topic.
     */
    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    /**
     * Adds question to questions list.
     * 
     * @param question Type Question.
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * Creates comment and adds to list.
     * 
     * @param userID String of user ID.
     * @param text   String of the comment text.
     */
    public void addComment(String userID, String text) {
        Comment comment = new Comment(userID, text);
        addComment(comment);
    }

    /**
     * Creatss question and adds to list.
     * 
     * @param questionText  String of question.
     * @param choices       ArrayList<String> of choices.
     * @param correctChoice String of the correct choice.
     */
    public void addQuestion(String questionText, ArrayList<String> choices, int correctChoiceIndex) {
        Question question = new Question(questionText, choices, correctChoiceIndex);
        addQuestion(question);
    }

    /**
     * Creates a topic and adds to list.
     * 
     * @param title       String of topic title.
     * @param description String of topic description.
     */
    public void addTopic(String title, String description) {
        Topic topic = new Topic(title, description);
        addTopic(topic);
    }

    /**
     * Allows user to take the module quiz.
     * 
     * @return
     * @throws InterruptedException
     */
    public double takeQuiz() throws InterruptedException {
        double ret = 0;
        for (Question question : questions) {
            if (question.answerQuestion()) {
                ret += 1;
            }
        }

        System.out.println("You got " + (int) ret + " / " + questions.size() + " questions correct.");

        animateRocketShip();
        ret = ret / (double) questions.size();
        ret = (int)(ret * 100);
        moduleGrade.addQuizGrade(ret);
        return ret;
    }
    /**
     * prints out detials about 
     * course such as description, module, quiz, and 
     * comments, etc..
     */
    public void displayDetails() {
        System.out.println(" -" + title + ":");
        System.out.println("   -Description: " + description);
        System.out.println("    -Topics: ");
        for (Topic topic : topics)
            topic.displayDetails();

        System.out.println("     -Quiz questions: ");
        for (int i = 1; i <= questions.size(); i++) {
            System.out.print("    Q" + i + ": ");
            System.out.println(questions.get(i - 1).getQuestionText());
        }

        System.out.println("      -Comments: ");
        for (Comment comment : comments)
            comment.display();
        
        System.out.println("      -Module Grade: " + moduleGrade.getFinalGrade());
    }
    /**
     * let's the user comment reply on a module
     * comment
     */
    public void moduleCommentReply() {
        System.out.println("Which comment would you like to reply to? (Enter number) ");

        for (int i = 1; i <= comments.size(); i++) {
            System.out.println(i + ". ");
            System.out.println(comments.get(i - 1).getText());
        }

        int choice = keyboard.nextInt();
        keyboard.nextLine();
        comments.get(choice - 1).reply();
    }
    /**
     * Prints out animated rocketShip that blasts up
     * ONLY TO BE USED IF USER HAS ACHEIVED SOMETHING 
     * SPECIAL
     * @throws InterruptedException
     */
    public void animateRocketShip() throws InterruptedException {
        System.out.println();
        // Draw rocket ship
        String[] rocket = new String[] {
                /*
                 * "         {}               ",
                 * "       {}  {}               ",
                 * "   >|--------------------------|{}",
                 * " > >|                          | {}",
                 * " > >|      CONGRATS!!!!        |  {}",
                 * " > >|                          | {}",
                 * "   >|--------------------------|{}",
                 * "       {}  {}               ",
                 * "         {}                 ",
                 */

                "   /\\      ",
                "  /  \\     ",
                " /    \\    ",
                "|------|   ",
                "| NASA |   ",
                "|      |   ",
                "|      |   ",
                "|      |   ",
                " !!!!!!    "

        };
        // Initialize rocket position
        int rocketY = 20;

        // Animate rocket moving up
        while (true) {

            // Clear console
            System.out.print("\033[H\033[2J");

            // Move rocket up
            rocketY--;
            // Draw rocket at new position
            for (int i = 0; i < rocketY; i++) {
                System.out.println();
            }
            for (int i = 0; i < rocket.length; i++) {
                for (int j = 0; j < 40; j++) {
                    System.out.print(" ");
                }
                System.out.println(rocket[i]);
            }
            // Wait for a short time
            Thread.sleep(200);

            // End animation if rocket has moved off screen
            if (rocketY <= 0) {
                break;
            }
        }
        // Print message when animation is complete
        System.out.println("Rocket ship has reached its destination! Just as you have finished this quiz!");
    }
    /**
     * Writes the details of this module to a text file with the same name as the module's title.
    * The file contains the module's title, description, and a list of topics, along with their details.
    * If the file already exists, it will be overwritten.
    * @throws FileNotFoundException if the file cannot be created or written to
     */
    public void printModuleToFile() {
        String fileName = title + ".txt";
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(" -" + title + ":");
            out.println("   -Description: " + description);
            out.println("    -Topics: ");
            for (Topic topic : topics)
                topic.displayDetailsToFile(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
