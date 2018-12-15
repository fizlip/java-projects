import java.util.*;

class LinearInsertion{
    public static void main(String[] args){
        int[] arrayToSort = {10, 2,100000, 3,6,1,1000};
        test(1000000);

        // System.out.println(Arrays.toString(binSort(arrayToSort)));
    }

    /**
     * A linear insertion will use a linear search to look for elements that
     * are not sorted and then use a linear search again to insert the unsorted
     * element in the correct position.
     * 
     * The two linear searches combine to give an upper bound on the runtime of O(n^2).
     * 
     * This shows that the linear search is a very time consuming process.
     * 
     * results with test:
     * 
     * n = 10000, t = 0.059s
     * n = 100000, t = 5.431s
     * n = 1000000, t = 590.895s
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

    /**
     * A binary insertion sort uses a linear search to find elements that
     * are unordered and then a binary search to find the correct position
     * of the unosorted elements. This gives the algorithm a worst case 
     * runtime complexity of O(nlog n).
     * 
     * Results with test:
     * 
     * n = 10000, t = 0.033s
     * n = 100000, t = 1.73s
     * n = 1000000, t = 216.998s
     * 
     * @param a
     * @return
     */

    public static int[] binSort(int[] a){
        // Loop through whole array
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[i-1]){
                // To avoid IndexArrayOutOfBounds errors later this special
                // case for i = 2 has to be added, it simply reverses the 
                // a size 2 array
                if(i == 1){
                    int tmp = a[i-1];
                    a[i-1] = a[i];
                    a[i] = tmp;
                    continue;
                }
                int upper = i;
                int lower = 0;

                // Binary search to find correct index of element
                int mid = (upper+lower)/2 + (upper+lower)%2;
                while(mid >= 0){
                    mid = (upper+lower)/2 + (upper+lower)%2;
                    if(a[i] > a[mid]){
                        lower = mid + 1;
                        if(a[i] <= a[mid+1]){
                            // Correct pos found
                            int tmp = a[i];
                            a = shiftRight(a, mid, i);
                            a[mid+1] = tmp;
                            break;
                        }
                    }
                    if(a[i] <= a[mid]){
                        upper = mid - 1;
                        if(mid == 0 || a[i] >= a[mid-1]){
                            // Correct pos found
                            int tmp = a[i];
                            a = shiftRight(a, mid, i);
                            a[mid] = tmp;
                            break;
                        }
                    }
                }                
            }
        }
        return a;
    }

    public static int[] shiftRight(int[] a, int mid, int i){
        for(int j = i; j > mid; j--){
            a[j] = a[j-1];
        }
        return a;
    }

    public static void test(int num){
        int[] array = new int[num];
        Random rand = new Random();
        for(int i = 0; i < num; i++){
            array[i] = rand.nextInt(100)+1;
        }
        long start = System.currentTimeMillis();
        int[] sorted = binSort(array);
        double tot = (System.currentTimeMillis() - start)/1000.0;

        System.out.println(String.format("Total time for %d: %fs", num, tot));

    }
}