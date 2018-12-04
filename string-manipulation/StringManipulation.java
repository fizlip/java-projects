import java.util.Arrays;

public class StringManipulation{
    public static void main(String[] args){
        System.out.println(interleave2("alexander", "p"));
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

    // apnantarik
}