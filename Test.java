import java.util.ArrayList;

/**
 * @author JavaDoc
 * Represents a module test.
 */
public class Test {
    private String name;
    private ArrayList<Question> questions;

    /**
     * Constructor to initialize a test.
     * @param name String of test name.
     */
    public Test(String name){
        this.name = name;
        this.questions = new ArrayList<Question>();
    }

    /**
     * Returns the test name.
     * @return String of test name.
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the questions of test.
     * @return ArrayList<Question> of questions.
     */
    public ArrayList<Question> getQuestions(){
        return questions;
    }

    /**
     * Add questions to questions list.
     * @param question Type Question.
     */
    public void addQuestion(Question question){
        questions.add(question);
    }
}