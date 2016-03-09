import java.util.LinkedList;

public class ProcessGuestChoice {

    private String data;

    public ProcessGuestChoice(String data) {
        this.data = data;
    }

    public String retrieveGuestData(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        String[] records = data.split("\n");
        for (String record : records) {
            OptionHandler handler = new OptionHandler(args);
            list.add(handler.handleOptionsAndReturnData(record));
        }
        return convertListToTString(list);
    }

    private String convertListToTString(LinkedList<String> list) {
        String guestData = "";
        for (String record : list)
            if (!(record.equals("")))
                guestData += record + "\n";
        return guestData;
    }
}
