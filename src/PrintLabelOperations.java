import java.util.HashMap;
import java.util.LinkedList;

public class PrintLabelOperations {

    private String data;

    public PrintLabelOperations(String data) {
        this.data = data;
    }

    public String guestDataRetrieval(HashMap<String, String> map) throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        int size = map.size();
        String[] records = data.split("\n");
        for (String record1 : records) {
            String[] record = record1.split(",");
            Person person = new Person(record[0], record[1], record[2], record[3], record[4], record[5], record[6]);
            if (size == 2) {
                list.add(person.getName(map.get("nameFormat")));
            } else if (size == 3) {
                list.add(person.getNameWithCountry(map.get("nameFormat"), map.get("country")));
            }
        }
        return refactorListToTString(list);
    }

    private String refactorListToTString(LinkedList<String> list) {
        String guestData = "";
        for (String record : list) {
            if (!(record.equals(""))) {
                guestData += record + "\n";
            }
        }
        return guestData;
    }
}
