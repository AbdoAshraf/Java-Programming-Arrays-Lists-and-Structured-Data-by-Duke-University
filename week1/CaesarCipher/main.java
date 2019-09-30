
/**
 * Write a description of main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main {
    public static void main(String[] args){
        CaesarCipher c1 = new CaesarCipher(15);
        c1.testCaesar();
        CaesarCipherTwo c2 = new CaesarCipherTwo(21,8);
        c2.testCaesar();
    }
}
