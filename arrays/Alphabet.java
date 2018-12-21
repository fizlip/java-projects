import java.util.*;

class Alphabet implements CompareChar{
 
    Character[] alphb = {'a', 'b', 'c', 'd','e','f','g','h','i','j','k','l','m',
                    'n','o','p','q','r','s','t','u','v','x','y','z','w'};

    HashMap<Character, Integer> alphaMap = new HashMap<>();
    
    public Alphabet(){
        for(int i = 0; i < alphb.length; i++){
            alphaMap.put(alphb[i], i);
        }
    }

    public String[] sortString(String[] ws){
        if(ws.length < 2){
            return ws;
        }
        String[] left = new String[ws.length/2 + ws.length%2];
        String[] right = new String[ws.length/2 + ws.length%2];
        for(int i = 0; i < ws.length; i++){
            if(i < ws.length/2){
                left[i] = ws[i];
            }
            else{
                right[i-(ws.length/2)] = ws[i]; 
            }
        }
        return mergeString(sortString(left), sortString(right));
    }

    public String[] mergeString(String[] l, String[] r){

        if(l[0] == null){
            return r;
        }
        if(r[0] == null){
            return l;
        }
        String[] result = new String[l.length + r.length];
        int li = 0;
        int ri = 0;
        
        while(li < l.length && ri < r.length){
            if(compareString(l[li], r[ri]) > 0){
                result[li+ri] = l[li];
                li++;
            }
            else{
                result[li+ri] = r[ri];
                ri++;
            }
        }

        while(ri < r.length){
            result[ri+li] = r[ri];
            ri++;
        }
        while(li < l.length){
            result[li+ri] = l[li];
            li++;
        }
        return result;

    }

    public Integer compare(Character a, Character b){
        if(alphaMap.get(a) < alphaMap.get(b)){
            return 1;
        }
        if(alphaMap.get(a) == alphaMap.get(b)){
            return 0;
        }
        else{
            return -1;
        }
    }

    public Integer compareString(String a, String b){
        if(a.length() == 0 || b.length() == 0){
            return 0;
        }
        if(compare(a.charAt(0), b.charAt(0)) == 0){
            compareString(a.substring(1), b.substring(1));
        }
        if(compare(a.charAt(0), b.charAt(0)) < 0){
            return -1;
        }
        else{
            return 1;
        }
    }

    // Use merge sort to sort string O(nlog n)
    public String mergeSort(String w){
        String left = "";
        String right = "";

        if(w.length() < 2){
            return w;
        }

        for(int i = 0; i < w.length(); i++){
            if(i <= (w.length()/2+w.length()%2)-1){
                left += w.charAt(i);
            }
            if(i > (w.length()/2+w.length()%2)-1){
                right += w.charAt(i);
            }
        }
        return merge(mergeSort(left), mergeSort(right));
    }

    private String merge(String a, String b){
        String result = "";
        int ai = 0;
        int bi = 0;
        while(ai < a.length() && bi < b.length()){
            if(compare(a.charAt(ai), b.charAt(bi)) > 0){
                result += a.charAt(ai);
                ai++;
            }
            else{
                result += b.charAt(bi);
                bi++;
            }
        }
        while(ai < a.length()){
            result += a.charAt(ai);
            ai++;
        }
        while(bi < b.length()){
            result += b.charAt(bi);
            bi++;
        }
        return result;
    }

    /**
     * Convert a string into a Character array, O(n) complexity
     */
    public static Character[] charify(String w){
        Character[] s = new Character[w.length()]; 
        for(int i = 0; i < w.length(); i++){
            s[i] = w.charAt(i);
        }
        return s;
    }

    public static void main(String[] args){
        Alphabet a = new Alphabet();
        String[] cs = {"filip","magnus", "erika", "pontus","maximus", "leonidas", "athena","athenas"};
        System.out.println(Arrays.toString(a.sortString(cs)));
    }
}