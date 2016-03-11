package cli;

import guest.GuestFactory;
import guest.Person;

import java.util.ArrayList;

public class ProcessGuestChoice {

    private String data;

    public ProcessGuestChoice(String data) {
        this.data = data;
    }

    public String retrieveGuestData(String[] args) throws Exception {
        ArrayList<String> processedLabels = new ArrayList<String>();
        ArrayList<Person> guestList = createGuestList();
        OptionHandler optionHandler = new OptionHandler(args);
        for (Person person : guestList) {
            processedLabels.add(optionHandler.handleOptionsAndReturnData(person));
        }
        return convertListToTString(processedLabels);
    }

    private ArrayList<Person> createGuestList() {
        GuestFactory guestFactory = new GuestFactory(data);
        ArrayList<Person> guestList = guestFactory.getGuestList();
        return guestList;
    }

    private String convertListToTString(ArrayList<String> list) {
        String guestData = "";
        for (String record : list)
            if (!(record.equals("")))
                guestData += record + "\n";
        return guestData;
    }
}
