package task1.ua.training;

import task1.ua.training.model.ModelInitializer;

public class MainClass {

    public static void main(String[] args) {
        View view = new View(System.in);
        ModelInitializer initializeModel = new ModelInitializer(view);
        Controller controller = new Controller(initializeModel, view);
        controller.accessPoint();

    }
}
