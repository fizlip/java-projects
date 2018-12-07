import java.util.Arrays;

public class StringManipulation{
    public static void main(String[] args){
        System.out.println(isPalindrome2(args[0]));
    }

    public static <E> E[] reverse(E[] x){
        int high = x.length-1;
        int low = 0;
        while(low < high){
            E tmp = x[low];
            x[low] = x[high];
            x[high] = tmp;
            low++;
            high--;
        }
        return x;
    }    

    public static <E> E[] reverse2(E[] x){
        for(int i = 0; i < x.length/2; i++){
            E tmp = x[i];
            x[i] = x[x.length-i-1];
            x[x.length-i-1] = tmp;
        }
        return x;
    }
    /**
     * 
     * Given two strings the function will return an interleaved version
     * of these two i.e. every other letter will come from one
     * every other will come from the other string. 
     * 
     * This function uses
     * a StringBuilder to replace characters at with the first string
     * if the index is even and replace them with the other string if
     * the index is odd.
     * 
     * The append function is assumed to take constant time and the foorloop will
     * be linear in respect to the minimum lenght string m, the complexity is
     * then given by O(m). 
     * 
     * @param a 1st string
     * @param b 2nd string
     * @return interleaved string
     */
    public static String interleave(String a, String b){
        if(a == null || b == null){
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder();
        result.append(a);result.append(b);
        for(int i = 0; i < Math.min(a.length(), b.length())*2; i++){
            result.setCharAt(i, ((i%2 == 0) ? a.charAt(i/2) : b.charAt(i/2)));
        }

        return result.toString();
    }

    public static String interleave2(String a, String b){
        if(a == null || b == null){
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < Math.min(a.length(), b.length()); i++){
            StringBuilder tmp = new StringBuilder();
            tmp.append("xx");
            tmp.setCharAt(0, a.charAt(i));
            tmp.setCharAt(1,b.charAt(i));
            result.append(tmp.toString());
        }
        if(a.length() > b.length()){
            result.append(a.substring(b.length()));
        }
        if(b.length() > a.length()){
            result.append(b.substring(a.length()));
        }
        return result.toString();
    }

    /**
     * Given a word this function will return a boolean value showing if the word is
     * a palindrome or not. The function first reverses the given and then checks if
     * the reversed string equals the original word. If it is then it returns true 
     * otherwise false.
     * 
     * The reversion algorithm has complexity O(n), the equality is assumed to 
     * have O(1), the function has complexity O(n).
     * 
     * @param word the word to chekc
     * @return boolean
     */
    public static boolean isPalindrome(String word){

        String revString = reverseString(word);
        if(revString.toString().toUpperCase().equals(word.toUpperCase())){
            return true;
        }
        return false;
    }

    public static String reverseString(String word){
        StringBuilder revString = new StringBuilder(word);

        for(int i = 0; i < word.length()/2; i++){
            char temp = word.charAt(word.length()-1-i);
            revString.setCharAt(i, word.charAt(word.length()-1-i));
            revString.setCharAt(word.length()-1-i, temp);
        }
        return revString.toString();
    }

    /**
     * Standalone is palindrome2 uses two indexes high and low to keep track of 
     * indexes in the string. A while-loop is used to check every character 
     * in each half of the string. If the character is not alphabetical then
     * the index that this characers belongs to i.e. high or low is incremented
     * or decremented.
     * 
     * The while loops length will be dependent upon the length of the string
     * becuase the high and low indexes are calculated from the string length. 
     * Complexity is then given by O(n).
     * 
     * @param string
     * @return
     */

    public static boolean isPalindrome2(String string){
        string = string.toUpperCase();
        int high = string.length()-1;
        int low = 0;
        while(high > low){
            Character cl = string.charAt(low);
            Character ch = string.charAt(high);
            if(!Character.isAlphabetic(cl)){
                low++;
                continue;
            }
            if(!Character.isAlphabetic(ch)){
                high--;
                continue;
            }
            if(!cl.equals(ch)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}