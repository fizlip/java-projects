import java.util.Arrays;

public class StringManipulation{
    public static void main(String[] args){
        String[] a = {"a","b","c"};
        System.out.println(Arrays.toString(reverse(a)));
    }
    // Reverse a string, returns the given list in the reversed order.
    public static String[] reverse(String[] a){
        String[] array = new String[a.length];
        for(int i = a.length-1; i >= 0; i--){
            array[a.length-1-i] = a[i];
        }
        return array;
    }

    

}