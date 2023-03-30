
import java.util.ArrayList;

/**
 * @author JavaDoc
 *         Represents grades for module.
 */
public class ModuleGrade {
    private ArrayList<Double> quizzes;
    private double finalGrade;

    /**
     * Constructor to initalize a module grade.
     * 
     * @param quiz       String of quiz grade from module.
     * @param finalGrade String of final grade from module.
     */
    public ModuleGrade() {
        this.quizzes = new ArrayList<>();
        this.finalGrade = 0.0;
    }

    /**
     * Returns quiz grades of module.
     * 
     * @return Type double of quize grade.
     */
    public ArrayList<Double> getQuizzes() {
        return this.quizzes;
    }

    /**
     * Calculates final grades of module and returns it.
     * 
     * @return Type double of final grade.
     */
    public double getFinalGrade() {
        double total = 0;
        for (double quiz : quizzes)
            total += quiz;
        this.finalGrade = total / (double) quizzes.size();
        return this.finalGrade;
    }

    /**
     * Adds quiz grade to module.
     * 
     * @param quiz String of quiz score.
     */
    public void addQuizGrade(double grade) {
        double tmpGrade = grade;
        if (tmpGrade >= 0 && tmpGrade <= 100) {
            quizzes.add(tmpGrade);
            System.out.println("Quiz added.");
        }
    }
}
