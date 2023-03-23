import java.util.ArrayList;

public class Question {
    private String questionText;
    private ArrayList<String> choices;
    private String correctChoice;

    public Question(String questionText, ArrayList<String> choices, String correctChoice) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctChoice = correctChoice;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public String getCorrectChoice() {
        return correctChoice;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public void setCorrectChoice(String correctChoice) {
        this.correctChoice = correctChoice;
    }
}