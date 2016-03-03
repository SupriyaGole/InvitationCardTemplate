public class Person {

    private int age;
    private String gender;
    private Name name;
    private Address address;

    public Person(String firstName, String lastName,String gender,int age, String city, String state, String country) {
        this.name  = new Name(firstName,lastName);
        this.age = age;
        this.gender = gender;
        this.address = new Address(city,state,country);
    }

    public String getName(String format) {
        String representation = represent(format);
        return representation;

    }

    public String getNameWithCountry(String format) {
        return getName(format) + address.getCountryName();
    }

    private String represent(String format){
        String fullName;
        if (format.equals("firstFirst"))
            fullName = name.firstNameFirst();
        else
            fullName = name.lastNameFirst();
        return isMale() ? Genders.Mr + fullName : Genders.Ms + fullName;
    }

    private boolean isMale(){
        return gender.equals("Male");
    }
}
