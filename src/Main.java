public class Main {

    // 1. parenthesesCheck

    public static boolean parenthesesCheck(String str) {
        // create variable to count parentheses, using it to check balance
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;    //+1 to count if there is open parentheses
            } else {
                count--;    //-1 to count if there is close parentheses
            }
            if (count < 0) {   //if count is not 0, means that the open and close parentheses are not balanced
                return false;
            }
        }
        return count == 0;    //only return when count = 0, parentheses are balanced
    }

    // 2. reverseInteger

    public static String reverseInteger(int number) {
        String result = "";     //initialize String result, values will be inserted into result during the loop

        String numStr = "" + number;    //convert number to string to get its length, in for loop
        for(int i = 0; i < numStr.length(); i++){
            int digit = number % 10;    //get the rightmost digit
            result = result + digit;    //add digit to result String
            number = number/10;         //remove rightmost digit, so loop continues with the next digit
        }

        return result;  //return result once loop is complete
    }



    // 3. encryptThis
    public static String encryptThis(String message) {
        String[] words = message.split(" ");    //splits the input message (String) into an ARRAY of words by space " "
        String result = "";     //initialize empty String for the result of method

        //loop goes through each WORD of the array
        for (int i = 0; i < words.length; i++) {
            String word = words[i]; //variable for the word being tracked in the array
            String encrypted = "";  //why must String encrypted be in the method

            //converting the first character into char --> ASCII
            encrypted += (int) word.charAt(0);

            // For words with length > 1, handle the rest
            if (word.length() > 1) {
                // Add last letter in second position
                encrypted += word.charAt(word.length() - 1);
                // Add the middle letters (unchanged)

                //only for words with more than 2 letters (length >2)
                if(word.length() > 2){
                    for (int j = 2; j < word.length() - 1; j++) {
                        encrypted += word.charAt(j);
                    }
                    // Add second letter at the end
                    encrypted += word.charAt(1);
                }
            }

            // Add space between words (except last word)
            result += encrypted;
            if (i < words.length - 1) {
                result += " ";
            }
        }

        return result;

    }


    // 4. decipherThis
    public static String decipherThis(String message) {
        String[] words = message.split(" ");
        String result = "";

        // loop goes through each word in the array called words
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            String decrypted = "";      // initializing a String, letters will be added one by one as one word is being decrypted

            //Count how many numbers at start of word
            int numberCount = 0;
            char[] chars = word.toCharArray();      // creating array that stores numbers in the String converted to char

            for(int j = 0; j < word.length(); j++){
                char c = chars[j];
                if (c >= '0' && c <= '9'){      //need '' around the numbers bc we want to compare the ASCII values, not actual numbers
                    numberCount ++;
                } else {
                    break;
                }
            }

            //Convert ASCII number to char
            char firstLetter = (char)Integer.parseInt(word.substring(0, numberCount));
            decrypted += firstLetter;

            //handle remaining letters
            String remainingLetters = word.substring(numberCount);
            if (remainingLetters.length() == 1){
                decrypted = remainingLetters;
            }
            if(remainingLetters.length() > 1){
                char secondLetter = remainingLetters.charAt(0);
                char lastLetter = remainingLetters.charAt(remainingLetters.length() - 1);

                decrypted += lastLetter;

                if(remainingLetters.length() > 2){
                    decrypted += remainingLetters.substring(1, remainingLetters.length() - 1);
                    decrypted += secondLetter;
                }
            }

            result += decrypted;
            if(i < words.length - 1){
                result += " ";
            }
        }

        return result;

    }
}