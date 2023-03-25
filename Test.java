import java.util.ArrayList;

public class Test {
    private String name;
    private ArrayList<Question> questions;

    public Test(String name){
        this.name = name;
        this.questions = new ArrayList<Question>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Question> getQuestions(){
        return questions;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }
}