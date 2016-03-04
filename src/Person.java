public class Person {
    private String age;
    private String gender;
    private Name name;
    private Address address;

    public Person(String firstName, String lastName, String gender, String age, String city, String state, String country) {
        this.name = new Name(firstName, lastName);
        this.age = age;
        this.gender = gender;
        this.address = new Address(city, state, country);
    }

    public String getName(String format) throws Exception {
        return represent(format);
    }

    public String getNameWithCountry(String format) throws Exception {
        return getName(format) + address.getCountryName();
    }

    private String represent(String format){
        String fullName;
        if (format.equals("firstFirst"))
            fullName = name.firstNameFirst();
        else if(format.equals("lastFirst"))
            fullName = name.lastNameFirst();
        else
            throw new RuntimeException("Given format is invalid");
        return isMale() ? Genders.Mr + fullName : Genders.Ms + fullName;
    }

    private boolean isMale() {
        return gender.equals("Male");
    }
}
