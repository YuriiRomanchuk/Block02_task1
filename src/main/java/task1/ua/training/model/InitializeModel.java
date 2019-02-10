package task1.ua.training.model;

import task1.ua.training.View;

import java.util.Random;

public class InitializeModel {

    private View view;
    private static final int DEFAULT_START_VALUE_OF_RANGE = 0;
    private static final int DEFAULT_FINISH_VALUE_OF_RANGE = 100;
    private Random random = new Random();

    public InitializeModel(View view) {
        this.view = view;
    }

    public int receiveDefaultStartValueOfRange() {
        return DEFAULT_START_VALUE_OF_RANGE;
    }

    public int receiveDefaultFinishValueOfRange() {
        return DEFAULT_START_VALUE_OF_RANGE;
    }

    public int receiveNewFirstValue() {
        int rangeValue = fillNewLimitOfRange(true);
        return rangeValue;
    }

    public int receiveNewFinishValue(int currentStartValueRange) {

        int rangeValue = fillNewLimitOfRange(false);

        while (currentStartValueRange >= rangeValue) {
            view.printMessageAboutWrongInput("Finish value could not be more or equal than first value!");
            rangeValue = fillNewLimitOfRange(false);
        }

        return rangeValue;
    }

    private int fillNewLimitOfRange(boolean startValue) {

        int rangeValue = startValue ? DEFAULT_START_VALUE_OF_RANGE : DEFAULT_FINISH_VALUE_OF_RANGE;
        int answer = view.receiveAnswerAboutNewRange(startValue ? "start" : "finish");

        if (answer == 1) {
            rangeValue = Math.abs(view.receiveNumberFromUser());
        }

        return rangeValue;
    }

    public int reveiveRandomRequiredNumber(int currentStartValueRange, int currentFinishValueRange) {
        return random.ints(currentStartValueRange, currentFinishValueRange).iterator().nextInt();
    }

}
