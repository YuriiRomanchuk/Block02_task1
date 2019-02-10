package task1.ua.training.model;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private int startValueOfRange;
    private int finishValueOfRange;
    private int requiredNumber;
    private List<Integer> attempts = new ArrayList<>();


    public Model(int startValueOfRange, int finishValueOfRange) {
        this.startValueOfRange = startValueOfRange;
        this.finishValueOfRange = finishValueOfRange;
    }

    public int getStartValueOfRange() {
        return startValueOfRange;
    }

    public int getFinishValueOfRange() {
        return finishValueOfRange;
    }

    public void setStartValueOfRange(int startValueOfRange) {
        this.startValueOfRange = startValueOfRange;
    }

    public void setFinishValueOfRange(int finishValueOfRange) {
        this.finishValueOfRange = finishValueOfRange;
    }

    public List<Integer> getAttempts() {
        return attempts;
    }

    public void setAttempts(List<Integer> attempts) {
        this.attempts = attempts;
    }

    public int getRequiredNumber() {
        return requiredNumber;
    }

    public void setRequiredNumber(int requiredNumbe) {
        this.requiredNumber = requiredNumbe;
    }
}



