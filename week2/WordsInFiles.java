
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsInFiles {
    private HashMap<String , ArrayList<String>> myWords;
    
    public WordsInFiles(){
        myWords = new HashMap<>();
    }
    
    private void addWords(File f)throws IOException{
              FileResource r = new FileResource(f);
              for (String word : r.words()) {
                String key = word.trim();
                ///System.out.println(f.getName());
                if(myWords.containsKey(key)){
                    ArrayList<String> tempArray = myWords.get(key);
                    if (!tempArray.contains(f.getName())){
                        tempArray.add(f.getName());
                        myWords.put(key,tempArray);
                    }
                    //System.out.println(tempArray.toString()+key);
                    
                }
                else {
                    //myWords.put(key,new ArrayList<String>().add(f.getName())))
                    ArrayList<String> tempArray = new ArrayList<String>();
                    tempArray.add(f.getName());
                    myWords.put(key,tempArray);
                    //System.out.println(tempArray.toString());
                }
         }
    }
    
    private void buildWordFileMap(){
        myWords.clear();
        DirectoryResource directoryResource = new DirectoryResource();
        for (File f : directoryResource.selectedFiles()) {
            try{
            addWords(f);
            }
            catch(IOException e){}
        }
    }
    
    private int maxNumber(){
        int max=0;
        for (String key : myWords.keySet()) {
            int size = myWords.get(key).size();
            if (size > max ){
                max=size;
            }
        }
        return max;
    }
    
    private ArrayList<String> wordsInNumFiles(int num){
        ArrayList<String>  arr = new ArrayList<String>  ();
        for (String key : myWords.keySet()){
            int size = myWords.get(key).size();
            if (size == num){
                arr.add(key.toString());
            }
        }
        return arr;
    }
    
    private void  printFilesIn(String key){
         ArrayList<String> arr = myWords.get(key);
         System.out.println(arr.toString());
    }
    
   
    public void  tester(){
        buildWordFileMap();
        System.out.println(wordsInNumFiles(7).size());
        System.out.println(wordsInNumFiles(4).size());
        printFilesIn("laid");
        printFilesIn("tree");
        //System.out.println(common(4));
    }
    
    
    

}
