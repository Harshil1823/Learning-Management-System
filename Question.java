import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author JavaDoc
 * Represents question on test.
 */
public class Question {
    private String questionText;
    private ArrayList<String> choices;
    private int correctChoiceIndex;
    private static Scanner keyboard = new Scanner(System.in);

    /**
     * Constructor to initialize a Question.
     * @param questionText String of question.
     * @param choices ArrayList<String> of choices. 
     * @param correctChoiceIndex String of correct choice.
     */
    public Question(String questionText, ArrayList<String> choices, int correctChoiceIndex) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctChoiceIndex = correctChoiceIndex;
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
    public int getCorrectChoice() {
        return correctChoiceIndex;
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
    public void setCorrectChoice(int choice) {
        this.correctChoiceIndex = choice;
    }

    /**
     * Allows user to answer a question.
     * @return true if correct answer, false otherwise.
     */
    public boolean answerQuestion(){
        int i = 0;
        System.out.print("Question: ");
        System.out.println(questionText);

        System.out.println("Choose from the following choices by number: ");

        for(String c : choices){
            System.out.print(i + ". ");
            System.out.println(c);
        }

        int choice = keyboard.nextInt();
        keyboard.nextLine();

        if(correctChoiceIndex == choice)
            return true;
        return false;
    }
}