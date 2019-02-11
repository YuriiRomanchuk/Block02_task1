package task1.ua.training;

import task1.ua.training.model.Model;
import task1.ua.training.model.ModelInitializer;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private ModelInitializer modelInitializer;
    private View view;
    private List<Model> models = new ArrayList<>();

    public Controller(ModelInitializer modelInitializer, View view) {
        this.modelInitializer = modelInitializer;
        this.view = view;
    }

    public void accessPoint() {

        boolean startProgram = true;

        while (startProgram) {

            Model currentModel = modelInitializer.initializeModel();
            view.printMessageCurrentRange(currentModel.getStartValueOfRange(), currentModel.getFinishValueOfRange());

            playGame(currentModel);
            models.add(currentModel);

            if (view.receiveAboutContinueProgram() != 1) {
                models.forEach(m -> view.printAllStatistics(currentModel));
                startProgram = false;
            }
        }
    }

    private void playGame(Model currentModel) {

        boolean startGame = true;

        while (startGame) {

            int userNumber = view.receiveNumberFromUser();

            while (userNumber < currentModel.getStartValueOfRange() || userNumber > currentModel.getFinishValueOfRange()) {
                view.printMessageAboutWrongInput("Input value outside the specified range!");
                userNumber = view.receiveNumberFromUser();
            }

            List<Integer> attemmpts = currentModel.getAttempts();
            attemmpts.add(userNumber);
            currentModel.setAttempts(attemmpts);

            if (userNumber == currentModel.getRequiredNumber()) {
                view.printMessageForWin();
                view.printAttemptsOfUser(attemmpts.toString());
                view.printCountOfAttempts(attemmpts.size());
                startGame = false;
            } else if (userNumber > currentModel.getRequiredNumber()) {
                view.printMessageAboutGreaterNumber();
            } else {
                view.printMessageAboutLessNumber();
            }
        }
    }

}
