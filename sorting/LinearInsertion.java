import java.util.Arrays;

class LinearInsertion{
    public static void main(String[] args){
        int[] arrayToSort = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(LinSort(arrayToSort)));
    }

    /**
     * A linear insertion will loop through the entire array and check
     * if any element i, in this case, larger than the next element.
     * If an element is larger than its neighbour to the right then
     * this element is not sorted. The element is then moved to the left
     * until an element is found that is smaller than this.
     * 
     * If the array is in the reversed order all of the total amount of 
     * loops through the array will be 1+2+3+...+n = n(n+1)/2 => O(n^2)
     * 
     * @param a the array to be sorted
     * @return a sorted array.
     */
    public static int[] LinSort(int[] a){
        for(int i = 0; i < a.length-1; i++){
            if(a[i] >= a[i+1]){
                int k = i;
                while(k >= 0){
                    int tmp = a[k];
                    if(a[k] <= a[k+1]){
                        break;
                    }
                    a[k] = a[k+1];
                    a[k+1] = tmp;
                    k--;
                }
            }
        }
        return a;
    }
}