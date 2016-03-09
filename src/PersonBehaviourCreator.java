public class PersonBehaviourCreator {
    private String data;

    public PersonBehaviourCreator(String data) {
        this.data = data;
    }

    private String[] splitRecord() {
        return data.split(",");
    }

    public Person getPersonObject(){ //create static person object
        String[] individualData = splitRecord();
        Name name = new Name(individualData[0], individualData[1]);
        Gender gender = new Gender(individualData[2]);
        Age age = new Age(Integer.parseInt(individualData[3]));
        Address address = new Address(individualData[4], individualData[5], new Country(individualData[6]));
        return new Person(name, gender, age, address);
    }
}
