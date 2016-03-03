public class Name {

    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String firstNameFirst(){
        return firstName + " "+lastName;
    }


    public String lastNameFirst(){
        return lastName + ", "+firstName;
    }
}
