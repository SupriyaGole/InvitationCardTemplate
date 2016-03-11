package guest;

public class Address {
    private String city;
    private String state;
    private Country country;

    public Address(String city, String state, Country country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCountryName() {
        return country.getCountry();
    }

    public boolean isFrom(String countryName) {
        return country.getCountry().equals(countryName);
    }
}
