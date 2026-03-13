package seedu.duke;

public class Record {
    protected String description;

    public Record(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;   // or whatever field holds the text
    }
}
