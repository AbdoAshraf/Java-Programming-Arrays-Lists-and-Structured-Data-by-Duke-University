
/**
 * Write a description of update here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.ArrayList;
public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> count;
    
    public  CharactersInPlay() {
        names = new ArrayList<String>();
        count = new ArrayList<Integer>();
    }
    private void update(String person){
    /*
     * method should update the two ArrayLists, adding 
     * the character’s name if it is not already
     *there, and counting this line as one speaking 
     *part for this person.
     */
      if (names.contains(person)){
          int index = names.indexOf(person);
          int value = count.get(index);
         count.set(index,++value);
        }
            
      else {
          names.add(person);
          count.add(1); 
        }
      
    }
    
    private void findAllCharacters(){

      FileResource resource = new FileResource();
      for (String line : resource.lines()) {
          StringBuilder person=new StringBuilder();
          for (char ch: line.toCharArray()) {
              if(ch != ' ' || ch != '.')
                 person.append(ch);
              if(ch == '.')
              {
                 update(person.toString());
                 break;
                }
                 
            }
}
      
      

    }
    public void tester(){
        findAllCharacters();
        charactersWithNumParts(40,1000000);
    }
    private void charactersWithNumParts(int min , int max){
        for(int i=0 ; i<names.size() ; i++){
            if(count.get(i)>min && count.get(i)<max)
                System.out.println(names.get(i)+" " + count.get(i));
                
        }
    }
    
}
