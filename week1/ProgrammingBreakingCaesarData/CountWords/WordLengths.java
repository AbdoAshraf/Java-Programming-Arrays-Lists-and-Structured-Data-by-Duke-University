
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {
    public void countWordLengths (FileResource fr , int [] acc ){
        
        for (String word : fr.words()){
            System.out.println(word);
            int count=word.length();
            if (!Character.isLetter(word.charAt(0)))
                count--;
            if (!Character.isLetter(word.charAt(word.length()-1)))
                count--;
            if (count >-1)
                acc[count]++;
        }
    }
    public void testCountWordLengths(){
         FileResource fr = new FileResource();
         int acc [] = new int[100];
         countWordLengths(fr,acc);
         for (int i=0 ; i<acc.length; i++){
             if (acc[i] !=0)
                System.out.println("length="+i +"  frq="+acc[i]);
            }
         System.out.println("most ocurrunce=" + indexOfMax(acc));
    }
    public int indexOfMax(int[]arr){
        int max=0;
        int index = 0;
        for (int i=0 ; i<arr.length; i++){
            if (arr[i]>max)
            {
                max=arr[i];
                index=i;
            }
        }
        return index;
        
    }
}
