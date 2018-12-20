import java.util.*;

class Anagram extends Comparable<? super String>{

    Map<String, String> words = new HashMap<>();

    Char[] alphb = {'a', 'b', 'c', 'd','e','f','g','h', 'j','m',
    'n','o','p','q','r','s','t','u','v','x','y','z'};

    HashMap<Char, Integer> alphaMap = new HashMap<>();

    public Anagram init(String[] ws){
        for(int i = 0; i < alphb.length-1; i++){
            alphaMap[alphb[i]] = i;
        }
    }

    public addWord(String w){
        // Sort word using radix sort and then add the word to the sorted word to the
        // hashmap if it does'nt already exist. If it exists add it to the array.
    }

    public compare(){

    }

}