package guest;

public class Gender {
    private String gender;

    public Gender(String gender) {
        this.gender = gender;
    }

    public boolean isMale() {
        return gender.equals("Male");
    }
}
