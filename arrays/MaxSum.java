class MaxSum{

    /**
     * Recursive maximum contiguous subsequence sum algorithm.
     * Finds maximum sum in subarray spanning a[left ... right].
     * Does not attempt to maintain acutal best sequence.
     */
    private static int maxSumRec(int[] a, int left, int right){
        if(left == right){
            if(a[left] > 0){
                return(a[left]);
            }
            else{
                return 0;
            }
        }
        
        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center+1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for(int i = center; i >= left; i--){
            leftBorderSum += a[i];
            if(leftBorderSum > maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for(int i = center + 1; i <= right; i++){
            rightBorderSum += a[i];
            if(rightBorderSum > maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max3(maxLeftSum, maxRightSum, 
                    maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int a, int b, int c){
        int max = 0;
        int[] x = {a,b,c};
        for(int i = 0; i < x.length; i++){
            if(x[i] > max){
                max = x[i];
            }
        }
        return x;
    }

    public static int maxSubSum4(int[] a){
        int maxSum = 0, thisSum = 0; 
        for(int j = 0; j < a.length; j++){
            thisSum += a[j];

            if(thisSum > maxSum){
                maxSum = thisSum;
            }
            else if(thisSum < 0){
                thisSum = 0;
            }
        }
        
        return maxSum;
    }

    public static int maxSubSum3(int[] a){
        return maxSumRec(a, 0, a.length-1);
    }
}