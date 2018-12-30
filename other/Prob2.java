/**
 * Problem: 
 * 
 * Micro purchased an array A having N integer values. 
 * After playing it for a while, he got bored of it and 
 * decided to update value of its element. In one second 
 * he can increase value of each array element by 1. He 
 * wants each array element's value to become greater than 
 * or equal to K. Please help Micro to find out the minimum 
 * amount of time it will take, for him to do so.
 * 
 * To solve this, in the minimum amount of time, all of the 
 * elements must be greater than or equal to k. I need to
 * loop through all of the elements and check if they are equal to
 * k, I simply add k to the value
 */

import java.util.*;

class Prob2{

    public static int[] addArray(int[] a, int k){
        for(int i = 0; i < a.length; i++){
            a[i] += k;
        }
        return a;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        System.out.println("Original: " + Arrays.toString(arr));
        System.out.println(Arrays.toString(addArray(arr, 4)));
    }

}