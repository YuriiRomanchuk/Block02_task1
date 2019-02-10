package task1.ua.training;

import task1.ua.training.model.InitializeModel;
import task1.ua.training.model.Model;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private InitializeModel initializeModel;
    private View view;
    private List<Model> models = new ArrayList<>();

    public Controller(InitializeModel initializeModel, View view) {
        this.initializeModel = initializeModel;
        this.view = view;
    }

    public void AccessPoint() {

        boolean startProgram = true;

        while (startProgram) {

            Model currentModel = initializeModel();
            view.printMessageCurrentRange(currentModel.getStartValueOfRange(), currentModel.getFinishValueOfRange());

            playGame(currentModel);
            models.add(currentModel);

            if (view.receiveAboutContinueProgram() != 1) {

                models.forEach(m -> view.printAllStatistics(m.getAttempts().toString(),
                        m.getAttempts().size(),
                        m.getStartValueOfRange(),
                        m.getFinishValueOfRange()));

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

    private Model initializeModel() {
        Model model = new Model(initializeModel.receiveDefaultStartValueOfRange(), initializeModel.receiveDefaultFinishValueOfRange());
        model.setStartValueOfRange(initializeModel.receiveNewFirstValue());
        model.setFinishValueOfRange(initializeModel.receiveNewFinishValue(model.getStartValueOfRange()));
        model.setRequiredNumber(initializeModel.reveiveRandomRequiredNumber(model.getStartValueOfRange(), model.getFinishValueOfRange()));
        return model;
    }

}
