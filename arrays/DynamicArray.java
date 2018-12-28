import java.util.*;

class DynamicArray{

    int size = 0;
    int[] array = new int[1];

    public void add(int element){
        if(size >= array.length){
            int[] oldArray = array;
            array = new int[size*2];
            for(int i = 0; i < size; i++){
                array[i] = oldArray[i];
            }
        }
        array[size] = element;
        size += 1;
    }

    /**
     * Delete an element by finding it in the array and removing the given index.
     * Worst time O(n).
     * 
     * The function uses deleteIndex(i) that deletes an element at index i. This
     * uses an algorithm that searhes the array from the last element until it
     * finds the index given. This will preserve the O(n) complexity because the
     * total amount of steps for both algos will be n.
     * 
     * @param element
     */
    public void delete(int element){
        for(int i = 0; i < size; i++){
            if(array[i] == element){
                deleteIndex(i);
                size--;
                break;
            }
        }
        if(size+1 == (array.length-1)/2+1){
            array = copy(array, new int[size+1]);
        }
    }

    public int[] copy(int[] oldArray, int[] newArray){
        for(int i = 0; i < size; i++){
            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    /**
     * Delete the element at specified index. Do this by shifting 
     * everything above the given index on element to the left.
     * Worst time given by O(n)
     * @param i
     */
    public void deleteIndex(int i){
        for(int j = i; j < size; j++){
            System.out.println(Arrays.toString(array));
            array[j] = array[j+1];
        }
        array[size] = 0;
    }

    public static String test(String name, int amount){
        long start = System.currentTimeMillis();
        DynamicArray a = new DynamicArray();
        for(int i = 0; i < amount; i++){
            a.add(i);
        }
        long end = System.currentTimeMillis();
        double tot = (end-start)/1000.0;
        return String.format("%s: %f, amount: %d", name, tot, amount);

    }
    public static void main(String[] args){
        int test = 1;
        for(int i = 1; i < Integer.MAX_VALUE; i*=10){
            System.out.println(DynamicArray.test("test-"+test, i));
            test++;
        }
    }
}