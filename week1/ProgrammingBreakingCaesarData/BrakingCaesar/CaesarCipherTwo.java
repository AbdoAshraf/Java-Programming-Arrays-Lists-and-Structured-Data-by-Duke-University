import edu.duke.*;

/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (AbdulrahmanAshraf) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private CaesarCipher ceasarCipher;
    private int key1;
    private int key2;
    public CaesarCipherTwo(int k1,int k2){
        key1=k1;
        key2=k2;
        ceasarCipher = new CaesarCipher();
    }
    
    public String encrypt(String input){
          ceasarCipher.setKey(key1);
          String input1 = ceasarCipher.encrypt(input);
          ceasarCipher.setKey(key2);
          String input2 = ceasarCipher.encrypt(input);
          StringBuilder encrypted = new StringBuilder(input);
          for(int i = 0; i < encrypted.length(); i++) {
              if(i%2==0){
                  encrypted.setCharAt(i, input1.charAt(i));
                }
              else 
                 encrypted.setCharAt(i, input2.charAt(i));
                }
          return encrypted.toString();
              
    }
    
    public String dcrypt(String input){
     
        ceasarCipher.setKey(key1);
        String input1 = ceasarCipher.dcrypt(input);
        ceasarCipher.setKey(key2);
        String input2 = ceasarCipher.dcrypt(input);
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++) {
            if(i%2==0){
                 encrypted.setCharAt(i, input1.charAt(i));
                }
              else 
                 encrypted.setCharAt(i, input2.charAt(i));
                }
          return encrypted.toString();
    }
    
     public void testCaesar() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = this.encrypt(message);
        System.out.println(encrypted);
        String decrypted = this.dcrypt(encrypted);
        System.out.println(decrypted);
    }
    
}
