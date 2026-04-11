package seedu.duke.command;

import seedu.duke.appcontainer.AppContainer;
import seedu.duke.ui.ErrorUi;

public class UnknownCommand implements Command {
    private final String commandWord;

    public UnknownCommand(String commandWord) {
        this.commandWord = commandWord;
    }

    @Override
    public void execute(AppContainer container) {
        if (commandWord.isEmpty()) {
            return;
        }
        ErrorUi.printUnknownCommandHint(commandWord);
    }
}
