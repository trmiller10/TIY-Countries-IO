/**
 * This class handles this requirement, "Create a Country class
 * to store both the name and abbreviation."
 */
public class Country {


    //DO NOT MAKE THESE PROPERTIES STATIC!  BAD!!
    // create a public string property for abbreviation

    public String countryAbbrev;

    // create a public string property for the country name

    public String countryName;

    // create a constructor for this class that accepts the abbreviation and name as arguments and configures this class

    public Country(String countryAbbrev, String countryName) {
        this.countryAbbrev = countryAbbrev;
        this.countryName = countryName;
    }

    // create a getter for abbreviation

    public String getCountryAbbrev() {
        return countryAbbrev;
    }

    // create a setter for abbreviation
    public void setCountryAbbrev(String countryAbbrev) {
        this.countryAbbrev = countryAbbrev;
    }

    // create a getter for name

    public String getCountryName() {
        return countryName;
    }

    // create a setter for name

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

/*
public String toString(){
        countryName.toString();
        return countryName;
    }
*/
}
