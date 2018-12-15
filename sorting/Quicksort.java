import java.util.*;

class Quicksort{

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        // a.add(2);
        // a.add(4);
        // a.add(2);
        // a.add(8);
        // a.add(4);
        // a.add(86);
        // a.add(3);
        // a.add(5);
        // a.add(8);
        // a.add(2);
        // System.out.println(quicksort(a, 0).toString());
        test(100000);
    }

    /** 
     * The quicksort algorithm works by defining a pivot in the array that 
     * is to be sorted. The array is then looped through to check what 
     * elements are greater than and what elements are less than the pivot.
     * The elements that are greater are placed to the left of the pivot, the
     * elements that are smaller are placed to the right. The algorithm is then
     * called recursivly to sort the other sides of the pivots.
     * 
     * The function below creates two list, high and low. A pivot element is
     * defined a initiation and a for-loop is used to loop through the array.
     * If an element is greater than the pivot then the it is added to the
     * high array, if it is lower than the pivot it is added to the low array.
     * The function is then called on the low array and the high array.
     * 
     * Result with test:
     * 
     * With pivot = 0
     * n = 10000, t = 0.112s
     * n = 100000, t = 2.285s
     * n = 500000, t = 27.185s
     * 
     */

    public static List<Integer> quicksort(List<Integer> a, int pivotIndex){
        if(a.size() > 1){
            // pivotIndex = getMedian(a.get(0), a.get(a.size()-1));
            int pivot = getMedian(a.get(0), a.get(a.size()-1));
            List<Integer> high = new ArrayList<>();
            List<Integer> low = new ArrayList<>();
            for(int i = 1; i < a.size(); i++){
                if(a.get(i) > pivot){
                    // Swap elements
                    high.add(a.get(i));
                }
                if(a.get(i) <= pivot){
                    low.add(a.get(i));
                }
            }
            List<Integer> result = new ArrayList<>();
            result.addAll(quicksort(low, 0));
            result.add(pivot);
            result.addAll(quicksort(high, 0));
            return result;
        }
        else{
            return a;
        }
    }

    public static int getMedian(int left, int right){
        int center = (left+right)/2;
        int median = left;
        if(center > median && center <= right){
            median = center;
        }        
        if(right > median && right <= center){
            median = right;
        }
        return median;
    }

    public static void test(int num){
        List<Integer> array = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < num; i++){
            array.add(rand.nextInt(100)+1);
        }
        long start = System.currentTimeMillis();
        List<Integer> sorted = quicksort(array, 0);
        double tot = (System.currentTimeMillis() - start)/1000.0;

        System.out.println(String.format("Total time for %d: %fs", num, tot));

    }

}