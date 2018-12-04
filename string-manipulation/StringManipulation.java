import java.util.Arrays;

public class StringManipulation{
    public static void main(String[] args){
        String[] a = {"a","b","c"};
        Integer[] b = {1,2,3,4,5,6,7,8,9,10};
        a = reverse2(a);
        System.out.println(Arrays.toString(a));
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

}