import java.util.ArrayList;

/**
 * @author JavaDoc
 * Represents question on test.
 */
public class Question {
    private String questionText;
    private ArrayList<String> choices;
    private String correctChoice;

    /**
     * Constructor to initialize a Question.
     * @param questionText String of question.
     * @param choices ArrayList<String> of choices. 
     * @param correctChoice String of correct choice.
     */
    public Question(String questionText, ArrayList<String> choices, String correctChoice) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctChoice = correctChoice;
    }

    /**
     * Returns the question text.
     * @return String of question.
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Returns choices of question.
     * @return ArrayList<String> of choices.
     */
    public ArrayList<String> getChoices() {
        return choices;
    }

    /**
     * Returns correct choice.
     * @return String of correct choice.
     */
    public String getCorrectChoice() {
        return correctChoice;
    }

    /**
     * Set the question.
     * @param questionText String of question.
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    /**
     * Set choices for question.
     * @param choices ArrayList<String> of choices.
     */
    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    /**
     * Set of correct choices.
     * @param correctChoice String of correct choice.
     */
    public void setCorrectChoice(String correctChoice) {
        this.correctChoice = correctChoice;
    }
}