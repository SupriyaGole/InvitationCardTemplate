package guest;

import java.util.ArrayList;

public class GuestFactory {

    private String data;

    public GuestFactory(String data) {
        this.data = data;
    }

    private Person getPersonObject(String record) {
        String[] individualData = record.split(",");
        Name name = new Name(individualData[0], individualData[1]);
        Gender gender = new Gender(individualData[2]);
        Age age = new Age(Integer.parseInt(individualData[3]));
        Address address = new Address(individualData[4], individualData[5], new Country(individualData[6]));
        return new Person(name, gender, age, address);
    }

    public ArrayList<Person> getGuestList() {
        ArrayList<Person> guestList = new ArrayList<Person>();
        String[] records = data.split("\n");
        for (String record : records) {
            Person person = getPersonObject(record);
            guestList.add(person);
        }
        return guestList;
    }
}
