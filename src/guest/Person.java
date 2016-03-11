package guest;

public class Person {
    private Name name;
    private Gender gender;
    private Age age;
    private Address address;

    public Person(Name name, Gender gender, Age age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public String getRepresentation(String nameFormat) {
        return represent(nameFormat);
    }


    public String getRepresentation(String nameFormat, String countryName) throws Exception {
        String representation = "";
        if (address.isFrom(countryName))
            representation += getRepresentation(nameFormat) + "," + address.getCountryName();
        return representation;
    }

    public String getRepresentation(String nameFormat, String countryName, int ageLimit) throws Exception {
        String representation = "";
        if (age.isAbove(ageLimit))
            representation = getRepresentation(nameFormat, countryName);
        representation += representation.equals("") ? "" : ", " + age.getAge();
        return representation;
    }

    private String represent(String format) {
        String fullName;
        if (format.equals("firstFirst"))
            fullName = name.firstNameFirst();
        else if (format.equals("lastFirst"))
            fullName = name.lastNameFirst();
        else
            throw new RuntimeException("Given format is invalid");
        return gender.isMale() ? Genders.Male + fullName : Genders.Female + fullName;
    }
}
