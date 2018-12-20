import java.util.Arrays;

class SortBool{

    public static void main(String[] args){
        boolean[] test = {true, false, false, false, true, true, false};
        System.out.println(Arrays.toString(sortBool(test)));
    }

    public static boolean[] sortBool(boolean[] bs){
        int low = 0;
        int high = bs.length - 1;
        while(true){
            while(high >= 0 && bs[high] == true){
                high--;
            }
            while(low < bs.length && bs[low] == false){
                low++;
            }
            if(low > high){
                break;
            }
            boolean tmp = bs[high];
            bs[high] = bs[low];
            bs[low] = tmp;
        }
        return bs;
    }

    public static boolean[] boolSort2(boolean[] bs){
        int pivot = bs[bs.length-1];
        
        boolean[] left = new boolean[bs.length/2];
        boolean[] right = new boolean[bs.length/2];
        for(int i = 0; i < bs.length; i++){
            
        }
    }

}