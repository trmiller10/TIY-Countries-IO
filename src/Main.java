import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class reads and parses the country.txt file and creates the
 * map of arrays we need. It also prompts the user for a letter and
 * writes out a file containing those countries
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // Create a HashMap that can hold an array list of countries indexed by a letter.


        // Create a File object pointing to the countries.txt file


        // Create a Scanner to read the file line by line


        /*
        The for loop below addresses this requirement:

        Read and parse the "countries.txt" file into an HashMap<String, ArrayList<Country>>
        where the key is a single letter and the value is a list of countries whose names
        start with that letter.
         */

        // Loop over the contents of the countries file, one line at a time


        // read the next line of content from the scanner


        // Create a array of Strings variable. Split the line of text we just read into an array of two String values and set it into this variables.
        // Hint: check out the .split() method on the String class


        // Create a String variable for the abbreviation and set it to the first (0) element in the array we just made


        // Create a String variable for the country name and set it to the second (1) element in the array we just made


        // Create a new instance of our Country object and set it into a variable named country


        // Create a String variable and set it to the first letter from the country name
        // Hint: check out the substring() method on String


        // Update the variable we just created and set it to the lowercase version
        // Hint: check out toLowerCase() on the String class.


        // check if our HashMap does NOT have a key for this letter


        // if not, create an empty ArrayList that can hold Country objects


        // put this new empty ArrayList into the HashTable at the correct index (IE: the first letter of the country
        // name. We determined this earlier and stored it in a variable)



        // Create a variable of type ArrayList and set it to the ArrayList in the HashMap for the first letter of the country we're working with


        // Add our current Country object into the ArrayList we just got


        // close the scanner that's reading the countries.txt file


        /*
        The next block of code addresses this requirement:

        Ask the user to type a letter (if they don't type a single letter, throw an exception).
         */

        // Create a new Scanner instance that we will use for user input (when we ask them for a letter)


        // Prompt the user to enter a letter


        // Use our new Scanner instance to read the input


        // Check if the length of the input is not equal to 1.
        // See the "throw" keyword.


        // If not, throw an exception


        // update the existing variable holding the letter, setting it to the lower case version of the letter. (see .toLowerCase())


        /*
        The next section handles this requirement:

        Save an "X_countries.txt" file, where X is the letter they typed, which only lists the countries starting with that letter.
         */

        // Create a new FileWriter instance that we will use to write out to the new x_countries file.
        // Hint: the FileWriter class has a constructor you can use that accepts a String. The string is the name of the file to write to.
        // Hint 2: Overwrite the file it if already exists. IE: don't append.


        // Create an ArrayList variable and set it to the ArrayList from the HashMap for the letter the user entered


        // loop over this array list of countries that we just got. Note: All of these countries start with the letter the user entered
        // Hint: use the for-each syntax to loop over this array


        // Use the FileWriter instance we just created and write out a line of text to the x_countries.txt file.
        // This line should contain the abbreviation and name for the current country.
        // Don't forget to add a line break for each line
        // Hint: check out the .append() method of FileWriter




        // close the FileWriter
        // Hint: see the .close() method on FileWriter


        // and you're done!!!!

    }

}
