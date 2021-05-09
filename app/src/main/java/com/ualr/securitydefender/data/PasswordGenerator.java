package com.ualr.securitydefender.data;

import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {


    private boolean useUpper = true;
    private boolean useLower = true;
    private boolean useNumbers = false;
    private boolean useSymbols = false;

    public void togglUseUpper() { this.useUpper = !this.useUpper; }
    public void toggleUseLower() { this.useUpper = !this.useLower; }
    public void toggleUseNumbers() { this.useNumbers = !this.useNumbers; }
    public void toggleUseSymbols() { this.useSymbols = !this.useSymbols; }




    public String generatePassword (int length) {

        if (length <= 0) {
            return "";
        }

        final char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
        final char[] numbers = "0123456789".toCharArray();
        final char[] symbols = "^$?!@#%&".toCharArray();
        //final char[] allAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789^$?!@#%&".toCharArray();

        //Use cryptographically secure random number generator
        Random random = new SecureRandom();

        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            //password.append(allAllowed[random.nextInt(allAllowed.length)]);
            // inserting required random chars in random positions
            if (useLower) {
                password.insert(random.nextInt(password.length()), uppercase[random.nextInt(uppercase.length)]);
            }
            if (useUpper) {
                password.insert(random.nextInt(password.length()), lowercase[random.nextInt(lowercase.length)]);
            }
            if ( useNumbers) {
                password.insert(random.nextInt(password.length()), numbers[random.nextInt(numbers.length)]);
            }
            if ( useSymbols) {
                password.insert(random.nextInt(password.length()), symbols[random.nextInt(symbols.length)]);
            }
        }
        return password.toString();
    }


    /* alternative logic/method for generatePassword
    public String generatePassword(int length) {
        // Argument Validation.
        if (length <= 0) {
            return "";
        }

        // Variables.
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);


        // Collect the categories to use.
        List<String> charCategories = new ArrayList<>(4);
        if (useLower) {
            charCategories.add(lowercase);
        }
        if (useUpper) {
            charCategories.add(uppercase);
        }
        if (useNumbers) {
            charCategories.add(numbers);
        }
        if (useSymbols) {
            charCategories.add(symbols);
        }

        // Build the password.
        for (int i = 0; i < length; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }
        return new String(password);
    }
    */

}
