import java.util.*;

class Comp{

    public static <E> void sortElements(E[] a, Comparator<? super E> b){
        Arrays.sort(a, b);
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args){
        Comparator<Char> c = new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return Integer.compare(a, b);
            }
        };
        Integer[] es = {2,3,1,5,78,2,1};
        sortElements(es, c);
    }

}