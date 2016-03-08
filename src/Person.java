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

    public String getName(String nameFormat) throws Exception {
        return represent(nameFormat);
    }

    public String getNameWithCountry(String nameFormat,String countryName) throws Exception {
        String representation="";
        if(address.getCountryName().equals(countryName))
            representation += getName(nameFormat) + ","+address.getCountryName();
        return representation;
    }

    private String represent(String format){
        String fullName;
        if (format.equals("firstFirst"))
            fullName = name.firstNameFirst();
        else if(format.equals("lastFirst"))
            fullName = name.lastNameFirst();
        else
            throw new RuntimeException("Given format is invalid");
        return isMale() ? Genders.Male + fullName : Genders.Female + fullName;
    }

    private boolean isMale() {
        return gender.equals("Male");
    }
}
