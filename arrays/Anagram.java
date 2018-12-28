import java.util.*;

class Anagram extends Alphabet{

    Map<String, List<String>> ws = new HashMap<>();

    public Anagram(String[] ws){
        super();
        init(ws);
    }

    

    public void init(String[] words){
        for(String w : words){
            // Sort word with complexity O(nlog n)
            String wa = this.mergeSort(w);
            if(ws.containsKey(wa)){
                List<String> prev = ws.get(wa);
                prev.add(w);
                ws.put(wa, prev);
            }
            else{
                List<String> l = new ArrayList<>();
                l.add(w);
                ws.put(wa, l);
            }
        }
    }
    

    public void addWord(String w){
        // Sort word using radix sort and then add the word to the sorted word to the
        // hashmap if it does'nt already exist. If it exists add it to the array.
    }

    public static void main(String[] args){
        String[] words = {"hasd", "sdasd", "adsads", "adasds"};
        Anagram g = new Anagram(words);
        System.out.println(g.ws);
    }
}