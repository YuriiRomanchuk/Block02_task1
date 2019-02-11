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

        boolean continueProgram = true;

        while (continueProgram) {

            Model currentModel = modelInitializer.initializeModel();
            view.printMessageCurrentRange(currentModel);

            playGame(currentModel);
            models.add(currentModel);

            if (view.receiveAboutContinueProgram() != 1) {
                models.forEach(m -> view.printAllStatistics(m));
                continueProgram = false;
            }
        }
    }

    private void playGame(Model currentModel) {

        boolean continueGame = true;

        while (continueGame) {

            int userNumber = view.receiveNumberFromUser();

            while (userNumber < currentModel.getStartValueOfRange() || userNumber > currentModel.getFinishValueOfRange()) {
                view.printMessageAboutWrongInput("Input value outside the specified range!");
                userNumber = view.receiveNumberFromUser();
            }

            List<Integer> attemmpts = currentModel.getAttempts();
            attemmpts.add(userNumber);

            if (userNumber == currentModel.getRequiredNumber()) {
                view.printMessageForWin();
                view.printAttemptsOfUser(attemmpts.toString());
                view.printCountOfAttempts(attemmpts.size());
                continueGame = false;
            } else if (userNumber > currentModel.getRequiredNumber()) {
                view.printMessageAboutGreaterNumber();
                currentModel.setFinishValueOfRange(userNumber);
                view.printMessageCurrentRange(currentModel);
            } else {
                ;
                view.printMessageAboutLessNumber();
                currentModel.setStartValueOfRange(userNumber);
                view.printMessageCurrentRange(currentModel);
            }
        }
    }
}
