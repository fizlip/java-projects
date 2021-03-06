import java.util.*;

public class CaesarCipher{

    private Character[] alphabet;

    public CaesarCipher(Character[] alphabet){
        this.alphabet = alphabet;
    }

    public String scramble(String message, int s){
        Alphabet<Character> x = new Alphabet<>(this.alphabet);

        StringBuilder newMsg = new StringBuilder();
        newMsg.append(message);
        // x.shift(s);
        for(int i = 0; i < newMsg.length(); i++){
            Character oldChar = newMsg.charAt(i);
            if(oldChar.equals(' ')){
                continue;
            }
            Integer newIndex = x.newIndex(oldChar, s);
            if(newIndex >= 0){
                Character newChar = this.alphabet[newIndex.intValue()];
                newMsg.setCharAt(i, newChar.charValue());
            }
        }
        return newMsg.toString();
    }

    public String unscramble(String message, int s){
        return scramble(message, -s);
    }

    public static void main(String[] args) {
        Character[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                            'U', 'V', 'W', 'X', 'Y', 'Z'};
        CaesarCipher cipher = new CaesarCipher(alphabet);  
        String message = "TESTING THE CAESAR CIPHER."; 
        String scramble = cipher.scramble(message, 3);
        String unscrambled = cipher.scramble(scramble, -3);
        System.out.println("Scrambled:");
        System.out.println(scramble);
        System.out.println("Unscrambled:");
        System.out.println(unscrambled);
    }
}
