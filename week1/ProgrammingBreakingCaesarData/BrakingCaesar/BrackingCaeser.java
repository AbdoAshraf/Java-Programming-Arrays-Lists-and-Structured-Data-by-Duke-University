
/**
 * Write a description of brackingCaeser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class BrackingCaeser {
  private String firstHalf;
  private String secondHalf;
  String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private CaesarCipherTwo caesarCipherTwo;

  public  BrackingCaeser(){
      firstHalf="";
      secondHalf="";
    }
    
  public void countLetters(String word , int acc[]){
      word = word.toUpperCase();
      for (int i=0 ; i<word.length();i++){
          if (Character.isLetter(word.charAt(i)))
          {
              int index=alphabet.indexOf(word.charAt(i));
              acc[index]++;
          }
        }
    }
  
  public int maxIndex(int acc[]){
      int max=0;
      int index=0;
      for (int i=0; i<26 ; i++){
          if (max<acc[i]){
               max=acc[i];
               index=i;
          } 
        }
    return index;
   }
  public int  getKey(int maxIndex){
        return (maxIndex-4+26)%26;
    }
    
    
  public void testbrackingCaeser(){
      FileResource fr = new FileResource();
      int acc0 [] = new int[26];
      int acc1 [] = new int[26];
      halfOfString(fr);
      countLetters(firstHalf,acc0);
      countLetters(secondHalf,acc1);
      int maxIndex0=maxIndex(acc0);
      int maxIndex1=maxIndex(acc1);
      int key0 = getKey(maxIndex0);
      int key1 = getKey(maxIndex1);
      caesarCipherTwo =new CaesarCipherTwo(key0,key1);
      System.out.println(key0+" " +key1);
      String message=fr.asString();
      System.out.println(message);
      System.out.println(caesarCipherTwo.dcrypt(message));
    }
 
  public void halfOfString(FileResource fr){
      String txt = fr.asString();
      for (int i=0 ; i<txt.length();i++){
          if (i%2==0)
            firstHalf+=txt.charAt(i);
          else secondHalf+=txt.charAt(i);
        }
    }
  
}
