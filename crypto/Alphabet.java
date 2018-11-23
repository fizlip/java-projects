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
    public void shift(int i){
        for(int j = 0; j < letters.size(); j++){
            if(j+i < 0){
                j = letters.size() + (j+1)%(letters.size());
            }
            E letter = (E) letters.keySet().toArray()[j];
            letters.replace(letter, (j+i)%(letters.size()));
        }
    }
}