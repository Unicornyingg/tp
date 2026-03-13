package seedu.duke;

public class ShowCommand extends Command{

    public ShowCommand(){

    }
    public static void printRecord(RecordList records, int index){
        System.out.println(records.getRecord(index));
    }

    @Override
    public void execute(RecordList list) {

    }
}
