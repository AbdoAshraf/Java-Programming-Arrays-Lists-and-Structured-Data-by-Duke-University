import edu.duke.*;

public class CaesarCipher {
    private String alphabetC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String alphabetS = "abcdefghijkmnopqrstuvwxyz";
    private int key;
    
    public CaesarCipher(){
    }
    public CaesarCipher(int k){
        key=k;
    }
    public void setKey(int k){
        key=k;
    }
    public String encrypt(String input) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        //Compute the shifted alphabet
        String shiftedAlphabetC = alphabetC.substring(key)+
        alphabetC.substring(0,key);
        String shiftedAlphabetS = alphabetS.substring(key)+
        alphabetS.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            currChar= Character.toUpperCase(currChar);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabetC.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabetC.charAt(idx);
                //Replace the ith character of encrypted with newChar
                if (Character.isUpperCase(input.charAt(i))){
                    encrypted.setCharAt(i, newChar);
                    encrypted.setCharAt(i, newChar);
                    }
                else {
                    newChar=Character.toLowerCase(newChar);
                 encrypted.setCharAt(i, newChar);
                }

            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public String dcrypt(String input) {
        //Make a StringBuilder with message (encrypted)
        int dk=26-key;
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        //Compute the shifted alphabet
        String shiftedAlphabetC = alphabetC.substring(dk)+
        alphabetC.substring(0,dk);
        String shiftedAlphabetS = alphabetS.substring(dk)+
        alphabetS.substring(0,dk);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            currChar= Character.toUpperCase(currChar);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabetC.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabetC.charAt(idx);
                //Replace the ith character of encrypted with newChar
                if (Character.isUpperCase(input.charAt(i)))
                    encrypted.setCharAt(i, newChar);
                else {
                    newChar=Character.toLowerCase(newChar);
                    encrypted.setCharAt(i, newChar);
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testCaesar() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message);
        System.out.println(encrypted);
        String decrypted = dcrypt(encrypted);
        System.out.println(decrypted);
    }
   
}

