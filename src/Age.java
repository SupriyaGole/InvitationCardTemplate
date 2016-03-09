public class Age {
    private int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean isAbove(int ageLimit) {
        return age >= ageLimit;
    }

    public int getAge() {
        return age;
    }
}
