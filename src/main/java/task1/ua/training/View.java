package task1.ua.training;

import task1.ua.training.model.Model;

import java.io.InputStream;
import java.util.Scanner;

public class View {

    private Scanner in;
    private static final String INPUT_INT_DATA = "Input INT value = ";
    private static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    private static final String CURRENT_RANGE = "Current range: %s to %s ";
    private static final String RECEIVE_ABOUT_CONTINUE_PROGRAM = "Do you want to continue game?(1 - Yes, 2 or other - No)";
    private static final String RECEIVE_ANSWER_ABOUT_RANGE = "Do you want to change %s value or set default of range? (1 - Yes, 2 or other - No)";
    private static final String USER_WIN = "You win!";

    public View(InputStream in) {
        this.in = new Scanner(in);
    }

    private int receiveValue() {
        while (!in.hasNextInt()) {
            printMessage(WRONG_INPUT_DATA + INPUT_INT_DATA);
            in.next();
        }
        return in.nextInt();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public int receiveAboutContinueProgram() {
        printMessage(RECEIVE_ABOUT_CONTINUE_PROGRAM);
        return receiveValue();
    }

    public int receiveAnswerAboutNewRange(String nameOfValue) {
        printMessage(String.format(RECEIVE_ANSWER_ABOUT_RANGE, nameOfValue));
        return receiveValue();
    }

    public void printMessageAboutWrongInput(String message) {
        printMessage(WRONG_INPUT_DATA + message);
    }

    public void printMessageCurrentRange(Model currentModel) {
        printMessage(String.format(CURRENT_RANGE, currentModel.getStartValueOfRange(), currentModel.getFinishValueOfRange()));
    }

    public int receiveNumberFromUser() {
        System.out.println(INPUT_INT_DATA);
        return receiveValue();
    }

    public void printAllStatistics(Model model) {
        printMessage("//-------------------------------------");
        printMessageCurrentRange(model);
        printAttemptsOfUser(model.getAttempts().toString());
        printCountOfAttempts(model.getAttempts().size());
    }

    public void printMessageForWin() {
        printMessage(USER_WIN);
    }

    public void printAttemptsOfUser(String attempts) {
        printMessage("You attempts: " + attempts);
    }

    public void printCountOfAttempts(int attemptsCount) {
        printMessage("Count of attempts: " + attemptsCount);
    }

    public void printMessageAboutLessNumber() {
        printMessage("Oops...The selected number is less than the specified");
    }

    public void printMessageAboutGreaterNumber() {
        printMessage("Oops...The selected number is greater than the specified");
    }

}
