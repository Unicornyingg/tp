package seedu.duke.commands;

import java.util.logging.Logger;

import seedu.duke.RecordList;
import seedu.duke.exceptions.ResumakeException;
import seedu.duke.recordtype.Record;

public class EditBulletCommand extends Command {
    private static final Logger logger = Logger.getLogger(EditBulletCommand.class.getName());

    private final int userRecordIndex;
    private final int userBulletIndex;
    private final String newBullet;

    public EditBulletCommand(int userRecordIndex, int userBulletIndex, String newBullet) {
        if (userRecordIndex <= 0) {
            throw new IllegalArgumentException("Record index must be a positive integer.");
        }
        if (userBulletIndex <= 0) {
            throw new IllegalArgumentException("Bullet index must be a positive integer.");
        }
        if (newBullet == null || newBullet.trim().isEmpty()) {
            throw new IllegalArgumentException("Edited bullet cannot be blank.");
        }

        this.userRecordIndex = userRecordIndex;
        this.userBulletIndex = userBulletIndex;
        this.newBullet = newBullet.trim();

        assert this.userRecordIndex > 0 : "Record index should be 1-based and positive";
        assert this.userBulletIndex > 0 : "Bullet index should be 1-based and positive";
        assert !this.newBullet.isBlank() : "Edited bullet should not be blank after trimming";

        logger.info(() -> "EditBulletCommand created for record index=" + userRecordIndex
                + ", bullet index=" + userBulletIndex
                + ", new bullet=" + this.newBullet);
    }

    public int getUserRecordIndex() {
        return userRecordIndex;
    }

    public int getUserBulletIndex() {
        return userBulletIndex;
    }

    public String getNewBullet() {
        return newBullet;
    }

    @Override
    public void execute(RecordList list) throws ResumakeException {
        assert list != null : "RecordList should not be null";

        logger.info(() -> "Executing EditBulletCommand for record index=" + userRecordIndex
                + ", bullet index=" + userBulletIndex);

        try {
            Record record = list.getRecord(userRecordIndex - 1);
            assert record != null : "Record at valid index should not be null";
            assert record.getBullets() != null : "Bullets list should not be null";

            logger.fine(() -> "Editing bullet in record: " + record.getTitle());

            record.editBullet(userBulletIndex - 1, newBullet);

            logger.info(() -> "Bullet edit succeeded for record index=" + userRecordIndex
                    + ", bullet index=" + userBulletIndex);

            System.out.println("Edited bullet " + userBulletIndex
                    + " in record " + userRecordIndex);

        } catch (IndexOutOfBoundsException e) {
            logger.warning(() -> "Bullet edit failed: record index=" + userRecordIndex
                    + ", bullet index=" + userBulletIndex + " out of range");
            throw new ResumakeException("Bullet index is out of range.");

        } catch (IllegalArgumentException e) {
            logger.warning(() -> "Bullet edit failed: " + e.getMessage());
            throw new ResumakeException(e.getMessage());
        }
    }
}