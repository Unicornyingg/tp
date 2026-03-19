package seedu.duke;

public class Parser {
    public static Command parse(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            return null;
        }
        String[] split = userInput.trim().split("\\s+");
        String keyword = split[0].toLowerCase();

        switch (keyword) {
        case "bye":
            return new ExitCommand();
        case "delete":
            if (split.length < 2) {
                return null;
            }
            try {
                return new DeleteCommand(Integer.parseInt(split[1]));
            } catch (NumberFormatException e) {
                return null;
            }
        default:
            return null;
        }
    }
}
