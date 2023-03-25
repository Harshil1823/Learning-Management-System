
/**
 * @author JavaDoc
 * Represents grades for module.
 */
public class ModuleGrade {
    private double quiz;
    private double finalGrade;

    /**
     * Constructor to initalize a module grade.
     * @param quiz       String of quiz grade from module.
     * @param finalGrade String of final grade from module.
     */
    public ModuleGrade(String quiz, String finalGrade) {
        setQuizGrade(quiz);
        setFinalGrade(finalGrade);
    }

    /**
     * Returns quiz grade of module.
     * @return Type double of quize grade.
     */
    public double getQuiz() {
        return this.quiz;
    }

    /**
     * Returns final grade of module.
     * @return Type double of final grade.
     */
    public double getFinalGrade() {
        return this.finalGrade;
    }

    /**
     * Sets quiz grade as type double.
     * @param quiz String of quiz score.
     */
    public void setQuizGrade(String grade) {
        double tmpGrade = Double.parseDouble(grade);
        if (tmpGrade >= 0 && tmpGrade <= 100)
            this.finalGrade = Double.parseDouble(grade);
    }

    /**
     * Sets final grade as type double.
     * @param finalGrade String of final grade.
     */
    public void setFinalGrade(String grade) {
        double tmpGrade = Double.parseDouble(grade);
        if (tmpGrade >= 0 && tmpGrade <= 100)
            this.finalGrade = Double.parseDouble(grade);
    }

    /**
     * Returns weighted grade of module.
     * @return double of weighted grade.
     */
    public double getTotalGrade() {
        return (this.quiz * .20) + (this.finalGrade * .80);
    }
}
