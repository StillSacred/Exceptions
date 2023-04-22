package EHW3.src;

import EHW3.src.model.DataSaver;

public class main {
    public static void main(String[] args) {
        EHW3.src.model.StringParser stringParser = new EHW3.src.model.StringParser();
        DataSaver dataSaver = new DataSaver();
        EHW3.src.controller.Controller controller = new EHW3.src.controller.Controller(stringParser, dataSaver);
        EHW3.src.View.View view = new EHW3.src.View.View(controller);
        view.run();
    }
}