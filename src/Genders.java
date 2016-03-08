public enum Genders {
    Male,
    Female;

    @Override
    public String toString() {
        return this.name().equals("Male") ? "Mr " : "Ms ";
    }
}
