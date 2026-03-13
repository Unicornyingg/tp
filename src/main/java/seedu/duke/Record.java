package seedu.duke;

public class Record {
    protected String description;

    public Record(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;   // or whatever field holds the text
    public String getDescription() {
        return description;
    }

    public boolean containsKeyword(String keyword) {
        return description.toLowerCase().contains(keyword.toLowerCase());
    }
}
    public void setDescription(String description) {
        this.description = description;

    }
}
