import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * This class reads and parses the country.txt file and creates the
 * map of arrays we need. It also prompts the user for a letter and
 * writes out a file containing those countries
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // TODO: Create a HashMap that can hold an array list of countries indexed by a letter.
        HashMap<String, ArrayList<Country>> countryHashMap = new HashMap<>();

        // TODO: Create a File object pointing to the countries.txt file
        // TODO: Create a Scanner to read the file line by line
        Scanner scan = new Scanner(new File("countries.txt"));

        /* TODO:
        The for loop below addresses this requirement:

        Read and parse the "countries.txt" file into an HashMap<String, ArrayList<Country>>
        where the key is a single letter and the value is a list of countries whose names
        start with that letter.
         */


        // TODO: Loop over the contents of the countries file, one line at a time
        while (scan.hasNext()) {

            // TODO: read the next line of content from the scanner
            String countriesFile = scan.nextLine();

            // TODO: Create a array of Strings variable. Split the line of text we just read into an array of two String values and set it into this variables.
            // TODO: Hint: check out the .split() method on the String class
            String[] splitCountriesFile = countriesFile.split("\\|");

            // TODO: Create a String variable for the abbreviation and set it to the first (0) element in the array we just made
            String countryAbbrev = splitCountriesFile[0];

            //TRM: System.out.println(Country.countryAbbrev);
            // TODO: Create a String variable for the country name and set it to the second (1) element in the array we just made
            String countryName = splitCountriesFile[1];

            // TODO: Create a new instance of our Country object and set it into a variable named country
            Country country = new Country(countryAbbrev, countryName);

            // TODO: Create a String variable and set it to the first letter from the country name
            // TODO: Hint: check out the substring() method on String
            //TRM: firstLetter must be the first letter of the country NAME, not the abbreviation
            String firstLetter = countryName.substring(0, 1);


            // TODO: Update the variable we just created and set it to the lowercase version
            // TODO: Hint: check out toLowerCase() on the String class.
            firstLetter = firstLetter.toLowerCase();

            // TODO: check if our HashMap does NOT have a key for this letter
            boolean hasKey = countryHashMap.containsKey(firstLetter);

            // TODO: if not, create an empty ArrayList that can hold Country objects
            if (!hasKey) {
                ArrayList<Country> hashMapArrayList = new ArrayList<>();

                // TODO: put this new empty ArrayList into the HashTable at the correct index (IE: the first letter of the country name. We determined this earlier and stored it in a variable)
                countryHashMap.put(firstLetter, hashMapArrayList);
            }
            
            // TODO: Create a variable of type ArrayList and set it to the ArrayList in the HashMap for the first letter of the country we're working with
            //TRM: We are not creating a new ArrayList, we are creating a variable countryArrayList that points to our hashMapArrayList that already exists in our countryHashMap
            //TRM: We then get the key associated with the hashMapArrayList that countryArrayList is pointing to and assign it to countryArrayList
            ArrayList countryArrayList = countryHashMap.get(firstLetter);

            // TODO: Add our current Country object into the ArrayList we just got
            //TRM: Because now countryArrayList is directly pointing to the hashMapArrayList associated with the firstLetter key, we can directly manipulate/edit hashMapArrayList
            //TRM: We add the current instance of our country object (which contains countryAbbrev and countryName) and store it in hashMapArrayList
            countryArrayList.add(country);

        }

        // TODO: close the scanner that's reading the countries.txt file
        scan.close();

        /* TODO:
        The next block of code addresses this requirement:

        Ask the user to type a letter (if they don't type a single letter, throw an exception).
         */

        // TODO: Create a new Scanner instance that we will use for user input (when we ask them for a letter)
        Scanner userInput = new Scanner(System.in);

        // TODO: Prompt the user to enter a letter
        System.out.println("Please enter a letter.");

        // TODO: Use our new Scanner instance to read the input
        //TRM: setting the String variable userLetter to null uses less memory than if we set userLetter to new String();
        String userLetter = userInput.nextLine();

        // TODO: Check if the length of the input is not equal to 1.
        // TODO: See the "throw" keyword.
        if (userLetter.length() != 1) {

            //  TODO: If not, throw an exception
            throw new Exception("user letter must be one letter long");
        }

        // TODO: update the existing variable holding the letter, setting it to the lower case version of the letter. (see .toLowerCase())
        userLetter = userLetter.toLowerCase();
        System.out.println(userLetter);

        /* TODO:
        The next section handles this requirement:

        Save an "X_countries.txt" file, where X is the letter they typed, which only lists the countries starting with that letter.
         */

        //  TODO: Create a new FileWriter instance that we will use to write out to the new x_countries file.
        //  TODO: Hint: the FileWriter class has a constructor you can use that accepts a String. The string is the name of the file to write to.
        //  TODO: Hint 2: Overwrite the file it if already exists. IE: don't append.
        FileWriter countriesFileWriter = new FileWriter(new File("X_countries.txt"));

        //  TODO: Create an ArrayList variable and set it to the ArrayList from the HashMap for the letter the user entered
        ArrayList<Country> countryArrayList = countryHashMap.get(userLetter);

        //  TODO: loop over this array list of countries that we just got. Note: All of these countries start with the letter the user entered
        //  TODO: Hint: use the for-each syntax to loop over this array
        //TRM: This converts allows us to print out each country name retrieved from the countryArrayList
        for (int i = 0; i < countryArrayList.size(); i++) {

            //HOMEWORK SESSION NOTES: START USING .printf()
            System.out.println(countryArrayList.get(i).getCountryAbbrev() + "-" + countryArrayList.get(i).getCountryName() + "\n");
        }


        //  TODO: Use the FileWriter instance we just created and write out a line of text to the x_countries.txt file.
        //  TODO: This line should contain the abbreviation and name for the current country.
        //  TODO: Don't forget to add a line break for each line
        //  TODO: Hint: check out the .append() method of FileWriter
        //HOMEWORK SESSION NOTES
        for(Country country : countryArrayList){
            countriesFileWriter.write(String.format(country + "\n"));
        }

        /* PREVIOUS
        for (int i = 0; i < countryArrayList.size(); i++) {
            countriesFileWriter.write(countryArrayList.get(i).getCountryAbbrev() + "-" + countryArrayList.get(i).getCountryName() + "\n");
        }
        */

        //  TODO: close the FileWriter
        //  TODO: Hint: see the .close() method on FileWriter
        countriesFileWriter.close();

            //  TODO: and you're done!!!!
    }

}
