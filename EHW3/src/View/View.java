package EHW3.src.View;

import java.util.Scanner;

public class View {
    public View(EHW3.src.controller.Controller controller) {
    }

    public void run() {
        while (true) {
            try {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("Enter information about person or type \"exit\" to stop program");
                    System.out.println("Data entry format: surname name patronymic date_of_birth gender phone_number, " +
                            "(separator - space)");
                    String userInput = scanner.nextLine();
                    if (userInput.toLowerCase().equals("exit")) {
                        break;
                    } else {
                        EHW3.src.controller.Controller.saveData(userInput);
                        System.out.println("Save succeeded");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}