
/**
 * Write a description of DNA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class DNA {
    private HashMap<String,Integer> dnaMap;
    DNA(){
        dnaMap = new HashMap<String,Integer>();
    }
    
    private void buildCodonMap(String name , int postion){
        for(int i=postion ; i<name.length()-2 ; i+=3){
            String key = name.substring(i,i+3);
            if(dnaMap.containsKey(key)){
                dnaMap.put(key ,dnaMap.get(key)+1);
            }
            
            else  dnaMap.put(key , 1);
        }
        
    }
    
    private String getMostCommonCodon(){
        String maxKey=null;
        int max=0;
        for (String s : dnaMap.keySet()) {
            if (dnaMap.get(s)>max){
                maxKey = s;
                max=dnaMap.get(s);
            }
        }
        return maxKey;
} 
        
    
    private void printCodonCounts(int start , int end){
        int count=0;
        for (String s : dnaMap.keySet()) {
            if (dnaMap.get(s)>start && dnaMap.get(s)<end){
                 System.out.println(s + " " + dnaMap.get(s));
                 count++;
            }
        }
        System.out.println(count);
    }
    
    public void tester(){
        FileResource resource = new FileResource();
        String DNA = resource.asString().trim();
        buildCodonMap(DNA,1);
        printCodonCounts(0,10000);
        
    }
    
    
    
    

}
