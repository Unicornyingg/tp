package seedu.duke;

import seedu.duke.recordtype.Record;

public class EditCommand extends Command {
    private final int index;
    private final String newDescription;
    private final Ui ui;

    public EditCommand(int index, String newDescription) {
        assert newDescription != null : "New description should not be null";

        this.index = index;
        this.newDescription = newDescription;
        this.ui = new Ui();

        assert this.ui != null : "Ui should be initialized";
    }

    @Override
    public void execute(RecordList list) {
        assert list != null : "RecordList passed to EditCommand should not be null";

        if (index < 0 || index >= list.getSize()) {
            ui.showLine();
            ui.showError("Record index is out of range.");
            ui.showLine();
            return;
        }

        Record record = list.getRecord(index);
        assert record != null : "Record at valid index should not be null";
        
        record.setDescription(newDescription);


        ui.showLine();
        System.out.println("Record " + (index + 1) + " has been updated.");
        ui.showLine();
    }
}
