public enum Genders {
    Mr(" "),
    Ms(" ");


    private String delimiter;

    Genders(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String toString() {
        return this.name() + this.delimiter;
    }
}
