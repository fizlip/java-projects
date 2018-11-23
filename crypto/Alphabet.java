import java.util.*;

public class Alphabet<E>{
    // Create english alphabet
    public Map<E, Integer> letters = new HashMap<E, Integer>();

    public Alphabet(E[] alphabet){
        for(int  i = 0; i < alphabet.length; i++){
            letters.put(alphabet[i], i);
        }
    }

    // Shift alphabet i steps.
    // public void shift(int i){
    //     for(int j = 0; j < letters.size(); j++){
    //         if(j+i < 0){
    //             j = letters.size() + (j+1)%(letters.size());
    //         }
    //         E letter = (E) letters.keySet().toArray()[j];
    //         letters.replace(letter, (j+i)%(letters.size()));
    //     }
    // }

    public int newIndex(E value, int shift){
        try{
            Integer oldIndex = letters.get(value);
            if(oldIndex.intValue() + shift < 0){
                shift = letters.size() + (oldIndex+1)%(letters.size());
            }
            return (shift + oldIndex)%(letters.size());
        }
        catch(NullPointerException e){
            return -1;
        }
    }
}