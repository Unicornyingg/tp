package seedu.duke.commands;

import seedu.duke.RecordList;
import seedu.duke.recordtype.Record;
import seedu.duke.Ui;

import java.util.logging.Logger;

public class AddBulletCommand extends Command {
    private static final Logger logger = Logger.getLogger(AddBulletCommand.class.getName());

    private final int index;
    private final String bullet;
    private final Ui ui;

    public AddBulletCommand(int index, String bullet) {
        if (index < 0) {
            throw new IllegalArgumentException("Record index must be non-negative.");
        }
        if (bullet == null || bullet.trim().isEmpty()) {
            throw new IllegalArgumentException("Bullet cannot be blank.");
        }

        this.index = index;
        this.bullet = bullet.trim();
        this.ui = new Ui();

        assert this.index >= 0 : "Record index should be 0-based and non-negative";
        assert !this.bullet.isBlank() : "Bullet should not be blank after trimming";
        assert this.ui != null : "Ui should be initialized";

        logger.info(() -> "AddBulletCommand created for record index=" + index
                + ", bullet=" + this.bullet);
    }

    public int getIndex() {
        return index;
    }

    public String getBullet() {
        return bullet;
    }

    @Override
    public void execute(RecordList list) {
        assert list != null : "RecordList should not be null";

        logger.info(() -> "Executing AddBulletCommand for record index=" + index);

        try {
            Record record = list.getRecord(index);
            assert record != null : "Record at valid index should not be null";
            assert record.getBullets() != null : "Bullets list should not be null";

            logger.fine(() -> "Adding bullet to record: " + record.getTitle());

            record.addBullet(bullet);

            logger.info(() -> "Bullet added successfully to record index=" + index);

            ui.showLine();
            ui.showMessage("Added bullet to: " + record.getTitle());
            ui.showLine();

        } catch (IndexOutOfBoundsException e) {
            logger.warning(() -> "AddBulletCommand failed: record index out of range: " + index);
            ui.showLine();
            ui.showError("Record index is out of range.");
            ui.showLine();

        } catch (IllegalArgumentException e) {
            logger.warning(() -> "AddBulletCommand failed: " + e.getMessage());
            ui.showLine();
            ui.showError(e.getMessage());
            ui.showLine();
        }
    }
}