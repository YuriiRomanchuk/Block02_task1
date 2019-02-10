package task1.ua.training;

import task1.ua.training.model.InitializeModel;

public class MainClass {

    public static void main(String[] args) {
        View view = new View(System.in);
        InitializeModel initializeModel = new InitializeModel(view);
        Controller controller = new Controller(initializeModel, view);
        controller.AccessPoint();
    }
}
